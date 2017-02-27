package sinno.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import sinno.*;
import sinno.beans.GestionUser;
import sinno.beans.MailServer;
import sinno.beans.User;

@WebServlet("/SendMail")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GestionUser uc;
    MailServer ms;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	uc=GestionUser.newInstance();
    	ms=MailServer.newInstance();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException {
    	User a = GestionUser.check(request);
		if (a==null){
			this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		} else {
    	this.getServletContext().getRequestDispatcher("/WEB-INF/sendmail.jsp").forward(request, response);
		}
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
    	
    	User a = GestionUser.check(request);
		if (a==null){
			this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		} else {

      
	  String from = ((User) request.getSession().getAttribute("user")).getLogin();
	  String to =  request.getParameter("to");
	  String subject =  request.getParameter("subject");
	  String message =  request.getParameter("message");	    
	  ms.sendMessage(from, to,subject, message);
	  String s = "Message Sent successfully";
	
	  s+="<br>"; 
	  s+="From    : " + from;
	  s+="<br>"; 
	  s+="To    : " + to;
	  s+="<br>"; 
	  s+="Subject      : " + subject;
	  s+="<br>"; 
	  s+="Message : " + message;

	  s+="<br>"; 
	  s+="<br>"; 

	  request.setAttribute("str", s);
	  this.getServletContext().getRequestDispatcher("/WEB-INF/confirmsendmail.jsp").forward(request , response);
		}
    }
}