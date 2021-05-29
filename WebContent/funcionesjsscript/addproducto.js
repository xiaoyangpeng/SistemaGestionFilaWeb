/**
 * 
 */  	window.onload=function(){
		  		
		  		$("#categoria").change(selector);
		  		
		  		if($("#categoria").val()!="mercancia"){
		  		
	  				$("#divmercancia").attr("style","display:none;");//隐藏div
		  		}
		  		
		  	
		  		
		  		
		  		readFoto();
		  		
		  		
		  	}
		  	
		  	
		  	function readFoto(){
		  		
		  		document.querySelector('#foto').onchange = function (){
		  			
					      if(this.files.length){
					     var file = this.files[0];
					       var reader = new FileReader();
					        //新建 FileReader 对象
					        reader.onload = function(){
					          // 当 FileReader 读取文件时候，读取的结果会放在 FileReader.result 属性中
					          document.querySelector('#img').src = this.result;
					        };
					        // 设置以什么方式读取文件，这里以base64方式
					        reader.readAsDataURL(file);
					       }
  					  }

		  		
		  		
		  		
		  	}
		  	
		  	
		 
			function selector(){
				
				var categoriaText = $("#categoria option:selected").val();

					if(categoriaText=="servicio"){
						
						$("#foto").attr("style","display:none;");//隐藏foto
						$("#divmercancia").attr("style","display:none;");// div
					}else if(categoriaText=="comida"){
						
						$("#foto").attr("style","display:block;");//显示foto
						
						$("#divmercancia").attr("style","display:none;");//隐藏div
					}
					
					else{
						
						$("#foto").attr("style","display:block;");//显示foto
						$("#divmercancia").attr("style","display:block;");//显示div
					}
			
				
			}
			
			
			
			
			
			
			
			function num(obj){
				
				obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
				
			}
			