package Resume;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Skills
 */
@WebServlet("/Skills")
public class Skills extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Skills() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pi=request.getParameter("personId");
		String sn=request.getParameter("skillName");
		String pr=request.getParameter("proficency");
		
	
		
		 HttpSession session=request.getSession();  
		 	session.setAttribute("personID_session", pi);
            
	        
		if (request.getParameter("first") != null) {
			
			 java.sql.Connection con=null;
				java.sql.Statement stmt=null;
				ResultSet rs=null;
				String sql = "Insert into SKILL(NAME,PROFICENCY,PID) values('"+sn+"','"+pr+"','"+pi+"')";
							
				System.out.println(sql);
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
		                                + "user=root&password=password");
					stmt = con.createStatement();
					 if(!stmt.execute(sql))
					 {
											
						sql= "Select * from SKILL where PID='"+pi+"'";
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
			
				String sql1 = "select * from PERSON where PID='"+pi+"'";
				
				
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
			           
			            session.setAttribute("personID_session", pi);
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
			    
			    
			    String sql2 = "select * from EDU where PID='"+pi+"'";
			    
			    try {
			    	Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
		                                + "user=root&password=password");
			        stmt = con.createStatement();
			        rs = stmt.executeQuery(sql1);
			        
			        ArrayList <String> Education = new ArrayList<String>();
			        while (rs.next()) {
			        	
			        	
			            String degree = rs.getString("DEGREE");
			            String school = rs.getString("SCHOOL");
			            String gYear = rs.getString("GYEAR");
			            Education.add(degree);
			            Education.add(school);
			            Education.add(gYear);
			            
			            System.out.println(degree + "\t" + school + "\t" + gYear);
			            
			           
				  			
			            session.setAttribute("EductionSesion", Education);
			            session.setAttribute("eduDE_session", degree);
			            session.setAttribute("eduSC_session", school);
			            session.setAttribute("eduGY_session", gYear);
			            
			           
				 		   
			            

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
			    
			    String sql3 = "select * from JOB where PID='"+pi+"'";
			    
			    try {
			    	Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
		                                + "user=root&password=password");
			        stmt = con.createStatement();
			        rs = stmt.executeQuery(sql3);
			        while (rs.next()) {
			            String title = rs.getString("TITLE");
			            String company = rs.getString("COMPANY");
			            String dates = rs.getString("DATES");
			            String duty1 = rs.getString("DUTY1");
			            String duty2 = rs.getString("DUTY2");
			            
			            
			            
			            System.out.println(title + "\t" + company + "\t" + dates+ "\t" + duty1+ "\t" + duty2);
			           
			            session.setAttribute("jobTI_session", title);
			            session.setAttribute("jobCO_session", company);
			            session.setAttribute("jobDA_session", dates);
			            session.setAttribute("jobD1_session", duty1);
			            session.setAttribute("jobD2_session", duty2);

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
			    String sql4 = "select * from SKILL where PID='"+pi+"'";
			    
			    try {
			    	Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
		                                + "user=root&password=password");
			        stmt = con.createStatement();
			        rs = stmt.executeQuery(sql4);
			        while (rs.next()) {
			            String name = rs.getString("NAME");
			            String proficency = rs.getString("PROFICENCY");
			                        
			            
			            
			            System.out.println(name + "\t" + proficency );
			           
			            session.setAttribute("skillNA_session", name);
			            session.setAttribute("skillPR_session", proficency);
			            

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
		else if (request.getParameter("second") != null) {
			
			
			java.sql.Connection con=null;
			java.sql.Statement stmt=null;
			ResultSet rs=null;
					
			String sql2 = "Insert into SKILL(NAME,PROFICENCY,PID) values('"+sn+"','"+pr+"','"+pi+"')";
			try{
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/RESUME?"
	                                + "user=root&password=password");
				stmt = con.createStatement();
				 if(!stmt.execute(sql2))
				 {
										
					sql2= "Select * from SKILL ";
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
			String nextURL ="/Skills.jsp";
			    	    
		    getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}	
		
				
			}
		
		}
