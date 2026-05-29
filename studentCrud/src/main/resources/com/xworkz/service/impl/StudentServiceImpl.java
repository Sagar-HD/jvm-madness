package com.xworkz.service;

import com.xworkz.dao.StudentDAO;
import com.xworkz.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

    private StudentDAO dao = new StudentDAO();

    @Override
    public boolean saveData(StudentDTO dto) {

        if (dto == null) {
            System.out.println("DTO is null");
            return false;
        }

        if (dto.getId() <= 0) {
            System.out.println("Invalid id");
            return false;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            System.out.println("Invalid name");
            return false;
        }

        if (dto.getTotalMarks() < 0 || dto.getTotalMarks() > 100) {
            System.out.println("Invalid total marks");
            return false;
        }

        dao.saveData(dto);

        System.out.println("Data saved successfully");

        return true;
    }
}