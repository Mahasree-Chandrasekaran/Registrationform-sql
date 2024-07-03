package com.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.Register;
import com.model.RegisterDao;

@WebServlet("/Registers")
@MultipartConfig
public class Registers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Part filePart = request.getPart("photo");

        ArrayList<String> list = new ArrayList<>();

        if (fname == null || fname.trim().isEmpty()) {
            list.add("Enter first name field");
        } else {
            fname = fname.trim();
        }

        if (lname == null || lname.trim().isEmpty()) {
            list.add("Enter last name field");
        } else {
            lname = lname.trim();
        }

        if (email == null || email.trim().isEmpty()) {
            list.add("Enter email field");
        } else {
            email = email.trim();
        }

        if (password == null || password.trim().isEmpty()) {
            list.add("Enter password field");
        } else {
            password = password.trim();
        }

        if (filePart == null || filePart.getSize() == 0) {
            list.add("Upload a photo");
        }

        if (!list.isEmpty()) {
            request.setAttribute("errors", list);
            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.forward(request, response);
            return;
        }

        // Assuming you have a directory named "uploads" in your server where you want to save the uploaded files
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Extract file name
        String fileName = extractFileName(filePart);
        filePart.write(uploadPath + File.separator + fileName);

        // Set the file path to the Register object
        Register r = new Register(fname, lname, email, password, fileName);
        RegisterDao ad = new RegisterDao();
        ad.storeData(r);
        RequestDispatcher rd = request.getRequestDispatcher("Acknowledge.html");
        rd.forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf('=') + 2, item.length() - 1);
            }
        }
        return "";
    }

    public String getEmail() {
        return null;
    }

    public String getPassword() {
        return null;
    }
}
