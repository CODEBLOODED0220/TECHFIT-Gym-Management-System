# TECHFIT – Gym Member Management System

## 1. Project Overview
TECHFIT is a Java-based web application designed to manage gym member records. It provides an admin login and functionality to add, view, search, and delete member records.

## 2. Technologies Used
- Java
- JSP (JavaServer Pages)
- Java Servlets
- JDBC
- MySQL
- Apache Maven
- Apache Tomcat 10.1

## 3. Main Features
- Admin login and logout
- Add gym members
- View all gym members
- Search and view member details
- Delete member records

## 4. Requirements
Install the following software before running the project:
- JDK 21
- Apache Maven
- MySQL Server
- Apache Tomcat 10.1
- MySQL Connector/J dependency

## 5. Database Setup
1. Start the MySQL server.
2. Open MySQL Workbench or your MySQL command-line client.
3. Open and review the `database.sql` file included in this repository.
4. Execute the SQL statements to create the required database and tables.
5. Configure the database connection settings for your local MySQL installation.

**Security:** Do not use real database passwords in public source code. Configure your own local credentials securely.

## 6. Build the Project
1. Clone or download this repository.
2. Open a terminal in the project root directory, where `pom.xml` is located.
3. Run:

```bash
mvn package
```

4. If the build succeeds, Maven generates the WAR file in the `target` directory.

## 7. Run the Application
1. Deploy the generated WAR file to your Apache Tomcat installation.
2. Start Tomcat.
3. Open the application in your browser using the configured Tomcat port and deployed application context path.
4. Configure the database connection before using the application.

## 8. Project Structure

```text
TECHFIT-Gym-Management-System/
├── src/
│   └── main/
│       ├── java/
│       └── webapp/
├── database.sql
├── pom.xml
└── README.md
```

## 9. Team Members
- Prashant Kumar
- Vikas Pushpakar
- Owais Akhtar

## 10. Project Purpose
This project demonstrates Java web development, servlet-based request handling, JDBC database connectivity, and basic gym member record management.
