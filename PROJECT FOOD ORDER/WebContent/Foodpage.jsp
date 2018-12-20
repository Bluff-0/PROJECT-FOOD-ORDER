<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Combo Meal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
    $(document).ready(function(){
    	var foodName=0;
    	var fileName=0;
    	var price=0.0;
    	var foodType=0;
    	$(".submit").click(function(lol){
    		fileName=$(this).prev().prev().prev().prev().prev('.fileName').val();
    		foodName=$(this).prev().prev().prev('.foodName').val();
    		price=$(this).prev('.price').val();
    		foodType=$(this).prev().prev().prev().prev().prev().prev().prev().prev('.foodType').val();
    		$.ajax({
    			 url: 'FoodToCart',
    			 type: 'POST',
    			 data:{
    				 fileName:fileName,
    				 price:price,
    				 foodName:foodName,
    				 foodType:foodType
    				 },
    		     success: function(data) {
    		         alert('Added To Cart: '+foodName);
    		         }
    			});
    		lol.preventDefault();
    	});
    	
    });
    
    function open1()
	{
		document.getElementById("sideopn").style.width="250px";
		document.getElementById("full").style.marginLeft="250px";
		document.body.style.backgroundColor="rgba(0,0,0,0.2)";
	}
	function close1()
	{
	document.getElementById("sideopn").style.width="0px";
	document.getElementById("full").style.marginLeft="0px";
	document.body.style.backgroundColor="white"	;
	}
    </script>
    
<style>
    .banner
    {
        opacity: 0.9;
        background-color:bisque;
        align-content: center;
    }
    body{
            background-image: url(images/combo.jpg);
            height: 100%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
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
    #sideopn{
		height: 100%;
		left:0px;
		top:0%;
		overflow-x: hidden;
		position: fixed;
		padding-top: 20px;
		width: 0px;
		transition: 0.5s;
		background-color: beige;
        opacity: 0.9;
		border-right: 4px ridge darkgoldenrod;
	}
	#sideopn a{
	padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: gray;
    display: block;
    transition: 0.3s;
	}
	#sideopn a:hover{
		color: white;
	}
	#sideopn .clsbtn{
	position: absolute;
    top: 0;
    right: 25px;
    font-size: 56px;
    font-weight: bolder;
	}
	#sideopn .clsbtn:hover{
		color: red;
	}
    #full{
		transition: margin-left 0.5s;
	}
    #optn{
		font-size: 60px;
		cursor: pointer;
		color: azure;
		background-color: darkgoldenrod;
		border-radius: 5px;
		width: 45px;
		display: inline;
		top: 0px;
	}
	.submit{
		background-color:orange;
		color:white;
		border: black;
		transition:0.3s;
	}
	.submit:hover{
	background-color:coral;
	transition:0.3s;
	}

</style>
</head>
<body>
<div id="sideopn"> 
				<a href="#" class="clsbtn" onclick="close1()">&times;</a> 
				<img src="images/Logo.jpg" width="140px" height="80px" style="padding-left: 20px;"/> 
				<br><br><br> 
				<a href="Home">Home</a>
				<a href="Food_Combo">Combo</a> 
				<a href="Food_Others">Others</a> 
				<a href="Food_Snacks">Snacks</a>
				<a href="Food_Beverage">Beverage</a>
				<a href="Food_Fruits">Fruits & Salad</a>
				</div>
				
    
</body>
</html>