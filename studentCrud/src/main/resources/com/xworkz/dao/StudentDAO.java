package com.xworkz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.xworkz.dto.StudentDTO;

public class StudentDAO {

    public void saveData(StudentDTO data) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/studentdb",
                            "root",
                            "sagarhd");

            String sql =
                    "insert into student(name,email,phone) values(?,?,?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, data.getName());
            statement.setString(2, data.getEmail());
            statement.setLong(3, data.getPhone());

            statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Data Saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}