package com.xworkz.dao;

import com.xworkz.dto.Student;

import java.sql.SQLException;

public interface AuthDao {
    boolean isUserPresent(String username) throws SQLException, ClassNotFoundException;
    Student getStudent(Student student) throws SQLException, ClassNotFoundException;
}
