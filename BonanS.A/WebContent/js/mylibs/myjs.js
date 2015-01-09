/*$(document).ready(function(){ 
	 agregarDireccion();
  });
   
   
   
   function agregarDireccion(){
	   
	   $('#btnAgregar').click(function(){
		   
		if ($("#cboTipoEstablecimiento option:selected").text() == "Sin Asignar"| $("#cboDistrito option:selected").text() == "SELECCIONE") 
		{
       	} 
		else 
		{
		   
		   direcCliente=document.getElementById("txtDireccion").value;
		   idTipoEstablec=$("#cboTipoEstablecimiento").val();
		   descTipoEstablecimiento=$("#cboTipoEstablecimiento option:selected").text();
		   ubigeo= $("#cboDistrito").val();
	   
    		 $.ajax({
                 url:'gestionaCliente?operacion=agregarDireccion',
                 type:'post',
                 datatype:'json',
                 data: "direcCliente="+direcCliente+"&ubigeo="+ubigeo+"&idTipoEstablec="+idTipoEstablec,
                 success:function(r){
                	 $("#tabla").find("tr:gt(0)").remove();	
                    var json = eval('('+r+')');
                    for(var i=0;i<json.length;i++){
                 
                    	
			       
			                    cadena = "<tr>";
			             		cadena = cadena + "<td>"
			             				+ descTipoEstablecimiento + "</td>";
			             		cadena = cadena + "<td>" + json[i].idTipoEstablec + "</td>";
			             		cadena = cadena + "<td>" + json[i].codubigeoDirecCliente  + "</td>";
			             		cadena = cadena + "<td>" + json[i].direcDirecCliente + "</td>";
			             		 cadena = cadena + "<td><a class='elimina'>eee</a></td>"; 
			             		$("#tabla").append(cadena);

                    };
                }
    	 });
	};
	   });
   };
   
   function limpiarTabla(){

	   $.ajax({
           url:'gestionaCliente?operacion=limpiarDirecciones',
           type:'post',
           success:function(r){
           	
        	   $("#tabla").find("tr:gt(0)").remove();
          }
	 });
   };
*/