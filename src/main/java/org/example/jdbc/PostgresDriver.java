package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class PostgresDriver {

  private Connection connection;

  @SneakyThrows
  public static void main(String[] args) {

    PostgresDriver driver = new PostgresDriver();
    driver.connect();
    String sqlQuery = "SELECT * FROM public.person;";
    String tableName = "name";

    driver.executeQuery(sqlQuery, tableName);

    driver.closeConnection();
  }

  @SneakyThrows
  public void executeQuery(String query, String tableName) {
    Statement statement = getConnection().createStatement();
    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      String columnValue = resultSet.getString(tableName);
      System.out.println("Column Value: " + columnValue);
    }

    resultSet.close();
    statement.close();
  }

  public void connect() {
    String url = "jdbc:postgresql://localhost:5432/company";
    String user = "postgres";
    String password = "";

    // Establishing a connection
    try {
      connection = DriverManager.getConnection(url, user, password);
      if (connection != null) {
        System.out.println("Connected to the database!");
      }
    } catch (SQLException e) {
      System.out.println("Connection failed!");
      e.printStackTrace();
    }
  }

  @SneakyThrows
  public void closeConnection() {
    if (connection != null) {
      connection.close();
    }
  }


}
