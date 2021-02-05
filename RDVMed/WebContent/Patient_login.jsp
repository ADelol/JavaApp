<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Page de connexion</title>
</head>
<style>
body {
	background-image:url('/PriseRDVMed/images/image1.png');
	background-size:100%;
	margin : 10px  ;
	width : 100%;
	height: 100%;
	font-family: sans-serif;
	
	
}
.header{
    height:50px;
    width: 100%;
	z-index:1;
    background-color:#009FCC;
	
}
.header img{
    position:absolute;
    margin-bottom:50px;
    padding-bottom: 40px;
    padding-left:650px;
	width: 80%;

}
.header>ul>li{
    list-style: none;
    display:inline-block;
    font-size: 90%;
    padding-left: 12%;
    padding-bottom: 1%;
}
ul{
    padding-top:1%;
	padding-left: 15%;
	border-bottom:1px solid #CCEEFF;
	
}
a{
    text-decoration: none;
}
a:link{
    color: gainsboro;
}
a:visited{
    color: gainsboro;
}
a:hover{
    color: white;
}
a:active{
    color: white;
}
.logGet { 
          position: absolute; 
          left: 50%; 
          top: 65%; 
          width: 450px; 
          height: 400px; 
		  margin: -300px 0 0 -215px; 
		  border: 8px solid #fff; 
		  border-radius: 30px; 
		  overflow: hidden;
		  
		 
		  }
 
 
 .logGet .p1{
	      
	      display: inline-block;
	      font-size: 28px;
	      margin-top: 30px;
	      width: 86%;
		  margin-left:30%;
		  color: #fff;
		  font-family:'lucida grande';
		
 
 }
 
 
 .logD { 
           position: relative; 
		   width: 360px; 
		   margin: 0 auto; 
		   padding-bottom: 30px;
		   }
.logD input { 
           
		   width: 288px; 
		   height: 48px; 
		   padding-left: 70px; 
		   border: 2.8px solid #fff; 
		   border-radius: 25px; 
		   font-size: 18px; 
		   color: #fff; 
		   background-color: transparent; 
		   outline: none;
		   }
.logD #submit { 
             
			width: 360px; 
			height: 50px; 
			border: 0; 
			border-radius: 25px; 
			font-size: 18px; 
			
			color: #fff; 
			outline: none; 
			cursor: pointer; 
			background-color: #009FCC; 
			font-family:'lucida grande';
			
			}

.logBar { 
             width: 360px; 
			 margin: 2px auto 0; 
			 font-size: 20px; 
			 overflow: hidden;
		}
.logBar a {  
             color: #fff; 
			 text-decoration: none; 
		}
.logBar a:hover { 
              
			  text-decoration: underline; }
.logBar .ins { float: left; }
.logBar .forget { float: right; }

</style>

<body>
<form action="login" method="post">
<div class="header">
        <ul>
         <li><a href="/PriseRDVMed/Patient/Patient_registre.jsp">S'enregistrer</a></li>
		</ul>
		
    </div>
	
	
	
	
	<div class="logGet">
	 <div class="log"><p class="p1">CONNEXION</p></div>
	 <div class="logD">
		<input id="username" type="text" autocomplete="off" placeholder="Adresse mail" />
	 </div>
	 <div class="logD">
		<input id="password" type="text" autocomplete="off" placeholder="Mot de passe" />
	 </div>
	 <div class="logD"><input type="submit" value="CONNECTER" id="submit"></div>
	 

	 <div class="logBar">
	    <a class="ins" href="/PriseRDVMed/Patient/Patient_registre.jsp"> S'inscrire</a>
		 </div>
	 </div>
</form>
</body>
</html>