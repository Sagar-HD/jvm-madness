package com.xworkz.service.impl;

import com.xworkz.dao.AuthDao;
import com.xworkz.dto.Student;
import com.xworkz.service.AuthService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private AuthDao authDao;

    @Override
    public Student login(Student student)  {
        if(authDao!=null && student!=null){
            try {
                boolean isPresent=authDao.isUserPresent(student.getUsername());
                if(!isPresent){
                    return null;
                }
                return authDao.getStudent(student);


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }
}
