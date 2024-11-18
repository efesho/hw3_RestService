package com.example.rest.servlet;

import com.example.rest.dao.AuthorBookDAO;
import com.example.rest.model.AuthorBook;
import com.example.rest.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/author-books")
public class AuthorBookServlet extends HttpServlet {
    private final AuthorBookDAO authorBookDAO = new AuthorBookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String authorIdParam = req.getParameter("authorId");
            String bookIdParam = req.getParameter("bookId");

            List<AuthorBook> result;
            if (authorIdParam != null) {
                int authorId = Integer.parseInt(authorIdParam);
                result = authorBookDAO.getAuthorBooksByAuthorId(authorId);
            } else if (bookIdParam != null) {
                int bookId = Integer.parseInt(bookIdParam);
                result = authorBookDAO.getAuthorBooksByBookId(bookId);
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Missing authorId or bookId parameter");
                return;
            }

            resp.setContentType("application/json");
            resp.getWriter().write(JsonUtil.toJson(result));
        } catch (SQLException | NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error retrieving author-book relations");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AuthorBook authorBook = JsonUtil.fromJson(req.getReader(), AuthorBook.class);
            authorBookDAO.addAuthorBook(authorBook);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error adding author-book relation");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String authorIdParam = req.getParameter("authorId");
            String bookIdParam = req.getParameter("bookId");

            if (authorIdParam != null && bookIdParam != null) {
                int authorId = Integer.parseInt(authorIdParam);
                int bookId = Integer.parseInt(bookIdParam);
                authorBookDAO.deleteAuthorBook(authorId, bookId);
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Missing authorId or bookId parameter");
            }
        } catch (SQLException | NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error deleting author-book relation");
        }
    }
}
