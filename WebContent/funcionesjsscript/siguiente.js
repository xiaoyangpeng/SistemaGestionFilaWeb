/**
 * 
 */ //回调函数
		  	window.onload=function(){
		
		cargarPagina();
	
		window.setInterval("cargarPagina()",10000)
		
		

		
	}
		
	 	 var data;
	
		 var req = new XMLHttpRequest();
		 
		 var reqMandaLista = new XMLHttpRequest();
		 
		 function cargarPagina(){
			 
	
		        
		  req.open("GET", "/proyectoFinalEntrada/siguiente", true);
		        //如果设置数据传送方式为post，则必须设置请求头信息
      
        //设置回调函数，当前操作完成后进行的操作
       		req.onreadystatechange = callback;
 
        //Ajax请求发送的数据不是表单，需要拼接数据，格式和get方式一样
        
	     //发送请求
		req.send(null);
		 }
		 
	
		 
		    function mandasiguiente() {
		        //设置传送方式，对应的servlet或action路径，是否异步处理
		        
		        req.open("GET", "/proyectoFinalEntrada/siguiente?siguiente=true", true);
		        //如果设置数据传送方式为post，则必须设置请求头信息
		      
		        //设置回调函数，当前操作完成后进行的操作
		       	req.onreadystatechange = callback;
		 
		        //Ajax请求发送的数据不是表单，需要拼接数据，格式和get方式一样
		  	  req.send(null);
		      
		    }



		   
		    //回调函数
		    function callback() {
		        //如果Ajax和request的状态都正确则进行操作
		        if (req.readyState == 4 && req.status == 200) {
		            //获取后台返回的数据
		            var response = req.responseText;
		            
		           	data=JSON.parse(response)
		
		            var tbody = document.getElementById('tbMain');  
		        	
		            var miturno=document.getElementById('miTurno');  
		    
		            
	      		  var parNode =  document.getElementById("tableturno");
		     
		       	  var filaTotal= tbody.getElementsByTagName("tr").length;
		           
		       	  
		       	  var totalturno=document.getElementById("turnoEnfila");
		        
				limpiarListaFilas();
		      
		        
		 if(data.length!=0){
					 
				 	
			      miturno.innerHTML=data[0].turno_actual;
				    totalturno.innerHTML="Turno total : "+(data.length+1);
			      
	      			crearPrimerpagina(tbody);
		       
			      
	
				      var totalpagina;
				      
				      // comprobar que pagina es entero o no
				      if(data.length%4==0){
				      	
				      	totalpagina=parseInt(data.length/4);
				      	
				      }else{
				      	
				      	totalpagina=parseInt(data.length/4)+1;
				      }
				      
				      
				      
	            	 new myPagination({
						        id: 'pagination',
						        curPage:1, //初始页码
						        pageTotal: totalpagina, //总页数
								pageAmount: 4,  //每页多少条
						        dataTotal: 500, //总共多少条数据
								pageSize: 5, //可选,分页个数
						        showPageTotalFlag:true, //是否显示数据统计
						        showSkipInputFlag:true, //是否支持跳转
						        getPage: function (page) {
						        	
						        	
						           //获取当前页数
						  
				   	  limpiarListaFilas();
						    
					        if(page==1){
					        		
					        		crearPrimerpagina(tbody);
					        }
					        
					        
					        else if(page<totalpagina){
					        
					        	// cuando no es ultima pagina no primero pagina 
					        	
					        	crearPage((4*(page-1)),(4*page),tbody);
		
					        }
					        
					        
					        else{
					        	
					        	// cuando el ultimia pagina
					        	crearPage((4*(page-1)), data.length,tbody);
					        
					        }
				
					       
					        }
				    })	
				                	
				 }else{
					 miturno.innerHTML="No queda Nadie En la fila";
					  totalturno.innerHTML="";
				 }
		        
		        }
		    }
	
		    

		    function getDataRow(h){ 
		    	
		    	 var row = document.createElement('tr'); //创建行  
		    	
		    	  var idCell = document.createElement('td'); //创建第一列id 
		    	
		    	  idCell.innerHTML = h.nombre; //填充数据  
		    	  
		    	  row.appendChild(idCell); //加入行  ，下面类似  
		    	  
		    	  
		    	  var turnoCell = document.createElement('td');//创建第二列name  
		    	  turnoCell.innerHTML = h.turno;  
		    	     row.appendChild(turnoCell); 
		    	     
		    	     
		    	      var horacancelarCell = document.createElement('td');
	    	    horacancelarCell.innerHTML = h.hora_cancelar;  
	    	     row.appendChild(horacancelarCell);    
		    	     
		    	     
		    	     
	    	     var horaCell = document.createElement('td');
	    	     horaCell.innerHTML = h.hora_entrada;  
	    	     row.appendChild(horaCell); 
	   	     	     
	    	     var formatoCell = document.createElement('td');
	    	     formatoCell.innerHTML = h.formato;  
	    	     row.appendChild(formatoCell); 
    	     	  
	    	     
	    	     
	    	     var delCell=document.createElement('td');//创建第四列，操作列  
	    	     
	    	     row.appendChild(delCell);  
	    	     
	    	     var bt =document.createElement("button");           //createElement生成button对象
			     bt.innerHTML = 'Información producto'; 
			     bt.onclick = function () {                          //绑定点击事件
			    	 reqMandaLista.open("GET", "/proyectoFinalEntrada/listausuarioweb?idusuario="+h.id_usuario, true);
		  		        //如果设置数据传送方式为post，则必须设置请求头信息
		  		      
		  		        //设置回调函数，当前操作完成后进行的操作
		  		   		  reqMandaLista.onreadystatechange = callbacklista;
		    	    	 
		  				  reqMandaLista.send(null);
			     };
			    	     
	    	     delCell.appendChild(bt);  //把删除按钮加入td，别忘了   
		    	     
		     return row; //返回tr数据   
		    }
		    
		    
		    
		    // limpar filas de productos
		    function limpiarListaProducto(){
		    	

		    	var tbody = document.getElementById('tbLista');  
		    	
  		 	  var filaTotal= tbody.getElementsByTagName("tr").length;
  		 	 
		 	    if(filaTotal>0){
		 			
			         for(var ii=0;ii<filaTotal;ii++){
			        	 
			        		tbody.deleteRow(0);
				     
				        	 
		        		}
			         
			        }
		    }
		    
		    
		    function limpiarListaFilas(){
		    	
		    	
	            var tbody = document.getElementById('tbMain');  
		    	
		    	 var filaTotal= tbody.getElementsByTagName("tr").length;
		    	 
	    	    if(filaTotal>0){
		
		         for(var ii=0;ii<filaTotal;ii++){
		        	 
		        		tbody.deleteRow(0);
			     
			        	 
	        		}
		         
		        }
		    	 
		    	
		    }
		    
		   
		    var dataLista;
		    
		    var totalPrecio=0
		    
		    function callbacklista() {
		    	
			 	 totalPrecio=0;
		    
		    	  if (  reqMandaLista.readyState == 4 &&   reqMandaLista.status == 200) {
		    		 
		    		 	 var response = reqMandaLista.responseText;
		    		  			
		    		 	 var dataLista=JSON.parse(response)
		    		 
		    		 	var tbody = document.getElementById('tbLista');  
		    
		    		 	 
		    		 	 limpiarListaProducto();
		    	
				        for(var i = 0;i < dataLista.length; i++){ //遍历一下json数据  
				             var trow = getDataProducto(dataLista[i]); //定义一个方法,返回tr数据  
				             tbody.appendChild(trow);  
				           
				           totalPrecio=totalPrecio+dataLista[i].precioTotal;
				        }   
				        
				    	var total = document.getElementById("totalprecio");  
				        
				       total.innerHTML=totalPrecio;
				    
				        
		    	  }
		    }
		    
		    
		    function getDataProducto(h){
		    	
		    	
		    	 var row = document.createElement('tr'); //创建行  
			    	
		    	  var idCell = document.createElement('td'); //创建第一列id 
		    	
		    	  idCell.innerHTML = h.nombre; //填充数据  
		    	  
		    	  row.appendChild(idCell); //加入行  ，下面类似  
		    	  
		    	  
		    	  var turnoCell = document.createElement('td');//创建第二列name  
		    	  turnoCell.innerHTML = h.precio;  
		    	     row.appendChild(turnoCell); 
		    	     
		    	     
	    	     var horaCell = document.createElement('td');
	    	     horaCell.innerHTML = h.cantidad_producto;  
	    	     row.appendChild(horaCell); 
	   	     	     
	    	     var formatoCell = document.createElement('td');
	    	     formatoCell.innerHTML = h.precioTotal;  
	    	     row.appendChild(formatoCell); 
   	     	  
	    	     


		     return row; //返回tr数据  
		    	
		    	
		    
		    	
		    }
		    
		    
		    function crearPage(empieza,termina,tbody){
		    	
    			 for(var i = empieza;i < termina; i++){ //遍历一下json数据  
        			  var trow = getDataRow(data[i]); //定义一个方法,返回tr数据  
        	 			 tbody.appendChild(trow);  
				}
		    }
		    
		    
		    
		    function crearPrimerpagina(tbody){
		    
		    	// si persona en fila es mayor que 4 , primer pagina carga 4
		    	
    	   	  if(data.length>=4){
					        	
	            		crearPage(0,4,tbody);
		            
        		}else{
					     // si es menor que 4, carga lo que hay   			
	        			crearPage(0,data.length,tbody);
		        		
    			}
				      
		    	
		    }
		    
		    
		    
		    
		    
		   