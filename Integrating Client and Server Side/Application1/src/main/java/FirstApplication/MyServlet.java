package FirstApplication;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve input from the form
        String username = request.getParameter("username");

        // Process the input (you can perform any business logic here)
        String greeting = "Hello, " + username + "!";

        // Set the response content type
        response.setContentType("text/html");

        // Forward the request to the JSP and pass data
        request.setAttribute("greeting", greeting);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
