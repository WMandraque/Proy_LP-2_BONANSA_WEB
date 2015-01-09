

$(document).ready(function() {
	agregarDireccion();
	limpiarTabla();
	fnc_limpiarCampos();
});



function agregarDireccion() {

	$('#btnAgregar')
			.click(
					function() {

						var ultimoValor = " ";
						// Hallar el ultimo valor de la ultima columna
						$('#tabla tr').each(function() {
							ultimoValor = $(this).find("td").eq(3).html();
						});

						if ($("#cboTipoEstablecimiento option:selected").text() == "Sin Asignar"
								| $("#cboDistrito option:selected").text() == "SELECCIONE"
								| !($("#txtDireccion").val() !== "")
								| !(ultimoValor !== $("#txtDireccion").val())) {
						} else {

							direcCliente = document.getElementById("txtDireccion").value;
							idTipoEstablec = $("#cboTipoEstablecimiento").val();
							descTipoEstablec = $("#cboTipoEstablecimiento option:selected").text();
							ubigeo = $("#cboDistrito").val();

							$
									.ajax({
										url : 'gestionaCliente?operacion=agregarDireccion&tipo=Update',
										type : 'post',
										datatype : 'json',
										data :   "direcCliente=" + direcCliente  
												+ "&ubigeo=" + ubigeo
												+ "&idTipoEstablec="+ idTipoEstablec
												+ "&descTipoEstablec="+ descTipoEstablec,
										success : function(r) {
											$("#tabla").find("tr:gt(0)").remove();
											var json = eval('(' + r + ')');
											for (var i = 0; i < json.length; i++) {
											

												cadena = "<tr>";
												cadena = cadena
														+ "<td>"
														+ json[i].descTipoEstablec
														+ "</td>";
												cadena = cadena
														+ "<td>"
														+ json[i].idTipoEstablec
														+ "</td>";
												cadena = cadena
														+ "<td>"
														+ json[i].codubigeoDirecCliente
														+ "</td>";
												cadena = cadena
														+ "<td>"
														+ json[i].direcDirecCliente
														+ "</td>";
												cadena = cadena + "<td><a class='elimina' onclick='fn_eliminar()'><input type='button' class='btn btn-sm' value='Eliminar'/></a></td>";
												$("#tabla").append(cadena);

											}
											;
										}
									});
						}
						;
					});
};

function fn_eliminar() {
	$("a.elimina").click(function(){
		direccion = $(this).parents("tr").find("td").eq(3).html();
		$.ajax({
			url : 'gestionaCliente?operacion=eliminarDireccion',
			type : 'post',
			data : "direccion="+direccion,
			success : function() {
				}
		});
		$(this).parents("tr").fadeOut("normal", function(){$(this).remove();});	
	});
};

function limpiarTabla() {
	$('#btnLimpiarTabla').click(function() {
		$.ajax({
			url : 'gestionaCliente?operacion=limpiarDirecciones',
			type : 'post',
			success : function(r) {
				$("#tabla").find("tr:gt(0)").remove();
			}
		});
	});
};

function fnc_limpiarCampos() {
	$('#btnLimpiarCampos').click(function() {

		$("#txtDireccion").val("");
		var combo = document.getElementById("cboPronvincia");
		var combo2 = document.getElementById("cboDistrito");
		LimpiarCombo(combo);
		LimpiarCombo(combo2);
	});

};

