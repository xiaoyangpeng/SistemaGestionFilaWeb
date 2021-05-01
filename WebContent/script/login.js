/**
 * 
 */
 

	
	

	$(function () {
		
		
			
			
			// para cambiar login normal y login de trabajador
		
		    var login_normal = document.querySelector('.login_normal')
			var login_trabajador = document.querySelector('.login_trabajador')
	
		    var switchBtns = document.querySelectorAll('.switch')

		    switchBtns.forEach(function(item){
		        item.addEventListener('click',function(){
		        	
		        	
		        	$("span.errorMsgTrabajador").text("");
		        		$("span.errorMsg").text("");
		            if(this.innerText=='Entrar normal'){
		                addStyle(login_trabajador,{ height: '0',transitionDelay:'0s'})
		                addStyle(login_normal,{height: '500px',transitionDelay: '1.2s'})
		            }else if(this.innerText=='Entrar como trabajador'){
		                addStyle(login_trabajador,{ height: '500px', transitionDelay: '1.2s'})
		                addStyle(login_normal,{height: '0',transitionDelay:'0s'})
		            }
		        })
		    })

		    
		    function addStyle(ele,orignStyle){
		        for(var item in orignStyle){
		            if(ele){
		                ele.style[item] = orignStyle[item] 
		            }
		        }
  }
		
		
		
		
		
		
		

	// funcion para probar el email
		
		
		var btnObjeto= document.getElementById("sub_btntrabajador")
	  
			 btnObjeto.onclick=function onclikFun() {
				
			var emailText = $("#emailTrabajador").val();
			//2 创建正则表达式对象
			
			var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			//3 使用test方法验证是否合法
			if (!emailPatt.test(emailText)) {
			//aviso
				$("span.errorMsgTrabajador").text("Formato de Email Incorrecto");

				return false;
				}else{
				$("span.errorMsgTrabajador").text("");
				}
			}
		
	
		$("#sub_btn").click(function () {
		
			// probar formato de email：xxxxx@xxx.com
			//1 获取邮箱里的内容
			var emailText = $("#email").val();
			//2 创建正则表达式对象
			
			var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			//3 使用test方法验证是否合法
			if (!emailPatt.test(emailText)) {
			//aviso
				$("span.errorMsg").text("Formato de Email Incorrecto");

				return false;
			}else{
				
				$("span.errorMsg").text("");
				}
		});
		
	

	});
	
	
	
	
	
	
	
	
	
	