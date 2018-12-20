<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head><title>Signup</title></head>
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
            height: 700px;
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
<script>
    function pass_validation()
    {
        var firstpassword=document.logform.password1.value;  
        var secondpassword=document.logform.password2.value;
        
        if(document.logform.name.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.con.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(document.logform.email.value=='')
        {
            alert("No field can be kept Blank!!!");
            return false;
        }
        else if(firstpassword=='')
        {
            alert("Password cannot be kept Blank!!!");
            return false;
        }
        else if(firstpassword==secondpassword)
        {
            alert("Successful!!!")
            return true;
        }  
        else
        {  
            alert("Re-entered password must be same!");
            return false;
        }  
    }
</script>
<body>
    <div class="head1"><center><img src="images/Logo.jpg" height="200"></center></div>
    <div class="head2" align="right">
    <div class="menu">
        <a href="Home"><button type="button" value="Home" class="menub">Home</button></a>
        <button type="button" value="Home" class="menub" onclick="window.location.href=('login.jsp')">Log-in</button>
        <button type="button" value="Contact Us" class="menub" onclick="window.location.href=('contact.html')";>Contact Us</button>
    </div>
        <marquee behavior="alternate"><h1 style="color: brown; font-family: Comic Sans MS;"><b>We Serve Best Quality...</b></h1></marquee>
    </div><br><br>
    <center><div class="login">
        <h1><br></h1>
        <form name="logform" action="RegisterUser" method="post">
        <fieldset style="border-radius: 10%; border-color: darkred; box-shadow: 2px 2px;">
        <h1 style="font-family: Elephant; font-size: 30px; color:chocolate; text-shadow: 2px 2px rgba(0,0,0,1); text-align: center;">REGISTER</h1>
        <table cellpadding="15px">
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">Name:</th>
                <th style="width: auto;"><input type="text" name="name" class="design" placeholder="Enter your name"></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">Contact No:</th>
                <th style="width: auto;"><input type="text" name="con" class="design" placeholder="Enter your contact" maxlength="10"></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">E-mail:</th>
                <th style="width: auto;"><input type="email" name="email" class="design" placeholder="Enter your e-mail"></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">Password:</th>
                <th style="width: auto;"><input type="password" name="password1" class="design" placeholder="Enter your password"></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">Re-enter Password:</th>
                <th style="width: auto;"><input type="password" name="password2" class="design" placeholder="Re-enter your password"></th>
            </tr>
        </table>
            <center>
                <input type="submit" value="Sign-up" onclick="return pass_validation()";>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Clear">
            </center>
        </fieldset>
        </form>
                <h4 class="ald">Already have an account?</h4>
                <button style="width: 150px; height: 45px; font-size: 18px; font-family: Comic Sans MS; border-radius: 7px; border-color: darkred;" onclick="window.location.href=('Login.jsp')";>Log-in</button>
	<br><br>
        
    </div></center>
    <div style="background-color: antiquewhite; opacity:0.9;"><h4>&copy Project Food Service(ISO 9001). <center>All right reserved.</center></h4></div>
</body>
</html>