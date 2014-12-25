// JavaScript Documen
        
    
   //Funcion que al inciar en documento html de va encargar de gestionar los combos dependientes
   //Toda las funciones que realizaen algun evento deben incializarce la funcion ready!!! 
   $(document).ready(function(){ 
	   gestionarCboDepartamento();
	   gestionarCboProvincia();
    });
   
   
   
   function gestionarCboDepartamento(){
	   
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
   
   
   //Funcion que va a gestionar el combo provincia
   function gestionarCboProvincia(){
	   
	   $('#cboPronvincia').change(function(){
       	var coddepto=document.getElementById("cboDepartamento").value;
       	var codprov=document.getElementById("cboPronvincia").value;
       	
    		 $.ajax({
                 url:'gestionaUbigeo?operacion=Distrito',
                 type:'post',
                 datatype:'json',
                 data: "coddepto="+coddepto+"&codprov="+codprov, 
             
                 success:function(r){
                 	
                     var json = eval('('+r+')');
                     var combo = document.getElementById("cboDistrito");
                     LimpiarCombo(combo);
                     combo.options[0] = new Option('SELECCIONE', '');
                        for(var i=0;i<json.length;i++){
                                combo.options[combo.length] = new Option(json[i].distrito, json[i].ubigeo);
                            }
                        }
                    });
    	 });
       
   }
        
   
   //Funcion que sirve para limpiar los combos
   function LimpiarCombo(combo){
   	
       while(combo.length > 0){
           combo.remove(combo.length-1);
       }
       
       combo.options[0] = new Option('SELECCIONE', '');
   }


        
        
        /*
         * function fn_cantidad(){ cantidad = $("#tabla tbody").find("tr").length;
         * $("#span_cantidad").html(cantidad); };
         */

        function fn_agregar() {
        	
        	/* $("#registrarDireccion").click(function(){ */

        	var ultimoValor = "";
        	var valorEntrante = $("#txtDireccion").val();

        	$('#tabla tr').each(function() {
        		ultimoValor = $(this).find("td").eq(3).html();
        	});

        	if ($("#cboTipoEstablecimiento option:selected").text() == "Sin Asignar"| $("#cboDistrito option:selected").text() == "SELECCIONE" | !(valorEntrante !== ultimoValor)) {
        	} else {

        		cadena = "<tr>";
        		cadena = cadena + "<td>"
        				+ $("#cboTipoEstablecimiento option:selected").text() + "</td>";
        		cadena = cadena + "<td>" + $("#cboTipoEstablecimiento").val() + "</td>";
        		cadena = cadena + "<td>" + $("#cboDistrito").val() + "</td>";
        		cadena = cadena + "<td>" + $("#txtDireccion").val() + "</td>";
        		/* cadena = cadena + "<td><a class='elimina'>eee</a></td>"; */
        		$("#tabla").append(cadena);
        		/*
        		 * aqui puedes enviar un conunto de tados ajax para agregar al usuairo
        		 * $.post("agregar.php", {ide_usu: $("#valor_ide").val(), nom_usu:
        		 * $("#valor_uno").val()});
        		 */
        		/*
        		 * fn_dar_eliminar(); fn_cantidad(); alert("Usuario agregado");
        		 */
        		/* }); */
        	}

        };


        function fnc_limpiarTabla(){
        	
        	 $("#tabla").find("tr:gt(0)").remove();
        	
        }


            //hide input text
           function fnc_limpiarCampos(){
        	   
        	   $("#txtDireccion").val("");
               var combo = document.getElementById("cboPronvincia");
               var combo2 = document.getElementById("cboDistrito");
               LimpiarCombo(combo);
               LimpiarCombo(combo2);


                
            };

            


        /*
         * function fn_dar_eliminar(){ $("a.elimina").click(function(){ id =
         * $(this).parents("tr").find("td").eq(0).html(); respuesta = confirm("Desea
         * eliminar el usuario: " + id); if (respuesta){
         * $(this).parents("tr").fadeOut("normal", function(){ $(this).remove();
         * 
         * 
         * aqui puedes enviar un conjunto de datos por ajax $.post("eliminar.php",
         * {ide_usu: id})
         *  }) } }); };
         */
        
        
      
    
 

 
        
    
             
   