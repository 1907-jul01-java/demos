# Passwords Security & Authentication
Storing plain text passwords is a very bad idea. Often times security breaches leak spreadsheets and database dumps revealing user account information, including these passwords, which compromises not only these accounts but any others shared by users on other sites where these passwords may be reused. A basic solution hashes passwords, such as SHA, but there are easy ways to reverse them. A better approach is to add a few random bytes of data known as a 'salt' to make it harder to reverse. An even better solution however is to use encryption such as PBKDF2 or BCrypt

```java
String passwordToHash = "p4ssw0rd";

// Generate random salt
SecureRandom random = new SecureRandom();
byte[] salt = new byte[16];
random.nextBytes(salt);

// Option 1: Hash password using SHA + salt
MessageDigest md = MessageDigest.getInstance("SHA-512");
md.update(salt);
byte[] hashedPassword = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));

// Option 2: Hash password using PBKDF2 + salt
KeySpec spec = new PBEKeySpec(passwordToHash.toCharArray(), salt, 131072, 128);
SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
byte[] hashedPassword = factory.generateSecret(spec).getEncoded();
```

Using either option, both the hashed password and the salt should be saved in a database for future authentication.

```java
public String hashingMethod(String password, byte[] salt) {
    // return hash using SHA/Encryption + salt
}

public void createUser(String user, byte[] salt, byte[] hashedPassword) {
    String sql = "insert into users (username, salt, hash) values (?, ?, ?)";

    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, user);
        pstmt.setBytes(2, salt);
        pstmt.setBytes(3, hashedPassword);
        pstmt.executeUpdate();
    } catch(NoSuchAlgorithmException | SQLException | UnsupportedEncodingException ex) {
        // log errors
    }
}

public boolean authenticateUser(String user, String password) {
    String hashedPassword;
    String salt;
    String sql = "select salt, hash from users where username = ?";
    
    try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, user);
        ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();
        salt = resultSet.getBytes("salt");
        hashedPassword = new String(resultSet.getBytes("hash"));

        if (hashedPassword.equals(hashingMethod(password, salt))) {
            return true;
        } else {
            return false;
        }
    } catch(NoSuchAlgorithmException | SQLException | UnsupportedEncodingException ex) {
        return false;
    }
}
```