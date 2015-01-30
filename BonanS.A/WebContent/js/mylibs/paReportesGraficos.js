

$(document).ready(function() {
	ocultaDivs();
	gestionaEntidadReporte();
});

function gestionaEntidadReporte() {

	$('#cboEntidadReporte').change(function() {


		var idEntidadReporte = document.getElementById("cboEntidadReporte").value;

		if (idEntidadReporte == '0') {
			ocultaDivs(); 

		} 
		
		else if (idEntidadReporte == '1') 
		{
			$('#reporteClientes').show();
			
			$('#reporteSOR').hide();
			$('#reporteEmpleados').hide();
			$('#reporteVehiculo').hide();
			$('#reporteGRT').hide();
			$('#reporteIncidencias').hide();
		} 
		
		else if (idEntidadReporte == '2')
		{
			$('#reporteEmpleados').show();
			
			$('#reporteSOR').hide();
			$('#reporteClientes').hide();
			$('#reporteVehiculo').hide();
			$('#reporteGRT').hide();
			$('#reporteIncidencias').hide();
		} 
		
		else if (idEntidadReporte == '3')
		{
			$('#reporteVehiculo').show();

			$('#reporteSOR').hide();
			$('#reporteClientes').hide();
			$('#reporteEmpleados').hide();
			$('#reporteGRT').hide();
			$('#reporteIncidencias').hide();
		}
		
		else if (idEntidadReporte == '4')
		{
			$('#reporteSOR').show();
			
			$('#reporteVehiculo').hide();
			$('#reporteClientes').hide();
			$('#reporteEmpleados').hide();
			$('#reporteGRT').hide();
			$('#reporteIncidencias').hide();
		}
		
		else if (idEntidadReporte == '5')
		{
			$('#reporteGRT').show();

			$('#reporteSOR').hide();
			$('#reporteVehiculo').hide();
			$('#reporteClientes').hide();
			$('#reporteEmpleados').hide();
			$('#reporteIncidencias').hide();
		}
		
		else if (idEntidadReporte == '6')
		{
			$('#reporteIncidencias').show();

			$('#reporteSOR').hide();
			$('#reporteVehiculo').hide();
			$('#reporteClientes').hide();
			$('#reporteEmpleados').hide();
			$('#reporteGRT').hide();

		}

	});

}
function verGraficoReporteCliente() {
	var valor = $("#tipo").val();
	if (valor == 1) {
		$('#grafico').attr('src',
				'gestionaGrafico?operacion=cliente&tipoReporte=reporteClientesRegistrado2015');
	}
	if (valor == 2) {
		$('#grafico').attr('src',
				'gestionaGrafico?operacion=cliente&tipoReporte=reporteClientesEliminados2015');
	}
	if (valor == 3) {
		$('#grafico').attr('src',
				'gestionaGrafico?operacion=cliente&tipoReporte=reporteTiposCliente');
	}
}


function verGraficoReporteEmpleado() {
	var valor = $("#cboReporteEmpleado").val();
	if (valor == 1) {
		$('#graficoEmpleado').attr('src',
				'gestionaGrafico?operacion=empleado&tipoReporte=reporteEmpleadosRegistrado2015');
	}
	if (valor == 2) {
		$('#graficoEmpleado').attr('src',
				'gestionaGrafico?operacion=empleado&tipoReporte=reporteEmpleadosEliminados2015');
	}
	if (valor == 3) {
		$('#graficoEmpleado').attr('src',
				'gestionaGrafico?operacion=empleado&tipoReporte=reporteTiposEmpleado');
	}
}


function verGraficoReporteVehiculo() {
	var valor = $("#cboReporteVehiculo").val();
	if (valor == 1) {
		$('#graficoVehiculo').attr('src',
				'gestionaGrafico?operacion=vehiculo&tipoReporte=reporteVehiculosRegistrado2015');
	}
	if (valor == 2) {
		$('#graficoVehiculo').attr('src',
				'gestionaGrafico?operacion=vehiculo&tipoReporte=reporteVehiculosEliminados2015');
	}
	if (valor == 3) {
		$('#graficoVehiculo').attr('src',
				'gestionaGrafico?operacion=vehiculo&tipoReporte=reporteCategoriasVehiculo');
	}
}

function verGraficoReporteSOR(){
	var valor = $("#cboReporteSOR").val();
	if (valor == 1) {
		$('#graficoSOR').attr('src',
				'gestionaGrafico?operacion=ordenRecojo&tipoReporte=reporteSORRegistrados2015');
	}
	if (valor == 2) {
		$('#graficoSOR').attr('src',
				'gestionaGrafico?operacion=ordenRecojo&tipoReporte=reporteSOREstado');
	}
}

function verGraficoReporteGRT(){
	var valor = $("#cboReporteGRT").val();
	if (valor == 1) {
		$('#graficoGRT').attr('src',
				'gestionaGrafico?operacion=GRT&tipoReporte=reporteGRTRegistrados2015');
	}
	if (valor == 2) {
		$('#graficoGRT').attr('src',
				'gestionaGrafico?operacion=GRT&tipoReporte=reporteGRTEstado');
	}
}

function verGraficoReporteIncidencia(){
	var valor = $("#cboReporteIncidencia").val();
	if (valor == 1) {
		$('#graficoIncidencia').attr('src',
				'gestionaGrafico?operacion=Incidencia&tipoReporte=reporteIncidenciasRegistrados2015');
	}
	if (valor == 2) {
		$('#graficoIncidencia').attr('src',
				'gestionaGrafico?operacion=Incidencia&tipoReporte=reporteIncidenciaEstado');
	}
}

function ocultaDivs() 
{
	$('#reporteClientes').hide();
	$('#reporteEmpleados').hide();
	$('#reporteVehiculo').hide();
	$('#reporteSOR').hide();
	$('#reporteGRT').hide();
	$('#reporteIncidencias').hide();
}



