/**
 * 
 */

	window.onload = function(){

		
		
		// para hacer que se mueve las imagenes de anuncio
			var speed=0.5;
		
			 var tab=document.getElementById("contenedor_anuncio");
		
			var tab1=document.getElementById("anuncio");
		
			 var tab2=document.getElementById("copia_anuncio");
		
			 tab2.innerHTML=tab1.innerHTML;
		
			 tab.scrollLeft=0;
				
			 function Marquee(){


			 	 if(tab.scrollLeft>=tab2.offsetWidth){
			 			
			 			 tab.scrollLeft=0;
			 		 }

			 	 else{

			 		 tab.scrollLeft++;
			 	

			 		 }

			  }
		
			  // accion de mouse cuando el mouse se deja encima de cualquier
			  // imagen de anuncio, el auncio parar¨¢ de mover
			 var MyMar=setInterval(Marquee,speed);
		
			tab.onmouseover=function() {clearInterval(MyMar)};
		
			tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
			
			
		
		   
	}
		    