<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta charset="UTF-8">

<meta name="descripcion" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

<title>Gestion Recojo y Transporte</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<link href="css/calendar.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/icons.css" rel="stylesheet">
<link href="css/generics.css" rel="stylesheet">
<link href="css/app.css" rel="stylesheet">
<link href="css/icons2.css" rel="stylesheet">

<script language="javascript" type="text/javascript"src="js/jquery-1.3.2.min.js"></script>
<script language="javascript" type="text/javascript"src="js/mylibs/pcRegistrarGRT.js"></script>
   

</head>
<body id="skin-blur-sunset">
	<header id="header" class="media"> <a href="" id="menu-toggle"></a>
	<a class="logo pull-left" href="Indice.jsp">Bonan S.A.</a>

	<div class="media-body">
		<div class="media" id="top-menu">
			
			<div id="time" class="pull-right">
				<span id="hours"></span> : <span id="min"></span> : <span id="sec"></span>
			</div>

			
		</div>
	</div>
	</header>


	<!--Para cambiar fondo  -->
	<section id="main" class="p-relative" role="main"> <aside
		id="sidebar">

	<div class="side-widgets overflow">
		<!-- Profile Menu -->
		<div class="text-center s-widget m-b-25 dropdown" id="profile-menu">                                                                                                       
			<a href="" data-toggle="dropdown">                             <img class="profile-pic animated" src="gestionaEmpleado?operacion=mostrarFoto&idEmpleado=${sessionScope.idEmpleado}">

			</a>
			<ul class="dropdown-menu profile-menu">
				<li><a href="">Mi Perfil</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="">Mensajes</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="">Ajustes</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="gestionaUsuario?operacion=salir">Desconectar</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>

			</ul>

                        <h5 class="m-0" style="color: orange;">Nombre completo:</h5>
                        <h5 class="m-0">${sessionScope.nombreCompleto}</h5>
 
                        <br>
                        
                        <h5 class="m-0" style="color: orange;">Tipo:</h5>
                        <h5 class="m-0">${sessionScope.tipoEmpleado}</h5>

		</div>
		<div class="s-widget m-b-25">
			<div id="sidebar-calendar"></div>
		</div>
		<nav id="wrapper">

		<ul class="menu">

			<a href="mpConductor.jsp"><img width="25" src="img/icon/home.png"> Inicio</a><br><br>

			<li class="item2"><a href="#"><img width="30" src="img/icon/registro.png">Servicio de Recojo y Transporte</a>
				<ul>
