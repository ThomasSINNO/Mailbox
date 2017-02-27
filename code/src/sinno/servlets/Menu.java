package sinno.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinno.beans.GestionUser;
import sinno.beans.MailServer;
import sinno.beans.User;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		} else {
		this.getServletContext().getRequestDispatcher("/WEB-INF/menu.jsp").forward( request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
