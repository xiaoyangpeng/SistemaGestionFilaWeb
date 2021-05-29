/**
 * 
 */
  	window.onload=function(){
		
		var puedeEnviar=true;
		
		$("#sub_btn").click(function () {
			

			// probar contraseña
			
			var passwordText = $("#password").val();
			
			// caracter de contraseña
			var passwordPatt = /^\w{5,12}$/;
			
			
			if (!passwordPatt.test(passwordText)) {
				//4 提示用户结果
				$("span.errorMsg").text("Contraseña debe ser entre 5 a 12 caracter letra o numeros ");
				puedeEnvair=false;
				return false;
			}else{
						puedeEnvair=true;
			}
			
			// probar repite contraseña debe conicidir 
			//1 获取确认密码内容
			var repwdText = $("#repwd").val();
			//2 和密码相比较
			if (repwdText != passwordText) {
				//3 提示用户
				$("span.errorMsg").text("contraseña no coincide！");
				puedeEnvair=false;
				return false;
			}else{
						puedeEnvair=true;
			}
			
			
		});
			
		

		
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
			  // imagen de anuncio, el auncio parará de mover
			 var MyMar=setInterval(Marquee,speed);
		
			tab.onmouseover=function() {clearInterval(MyMar)};
		
			tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
			
  	}