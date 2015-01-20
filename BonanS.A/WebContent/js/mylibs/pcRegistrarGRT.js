

$(document).ready(function() {
	fn_fn_agregarGRyFACT();
	
	
});





function fn_agregarGRyFACT() {
	$("a.agregarGRyFACT").click(function(){
		descTraslado = $(this).parents("tr").find("td").eq(0).html();
		txtNumGr = document.getElementById("txtNumGr").value;
		txtNumFact = document.getElementById("txtNumFact").value;
		$.ajax({
			url : 'gestionaGRT?operacion=agregarGRyFACT',
			type : 'post',
			datatype : 'json',
			data :   "descTraslado="+descTraslado
			        +"&txtNumGr="+txtNumGr
			        +"&txtNumFact="+txtNumFact,
			success : function(r) 
			{
									$("#tablaDGRT").find("tr:gt(0)").remove();
									var json = eval('(' + r + ')');
									for (var i = 0; i < json.length; i++) 
									{
									
										cadena = "<tr>";
										cadena = cadena +"<td>"+ json[i].descTraslado+ "</td>";
										cadena = cadena+ "<td>"+ json[i].cantidad+ "</td>";
										cadena = cadena+ "<td>"+ json[i].descTipoUnidadMedida+ "</td>";
										cadena = cadena+ "<td>"+ json[i].pesoKg+ "</td>";
										cadena = cadena+ "<td>"+ json[i].numCodGR+ "</td>";
										cadena = cadena+ "<td>"+ json[i].numCodFT+ "</td>";
										cadena = cadena + "<td><a class='eliminarGRyFACT' onclick='fn_agregarGRyFACT()'><input type='button' class='btn btn-sm' value='ELIMINAR'/></a></td>";
										cadena = cadena + "<td><a class='agregarGRyFACT' onclick='fn_agregarGRyFACT()'><input type='button' class='btn btn-sm' value='ASIGNAR'/></a></td>";
										$("#tablaDGRT").append(cadena);
				
								   }
				}
		});
		
	});
};



