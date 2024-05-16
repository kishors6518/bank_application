package bank_application.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank_application.dao.UserDao;
import bank_application.dto.Bank;
import bank_application.dto.User;

@WebServlet("/saveUser")
public class SaveUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		double balance=Double.parseDouble(req.getParameter("balance"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		
		Bank bank=new Bank();
		bank.setBname("SBI");
		bank.setIfsc("SBI@123");
		
		User user=new User();
		user.setName(name);
		user.setBalance(balance);
		user.setPhone(phone);
		user.setAddress(address);
		user.setB1(bank);
		
		UserDao dao=new UserDao();
		dao.saveUser(user);
	}

}