<%-- 					 <li class="subitem1"><a href="gestionaOrdenRecojo?operacion=listar&idEmpleado=${sessionScope.idEmpleado}&nivel=condu">Mis Ordenes de recojo</a></li>
 --%>				     <%-- <li class="subitem1"><a href="gestionaGRT?operacion=listar&nivel=CONDUCTOR&idEmpleado=${sessionScope.idEmpleado}">Listar GRT</a></li> --%>
					 <li class="subitem2"><a href="pcRegistrarGRT.jsp">Generar Guia de Remision del Transportista</a></li>
					 <li class="subitem2"><a href="pcEntregaMercaderia.jsp">Entregar Mercaderia</a></li>
				</ul>
			</li>
			
			

			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/ruta.png"> Control de Ruta</a>
				<ul>
                    <li class="subitem2"><a href="pcRegistrarIncidencias.jsp">Registrar Incidencias</a></li>				
                </ul>
			</li>


			



		</ul>         
		</nav>
	</div>
	</aside> <section id="content" class="container">


	<div class="block-area" id="required">

		<!--Titulo  -->
		<h3 class="block-title">Gestion Transporte</h3>
	</div>




	<!--Espacio para el formulario  -->
	<div class="block-area" id="required">

		<!-- FORMULARIO  -->
		<form action="gestionaGRT" method="post">
		<c:set var="x" value="${requestScope.r_regGrt}"></c:set>
	    <input type="hidden" name="operacion" value="registrarEntregaMercaderia">
		<fieldset>
		<legend class="block-title" style="color: white;">Registrar Entrega</legend>


				<div class="block-area">

					<div class="row">
						<div class="col-md-3 m-b-15">
							<label style="font-size: 15px;">ID GRT</label> 
							<input
							    style="font-size: 16px; text-align: center;" 
								type="text" id="txtIdGRT" name="txtIdGRT" class="input-sm form-control mask-date_time"
								value="${x.idGRT}"
							>
						</div>
						
						<div class="col-md-3 m-b-15">
                                   <br>
		                           <input type="button" class="btn" value="Buscar GRT" onclick="location='gestionaGRT?operacion=listar&nivel=CONDUCTOR&idEmpleado=${sessionScope.idEmpleado}'">
		                </div>
                     </div>
                 </div>
					

					<!--  DATOS GENERALES DEL GRT-->
					<br>
					<hr class="whiter m-t-20" />
                    <div class="block-area">
					<h3 class="block-title">DATOS GENERALES</h3>
					<br><br>

						<!--  -->
						
						<div class="row">
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">FECHA DE INICIO DEL TRASLADO</label>
								   <input
									type="text" id="txtFechaTraslado" name="txtFechaTraslado" id="txtFechaTraslado"
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20" 
									value="${x.fecInicioTraslado}"
									>
							</div>
							
							
						    <div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">ID VEHICULO</label> <input
								    id="txtIdVehiculo" name="txtIdVehiculo"
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20" value="${x.idVeh}"
									>
							</div>
							
							
						<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">Nº PLACA DEL VEHICULO</label> <input
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20" value="${x.placaVeh}"
									>
							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">ID EMPLEADO</label> <input
								    id="txtIdEmpleado" name="txtIdEmpleado"
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20"
									value="${x.idEmpleado}"
									>
							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">Nº DE LICENCIA DEL CONDUCTOR</label> <input
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20"
									value="${x.licenCondEmpleado}"
									>
							</div>
					</div>	
					</div>
					<!--FIN DE LOS DATOS GENERALES DEL GRT  -->
					
			
			<!-- CLIENTE REMITENTE -->  
            <br>
			<hr class="whiter m-t-20" /> 
			<br><br>                  
            <div class="block-area">
						<h3 class="block-title">CLIENTE REMITENTE</h3>
						<br><br>   
						<div class="row">
						
					
												
						<div class="col-md-3 m-b-15">
						<label style="font-size: 12px;">TIPO DE DOCUMENTO</label>	
						<c:choose>
						      <c:when test="${x.idTipoCliente=='1'}">
						      <input
									type="text" 
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="JURIDICO"
									>
						      </c:when>
						
						      <c:when test="${x.idTipoCliente=='2'}">
						            <input
											type="text" 
											class="input-sm form-control mask-date"
											style="font-size: 16px;"
											value="NATURAL"
									>
						       </c:when>
						       <c:otherwise>
						       <input
									type="text" 
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									placeholder="seleccione una orden de recojo"
								>

						      </c:otherwise>
						      
						</c:choose>
						</div>		
							
						<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">Nº DE DOCUMENTO</label>
								<input
									type="text" 
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="${x.numDocumentoCliRemitente}"
									>
							</div>
							
							
						   <div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">ID CLIENTE</label>
								<input
									type="text" id="txtIdClienteRemi" name="txtIdClienteRemi"
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="${x.idCliRemitente}"
									>

							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">NOMBRE COMPLETO</label>
								<input
									type="text" 
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="${x.nomCliRemitente} ${x.apePaCliRemitente} ${x.apeMaCliRemitente}"
									>

							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">DIRECCION</label>
								<input
									type="text" id="txtDireccionRemitente" name="txtDireccionRemitente"
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="${x.direcCliRemitente}"
									>

							</div>
						
						</div>

						
						</div>	
						
						
			<!-- Cliente Destinatario -->
            <br>
			<hr class="whiter m-t-20" /> 
			<br><br>                  
            <div class="block-area">
						<h3 class="block-title">CLIENTE DESTINATARIO</h3>
						<br><br>   
						<div class="row">
						
						
						<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">TIPO DE DOCUMENTO</label>
								<libreria:CboTipoDocumento idTipoDocumento="${x.idTipoDocIdCliDestinatario}"/>
							</div>
						
						
						<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">Nº DE DOCUMENTO</label>
								<input
									type="text" id="txtNumDocumentoCliDest" name="txtNumDocumentoCliDest"
									class="input-sm form-control mask-date"
									style="font-size: 16px;" value="${x.numDocCliDestinatario}"
									>
							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">NOMBRE</label>
								<input
									type="text" id="txtNomCliDestinatario" name="txtNomCliDestinatario"
									class="input-sm form-control mask-date"
									style="font-size: 16px;" value="${x.nomCliDestinatario}"
									>

							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">A. PATERNO</label>
								<input
									type="text" id="txtApePaCliDest" name="txtApePaCliDest"
									class="input-sm form-control mask-date"
									style="font-size: 16px;" value="${x.apepaCliDestinatario}"
									>

							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">A. MATERNO</label>
								<input
									type="text" id="txtApeMaCliDest" name="txtApeMaCliDest"
									class="input-sm form-control mask-date"
									style="font-size: 16px;" value="${x.apemaCliDestinatario}"
									>

							</div>
							
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">DIRECCION</label>
								<input
									type="text" id="txtDireccionCliDest" name="txtDireccionCliDest"
									class="input-sm form-control mask-date"
									style="font-size: 16px;"
									value="${x.direcClienteDestinatario}"
									>

							</div>
						
						</div>

						
						</div>	
						
					
					
					<br>
					<hr class="whiter m-t-20" />
                    <div class="block-area">
					<h3 class="block-title">FECHAS DE ENTREGA</h3>	
					<br><br>

						
						<div class="row">
							<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">FECHA MINIMA DE ENTREGA</label>
								 <input
									type="text" id="txtFechaMinEntrega" name="txtFechaMinEntrega"
									class="input-sm form-control mask-phone"
									style="font-size: 16px;"
									required="requerid" maxlength="20" value="${x.fecMinEntrega}" >
							</div>
							
							
						<div class="col-md-3 m-b-15">
								<label style="font-size: 12px;">FECHA MAXIMA DE ENTREGA</label> 
								<input
								    id="txtFechaMaxEntrega" name="txtFechaMaxEntrega"
									class="input-sm form-control mask-phone"
									style="font-size: 16px;" 
									required="requerid" maxlength="20" value="${x.fecMaxEntrega}"
									>
							</div>
					</div>	
					</div>	
						
						
						
			 <!-- EQUIPO PERSONAL DE RECOJO -->
            <br>
			<hr class="whiter m-t-20" /> 
			<br><br>                  
            <div class="block-area">
						<h3 class="block-title">EQUIPO PERSONAL DE TRASLADO</h3>
						<br><br><br>   
						<div class="row">
							<table id="tabla" class="table table-bordered table-hover tile">
								<thead>
									<tr>
										<td>ID EMPLEADO</td>
										<td>TIPO DE EMPLEADO</td>
										<td>NOMBRE COMPLETO</td>
									
									</tr>
									
									<c:forEach items="${x.listadoEquipoPersonalTraslado}" var="listaPersonalTrasladoGRT">
									<tr>
	                                    <td>${listaPersonalTrasladoGRT.idEmpleado}</td>
	                                    <td>${listaPersonalTrasladoGRT.descTipoEmpleado}</td>
	                                    <td>${listaPersonalTrasladoGRT.nomEmpleado} ${listaPersonalTrasladoGRT.apePaEmpleado} ${listaPersonalTrasladoGRT.apeMaEmpleado}</td>
									</tr>	
									</c:forEach>
 
								</thead>
							</table>
						</div>
                        </div>			
						
					
            <!-- EQUIPO PERSONAL DE RECOJO -->
            <br>
			<hr class="whiter m-t-20" /> 
			<br><br>                  
            <div class="block-area">
						<h3 class="block-title">DESCRIPCION GENERAL DEL TRASLADO</h3>
						<br><br>   
						<br>
						<div class="row">
							<table id="tablaDGRT" class="table table-bordered table-hover tile">
								<thead>
									<tr>
										<td>DESCRIPCION DE TRASLADO</td>
										<td>CANTIDAD</td>
										<td>UNIDAD DE MEDIDA</td>
										<td>PESO EN KG</td>
										<td>G. REMITENTE</td>
										<td>FACTURA</td>
									</tr>
									
									<c:forEach items="${x.listadoDGRT}" var="listaDGRT">
									<tr>
									<td>${listaDGRT.descTraslado}</td>
									<td>${listaDGRT.cantidad}</td>
									<td>${listaDGRT.descTipoUnidadMedida}</td>
									<td>${listaDGRT.pesoKg}</td>
									<td>${listaDGRT.numCodGR}</td>
									<td>${listaDGRT.numCodFT}</td>
									</tr>
										
									</c:forEach>
 
								</thead>
							</table>
						</div>
                        </div>
                        
                        
                        
           
                      
                      <!-- OPERACIONES  -->
                        <br><br><br><br><br><br>
						<hr class="whiter m-t-20" />
						<br><br><br><br><br><br>
						<div class="block-area">
							<input class="btn btn-sm" type="submit" value="REGISTRAR">
							<input class="btn btn-sm" type="reset" value="LIMPIAR">
						</div>

					    
					    
               
                 <c:set var="mensaje" value="${requestScope.mensaje}"/>
				      <c:if test="${mensaje!=null}">
				                      <div class="block-area" >
									       <div class="alert alert-success" style="font-size: 20px;">
									        <center>${mensaje}</center>
									       </div>
				                   </div>
				      </c:if> 

			</fieldset>
		</form>
		<!--FIN DEL FORMULARIO  -->
	</div>

	
	
	<!-- Fin del contenedor del form --> <!--Chat  -->
	<div class="chat">

		<!-- Chat List -->
		<div class="pull-left chat-list">
			<div class="listview narrow">
				<div class="media">
					<img class="pull-left" src="img/profile-pics/1.jpg" width="30"
						alt="">
					<div class="media-body p-t-5">Alex Bendit</div>
				</div>
				<div class="media">
					<img class="pull-left" src="img/profile-pics/2.jpg" width="30"
						alt="">
					<div class="media-body">
						<span class="t-overflow p-t-5">David Volla Watkinson</span>
					</div>
				</div>
				<div class="media">
					<img class="pull-left" src="img/profile-pics/3.jpg" width="30"
						alt="">
					<div class="media-body">
						<span class="t-overflow p-t-5">Mitchell Christein</span>
					</div>
				</div>
				<div class="media">
					<img class="pull-left" src="img/profile-pics/4.jpg" width="30"
						alt="">
					<div class="media-body">
						<span class="t-overflow p-t-5">Wayne Parnell</span>
					</div>
				</div>
				<div class="media">
					<img class="pull-left" src="img/profile-pics/5.jpg" width="30"
						alt="">
					<div class="media-body">
						<span class="t-overflow p-t-5">Melina April</span>
					</div>
				</div>
				<div class="media">
					<img class="pull-left" src="img/profile-pics/6.jpg" width="30"
						alt="">
					<div class="media-body">
						<span class="t-overflow p-t-5">Ford Harnson</span>
					</div>
				</div>

			</div>
		</div>

		<!-- Chat Area -->
		<div class="media-body">
			<div class="chat-header">
				<a class="btn btn-sm" href=""> <i
					class="fa fa-circle-o status m-r-5"></i> Chat with Friends
				</a>
			</div>

			<div class="chat-body">
				<div class="media">
					<img class="pull-right" src="img/profile-pics/1.jpg" width="30"
						alt="" />
					<div class="media-body pull-right">
						Hiiii<br /> How you doing bro? <small>Me - 10 Mins ago</small>
					</div>
				</div>

				<div class="media pull-left">
					<img class="pull-left" src="img/profile-pics/2.jpg" width="30"
						alt="" />
					<div class="media-body">
						I'm doing well buddy. <br />How do you do? <small>David -
							9 Mins ago</small>
					</div>
				</div>

				<div class="media pull-right">
					<img class="pull-right" src="img/profile-pics/2.jpg" width="30"
						alt="" />
					<div class="media-body">
						I'm Fine bro <br />Thank you for asking <small>Me - 8 Mins
							ago</small>
					</div>
				</div>

				<div class="media pull-right">
					<img class="pull-right" src="img/profile-pics/2.jpg" width="30"
						alt="" />
					<div class="media-body">
						Any idea for a hangout? <small>Me - 8 Mins ago</small>
					</div>
				</div>

			</div>

			<div class="chat-footer media">
				<i class="chat-list-toggle pull-left fa fa-bars"></i> <i
					class="pull-right fa fa-picture-o"></i>
				<div class="media-body">
					<textarea class="form-control" placeholder="Type something..."></textarea>
				</div>
			</div>
		</div>
	</div>
	</section> </section>

	<script src="js/jquery.min.js"></script>
	<!-- jQuery Library -->




	<script src="js/validation/validationEngine.min.js"></script>
	<!-- jQuery Form Validation Library - requirred with above js -->
	<script src="js/select.min.js"></script>
	<!-- Custom Select -->
	<script src="js/chosen.min.js"></script>
	<!-- Custom Multi Select -->
	<script src="js/datetimepicker.min.js"></script>
	<!-- Date & Time Picker -->
	<script src="js/colorpicker.min.js"></script>
	<!-- Color Picker -->
	<script src="js/icheck.js"></script>
	<!-- Custom Checkbox + Radio -->
	<script src="js/autosize.min.js"></script>
	<!-- Textare autosize -->
	<script src="js/toggler.min.js"></script>
	<!-- Toggler -->
	<script src="js/input-mask.min.js"></script>
	<!-- Input Mask -->
	<script src="js/spinner.min.js"></script>
	<!-- Spinner -->
	<script src="js/slider.min.js"></script>
	<!-- Input Slider -->
	<script src="js/fileupload.min.js"></script>
	<!-- File Upload -->


	<script src="js/jquery-ui.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Charts -->
	<script src="js/charts/jquery.flot.js"></script>
	<!-- Flot Main -->
	<script src="js/charts/jquery.flot.time.js"></script>
	<!-- Flot sub -->
	<script src="js/charts/jquery.flot.animator.min.js"></script>
	<!-- Flot sub -->
	<script src="js/charts/jquery.flot.resize.min.js"></script>
	<!-- Flot sub - for repaint when resizing the screen -->

	<script src="js/sparkline.min.js"></script>
	<!-- Sparkline - Tiny charts -->
	<script src="js/easypiechart.js"></script>
	<!-- EasyPieChart - Animated Pie Charts -->
	<script src="js/charts.js"></script>
	<!-- All the above chart related functions -->

	<!-- Map -->
	<script src="js/maps/jvectormap.min.js"></script>
	<!-- jVectorMap main library -->
	<script src="js/maps/usa.js"></script>
	<!-- USA Map for jVectorMap -->

	<!--  Form Related -->
	<script src="js/icheck.js"></script>
	<!-- Custom Checkbox + Radio -->

	<!-- UX -->
	<script src="js/scroll.min.js"></script>
	<!-- Custom Scrollbar -->

	<!-- Other -->
	<script src="js/calendar.min.js"></script>
	<!-- Calendar -->
	<script src="js/feeds.min.js"></script>
	<!-- News Feeds -->


	<!-- All JS functions -->
	<script src="js/functions.js"></script>
	<script src="js/depmain.js"></script>

        
        
    

</body>
</html>