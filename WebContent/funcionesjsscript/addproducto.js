/**
 * 
 */  	window.onload=function(){
		  		
		  		$("#categoria").change(selector);
		  		
		  		$("#divmercancia").attr("style","display:none;");//����div
		  	}
			
			function selector(){
				
			
				var categoriaText = $("#categoria option:selected").val();

					if(categoriaText=="mercancia"){
						
						$("#foto").attr("style","display:none;");//����foto
						$("#divmercancia").attr("style","display:block;");//��ʾdiv
					}else{
						

						$("#foto").attr("style","display:block;");//��ʾdiv
						$("#divmercancia").attr("style","display:none;");//����foto
					}
			
				
			}
			
			
			
			function num(obj){
				
				obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //ֻ����������С��
				
			}
			