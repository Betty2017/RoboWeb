package Resume;

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


@WebServlet("/Experiance")
public class Experiance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Experiance() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pi=request.getParameter("personId");
		String ti=request.getParameter("title");
		String na=request.getParameter("name");
		String du=request.getParameter("duration");
		String d1=request.getParameter("duty1");
		String d2=request.getParameter("duty2");
	
		
		 HttpSession session=request.getSession();  
		 	session.setAttribute("personID_session", pi);
            
	        
		if (request.getParameter("first") != null) {
			
			 java.sql.Connection con=null;
				java.sql.Statement stmt=null;
				ResultSet rs=null;
				String sql = "Insert into JOB(TITLE,COMPANY, DATES,DUTY1,DUTY2,PID) values('"+ti+"','"+na+"','"+du+"','"+d1+"','"+d2+"','"+pi+"')";
							
				System.out.println(sql);
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
		                                + "user=root&password=password");
					stmt = con.createStatement();
					 if(!stmt.execute(sql))
					 {
											
						sql= "Select * from JOB where PID='"+pi+"'";
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
				String nextURL ="/Skills.jsp";
	    	    
			    getServletContext().getRequestDispatcher(nextURL).forward(request,response);		
			
		}
		else if (request.getParameter("second") != null) {
			
			
			java.sql.Connection con=null;
			java.sql.Statement stmt=null;
			ResultSet rs=null;
					
			String sql2 = "Insert into JOB(TITLE,COMPANY, DATES,DUTY1,DUTY2,PID) values('"+ti+"','"+na+"','"+du+"','"+d1+"','"+d2+"','"+pi+"')";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
	                                + "user=root&password=password");
				stmt = con.createStatement();
				 if(!stmt.execute(sql2))
				 {
										
					sql2= "Select * from JOB ";
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
		
				
			}
		
		}

	