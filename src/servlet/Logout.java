package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("aaaaaaa");
		req.getSession().invalidate();
		

	    Cookie[] cookies = req.getCookies();

		
		for(Cookie c:cookies) {
			if(c.getName().equals("token")) {
				c.setMaxAge(0);
				resp.addCookie(c);
			}
		}
		
		String basePath=req.getScheme()
				+"://"
				+req.getServerName()
				+":"
				+req.getServerPort()
				+req.getContextPath()
				+"/";
		

		resp.sendRedirect(basePath+"entrada");
		
	}
	
	
	
}
