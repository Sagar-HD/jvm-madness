package com.xworkz.dao.impl;

import com.xworkz.dao.AuthDao;
import com.xworkz.dto.Student;

import java.sql.*;

public class AuthDaoImpl implements AuthDao {
    @Override
    public boolean isUserPresent(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "sagarhd");
            st = con.createStatement();
            String query =
                    "select * from student where username = '" + username + "'";
            ResultSet rs = st.executeQuery(query);
            return rs.next();

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {
            if (st != null) {
                st.close();
            }
            if(con!=null){
                con.close();
            }

        }


    }


    @Override
    public Student getStudent(Student student) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "sagarhd");
            st = con.createStatement();
            String query =
                    "select * from student where username = '" +
                            student.getUsername() +
                            "' and password = '" +
                            student.getPassword() +
                            "'";
            boolean isPresent=st.execute(query);
           if(isPresent) {
               ResultSet rs= st.getResultSet();
               if (rs.next()) {
                   return new Student(
                           rs.getString("username"),
                           rs.getString("password")
                   );
               }
               else{
                   return null;
               }

           }
           else{
               return null;
           }
        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {
            if (st != null) {
                st.close();
            }
            if(con!=null){
                con.close();
            }


        }

    }
}