package control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import daofiles.PatientDao;

/**
 * Servlet implementation class PatientLog
 */
@WebServlet("/PatientLog")
public class PatientLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientLog() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AdminDocReg</title>");
        out.println("</head>");
        out.print("<body>");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (PatientDao.validate(email, password)) {

            out.println("Welcome" + email);
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);

            response.sendRedirect("PatientHome.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
        }

        out.close();

        out.print("</body>");
        out.print("</html>");
    }

}
