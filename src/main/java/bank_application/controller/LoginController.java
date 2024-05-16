package bank_application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank_application.dao.UserDao;
import bank_application.dto.User;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int accno=Integer.parseInt(req.getParameter("accno"));
		String name=req.getParameter("name");
		
		UserDao dao=new UserDao();
		User dbAccount=dao.getAccount(accno);
		if(dbAccount!=null)
		{
			if(name.equals(dbAccount.getName()));
			{
				req.setAttribute("message", "Login sucsessful \nWelcome!!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("sucess.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				req.setAttribute("message", "Invalid Password, Please Try again");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		}
		else 
		{
			req.setAttribute("message", "User is not Registered, please Register first");
			RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
		}
	}
}


