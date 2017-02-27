package sinno.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sinno.beans.*;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    GestionUser uc;
    MailServer ms;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	uc=GestionUser.newInstance();
    	ms=MailServer.newInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User a = GestionUser.check(request);
		if (a==null){
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Menu").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login =  request.getParameter("login");
		String password =  request.getParameter("password");
		User a = uc.Search(login, password);
		if (a==null){
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);
		} else {
			HttpSession s = request.getSession();
			s.setAttribute("user", a);
			s.setMaxInactiveInterval(50);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		}
		
	}

}
