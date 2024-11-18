package com.example.rest.servlet;

import com.example.rest.dao.AuthorDAO;
import com.example.rest.model.Author;
import com.example.rest.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
    private final AuthorDAO authorDAO = new AuthorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Author> authors = authorDAO.getAllAuthors();
            resp.setContentType("application/json");
            resp.getWriter().write(JsonUtil.toJson(authors));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error fetching authors");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Author author = JsonUtil.fromJson(req.getReader(), Author.class);
            authorDAO.addAuthor(author);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error adding authors");
        }
    }
}
