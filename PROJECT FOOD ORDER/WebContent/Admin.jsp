<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Project Food Service</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    body
    {
        background-color: cornsilk;
        background-image: url(i/bg2.jpg);
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
        font-family: cursive;
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
            height: auto;
            width: 550px;
            border-color: dodgerblue;
            border-radius: 5%;
        }
    .od1{
        width: 25%; 
        height: 30px;  
        color: darkblue;
        font-size: 20px;
    }
    .od2{
        width: 25%; 
        height: 30px;  
        color: darkgreen;
        font-size: 15px;
    }
    .OrderManage{
    margin-left:50px;
    }
    .member{
    margin-left:30px;}
</style>
<script src="js/jquery-3.3.1.js"></script>
<script>
   function goal()
    {
        alert("Logged Out Successfully.");
        
    }
     window.history.forward();
        function noBack()
        {
            
            window.history.forward();
        }
        </script>
        <script>
	$(document).ready(function(){
		var curr=0;
		var oN=0;
		var orderNo=0;
		var status=0;
	$('.mid .OrderManage .od2 .btn1').click(function(lol){
		curr=$(this).closest('tr');
		oN=curr.find('th:eq(0)').text();
		orderNo=parseFloat(oN);
		status=curr.find('th:eq(2) option:selected').text();
		alert(orderNo);
		$.ajax({
			url: 'UpdateStatus',
			type: 'POST',
			data: {
				orderNo:orderNo,
				status:status
			}
		});
		
		lol.preventDefault();
	});
	});
</script>
<body>

    
   
    
</body>
</html>