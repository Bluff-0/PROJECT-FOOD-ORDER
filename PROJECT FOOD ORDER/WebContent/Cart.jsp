<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Cart</title>
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/jquery-3.3.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<style>
    .table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table #cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table #cart thead { display: none; }
	table #cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table #cart tbody tr td:first-child { background: #333; color: #fff; }
	table #cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table #cart tfoot td{display:block; }
	table #cart tfoot td .btn{display:block;}
	
}
</style>
<script>
    function logi()
    {
        alert("Please Login...");
        window.location.href=('Login.jsp');
    }
</script>
<script type="text/javascript">
                $(document).ready(function(){
                	var foodName=0;
                	var priceTotal=0;
                    $(".clickid").click(function (lx) {
						var p=$(this).parent().parent().parent().find(".subtotal").text();
						var deduct=parseFloat(p);
						var tot=$(".container #cart tfoot .totalpay").text();
						var total=parseFloat(tot);
						var GrandTotal=total-deduct;
						
						foodName=$(this).prev().prev('.foodName').val();
						$.ajax({
			    			 url: 'DelItemCart',
			    			 type: 'POST',
			    			 data:{
			    				 foodName:foodName
			    				 }
			    			 });
						
						$(".container #cart tfoot .totalpay").html('<strong>'+GrandTotal+'</strong>');
                        $(this).parent().parent().parent().remove();
                        lx.preventDefault();
                        });
					$(".checkout").click(function(lol){
						var pT=$(".container #cart tfoot .totalpay").text();
						priceTotal=parseFloat(pT);
						if(priceTotal!=0.0)
						{
						$.ajax({
							url: 'TakePrice',
							type: 'POST',
							data:{
								priceTotal:priceTotal
							}
						});
						//lol.preventDefault();
						//alert('BEFORE PROCEEDING FOR CHECKOUT YOU MUST LOGIN TO AN ACCOUNT');
						//$(location).attr('href','LoginCheckout.jsp');
						}else{
							alert('NO ITEMS AVAILABLE FOR CHECKOUT!!');
						}
					});
					
					$("#cart .like").prop('disabled',true);
					$("#cart .like").click(function(){ 
								var $button = $(this);
								var oldval=$button.siblings('.figure').val();
								var p=$button.closest("tr").find('.price').text();
								var pay=parseFloat(p);
								var total=0;
						
								if(oldval>2){
									var newval=parseFloat(oldval)-1;}
								else{
									var newval=1;
									$button.prop('disabled',true);
									}
								$button.siblings('.figure').val(newval);
								$button.closest("tr").find('.subtotal').text(newval*pay);
								//for total amount change
								$(".container #cart tbody .subtotal").each(function(){
								total=total+parseFloat($(this).text());
								});
								$(".container #cart tfoot .totalpay").html('<strong>'+total+'</strong>');
							   	});
					$(".container #cart .dislike").click(function(){
									var $button = $(this);
									var oldval=$button.siblings('.figure').val();
									var p=$button.closest("tr").find('.price').text();
									var pay=parseFloat(p);
									var total=0;
						
								   if(oldval>=1){
									   var newval=parseFloat(oldval)+1;
									   $button.siblings(".like").prop('disabled',false);
								   	}else{
										var newval=1;
									}
						$button.siblings('.figure').val(newval);
						$button.closest("tr").find('.subtotal').text(newval*pay);
						//for total amount change
						$(".container #cart tbody .subtotal").each(function(){
						total=total+parseFloat($(this).text());
						});
						$(".container #cart tfoot .totalpay").html('<strong>'+total+'</strong>');
					});
					
                });
					
			
	</script>
</head>
<body>
</body>
</html>