<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>LOGIN</title></head>
<style>
    .head1{
            height: 200;
            background-color: cornsilk;
            align-content: center;
            opacity: 0.9;
          }
    body{
            background-image: url(images/background.jpg);
        }
    .main{height: 1080px; width: 1920px;}
    .menu{
            height: 50;
            background-color: cornsilk;
            opacity: 0.9;
        
         }
    .menub{
            padding: 15px 10px;
            border-radius: 25%;
            background-color: darkgoldenrod;
          }
    .menub:hover{
                    color: antiquewhite;
                    background-color: brown;
                    transition: 0.2s;
                }
    .head2{
            height: auto;
            background-color: beige;
            opacity: 0.9;
          }
    .ald{
        font-family: Comic Sans MS;
        }

    .login{
            background-color: floralwhite;
            height: 500px;
            width: 500px;
            font-family: Cooper Black;
            border-radius: 20%;
            border-color: darkred;
            opacity: 0.9;
          }
    .design
        {
            width:95%;
            padding:7px;
            border-radius:4px;
            font-size:15px;
            font-family: Arial Rounded MT;
        }
    button{
            padding: 10px 30px;
            border-radius: 25%;
            background-color: darkgoldenrod;
          }
    input[type=submit],input[type=reset]
	{
		width: 90px;
		height:35px;
		font-family:cursive;
		font-size: 15px;
		border-bottom-style: ridge;
		border-color:chocolate;
		font-weight: 100;
		background-color: white;
        border-radius: 10%;
	}
	input[type=submit]:hover,input[type=reset]:hover{
		transition: 0.5s;
		background-color: blanchedalmond;
		color: black;
	}
    input:focus{
                    background-color: burlywood;
                    color: darkred;
                    transition: 0.3s;
                }
    button:hover{
                    background-color: black;
                    color: aliceblue;
                    transition: 0.2s;
                }
</style>
<body>
    <div class="head1"><center><img src="images/Logo.jpg" height="200"></center></div>
    <div class="head2" align="right">
    <div class="menu">
        <a href="Home" style="text-decoration:none;"><button type="button" value="Home" class="menub">Home</button></a>
        <button type="button" value="Contact Us" class="menub" onclick="window.location.href=('contact.html')";>Contact Us</button>
    </div>
        <marquee behavior="alternate"><h1 style="color: brown; font-family: Comic Sans MS;"><b>We Serve Best Quality...</b></h1></marquee>
    </div><br><br>
    <center><div class="login">
        <h1><br></h1>
        <form action="Login" method="post">
        <fieldset style="border-radius: 10%; border-color: darkred; box-shadow: 2px 2px;">
        <h1 style="font-family: Elephant; font-size: 30px; color:chocolate; text-shadow: 2px 2px rgba(0,0,0,1); text-align: center;">LOG_IN</h1>
        <table cellpadding="20px">
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">E-Mail:</th>
                <th style="width: auto;"><input type="email" name="email" class="design" placeholder="Enter your e-mail" required></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">Password:</th>
                <th style="width: auto;"><input type="password" name="password" class="design" placeholder="Enter your password" required></th>
            </tr>
        </table>
            <center>
                <input type="submit" value="Log-in">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Clear">
            </center>
        </fieldset>
        </form>
                <h4 class="ald">Don't have any account?</h4>
                <button style="width: 150px; height: 45px; font-size: 18px; font-family: Comic Sans MS; border-radius: 7px; border-color: darkred;" onclick="window.location.href=('Register.jsp')";>Signup</button>
	<br><br>
        
    </div></center>
    <div style="background-color: antiquewhite; opacity:0.9;"><h4>&copy Project Food Service(ISO 9001). <center>All right reserved.</center></h4></div>
</body>
</html>