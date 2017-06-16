package Resume;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String personId= request.getParameter("personId");
		request.setAttribute("personId", personId);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
				
		
		String sql = "select * from PERSON where PID='"+personId+"'";
	
			
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
                                + "user=root&password=password");
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	        	
	            String firstName = rs.getString("FNAME");
	            String LastName = rs.getString("LNAME");
	            String email = rs.getString("EMAIL");
	            
	            System.out.println(firstName + "\t" + LastName + "\t" + email);
	           
	            session.setAttribute("personID_session", personId);
	            session.setAttribute("personFN_session", firstName);
	            session.setAttribute("personLN_session", LastName);
	            session.setAttribute("personEM_session", email);

	        }
	    } catch (SQLException e ) {
	    	System.out.println(e);
	    }catch (ClassNotFoundException e ) {
	    	System.out.println(e);
	    }
	    finally {
	        if (stmt != null) { 
	        	try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
	    }
	    
	    
	    String sql1 = "select * from EDU where PID='"+personId+"'";
	   
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
                                + "user=root&password=password");
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(sql1);
	        
	        String degreeText = " " ;
	        while (rs.next()) {
	        	
	            String degree = rs.getString("DEGREE");
	            String school = rs.getString("SCHOOL");
	            String gYear = rs.getString("GYEAR");
	           
	            
	            System.out.println(degree + "\t" + school + "\t" + gYear);
	            
	          degreeText = degreeText + degree+" <br/> "+school+" "+gYear+"<br/><br/>";
	                    
	            session.setAttribute("eduCO_session", degreeText);
	           
	        
		 		   
	            

	        }
	    } catch (SQLException e ) {
	    	System.out.println(e);
	    }catch (ClassNotFoundException e ) {
	    	System.out.println(e);
	    }
	    finally {
	        if (stmt != null) { 
	        	try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
	    }
	    
	    String sql3 = "select * from JOB where PID='"+personId+"'";
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
                                + "user=root&password=password");
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(sql3);
	        
	        String jobText ="";
	        
	        while (rs.next()) {
	            String title = rs.getString("TITLE");
	            String company = rs.getString("COMPANY");
	            String dates = rs.getString("DATES");
	            String duty1 = rs.getString("DUTY1");
	            String duty2 = rs.getString("DUTY2");
	            
	            
	            
	            System.out.println(title + "\t" + company + "\t" + dates+ "\t" + duty1+ "\t" + duty2);
	           
	            jobText = jobText + title+" <br/> "+company+" "+dates+"<br/>"+" Duty1" +duty1+" <br/>"+"Duty2"+duty2+" <br/><br/>";            
	           
	            session.setAttribute("jobCO_session", jobText);

	            
	        }
	    } catch (SQLException e ) {
	    	System.out.println(e);
	    }catch (ClassNotFoundException e ) {
	    	System.out.println(e);
	    }
	    finally {
	        if (stmt != null) { 
	        	try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
	    }
	    String sql4 = "select * from SKILL where PID='"+personId+"'";
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
                                + "user=root&password=password");
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(sql4);
	        
	        String skillText="";
	        
	        while (rs.next()) {
	            String name = rs.getString("NAME");
	            String proficency = rs.getString("PROFICENCY");
	                        
	            
	            
	            System.out.println(name + "\t" + proficency );
	            
	            skillText= skillText+name+"<br/>"+proficency+"<br/><br/>";
	            
	            session.setAttribute("skillCO_session", skillText);
	            
	            

	        }
	    } catch (SQLException e ) {
	    	System.out.println(e);
	    }catch (ClassNotFoundException e ) {
	    	System.out.println(e);
	    }
	    finally {
	        if (stmt != null) { 
	        	try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
	    }
	    
	    
	    String nextURL ="/output.jsp";
				
	    	    
	    getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}
		
}	

				
				
	



		