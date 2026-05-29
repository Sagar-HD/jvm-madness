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
                    "INSERT INTO student(id, name, total_marks) VALUES (?, ?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, data.getId());
            statement.setString(2, data.getName());
            statement.setInt(3, data.getTotalMarks());

            int rows = statement.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}