package Absents;
import com.mongodb.MongoClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	SqlDB sqldb=new SqlDB();
	public static String date,time,niveau,filiere;
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();


		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(Login.student==null && Login.teacher==null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		 niveau=request.getParameter("Niveau");
		 filiere=request.getParameter("Filiere");
		date=request.getParameter("date");
		time=request.getParameter("de")+"=>"+request.getParameter("a");
	    response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		writer.println(sqldb.getStudentList(niveau,filiere,date,time));
		
		
	}}


