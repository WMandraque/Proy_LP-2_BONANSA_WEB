

$(document).ready(function() {
	agregarDOR();
	agregarOR_EquipoPersonalRecojo();
	agregarOR_EquipoVehicularRecojo();
	limpiarTabla();
	limpiar_tablaEquipoPersonal();
	limpiar_tablaEquipoVehicular();
	fnc_limpiarCampos();
	fnc_limpiarCamposEquipoPersonal();
	fnc_capturarDatosDescripcionTraslado();
	
});



function fnc_capturarDatosDescripcionTraslado()
{

	$("#btnBuscarEmpleado").click(function(){
		
		//cboDireccionRecojo=$("#cboDireccionesCliente").val();
		txtFechaRecojo=document.getElementById("txtFechaRecojo").value;
		txtHoraRecojo=document.getElementById("txtHoraRecojo").value;
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=prelistarEmpleados',
			type : 'post',
			data :      // "cboDireccionRecojo="+cboDireccionRecojo
		                 "txtFechaRecojo="+txtFechaRecojo
		              +  "&txtHoraRecojo="+txtHoraRecojo,
			success : function() {
				location.href='gestionaOrdenRecojo?operacion=listarEmpleados';
			}
		});
		
	});
	
}

function agregarDOR() {

	$('#btnAgregarDOR').click(function() {
     
						var ultimoValor = " ";
						
						$('#tabla tr').each(function() {
							ultimoValor = $(this).find("td").eq(0).html();
						});

						if (    !($("#txtDesTraslado").val() !== "") | !($("#txtPesoKg").val() !== "")| !(ultimoValor !== $("#txtDesTraslado").val())) 
						{
						} else {
							
							descripcionTraslado = document.getElementById("txtDesTraslado").value;
							descTipoUnidadMedida = $("#cboTipoUnidadMedida option:selected").text();
							cantidad = document.getElementById("txtCantidad").value;
							idTipoUnidadMedida = $("#cboTipoUnidadMedida").val();
							PesokG = $("#txtPesoKg").val();


							$
							.ajax({
								url : 'gestionaOrdenRecojo?operacion=agregarDOR&tipo=Insert',
								type : 'post',
								datatype : 'json',
								data :    "descripcionTraslado=" + descripcionTraslado
										+ "&descTipoUnidadMedida=" + descTipoUnidadMedida
										+ "&cantidad="+ cantidad
										+ "&idTipoUnidadMedida="+ idTipoUnidadMedida
										+ "&PesokG="+ PesokG,
								success : function(r) {
									$("#tabla").find("tr:gt(0)")
									.remove();
							var json = eval('(' + r + ')');
							for (var i = 0; i < json.length; i++) {

								cadena = "<tr>";
								cadena = cadena
										+ "<td>"
										+ json[i].descripcionTraslado
										+ "</td>";
								cadena = cadena
								+ "<td>"
								+ json[i].cantidad
								+ "</td>";
								cadena = cadena
										+ "<td>"
										+ json[i].descTipoUnidadMedida
										+ "</td>";
								cadena = cadena
								+ "<td>"
								+ json[i].pesoKg
								+ "</td>";
								cadena = cadena + "<td><a class='elimina' onclick='fn_eliminar()'><input type='button' class='btn btn-sm' value='Eliminar'/></a></td>";
								$("#tabla").append(cadena);
								
							};

							$("#txtCantidad").val("");
							$("#txtDesTraslado").val("");
							$("#txtPesoKg").val("");		
							}
							
							});
						}
						;
					});
};


function fn_eliminar() {
	$("a.elimina").click(function(){
		descripcionTraslado = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=eliminarDOR',
			type : 'post',
			data : "descripcionTraslado="+descripcionTraslado,
			success : function() {
				}
		});
		$(this).parents("tr").fadeOut("normal", function(){$(this).remove();});	
	});
};


function limpiarTabla() {
	$('#btnLimpiarTablaDOR').click(function() {
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=limpiarDOR',
			type : 'post',
			success : function(r) {
				$("#tabla").find("tr:gt(0)").remove();
			}
		});
	});
};


function fnc_limpiarCampos() {
	$('#btnLimpiarCamposDOR').click(function() {

		$("#txtCantidad").val("");
		$("#txtDesTraslado").val("");
		$("#txtPesoKg").val("");
	});

};





