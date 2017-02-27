package sinno.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinno.beans.GestionUser;
import sinno.beans.MailServer;
import sinno.beans.Message;
import sinno.beans.User;

/**
 * Servlet implementation class ReceiveMailServlet
 */
@WebServlet("/ReceiveMail")
public class ReceiveMailServlet extends HttpServlet {
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
    public ReceiveMailServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		Vector<Message> messages = ms.readAllMessages(a.getLogin());
		String s="";
		for (int i=0;i<messages.size();i++){
			s+=messages.elementAt(i).toString();
		}
		request.setAttribute("str", s);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/receivemail.jsp" ).forward( request, response );
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
