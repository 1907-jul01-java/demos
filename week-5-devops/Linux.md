# Linux
Linux is a popular choice for a cloud server. There are a variety of open-source distributions each with a large community of hobbyists and professionals supporting them. Unique development tools are widespread and simple to install, use, and maintain. And most distributions are very capable without the resource overhead of a graphical desktop user interface, making the system very lightweight.

On a headless server (without a graphical interface), the most popular way to interact with a server is through a terminal interface. The most widespread is a shell known as Bash, the Borne Again Shell.

## Shell
A shell is a program that interprets user input. Emulating the look and feel of an old mainframe terminal interface, many shells like Bash provide their users access to several command-line interface (CLI) tools as well as useful conveniences such as auto-completion, a scripting language syntax, and I/O redirection.

To use a CLI tool a user types the name of a program followed by any parameters or flags.

## Scripting
Text files saved with the `.sh` extension are commonly used as shell scripts - a manifest of commands for Bash to run automatically line by line. To write a script, a shebang is commonly used on the first line to denote the shell program of choice. To execute a script, either pass the file as an argument to the `sh` or `bash` command, or make the file executable using `chmod` and call the file in the shell.

#### Example `script.sh`
```bash
#!/bin/bash

# Updating and installing packages through yum
sudo yum update -y
sudo yum remove -y java
sudo yum install -y git java-1.8.0-openjdk-devel

# Adding external yum repository for Maven
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum update -y
sudo yum install -y apache-maven

#Installing Jenkins
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
sudo rpm --import http://pkg.jenkins-ci.org/redhat-stable/jenkins-ci.org.key
sudo yum install -y jenkins
sudo service jenkins start
```

## Sudo
The `sudo` command elevates the shell prompt with root permissions. Root is the default administrator account and is rarely stopped by the system from doing anything. Whlie some programs require root access and thus must be used together with `sudo`, it is dangerous to use carelessly.

## Package Management
Linux distributions maintain a variety of public and private repositories of program installation scripts. These repositories and their related CLI tool makes quick work of installing, updating, and uninstalling programs with simple commands. The program `yum` is commonly used on Amazon Linux and any Red Hat derived systems (RHEL, Fedora, CentOS), while `apt` is popular on Debian-based systems (Debian, Ubuntu).

#### Examples (using `yum`)
```bash
# To update all packages
sudo yum update

# To install a program (git)
sudo yum install git

# To uninstall a program (java)
sudo yum remove java

# To install OpenJDK Java 8
sudo yum install java-1.8.0-openjdk-devel
```

## Man
The `man` command will seek and display the manual page for most CLI tools installed through a package manager. Used like `sudo`, it takes a CLI command as an argument.
```bash
# Will display the manual page for yum
man yum
```

## Grep
The global regular expression print tool (`grep`) processes files and standard output text to search for an expression matching what was passed to the command.
```bash
# Will search for lines with 'tim' inside users.txt
grep tim users.txt
```
