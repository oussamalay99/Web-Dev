package Absents;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentPortal
 */
@WebServlet("/StudentPortal")
public class StudentPortal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String ABSENCETABLE;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Mongodb mongo=new Mongodb();
    public StudentPortal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(Login.student==null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
		else {
			ABSENCETABLE="<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"<title>Absences</title>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/bootstrap/css/bootstrap.min.css\">\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/animate/animate.css\">\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/select2/select2.min.css\">\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/perfect-scrollbar/perfect-scrollbar.css\">\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/css/util.css\">\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/css/main.css\">\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"<body >\r\n" + 
					"\r\n" + 
					"<div class=\"limiter\">\r\n" + 
					"<div class=\"container-table100\">\r\n" + 
					"<div class=\"wrap-table100\">\r\n" + 
					"<div class=\"table100\">\r\n" + 
					"<div>\r\n" + 
					"<table>\r\n" + 
					"<thead>\r\n" + 
					"<tr class=\"table100-head\">\r\n" + 
					"<th class=\"column1\">"+"</th>\r\n" +
					"<th class=\"column3\">"+Login.student.getNom()+"</th>\r\n" +
					"<th class=\"column3\">"+Login.student.getPrenom()+"</th>\r\n" + 
					"<th class=\"column3\">"+Login.student.getNiveau()+"</th>\r\n" + 
					"<th class=\"column3\">"+Login.student.getFiliere()+"</th>\r\n" + 
					"<th class=\"column1\">"+"</th>\r\n" +
					"</tr>\r\n" + 
					"</thead>\r\n" + 
					"</table></div><br>\r\n" + 
					"<table>\r\n" + 
					"<thead>\r\n" + 
					"<tr class=\"table100-head\">\r\n" + 
					"<th class=\"column1\"></th>\r\n" + 
					"<th class=\"column3\">Date</th>\r\n" + 
					"<th class=\"column3\">Time</th>\r\n" + 
					"<th class=\"column3\">Matiere</th>\r\n" + 
					"<th class=\"column3\">Professeur</th>\r\n" + 
					"<th class=\"column3\">Email</th>\r\n" + 
					"<th class=\"column1\"></th>\r\n" + 
					"</tr>\r\n" + 
					"</thead>\r\n" + 
					"<tbody>"+
					mongo.getabs(Login.student.getEmail())+"</tbody>\r\n" + 
							"</table>\r\n" + 
							"</div>\r\n" + 
							"</div>\r\n" + 
							"</div>\r\n" + 
							"</div>\r\n" + 
							"\r\n" + 
							"<script src=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n" + 
							"\r\n" + 
							"<script src=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/bootstrap/js/popper.js\"></script>\r\n" + 
							"<script src=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
							"\r\n" + 
							"<script src=\"https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/select2/select2.min.js\"></script>\r\n" + 
							"\r\n" + 
							"<script src=\"https://colorlib.com/etc/tb/Table_Responsive_v1/js/main.js\"></script>\r\n" + 
							"\r\n" + 
							"<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-23581568-13\"></script>\r\n" + 
							"<script>\r\n" + 
							"	  window.dataLayer = window.dataLayer || [];\r\n" + 
							"	  function gtag(){dataLayer.push(arguments);}\r\n" + 
							"	  gtag('js', new Date());\r\n" + 
							"\r\n" + 
							"	  gtag('config', 'UA-23581568-13');\r\n" + 
							"	</script>\r\n" + 
							"</body>\r\n" + 
							"</html>";
			response.getWriter().append(ABSENCETABLE);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
