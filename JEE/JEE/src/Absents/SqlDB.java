package Absents;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDB {
	String OUTPUT="";
    
	public SqlDB() {
		
	}
	public String getStudentList(String niveau,String filiere,String date,String time) {
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
	            .prepareStatement("select Nom,Prenom,Email from students where Niveau = ? and Filiere = ? order by Nom ASC ")) {
	            preparedStatement.setString(1, niveau);
	            preparedStatement.setString(2, filiere);
	            ResultSet rs = preparedStatement.executeQuery();
	            OUTPUT="<html>\r\n" + 
	            		"<head>\r\n" + 
	            		"<meta charset=\"UTF-8\">\r\n" + 
	            		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	            		"\r\n" + 
	            		"<link rel=\"icon\" type=\"image/png\" href=\"https://colorlib.com/etc/tb/Table_Responsive_v1/images/icons/favicon.ico\" />\r\n" + 
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
	            		"<title>Dashboard</title>\r\n" + 
	            		"<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>\r\n" + 
	            		"<style type=\"text/css\">\r\n" + 
	            		".form-style-8{\r\n" + 
	            		"	font-family: 'Open Sans Condensed', arial, sans;\r\n" + 
	            		"	width: 500px;\r\n" + 
	            		"	padding: 30px;\r\n" + 
	            		"	background: #FFFFFF;\r\n" + 
	            		"	margin: 50px auto;\r\n" + 
	            		"	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);\r\n" + 
	            		"	-moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);\r\n" + 
	            		"	-webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);\r\n" + 
	            		"\r\n" + 
	            		"}\r\n" + 
	            		".form-style-8 h2{\r\n" + 
	            		"	background: #4D4D4D;\r\n" + 
	            		"	text-transform: uppercase;\r\n" + 
	            		"	font-family: 'Open Sans Condensed', sans-serif;\r\n" + 
	            		"	color: #797979;\r\n" + 
	            		"	font-size: 18px;\r\n" + 
	            		"	font-weight: 100;\r\n" + 
	            		"	padding: 20px;\r\n" + 
	            		"	margin: -30px -30px 30px -30px;\r\n" + 
	            		"}\r\n" + 
	            		".form-style-8 input[type=\"text\"],\r\n" + 
	            		".form-style-8 input[type=\"date\"],\r\n" + 
	            		".form-style-8 input[type=\"datetime\"],\r\n" + 
	            		".form-style-8 input[type=\"email\"],\r\n" + 
	            		".form-style-8 input[type=\"number\"],\r\n" + 
	            		".form-style-8 input[type=\"search\"],\r\n" + 
	            		".form-style-8 input[type=\"time\"],\r\n" + 
	            		".form-style-8 input[type=\"url\"],\r\n" + 
	            		".form-style-8 input[type=\"password\"],\r\n" + 
	            		".form-style-8 textarea,\r\n" + 
	            		".form-style-8 select \r\n" + 
	            		"{\r\n" + 
	            		"	box-sizing: border-box;\r\n" + 
	            		"	-webkit-box-sizing: border-box;\r\n" + 
	            		"	-moz-box-sizing: border-box;\r\n" + 
	            		"	outline: none;\r\n" + 
	            		"	display: block;\r\n" + 
	            		"	width: 100%;\r\n" + 
	            		"	padding: 7px;\r\n" + 
	            		"	border: none;\r\n" + 
	            		"	border-bottom: 1px solid #ddd;\r\n" + 
	            		"	background: transparent;\r\n" + 
	            		"	margin-bottom: 10px;\r\n" + 
	            		"	font: 16px Arial, Helvetica, sans-serif;\r\n" + 
	            		"	height: 45px;\r\n" + 
	            		"}\r\n" + 
	            		".form-style-8 textarea{\r\n" + 
	            		"	resize:none;\r\n" + 
	            		"	overflow: hidden;\r\n" + 
	            		"}\r\n" + 
	            		".form-style-8 input[type=\"button\"], \r\n" + 
	            		".form-style-8 input[type=\"submit\"]{\r\n" + 
	            		"	-moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;\r\n" + 
	            		"	-webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;\r\n" + 
	            		"	box-shadow: inset 0px 1px 0px 0px #45D6D6;\r\n" + 
	            		"	background-color: #2CBBBB;\r\n" + 
	            		"	border: 1px solid #27A0A0;\r\n" + 
	            		"	display: inline-block;\r\n" + 
	            		"	cursor: pointer;\r\n" + 
	            		"	color: #FFFFFF;\r\n" + 
	            		"	font-family: 'Open Sans Condensed', sans-serif;\r\n" + 
	            		"	font-size: 14px;\r\n" + 
	            		"	padding: 8px 18px;\r\n" + 
	            		"	text-decoration: none;\r\n" + 
	            		"	text-transform: uppercase;\r\n" + 
	            		"}\r\n" + 
	            		".form-style-8 input[type=\"button\"]:hover, \r\n" + 
	            		".form-style-8 input[type=\"submit\"]:hover {\r\n" + 
	            		"	background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);\r\n" + 
	            		"	background-color:#34CACA;\r\n" + 
	            		"}\r\n" + 
	            		"</style>\r\n" + 
	            		"</head>\r\n" + 
	            		"<body> \r\n" + 
	            		"<div class=\"limiter\">\r\n" + 
	            		"	<div class=\"container-table100\">\r\n" + 
	            		"	<div class=\"wrap-table100\">\r\n" + 
	            		"	<div class=\"table100\">\r\n" + 
	            		"\r\n" + 
	            		"<div class=\"form-style-8\"  style=\" float:left;  margin:10px\">\r\n" + 
	            		"  <h2>Séance : </h2>\r\n" + 
	            		"  <form action=\"Dashboard\" method=\"post\">\r\n" + 
	            		"  <h1 style=font-size:25px>\r\n" + 
	            		"		Nom: "+Login.teacher.getNom()+"  <br>\r\n" + 
	            		"Prenom: "+Login.teacher.getPrenom()+" <br>\r\n" + 
	            		"Matiere: "+Login.teacher.getMatiere()+" <br>\r\n" + 
	            		"Niveau: "+niveau+" <br>\r\n" + 
	            		"Filiere: "+filiere+"<br>\r\n" + 
	            		"Date: "+date+" <br>\r\n" + 
	            		"Time: "+time+" <br>  <h1>\r\n" + 
	            		"	</form>\r\n" + 
	            		"</div>\r\n" + 
	            		"<div class=\"form-style-8\"   style=\" float:left;  margin:10px\">\r\n" + 
	            		"  <h2>Cocher les absents :</h2>\r\n" + 
	            		"  <form action=\"MarkAbsents\" method=\"post\">"+"<h1 style=font-size:25px>";
	            

	            while (rs.next()) {
	                String Nom = rs.getString("Nom");
	                String Prenom = rs.getString("Prenom");
	                String Email = rs.getString("Email");
	                OUTPUT=OUTPUT + "<input type=\"checkbox\" name=\"absent\" value=\"+Email+\" style=\"display: inline-block\">"+"  "+Nom+" "+Prenom+'\n'+"</input><br>";
	               
	              }
	            OUTPUT=OUTPUT+"<h1><br><br><input type=\"submit\" value=\"Enregistrer\"/></form>\r\n" + 
	            		"</div>\r\n" + 
	            		"   <center>\r\n" + 
	            		"	\r\n" + 
	            		"	</center>\r\n" + 
	            		"	</div></div></div></div> \r\n" + 
	            		"</body>\r\n" + 
	            		"</html>";
	            
	            
	            

	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	        }
		return OUTPUT;
	}
	public String getTeacherName(String email) {
		String Fullname="";
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
	            .prepareStatement("select Nom,Prenom from teachers where Email = ? ")) {
	            preparedStatement.setString(1, email);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            
	            if (rs.next()) {
	                Fullname=rs.getString("Nom")+" "+rs.getString("Prenom");
	                
	              }
	           
	            
	            
	            

	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	        }
		return Fullname;
	}

}
