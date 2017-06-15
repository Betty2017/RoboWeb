package Resume;

import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Submit() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String pi=request.getParameter("personId");
				String fn=request.getParameter("firstName");
				String ln=request.getParameter("lastName");
				String email=request.getParameter("email");
				String de=request.getParameter("degree");
				String sc=request.getParameter("school");
				String gy=request.getParameter("year");
				
				 HttpSession session=request.getSession();  
			        session.setAttribute("perId",pi); 
			        
		if (request.getParameter("first") != null) {
		  			      	        
	        java.sql.Connection con=null;
			java.sql.Statement stmt=null;
			ResultSet rs=null;
			String sql = "Insert into PERSON(PID,FNAME, LNAME,EMAIL) values('"+pi+"','"+fn+"','"+ln+"','"+email+"')";
			
			
			System.out.println(sql);
			
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
	                                + "user=root&password=password");
				stmt = con.createStatement();
				 if(!stmt.execute(sql))
				 {
										
					sql= "Select * from PERSON where FNAME='"+fn+"' and LNAME='"+ln+"'";
					stmt=con.createStatement();
					rs=(ResultSet) stmt.executeQuery(sql);
					
				
					
					while(rs.next()){
						System.out.print(rs.getString(1) + "\t");
						System.out.print(rs.getString(2));
						System.out.println();
					}
										
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			
			
			
			String sql2 = "Insert into EDU(DEGREE,SCHOOL,GYEAR,PID) values('"+de+"','"+sc+"','"+gy+"','"+pi+"')";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
	                                + "user=root&password=password");
				stmt = con.createStatement();
				 if(!stmt.execute(sql2))
				 {
										
					sql2= "Select * from EDU ";
					stmt=con.createStatement();
					rs=(ResultSet) stmt.executeQuery(sql2);
					
				
					
					while(rs.next()){
						System.out.print(rs.getString(1) + "\t");
						System.out.print(rs.getString(2));
						System.out.println();
					}
										
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			String nextURL ="/Experiance.jsp";
			    	    
		    getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	        
	}
		else if (request.getParameter("second") != null) {
			String nextURL ="/Education.jsp";
			    	    
		    getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}	
		
	}
	
		
	
		
	}


