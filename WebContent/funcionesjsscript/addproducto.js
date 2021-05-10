/**
 * 
 */  	window.onload=function(){
		  		
		  		$("#categoria").change(selector);
		  		
		  		$("#divmercancia").attr("style","display:none;");//隐藏div
		  	}
			
			function selector(){
				
			
				var categoriaText = $("#categoria option:selected").val();

					if(categoriaText=="mercancia"){
						
						$("#foto").attr("style","display:none;");//隐藏foto
						$("#divmercancia").attr("style","display:block;");//显示div
					}else{
						

						$("#foto").attr("style","display:block;");//显示div
						$("#divmercancia").attr("style","display:none;");//隐藏foto
					}
			
				
			}
			
			
			
			function num(obj){
				
				obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
				
			}
			