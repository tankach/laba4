import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sumdu.edu.ua.webstudent.Student;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        if (students == null) {
            students = new LinkedList<>();
            getServletContext().setAttribute("students", students);
        }

        if (!"".equals(request.getParameter("name")) || !"".equals(request.getParameter("surname"))) {
            Student student = new Student(
                    request.getParameter("name"),
                    request.getParameter("surname"),
                    request.getParameter("email"),
                    request.getParameter("group"),
                    request.getParameter("faculty"));
            students.add(student);

            // Set the students list as an attribute in the request
            request.setAttribute("students", students);
        }

        // Redirect to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Student.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
