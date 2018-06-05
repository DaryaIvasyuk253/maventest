package org.java.homework.Task_40;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    public static void main(String[] args) throws Exception {
        Connection connection;

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/automobiles ? " +
                "verifyServerCertificate=false&useSSL=true&serverTimezone=UTC", "root", "3548ghklop");

        if (connection != null) {
            System.out.println("Connection created successfully");

        } else {
            System.out.println("Problem with creating connection");
        }



        Statement stmt;
        String sql;
        assert connection != null;

        stmt = connection.createStatement();
        sql = "DROP TABLE IF EXISTS AUTO;";
        stmt.executeUpdate(sql);
        stmt.close();

        stmt = connection.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS auto" +
                "(ID INTEGER     PRIMARY KEY AUTO_INCREMENT  NOT NULL," +
                " MARK           VARCHAR(50)       NOT NULL, " +
                " MODEL          VARCHAR(50)       NOT NULL, " +
                " GEARBOX        VARCHAR(50)       NOT NULL, " +
                " YEAR           YEAR(4)           NOT NULL, " +
                "PRICE           DECIMAL(15, 3)    NOT NULL," +
                "QUANTITY        INTEGER           NOT NULL," +
                "COUNTRY          VARCHAR(50)      NOT NULL)";
        stmt.executeUpdate(sql);
        stmt.close();

        connection.setAutoCommit(false);

        stmt = connection.createStatement();
        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Land Rover'," +
                "'LR4', 'AUTO', 2016, 42.795, 1, 'Great Britain');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Land Rover'," +
                " 'Range Rover', 'AUTO', 2018, 87.350, 1, 'Great Britain');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Subaru', " +
                "'BRZ', 'AUTO', 2018, 25.595, 1, 'Japan');";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Audi', " +
                "'R8', 'AUTO', 2018, 138.700, 1, 'Germany');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Honda'," +
                " 'Accord', 'auto', 2018, 23.580, 1, 'Japan');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Mazda'," +
                "'Mazda6', 'auto', 2016, 23.870, 1, 'Japan');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Audi'," +
                "'A5', 'auto', 2018, 42.600, 1, 'Germany');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('INFINITI'," +
                "'Q60', 'auto', 2018, 39.960, 1, 'Japan');";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO AUTO (MARK, MODEL, GEARBOX, YEAR, PRICE, QUANTITY, COUNTRY) VALUES ('Tesla'," +
                "'ModelS', 'auto', 2018, 74.600, 1, 'USA');";
        stmt.executeUpdate(sql);
        stmt.close();
        connection.commit();

        System.out.println("Print all models represented by specified mark:");
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MODEL FROM AUTO WHERE MARK = 'Land Rover';");
        while (rs.next()) {
            String model = rs.getString("model");
            System.out.println("MODEL = " + model);
            System.out.println();
        }
        rs.close();
        stmt.close();

        System.out.println("**********************************");
        System.out.println("Print all automobiles, where price is lower than 50.000:");
        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM AUTO WHERE PRICE <= 50.000;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String mark = rs.getString("mark");
            String model = rs.getString("model");
            String gearbox = rs.getString("gearbox");
            int year = rs.getInt("year");
            BigDecimal price = rs.getBigDecimal("price");
            int quantity = rs.getInt("quantity");
            String country = rs.getString("country");
            System.out.println("ID = " + id);
            System.out.println("MARK = " + mark);
            System.out.println("MODEL = " + model);
            System.out.println("GEARBOX = " + gearbox);
            System.out.println("YEAR = " + year);
            System.out.println("PRICE = " + price);
            System.out.println("QUANTITY = " + quantity);
            System.out.println("COUNTRY = " + country);
            System.out.println();
        }
        rs.close();
        stmt.close();

        System.out.println("**********************************");
        System.out.println("Print mark and model of auto specified by country:");
        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT MARK, MODEL FROM AUTO WHERE COUNTRY = 'Japan';");
        while (rs.next()) {
            String mark = rs.getString("mark");
            String model = rs.getString("model");
            System.out.println("MARK = " + mark);
            System.out.println("MODEL = " + model);
            System.out.println();
        }
        rs.close();
        stmt.close();


        System.out.println("**********************************");
        System.out.println("Print the most expensive auto:");

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM AUTO WHERE PRICE = (SELECT MAX(PRICE) FROM AUTO);");
        while (rs.next()) {
            int id = rs.getInt("id");
            String mark = rs.getString("mark");
            String model = rs.getString("model");
            String gearbox = rs.getString("gearbox");
            int year = rs.getInt("year");
            BigDecimal price = rs.getBigDecimal("price");
            int quantity = rs.getInt("quantity");
            String country = rs.getString("country");
            System.out.println("ID = " + id);
            System.out.println("MARK = " + mark);
            System.out.println("MODEL = " + model);
            System.out.println("GEARBOX = " + gearbox);
            System.out.println("YEAR = " + year);
            System.out.println("PRICE = " + price);
            System.out.println("QUANTITY = " + quantity);
            System.out.println("COUNTRY = " + country);
            System.out.println();
        }
        rs.close();
        stmt.close();

        System.out.println("**********************************");
        System.out.println("Print the cheapest auto:");

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM AUTO WHERE PRICE = (SELECT MIN(PRICE) FROM AUTO);");
        while (rs.next()) {
            int id = rs.getInt("id");
            String mark = rs.getString("mark");
            String model = rs.getString("model");
            String gearbox = rs.getString("gearbox");
            int year = rs.getInt("year");
            BigDecimal price = rs.getBigDecimal("price");
            int quantity = rs.getInt("quantity");
            String country = rs.getString("country");
            System.out.println("ID = " + id);
            System.out.println("MARK = " + mark);
            System.out.println("MODEL = " + model);
            System.out.println("GEARBOX = " + gearbox);
            System.out.println("YEAR = " + year);
            System.out.println("PRICE = " + price);
            System.out.println("QUANTITY = " + quantity);
            System.out.println("COUNTRY = " + country);
            System.out.println();
        }
        rs.close();
        stmt.close();



    }
}
