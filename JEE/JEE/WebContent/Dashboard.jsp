<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="https://colorlib.com/etc/tb/Table_Responsive_v1/images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/animate/animate.css">

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/vendor/perfect-scrollbar/perfect-scrollbar.css">

<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/css/util.css">
<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/tb/Table_Responsive_v1/css/main.css">

<title>Dashboard</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
<style type="text/css">
.form-style-8{
	font-family: 'Open Sans Condensed', arial, sans;
	width: 500px;
	padding: 30px;
	background: #FFFFFF;
	margin: 50px auto;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

}
.form-style-8 h2{
	background: #4D4D4D;
	text-transform: uppercase;
	font-family: 'Open Sans Condensed', sans-serif;
	color: #797979;
	font-size: 18px;
	font-weight: 100;
	padding: 20px;
	margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 textarea,
.form-style-8 select 
{
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	outline: none;
	display: block;
	width: 100%;
	padding: 7px;
	border: none;
	border-bottom: 1px solid #ddd;
	background: transparent;
	margin-bottom: 10px;
	font: 16px Arial, Helvetica, sans-serif;
	height: 45px;
}
.form-style-8 textarea{
	resize:none;
	overflow: hidden;
}
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
	-moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	-webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	box-shadow: inset 0px 1px 0px 0px #45D6D6;
	background-color: #2CBBBB;
	border: 1px solid #27A0A0;
	display: inline-block;
	cursor: pointer;
	color: #FFFFFF;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 14px;
	padding: 8px 18px;
	text-decoration: none;
	text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
	background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
	background-color:#34CACA;
}
</style>
<title>Dashboard</title>
</head>
<body>  
<%@ page import = "Absents.Login,Absents.Teacher" %>

<%
	if(Absents.Login.teacher==null){
	response.sendRedirect(request.getContextPath() + "/index.jsp");
}

%>
<% Teacher teacher =(Teacher)request.getAttribute("teacher");%>
<div class="limiter">
	<div class="container-table100">
	<div class="wrap-table100">
	<div class="table100">

<div class="form-style-8"  style=" float:left;  margin:10px">
  <h2>Mon profile</h2>
  
  <form action="Dashboard" method="post">
  <h1 style=font-size:25px>
		Nom: <%=teacher.getNom() %>  <br>
Prenom: <%=teacher.getPrenom() %> <br>
Matiere: <%=teacher.getMatiere() %> <br>
</h1>
	</form>
</div>
<div class="form-style-8"   style=" float:left;  margin:10px">
  <h2>Selectionner le niveau, filiere et horaire</h2>
  <form action="Dashboard" method="post">
		Niveau :<Select type="text" name="Niveau">
			<option value="INE1">INE1</option>
			<option value="INE2">INE2</option>
			<option value="INE3">INE3</option>
		</select><br> <br> Filière :<Select type="text" name="Filiere">
			<option value="DATA">DATA</option>
			<option value="ICCN">ICCN</option>
			<option value="CLOUD">CLOUD</option>
			<option value="ASEDS">ASEDS</option>
			<option value="AMOA">AMOA</option>
			<option value="SMART">SMART</option>
			<option value="SESNUM">SESNUM</option>

		</select><br> 
		<label for="start">Date:</label> <input type="date"
			 name="date" value="2020-12-22" min="2020-09-10"
			max="2021-07-10"> De: <input type="time" name="de" min="09:00" max="18:00" >A:<input type="time" name="a" min="09:00" max="18:00" >
			<br> 
			<input type="submit" value="Insert"/>

	</form>
</div>
   <center>
	
	</center>
	</div></div></div></div> 
</body>
</html>