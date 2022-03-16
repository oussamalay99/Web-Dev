package Absents;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MarkAbsents
 */
@WebServlet("/MarkAbsents")
public class MarkAbsents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mongodb mongo=new Mongodb();
    List<String> absentsList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkAbsents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] absents=request.getParameterValues("absent");
		PrintWriter writer = response.getWriter();
		
		
		
		mongo.insertAbs(Dashboard.niveau+'-'+Dashboard.filiere,Dashboard.date,Dashboard.time,Login.teacher.getMatiere(),absents);
	
		request.setAttribute("teacher", Login.teacher);
		request.getRequestDispatcher("Dashboard.jsp").forward(request, response);

		
	}

}
