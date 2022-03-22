package com.example.DemoServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;


@WebServlet(name = "Servlet", urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileWriter fw = new FileWriter("database.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dob");
        String phone = request.getParameter("phone");

        bw.newLine();
        bw.write("Name: " + name);
        bw.newLine();
        bw.write("Email: " + email);
        bw.newLine();
        bw.write("Date Of Birth: " + dateOfBirth);
        bw.newLine();
        bw.write("Phone #: " + phone);
        bw.newLine();
        bw.close();

        out.println("<h1>-Contact Information Written to Database-</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Date Of Birth: " + dateOfBirth + "</p>");
        out.println("<p>Phone #: " + phone + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");
        out.println("<p>Here are the contents of the database.</p>");

        try {
            File myObj = new File("database.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                out.println("<p>" + data + "</p>");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            out.println("<p>An error occurred.</p>");
            e.printStackTrace();
        }
        out.println("</body></html>");

    }

}
