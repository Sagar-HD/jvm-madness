package com.xworkz.service;

import java.util.List;

import com.xworkz.dto.StudentDTO;

public interface StudentService {

    boolean saveData(StudentDTO dto);

    StudentDTO getDataById(int id);

    List<StudentDTO> getAllData();

    boolean updateData(StudentDTO dto);

    boolean deleteData(int id);
}