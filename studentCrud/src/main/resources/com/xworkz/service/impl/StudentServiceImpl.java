package com.xworkz.service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public StudentDTO getDataById(int id) {

        System.out.println("Getting data by id : " + id);

        return new StudentDTO(
                id,
                "Dummy Student",
                85);
    }

    @Override
    public List<StudentDTO> getAllData() {

        System.out.println("Getting all student data");

        List<StudentDTO> list = new ArrayList<>();

        list.add(new StudentDTO(1, "Sagar", 90));
        list.add(new StudentDTO(2, "Rahul", 80));
        list.add(new StudentDTO(3, "Kiran", 70));

        return list;
    }

    @Override
    public boolean updateData(StudentDTO dto) {

        System.out.println("Updating data");

        return true;
    }

    @Override
    public boolean deleteData(int id) {

        System.out.println("Deleting data for id : " + id);

        return true;
    }
}