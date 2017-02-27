package sinno.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinno.beans.*;

/**
 * Servlet implementation class DeleteMailServlet
 */
@WebServlet("/DeleteMail")
public class DeleteMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GestionUser uc;
    MailServer ms;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	uc=GestionUser.newInstance();
    	ms=MailServer.newInstance();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User a = GestionUser.check(request);
		if (a==null){
			this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		} else {
		String d = ms.removeMessages(a.getLogin());
		request.setAttribute("del", d);
		this.getServletContext().getRequestDispatcher("/WEB-INF/deletemail.jsp").forward(request, response);
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
