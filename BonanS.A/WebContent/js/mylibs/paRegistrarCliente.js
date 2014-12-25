// JavaScript Document


 $(document).ready(function(){
	ocultaDivs();
	gestionaTiposRegistroCliente();
 });

 
 
 
 function gestionaTiposRegistroCliente(){
	 
$('#cboTipoCliente').change(function(){
		 
		 $('#contenedor').show();
		 
		 var idTipoCliente=document.getElementById("cboTipoCliente").value;
		 
		 if(idTipoCliente=='1'){
		    $('#divNatural').hide();
		    $('#tituloCN').hide();
		    
			$('#divJuridico').show(); //muestro mediante id
			$('#tituloCJ').show();
		
		  }else if(idTipoCliente=='2'){
			    $('#divJuridico').hide(); //muestro mediante id 
			    $('#tituloCJ').hide();
			    
			    $('#divNatural').show();
			    $('#tituloCN').show();
		  }else if(idTipoCliente=='0'){
			    $ ('#divJuridico').hide();
				$('#tituloCN').hide();
				$('#tituloCJ').hide();
				$('#contenedor').hide()
		  }
		 
		
	});
	 
 }
 
 function ocultaDivs(){
		$('#divNatural').hide();
		$('#divJuridico').hide();
		$('#tituloCN').hide();
		$('#tituloCJ').hide();
		$('#contenedor').hide();
	 
 }
 
 