function agregarOR_EquipoPersonalRecojo() {

	$('#btnAgregarPersonal').click(function() {
		
		               $('#tablaEquipoPersonal tr').each(function() {ultimoValor = $(this).find("td").eq(0).html();});
						if (    (!($("#txtIdEmpleado").val() !== "")) | !(ultimoValor !==  $("#txtIdEmpleado").val()) ) 
						{
						} else {
							
							txtIdEmpleado = document.getElementById("txtIdEmpleado").value;
							txtDescTipoEmpleado = document.getElementById("txtDescTipoEmpleado").value;
							txtNomCompletoEmp = document.getElementById("txtNomCompletoEmp").value;
							

							$
							.ajax({
								url : 'gestionaOrdenRecojo?operacion=agregarOR_EquipoPersponal&tipo=Insert',
								type : 'post',
								datatype : 'json',
								data :    "txtIdEmpleado=" + txtIdEmpleado
										+ "&txtDescTipoEmpleado=" + txtDescTipoEmpleado
										+ "&txtNomCompletoEmp="+ txtNomCompletoEmp,
								success : function(r) {
									$("#tablaEquipoPersonal").find("tr:gt(0)")
									.remove();
							var json = eval('(' + r + ')');
							for (var i = 0; i < json.length; i++) {

								cadena = "<tr>";
								cadena = cadena
										+ "<td>"
										+ json[i].idEmpleado
										+ "</td>";
								cadena = cadena
										+ "<td>"
										+ json[i].descTipoEmpleado
										+ "</td>";
								cadena = cadena
										+ "<td>"
										+ json[i].nomCompleto
										+ "</td>";
								cadena = cadena + "<td><a class='eliminaEquipoPersonal' onclick='fn_eliminarEquipoPersonal()'><input type='button' class='btn btn-sm' value='Eliminar'/></a></td>";
								$("#tablaEquipoPersonal").append(cadena);

							};
							$("#txtNomCompletoEmp").val("");
							$("#txtDescTipoEmpleado").val("");
							$("#txtIdEmpleado").val("");	
							}
							});
						}
						;
					});
};




function fn_eliminarEquipoPersonal() {
	$("a.eliminaEquipoPersonal").click(function(){
		idEmpleado = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=eliminarOR_EquipoPersonal',
			type : 'post',
			data : "idEmpleado="+idEmpleado,
			success : function() {
				}
		});
		$(this).parents("tr").fadeOut("normal", function(){$(this).remove();});	
	});
};



function limpiar_tablaEquipoPersonal() {
	$('#btnLimpiarTablaEquipoPersonal').click(function() {
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=limpiarOR_EquipoPersonal',
			type : 'post',
			success : function(r) {
				$("#tablaEquipoPersonal").find("tr:gt(0)").remove();
			}
		});
	});
};

function fnc_limpiarCamposEquipoPersonal() {
	$('#btnLimpiarCamposEquipoPersonal').click(function() {

		$("#txtNomCompletoEmp").val("");
		$("#txtDescTipoEmpleado").val("");
		$("#txtIdEmpleado").val("");
	});

};







function agregarOR_EquipoVehicularRecojo() {

	$('#btnAgregarEquipoVehicular').click(function() {
		
		               $('#tablaEquipoVehicular tr').each(function() {ultimoValor = $(this).find("td").eq(0).html();});
						if (    (!($("#txtIdVehiculo").val() !== "")) | !(ultimoValor !==  $("#txtIdVehiculo").val()) ) 
						{
						} else {
							
							txtIdVehiculo = document.getElementById("txtIdVehiculo").value;
							txtPlacaVehiculo = document.getElementById("txtPlacaVehiculo").value;
							txtCatVehiculo = document.getElementById("txtCatVehiculo").value;
							

							$
							.ajax({
								url : 'gestionaOrdenRecojo?operacion=agregarOR_EquipoVehicular&tipo=Insert',
								type : 'post',
								datatype : 'json',
								data :    "txtIdVehiculo=" + txtIdVehiculo
										+ "&txtPlacaVehiculo=" + txtPlacaVehiculo
										+ "&txtCatVehiculo="+ txtCatVehiculo,
								success : function(r) {
									$("#tablaEquipoVehicular").find("tr:gt(0)")
									.remove();
							var json = eval('(' + r + ')');
							for (var i = 0; i < json.length; i++) {

								cadena = "<tr>";
								cadena = cadena
										+ "<td>"
										+ json[i].idVehiculo
										+ "</td>";
								cadena = cadena
										+ "<td>"
										+ json[i].placaVehiculo
										+ "</td>";
								cadena = cadena
										+ "<td>"
										+ json[i].descCatVehiculo
										+ "</td>";
								cadena = cadena + "<td><a class='eliminaEquipoVehicular' onclick='fn_eliminarEquipoVehicular()'><input type='button' class='btn btn-sm' value='Eliminar'/></a></td>";
								$("#tablaEquipoVehicular").append(cadena);

							};
							$("#txtCatVehiculo").val("");
							$("#txtPlacaVehiculo").val("");
							$("#txtIdVehiculo").val("");	
							}
							});
						}
						;
					});
};


function fn_eliminarEquipoVehicular() {
	$("a.eliminaEquipoVehicular").click(function(){
		idVehiculo = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=eliminarOR_EquipoVehicular',
			type : 'post',
			data : "idVehiculo="+idVehiculo,
			success : function() {
				}
		});
		$(this).parents("tr").fadeOut("normal", function(){$(this).remove();});	
	});
};




function limpiar_tablaEquipoVehicular() {
	$('#btnLimpiarTablaEquipoVehicular').click(function() {
		$.ajax({
			url : 'gestionaOrdenRecojo?operacion=limpiarOR_EquipoVehicular',
			type : 'post',
			success : function(r) {
				$("#tablaEquipoVehicular").find("tr:gt(0)").remove();
			}
		});
	});
};

function fnc_limpiarCamposEquipoVehicular() {
	$('#btnLimpiarCamposEquipoVehicular').click(function() {

		$("#txtCatVehiculo").val("");
		$("#txtPlacaVehiculo").val("");
		$("#txtIdVehiculo").val("");
	});

};



