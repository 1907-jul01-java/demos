package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.99.100:5432/moviedb";
        String user = "moviedb";
        String password = "p4ssw0rd";
        String query;

        try (Connection connection = DriverManager.getConnection(url, user, password);
                Scanner scanner = new Scanner(System.in);) {

            while (true) {
                Statement statement = connection.createStatement();
                System.out.print("postgres=> ");
                query = scanner.nextLine();
                if (query.equalsIgnoreCase("exit"))
                    break;

                boolean isResultSet = statement.execute(query);

                if (isResultSet) {
                    ResultSet resultSet = statement.getResultSet();
                    ResultSetMetaData rsmd = resultSet.getMetaData();

                    // print rows
                    while (resultSet.next()) {
                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println(statement.getUpdateCount() + " rows affected.");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
