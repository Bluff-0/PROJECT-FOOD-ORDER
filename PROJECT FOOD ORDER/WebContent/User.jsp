<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Project Food Service</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<style>
    body
    {
        background-color: cornsilk;
        background-image: url(i/bg2.jpg);
    }
	.OrderDetails
	{
		border-color: red;
		border-style: double;
		border-width: 10px;
		background-color: white;
		border-radius:13px;
	}
    .banner
    {
        opacity: 0.9;
        background-color:bisque;
        align-content: center;
    }
    .itemb
    {
        text-decoration: none;
        font-family: Arial Rounded MT;
        font-size: 20px;
        color: darkslateblue;
        border-color: darkblue;
        padding: 15px 30px;
        border-radius: 15%;
        background-color: powderblue;
    }
   .menub
    {
            text-decoration: none;
            color: black;
            padding: 15px 10px;
            border-radius: 25%;
            background-color: darkgoldenrod;
    }
    .menub:hover{
                    color: antiquewhite;
                    background-color: brown;
                    transition: 0.2s;
                }
    .mid{
            background-color: aliceblue;
            height: 300px;
            width: 630px;
            border-color: dodgerblue;
            border-radius: 15%;
            opacity: 0.9;
			text-align: center;
        }
    .od1{
        width: 33%; 
        height: 30px;  
        color: darkblue;
        font-size: 20px;
    }
    .od2{
        width: 33%; 
        height: 30px;  
        color: darkgreen;
        font-size: 15px;
    }
</style>
<script>
   function goal()
    {
        alert("Logged Out Successfully.");
        
    }
</script>
<body></body>
</html>