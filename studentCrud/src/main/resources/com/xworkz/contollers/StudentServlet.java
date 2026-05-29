package com.sagar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.xworkz.service.StudentService;
import com.xworkz.service.impl.StudentServiceImpl;
import com.xworkz.dto.StudentDTO;
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
          
        StudentService studentService=new StudentServiceImpl();
        StudentDTO data=new StudentDTO(1,"sagar",3);
        studentSerice.saveData(data);
        out.println(data.getName());
    }
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("data saved ...");
    }
}