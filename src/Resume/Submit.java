package Resume;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname= request.getParameter("firstName");
		System.out.print("The  name is " );
		System.out.println(firstname);
		request.setAttribute("firstName", firstname);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from PERSON,EDU,JOB,SKILL where FNAME='"+firstName+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Customers?"
					+ "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String[] vals=new String[12];

				for(int i=0;i<vals.length;i++)
				{
					vals[i]=rs.getString(i+1);
					System.out.print(vals[i] + "\t");

				}


				System.out.println(vals.length);

				String nextURL ="/output.jsp";
				String message ="<h1>Customer ID is "+ vals[11]+"</h1>";
				String message1 =vals[1] +" "+ vals[0]+"\n";
				String message2 =vals[4];
				String message3= vals[5]+vals[6]+vals[7];
				String message4 = vals[8];
				String message5= vals[9]+ vals[10];
				String message6= "Press (1) to search for another customer or press (2) to Edit the customer's address.";


				request.setAttribute("message", message);
				request.setAttribute("message1", message1);
				request.setAttribute("message2", message2);
				request.setAttribute("message3", message3);
				request.setAttribute("message4", message4);
				request.setAttribute("message5", message5);

				request.setAttribute("message6", message6);

				getServletContext().getRequestDispatcher(nextURL).forward(request,response);
			}
		}
		catch(Exception e){System.out.println(e);

		}


		
		
		
		
		
		
		
		
		
		
		
		
		getServletContext().getRequestDispatcher("/output.jsp").forward(request,response);
		
	}

}
