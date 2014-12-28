/*$(document).ready(function(){ 
	 listarDirecciones();
	 agregarDireccion();
  });
   
   
   
   function listarDirecciones(){
	   
	   $("#btnAgregar").click(func);
	   
	   $('#cboDepartamento').change(function(){
    		 $.ajax({
                 url:'gestionaUbigeo?operacion=Provincia',
                 type:'post',
                 datatype:'json',
                 data: {coddepto: cboDepartamento.options[cboDepartamento.selectedIndex].value},
                 success:function(r){
                 	
                     var json = eval('('+r+')');
                    
                     
                     var combo = document.getElementById("cboPronvincia");
                     var combo2 = document.getElementById("cboDistrito");
                     LimpiarCombo(combo);
                     LimpiarCombo(combo2);
                     //LimpiarCombo2(combo2);
                     
                     combo.options[0] = new Option('SELECCIONE', '');
                        for(var i=0;i<json.length;i++){
                                combo.options[combo.length] = new Option(json[i].provincia, json[i].codprov);
                            }
                        }
                    });
    	 });
	   
	   function agregarDireccion(){
		   
		   $('#cboDepartamento').change(function(){
	    		 $.ajax({
	                 url:'gestionaUbigeo?operacion=Provincia',
	                 type:'post',
	                 datatype:'json',
	                 data: {coddepto: cboDepartamento.options[cboDepartamento.selectedIndex].value},
	                 success:function(r){
	                 	
	                     var json = eval('('+r+')');
	                    
	                     
	                     var combo = document.getElementById("cboPronvincia");
	                     var combo2 = document.getElementById("cboDistrito");
	                     LimpiarCombo(combo);
	                     LimpiarCombo(combo2);
	                     //LimpiarCombo2(combo2);
	                     
	                     combo.options[0] = new Option('SELECCIONE', '');
	                        for(var i=0;i<json.length;i++){
	                                combo.options[combo.length] = new Option(json[i].provincia, json[i].codprov);
	                            }
	                        }
	                    });
	    	 });
	   
   };
   */