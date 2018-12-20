<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Checkout</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.min.js"></script>
<style>
   .banner
    {
        opacity: 0.9;
        background-color:bisque;
        align-content: center;
        height: 220px;
    }
    body{
        background-color: cornsilk;
    }
    .menub{
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
    .a{
        background-color: blanchedalmond;
        height: 500px;
        width: 550px;
        border-radius: 10%;
        box-shadow: 2px 2px 2px 2px;
      }
    .design
        {
            width:95%;
            padding:7px;
            border-radius:4px;
            font-size:15px;
            font-family: Arial Rounded MT;
        }
</style>
<script>
    function succc()
    {
         if(document.outform.c6.value=='Month')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c1.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c2.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c3.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c4.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c5.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.outform.c7.value=='Year')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.c8.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
		else
        {
            alert("Payment Successful & Order Placed");
            return true;
        }
    }
</script>
</head>
<body>
</body>
</html>