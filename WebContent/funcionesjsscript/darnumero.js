/**
 * 
 */	window.onload=function(){
		
 	
 }
 
 
 
 	 var reqGetTurno = new XMLHttpRequest();
 	 		 var req = new XMLHttpRequest();
 	  	 var data;
 	 
 function peticionTurno(){
 	
 		 req.open("GET", "/proyectoFinalEntrada/darnumero", true);
 		req.onreadystatechange = callback;
 		
 		
 		req.send(null);
 }
 
     function callback() {
     	
     	     if (req.readyState == 4 && req.status == 200) {
     	     	
     	     	       var response = req.responseText;
     	     	            	data=JSON.parse(response);
     	     	    
     	            	  var texturno =  document.getElementById("turno");
     	            	  
     	            	
     	            	 texturno.value=data;
     	     	            	
     	     	
     	     }
     	
     	
     	
     	
     }