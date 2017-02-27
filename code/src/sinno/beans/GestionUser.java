package sinno.beans;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

public class GestionUser {

	public Vector<User> users;
    private static GestionUser  instance=null;
    // ajouter ici les variables que vous jugez nécessaires

    public GestionUser(){
	users=new Vector<User>();
    }

    public static GestionUser   newInstance(){
	if (instance==null)
	    instance=new  GestionUser();
		User a = new User();
		a.setLogin("bob");
		a.setPassword("bob");
		instance.users.add(a);
		User b = new User();
		b.setLogin("fred");
		b.setPassword("fred");
		instance.users.add(b);
	return instance;       
    }
    
    public User Search(String l, String p){
    	for (int i=0;i<users.size();i++){
    		if (users.elementAt(i).login.equals(l)){
    			if (users.elementAt(i).password.equals(p)){
    				return users.elementAt(i);
    			}
    		}
    		
    	}
    	return null;
    }
    
    public static User check(HttpServletRequest request){
    	if (request.getSession(false)==null){
    		return null;
    	} else {
    		User a = ((User) request.getSession().getAttribute("user"));
    		if (a==null){
    			return null;
    		} else {
    			return a;
    		}
    	}
    }
}
