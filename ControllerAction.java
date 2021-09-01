import java.sql.*;


public class ControllerAction {
	Connection con=null;
	public boolean registerDetail(Bean sib){
		boolean status=false;
		Integer id=sib.getId();
		String userid=sib.getUsername();
		Double loan_tenure=sib.getEnterthenumberofmonths();
		Double rate_of_interest=sib.getEntertheniterestrate();
		Double loan_amount=sib.getEntertheamount();
		Double total_interest=sib.getInterestpayable();
		Double total_amount=sib.getTotalpayment();
		Double interest_permonth=sib.getFinalValue();



		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rakesh","rakesh");
			Statement st=con.createStatement();
			int i = st.executeUpdate("insert into hdfc values("+loan_amount+","+rate_of_interest+","+loan_tenure+",'"+userid+"',"+interest_permonth+","+total_interest+","+id+")");
			if(i>0){
				//status=true;
				System.out.println(i);
			}

		}catch(Exception e){
			System.out.print(e);
		}
		return status;
	}


public boolean doupdate(Bean ra) {
	boolean status=false;
	Integer id=ra.getId();
	String userid=ra.getUsername();
	Double loan_tenure=ra.getEnterthenumberofmonths();
	Double rate_of_interest=ra.getEntertheniterestrate();
	Double loan_amount=ra.getEntertheamount();
	Double total_interest=ra.getInterestpayable();
	Double total_amount=ra.getTotalpayment();
	Double interest_permonth=ra.getFinalValue();
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rakesh","rakesh");
		Statement st=con.createStatement();
		st = con.createStatement();
		int i=st.executeUpdate("update hdfc set loan_amount= "+loan_amount+",rate_of_interest = "+rate_of_interest+",loan_tenure ="+loan_tenure+",userid= "+userid+", interest_permonth ="+interest_permonth+",total_interest= "+total_interest+",id= "+id+"");
		if(i>0){
			status=true;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return status;

}
public boolean doDelete(String Username) {
	boolean status=false;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rakesh","rakesh");
		Statement st=con.createStatement();
		st = con.createStatement();
		int i=st.executeUpdate("delete hdfc where userid='"+Username+"'");
		if(i>0){
			status=true;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	
	return status;
}


public boolean doDeleteall(Bean ra)  {
	boolean status=false;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rakesh","rakesh");
		Statement st=con.createStatement();
		st = con.createStatement();
		ResultSet rs=st.executeQuery("truncate table hdfc");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	
	return true;
}
}