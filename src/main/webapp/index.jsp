<html>
<body>
<h2>Hello World!</h2>

<button id="button1">Button1</button>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#button1").click(function(){
		alert('button1 clicked');
	
		$.ajax({
			url: "http://localhost:8080/DTCCafeteriaApp/user/order",
			type: "POST",
			data: JSON.stringify({ name: "John", age: "10" }),
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
				},	
	       	success: function(result){
				alert(result);
			}
	       
	    });
		
		
	});
});
</script>


</html>
