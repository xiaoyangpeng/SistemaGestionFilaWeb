$(function() {
	
	
	init();
	var data_list = {};
	$("#data_body ul>li ol>li").click(function() {
		var back = $(this).css("background-color");
		var $column_index = $(this).index();
		var $row_index = ($(this).parent().parent().index() + 1).toString();
		if(back == "rgb(195, 224, 254)") {
			$(this).css("background-color", "#fff");
			//鍒犻櫎鏃堕棿
			for(var i = 0; i < data_list[$row_index].length; i++) {
				if(data_list[$row_index][i] == $column_index) {
					data_list[$row_index].splice(i, 1);
				}
			}
		} else {
			$(this).css("background-color", "#c3e0fe");
			//娣诲姞鏃堕棿
			if(data_list[$row_index] != undefined) {
				data_list[$row_index].push($column_index);
			} else {
				data_list[$row_index] = [$column_index, ];
			}
		}
	});
	function getData() {
		console.count(data_list);
		return data_list;
	}

	function setData(data) {
		data_list = data;
		for(var key in data_list) {
			var $data_body = $("#data_body ul>li").eq(parseInt(key) - 1);
			var data_list_aa = data_list[key];
			for(var i = 0; i < data_list[key].length; i++) {
				$data_body.find("li").eq(data_list[key][i]).css("background-color", "#c3e0fe");
			}
		}
	}

	function init() {
		var ele = "<div id='data_top'> Horario de apertura&nbsp&nbsp &nbsp&nbsp <dl><dd></dd><dt>Abre</dt></dl><dl><dd></dd><dt>No abre</dt></dl></div>"
		ele += "<div id='data_body'>";
		ele += "<div id='data_body_top'>";
		$("#data_body_top").html("<p>" + i + ":00</p>");
		for(var i = 8; i <= 24; i++) {
			ele += "<p>" + i + ":00</p>";
			i++;
		}
		ele += "</div>";
		ele += "<ul>";
		var keep = ["LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM"];
		for(var i = 0; i < keep.length; i++) {
			ele += "<li><p>" + keep[i] + "</p><ol>";
			for(var j = 7; j < 24; j++) {
				ele += "<li></li>";
			}
			ele = ele + "</ol></li>";
		}
		ele += "</div></div>";
		$("#data").html(ele);
	}
//	window.getData = getData;
	//window.setData = setData;
	
	var array = ["1","2","3","4"];
	
	$("#sub_btn").click(function(){


		var str=JSON.stringify(getData());
		


			$.ajax({
			
				url:'/proyectoFinalEntrada/registServlet',  // el direccion para va mantar 
				data:{'id':str},               // {'nombre de paramentro entrada', datos que va enviar}
				type:'POST', 
				dataType:"json",          // tipo
				 traditional: true
    
				/*success:function(data){
					
								alert(data);
				},
				error : function(data){
					
					alert(str);
				}*/
				
			});
			
		 	  
		  });
	
});