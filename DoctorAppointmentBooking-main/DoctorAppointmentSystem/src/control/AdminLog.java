package control;

import java.io.IOException;
import java.io.PrintWriter;

import daofiles.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLog
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLog() {
        super();
        // TODO Auto-generated constructor stub
    }

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
        
    
    
        if (AdminDao.validate(email, password)) {

            out.println("Welcome" + email);
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);

            response.sendRedirect("AdminHome.jsp");
        } else {

            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

        out.close();

        out.print("</body>");
        out.print("</html>");
    }
}
