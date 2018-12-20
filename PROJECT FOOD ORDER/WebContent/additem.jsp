<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head><title>ADD ITEM</title></head>
<style>
    .head1{
            height: 200;
            background-color: cornsilk;
            align-content: center;
            opacity: 0.9;
          }
    body{
            background-image: url(images/bg2.jpg);
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
            background-color: darkgoldenrod;
            height: 630px;
            width: 620px;
            font-family: Cooper Black;
            border-radius: 10%;
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
            border-radius: 10%;
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
    function lol()
    {
        alert("Successfully Added");
        window.location.href('admin.html');
    }
</script>
<body>
    <div class="head1"><center><img src="images/Logo.jpg" height="200"></center></div>
    <div class="head2" align="right">
    <div class="menu" align="right">                                        
        
        <a href="AdminPage" style="text-decoration: none;"><button type="button" value="Home" class="menub">Home</button></a>
        <button type="button" value="Contact Us" class="menub" onclick="window.location.href=('contact.html')";>Contact Us</button>
    </div>
        <marquee behavior="alternate"><h1 style="color: brown; font-family: Comic Sans MS;"><b>We Serve Best Quality...</b></h1></marquee>
    </div><br><br>
    <center><div class="login">
        <h1><br></h1>
        <form name="logform" method="post" action="additem" enctype="multipart/form-data">
        <fieldset style="border-radius: 10%; border-color: darkred; box-shadow: 2px 2px;">
        <h1 style="font-family: Elephant; font-size: 30px; color:darkorange; text-shadow: 2px 2px rgba(0,0,0,1); text-align: center;">ADD NEW ITEM</h1>
        <table cellpadding="20px">
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">NAME:</th>
                <th style="width: auto;"><input type="text" name="email" class="design" required></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">PHOTO[1:1]:</th>
                <th style="width: auto;"><input type="file" placeholder="INSERT Image" name="image" style="background-color: azure;"></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">PRICE:</th>
                <th style="width: auto;"><input type="text" name="price" class="design" required></th>
            </tr>
            <tr>
                <th style="width: 50%; color: darkred; font-size: 25px;">DESCRIPTION:</th>
                <th style="width: auto;"><select class="design" name="descrip"><option value="Combo Meal">Combo Meal</option><option value="Snacks">Snacks</option><option value="Beverage">Beverage</option><option value="Fruits & Salads">Fruits & Salads</option><option value="Others">Others</option></select></th>
            </tr>
        </table>
            <center>
            	
                <input type="submit" value="Include" onclick="lol()";>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Clear">
            </center>
        </fieldset>
        </form>
	<br><br>
        
    </div></center>
    <div style="background-color: antiquewhite; opacity:0.9;"><h4>&copy Project Food Service(ISO 9001). <center>All right reserved.</center></h4></div>
</body>
</html>