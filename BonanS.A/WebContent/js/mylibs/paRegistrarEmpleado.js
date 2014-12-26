// JavaScript Document


 $(document).ready(function(){
	ocultaDivs();
	gestionaTiposRegistroEmpleado();
 });

 
 
 
 function gestionaTiposRegistroEmpleado(){
	 
$('#cboTipoEmpleado').change(function(){
		 
		 $('#contenedor').show();
		 
		 //Capturamos el valor del combo por el id!!
		 var idTipoEmpleado=document.getElementById("cboTipoEmpleado").value;
		 
		 if(idTipoEmpleado==1){
 
				$('#tituloEA').show(); //muestro mediante id
				
				 $('#divEmpleadoConductor').hide(); //ocultamos mediante id
				 $('#tituloER').hide(); //ocultamos mediante id
				 $('#tituloEC').hide(); ///ocultamos mediante id
				 $('#tituloEE').hide(); //ocultamos mediante id

		  }else if(idTipoEmpleado==2){
				$('#tituloER').show(); //muestro mediante id
				
				 $('#divEmpleadoConductor').hide(); //ocultamos mediante id
				 $('#tituloEA').hide(); //ocultamos mediante id
				 $('#tituloEC').hide(); ///ocultamos mediante id
				 $('#tituloEE').hide(); //ocultamos mediante id

			    
		  }else if(idTipoEmpleado==3){
				$('#tituloEC').show(); //muestro mediante id
				$('#divEmpleadoConductor').show(); //ocultamos mediante id
				

				 $('#tituloER').hide(); //ocultamos mediante id
				 $('#tituloEA').hide(); ///ocultamos mediante id
				 $('#tituloEE').hide(); //ocultamos mediante id

			   
		  
		  }else if(idTipoEmpleado==4){
				$('#tituloEE').show(); //muestro mediante id
				
				 $('#divEmpleadoConductor').hide(); //ocultamos mediante id
				 $('#tituloER').hide(); //ocultamos mediante id
				 $('#tituloEC').hide(); ///ocultamos mediante id
				 $('#tituloEA').hide(); //ocultamos mediante id

		  }else if(idTipoEmpleado=='void'){
			  ocultaDivs();
		  }		
	});
	 
 }
 
 function ocultaDivs(){
		$('#contenedor').hide();//ocultamos mediante id
		$('#tituloEC').hide(); //ocultamos mediante id
		 $('#tituloER').hide(); //ocultamos mediante id
		 $('#tituloEA').hide(); ///ocultamos mediante id
		 $('#tituloEE').hide(); //ocultamos mediante id
		 $('#divEmpleadoConductor').hide(); //ocultamos mediante id


	 
 }
 
 

