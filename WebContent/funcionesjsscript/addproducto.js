/**
 * 
 */  	window.onload=function(){
		  		
		  		$("#categoria").change(selector);
		  		
		  		if($("#categoria").val()!="mercancia"){
		  		
	  				$("#divmercancia").attr("style","display:none;");//����div
		  		}
		  		
		  	
		  		
		  		
		  		readFoto();
		  		
		  		
		  	}
		  	
		  	
		  	function readFoto(){
		  		
		  		document.querySelector('#foto').onchange = function (){
		  			
					      if(this.files.length){
					     var file = this.files[0];
					       var reader = new FileReader();
					        //�½� FileReader ����
					        reader.onload = function(){
					          // �� FileReader ��ȡ�ļ�ʱ�򣬶�ȡ�Ľ������� FileReader.result ������
					          document.querySelector('#img').src = this.result;
					        };
					        // ������ʲô��ʽ��ȡ�ļ���������base64��ʽ
					        reader.readAsDataURL(file);
					       }
  					  }

		  		
		  		
		  		
		  	}
		  	
		  	
		 
			function selector(){
				
				var categoriaText = $("#categoria option:selected").val();

					if(categoriaText=="servicio"){
						
						$("#foto").attr("style","display:none;");//����foto
						$("#divmercancia").attr("style","display:none;");// div
					}else if(categoriaText=="comida"){
						
						$("#foto").attr("style","display:block;");//��ʾfoto
						
						$("#divmercancia").attr("style","display:none;");//����div
					}
					
					else{
						
						$("#foto").attr("style","display:block;");//��ʾfoto
						$("#divmercancia").attr("style","display:block;");//��ʾdiv
					}
			
				
			}
			
			
			
			
			
			
			
			function num(obj){
				
				obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //ֻ����������С��
				
			}
			