package Absents;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	Map<String, String> currentUser = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;
	public static Student student;
	public static Teacher teacher;
	static String type="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(Login.student==null && Login.teacher==null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		PrintWriter writer= response.getWriter();
		
		if (login(email,password)!="") {
			getInfo(email,login(email,password));
			if (login(email,password).equals("student")) {
				
				
				response.sendRedirect(request.getContextPath() + "/StudentPortal");
	            //response.sendRedirect("loginsuccess.html");
			
				}
			else if (login(email,password).equals("teacher")){
				request.setAttribute("teacher", teacher);
				request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
				}
			
        } else {
        	writer.println("Wrong  info");
			writer.flush();
        }
	}
	public String login(String email,String password) {
			type="";

	        boolean status = false;

	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2381889?useSSL=false", "sql2381889", "hX3!rC8!");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select Type from login where Email = ? and Password = ? ")) {
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            status = rs.next();
	            type = rs.getString("Type");
	            /*
	            if(status) {
	            	type = rs.getString("Type");
	            	Map userInfo=getInfo(email,type);
	            	if (type=="student") {
	            		Student student=new Student(email,userInfo.get("nom").toString(),userInfo.get("prenom").toString(),userInfo.get("niveau").toString(),userInfo.get("filiere").toString());
	            	}
	            	else {
	            		Teacher teacher=new Teacher(email,userInfo.get("nom").toString(),userInfo.get("prenom").toString(),userInfo.get("matiere").toString());
	            	}
	            }*/
	            

	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	        }
	        return type;
	    }
	void getInfo(String email,String type) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2381889?useSSL=false", "sql2381889", "hX3!rC8!");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from "+type+"s where Email = ?  ")) {
	            preparedStatement.setString(1, email);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            if(rs.next()) {
	            	if(type.equals("student")) {
	            		student=new Student(email,rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Niveau"),rs.getString("Filiere"));
	            		

	            	}
	            	else if(type.equals("teacher")) {
	            		teacher=new Teacher(email,rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Matiere"));
	            		

	            	}
	            	
	            }
	            else {
	            	System.out.println("Err sql2");
	            }
	            
	           
	            

	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	        }
		
	}

	   

}
