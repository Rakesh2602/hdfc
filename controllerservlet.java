

import java.io.IOException;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 public class controllerservlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public controllerservlet() {
		super();
	}   	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		ControllerAction rl = new ControllerAction();
		Bean bb = new Bean();
		String action=request.getParameter("action");
		
		if(action.equals("update")){
			rl.doupdate(bb);
		}
		else if(action.equals("delete")){
			rl.doDelete(bb.getUsername());
		}
		else if(action.equals("deleteall")){
			rl.doDeleteall(bb);
		}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double amount=Double.parseDouble(request.getParameter("amount"));
		Double inter=Double.parseDouble(request.getParameter("rate"));
		Double month=Double.parseDouble(request.getParameter("month"));
		String user=request.getParameter("user");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Double loanAmount = amount;
		double rateOfInterest = inter;
		Double numberOfMonths = month;
		double temp = 1200;           //100*numberofmonths(12))
		double interestPerMonth = rateOfInterest/temp;
		
		double interestpayable = Math.round(loanAmount*(rateOfInterest/100)*numberOfMonths)/365; 

        double onePlusInterestPerMonth = 1 + interestPerMonth;

        double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,numberOfMonths);

        double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;

        double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;

		double principleMultiplyInterestPerMonth = loanAmount * interestPerMonth;

        double totalEmi =  principleMultiplyInterestPerMonth*divides;

        double finalValue = Math.round( totalEmi * 100.0 ) / 100.0;
        
        double totalpayment = loanAmount + interestpayable;

        Bean ra = new Bean();
        ra.setId(id);
        ra.setUsername(user);
        ra.setEnterthenumberofmonths(month);
        ra.setEntertheniterestrate(inter);
        ra.setEntertheamount(amount);
        ra.setTotalpayment(totalpayment);
        ra.setInterestpayable(interestpayable);
        ra.setFinalValue(finalValue);
        
        ControllerAction re=new ControllerAction();
        boolean status=re.registerDetail(ra);
        
        
	 request.setAttribute("emi_payable", finalValue);
	 request.setAttribute("total_interest", interestpayable);
	 request.setAttribute("totalpay", totalpayment);
	request.getRequestDispatcher("/emi.jsp").forward(request,response);
}   	  	    
}