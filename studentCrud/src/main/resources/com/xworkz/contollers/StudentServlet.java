package com.sagar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.dto.StudentDTO;
import com.xworkz.service.StudentService;
import com.xworkz.service.impl.StudentServiceImpl;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService =
            new StudentServiceImpl();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>Student Servlet Working...</h2>");
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        String name =
                request.getParameter("name");

        int totalMarks =
                Integer.parseInt(
                        request.getParameter("totalMarks"));

        StudentDTO dto =
                new StudentDTO(
                        id,
                        name,
                        totalMarks);

        boolean saved =
                studentService.saveData(dto);

        if (saved) {

            out.println("<h2>Data Saved Successfully</h2>");
            out.println("<h3>Name : " + dto.getName() + "</h3>");
            out.println("<h3>Total Marks : " + dto.getTotalMarks() + "</h3>");

        } else {

            out.println("<h2>Failed To Save Data</h2>");
        }
    }
}