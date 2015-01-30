<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/libreria.tld" prefix="libreria" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="descripcion" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>Actualizar Vehiculo</title>
            
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
    </head>
<body id="skin-blur-sunset">
        <header id="header" class="media">
            <a href="" id="menu-toggle"></a> 
            <a class="logo pull-left" href="Indice.jsp">Bonan S.A.</a>
            
            <div class="media-body">
                <div class="media" id="top-menu">
                    
                    
                    <div id="time" class="pull-right">
                        <span id="hours"></span>
                        :
                        <span id="min"></span>
                        :
                        <span id="sec"></span>
                    </div>
                    
                 
                </div>
            </div>
        </header>
        
        
         <!--Para cambiar fondo  -->
         <section id="main" class="p-relative" role="main">
         
         
         
        	<aside id="sidebar">
        	
                <div class="side-widgets overflow">
                    <!-- Profile Menu -->
                    <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                        <a href="" data-toggle="dropdown">
                                                      <img class="profile-pic animated" src="gestionaEmpleado?operacion=mostrarFoto&idEmpleado=${sessionScope.idEmpleado}">
                        </a>
                        <ul class="dropdown-menu profile-menu">
                            <li><a href="">Mi Perfil</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="">Mensajes</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="">Ajustes</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
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

			<a href="mpAdministrador.jsp"><img width="25" src="img/icon/home.png"> Inicio</a><br><br>
			
			 <li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/recojo.png"> Gestion de Recojo</a>
				<ul class="main-menu mainmenu-menu">
					<li class="subitem1"><a href="paRegistrarSolicitudRecojo.jsp">Registrar Solicitud de recojo</a></li>
					<!-- <li class="subitem2"><a href="#">Actualizar Solicitud de recojo</a></li>
					<li class="subitem2"><a href="#">Eliminar Solicitud de recojo</a></li> -->
					<li class="subitem2"><a href="gestionaOrdenRecojo?operacion=listar&nivel=admin">Listar Ordenes de recojo</a></li>
				</ul>
			</li>
			
			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/transporte.png"> Gestion de Transporte</a>
			<ul class="main-menu mainmenu-menu">
<!-- 				    <li class="subitem2"><a href="#">Actualizar GRT</a></li>
					<li class="subitem2"><a href="#">Eliminar GRT</a></li> -->
				    <li class="subitem1"><a href="gestionaGRT?operacion=listar&nivel=ADMINISTRADOR">Listar GRT</a></li>
					
				</ul>
			</li>



			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/ruta.png"> Control de Ruta</a>
				<ul>
					<li class="subitem2"><a href="paActualizarIncidencias.jsp">Actualizar Incidencias</a></li>
					<li class="subitem2"><a href="gestionaIncidencia?operacion=listar&nivel=ADMINISTRADOR">Listar Incidencias</a></li>
				</ul>
			</li>
			
			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="25" src="img/icon/chart.png">Reportes Grafico</a>
				<ul>
					<li class="subitem2"><a href="paReportesGraficos.jsp">Reportes Graficos</a></li>
				</ul>
			</li>

			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/clientes.png"> Mantenimiento Clientes</a>
			<ul class="main-menu mainmenu-menu">
					<li class="subitem1"><a href="paRegistrarCliente.jsp">Registrar Cliente</a></li>
					<li class="subitem2"><a href="paMenuActualizarCliente.jsp">Actualizar Cliente</a></li>
					<li class="subitem2"><a href="paMenuEliminarCliente.jsp">Eliminar Cliente</a></li>
					<li class="subitem3"><a href="gestionaCliente?operacion=listar">Listar Cliente</a></li>
				</ul></li>


			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/empleados.png"> Mantenimiento Empleados</a>
			<ul class="main-menu mainmenu-menu">
					<li class="subitem1"><a href="mpAdRegistrarEmpleado.jsp">Registrar Empleado</a></li>
					<li class="subitem2"><a href="paMenuActualizarEmpleado.jsp">Actualizar Empleado</a></li>
					<li class="subitem2"><a href="paMenuEliminarEmpleado.jsp">Eliminar Empleado</a></li>
					<li class="subitem3"><a href="gestionaEmpleado?operacion=listar">Listar Empleado</a></li>
				</ul>
			</li>


			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/usuario.png"> Mantenimiento Usuario</a>
			<ul class="main-menu mainmenu-menu">

					<li class="subitem1"><a href="paRegistrarUsuario.jsp">Registrar
							Usuario</a></li>
					<li class="subitem2"><a href="paActualizarUsuario.jsp">Actualizar
							Usuario</a></li>
					<li class="subitem2"><a href="paEliminarUsuario.jsp">Eliminar Usuario</a></li>
					<li class="subitem3"><a
						href="gestionaUsuario?operacion=listar">Listar Usuario</a></li>

				</ul>
			</li>

			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/vehiculos.png"> Mantenimiento Vehiculos</a>
				<ul class="main-menu mainmenu-menu">
					<li class="subitem1"><a href="paRegistrarVehiculo.jsp">Registrar
							Vehiculo</a></li>
					<li class="subitem2"><a href="paActualizarVehiculo.jsp">Actualizar
							Vehiculo</a></li>
					<li class="subitem2"><a href="paEliminarVehiculo.jsp">Eliminar
							Vehiculo</a></li>
					<li class="subitem3"><a
						href="gestionaVehiculo?operacion=listar">Listar Vehiculos</a></li>
				</ul></li>


			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/acciones.png"> Registro de acciones</a>
				<ul class="main-menu mainmenu-menu">
					<li class="subitem1"><a href="gestionaLog?operacion=listar">Listado
							de logs</a></li>
				</ul></li>



		</ul>
                	</nav>
                    </div>
        	</aside>
        	
        <section id="content" class="container">
                
                
                <div class="block-area" id="required">

                <!--Titulo  -->
                 <h3 class="block-title">Matenimiento de vehiculo</h3>
                </div>
                
                
                <div class="block-area" id="required">

                <!--Titulo  -->
                 
                </div>

                
                
      <!--Espacio para el formulario  -->
     <div class="block-area" id="required">
                    
       <!-- FORMULARIO  -->             
       <form action="gestionaVehiculo" method="post" enctype="multipart/form-data">
         <input type="hidden" name="operacion" value="actualizar">          
         <fieldset>
                   
         <legend class="block-title" style="color: white;">Actualizar vehiculo</legend>
                   
                   <input type="hidden" name="operacion" value="registrar">
                   
                   
                
                   
                   <!--Contenedor de datos generales  -->
                <div class="block-area" id="input-masking">
                
                <div class="block-area" id="input-masking">
                   
		         <h3 class="block-title">Datos  Generales del Vehiculo</h3>
		
		         </div> 
		         
		         
		         <br>
		         <br>
		         <br>
		         <br>		         
		         
		         
		         <c:set var="x" value="${requestScope.vehiculoX}"></c:set>
     
     
		                   
		            <div class="block-area">
		                   <div class="row">
		                   	  <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">ID Vehiculo</label>
		                            <input type="text" name="txtIdVeh" id="txtIdVeh" class="input-sm form-control mask-date_time" placeholder="ingresar codigo" value="${x.idVeh}">
		                        </div>
		                        
		                        
		                       <div class="col-md-3 m-b-15">
                                   <br>
		                           <input type="button" class="btn" value="Buscar vehiculo" onclick="location='gestionaVehiculo?operacion=listar'">
		                        </div>
		                        
		                   </div>
		            </div>
		            
		            
		          
		             <hr class="whiter m-t-20" />
		                    
		                    
		             <div class="block-area">
		             <div class="row">
		             
		             <div class="col-md-3 m-b-29">
														
														<center>
														<h1 class="block-title">FOTO DEL VEHICULO</h1>
															<div class="col-sm-12">
																<div class="fileupload fileupload-new" data-provides="fileupload">
																	<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="gestionaVehiculo?operacion=fotoVehiculo&idVehiculo=${x.idVeh}">
																	</div>
																	<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
																	<div>
																		<span class="btn btn-light-grey btn-file">
																			 <span class="fileupload-new">
																				<i class="icon-picture"></i> Cambiar Imagen
																			</span> 
																			<span class="fileupload-exists"><i class="icon-picture"></i> Cambiar</span>
																			<input type="file" name="txtFoto">
																		</span>
																		<a href="#" class="btn fileupload-exists btn-light-grey" data-dismiss="fileupload">
																			<i class="icon-remove"></i> Remover
																		</a>
																	</div>
																</div>
															</div>
														</center>
														
								</div>
								
								<div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Placa del Vehiculo</label>
		                            <input type="text" id="txtPlacaVehiculo" name="txtPlacaVehiculo" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar placa" required="requerid"
		                                    maxlength="20" value="${x.placaVeh}">
                               </div> 
		                   
		                   
		                        <div class="col-md-3 m-b-15">
		                        <label style="font-size: 12px;">Categoria del Vehiculo</label>
		                           <libreria:cboCategoriaVehiculo idCatVeh="${x.idCategoriaVeh}"/>
		                        </div>
                                  
                                  
                                <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Marca del Vehiculo</label>
		                            <input type="text" id="txtMarcaVehiculo" name="txtMarcaVehiculo" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar marca" required="requerid" value="${x.marcaVeh}">
                               </div>  
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Modelo del Vehiculo</label>
		                            <input type="text" id="txtModeloVehiculo" name="txtModeloVehiculo" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar modelo" required="requerid" value="${x.modeloVeh}">
                               </div>  
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Numero de Asientos</label>
		                            <input type="text" id="txtNumAsiento" name="txtNumAsiento" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar N° de asientos" required="requerid" value="${x.numAsientosVeh}">
                               </div> 
                               
                                <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Año de Fabricacion</label>
		                            <input type="text" id="txtAñoFabricacion" name="txtAñoFabricacion" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar año de fabricacion" required="requerid" value="${x.anhoFabricVeh}">
                               </div> 
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Nro Serie de Motor</label>
		                            <input type="text" id="txtNumSerieMotor" name="txtNumSerieMotor" class="input-sm form-control mask-phone"  style="font-size: 16px;" placeholder="ingresar N° de serie" required="requerid" value="${x.numSerieMotorVeh}">
                               </div> 
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Largo del Vehiculo</label>
		                            <input type="text" id="txtLargo" name="txtLargo" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar largo del vehiculo" required="requerid" value="${x.largoVeh}">
                               </div> 
                               
                                 <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Ancho del Vehiculo</label>
		                            <input type="text" id="txtAncho" name="txtAncho" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar ancho" required="requerid" value="${x.anchoVeh}">
                               </div> 
                               
                               
                                 <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Altura del Vehiculo</label>
		                            <input type="text" id="txtAltura" name="txtAltura" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar altura" required="requerid" value="${x.alturaVeh}">
                               </div> 
                               
                                 <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Carga Bruta</label>
		                            <input type="text" id="txtCargaBruta" name="txtCargaBruta" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar carga bruta" required="requerid" value="${x.cargaBrutaVeh}">
                               </div> 
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Carga Util</label>
		                            <input type="text" id="txtCargaUtil" name="txtCargaUtil" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar carga util" required="requerid" value="${x.cargaUtilVeh }">
                               </div> 
                               
                               
                               <div class="col-md-3 m-b-15">
								
							   </div>
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Carga Neta</label>
		                            <input type="text" id="txtCargaNeta" name="txtCargaNeta" class="input-sm form-control mask-phone" style="font-size: 16px;" placeholder="ingresar carga neta" required="requerid" value="${x.cargaNetaVeh}">
                               </div>
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Estado</label>
		                            <libreria:cboEstado idEstado="${x.idEstado}"/>
		                            
                               </div> 
                               
                               
                               <div class="col-md-3 m-b-15">
		                            <label style="font-size: 12px;">Estado Trabajo</label>
		                            <libreria:cboEstadoTrabajo idEstadoTrabajo="${x.idEstadoTrabajo}"/>
                               </div> 
                               
                               
                               
                      <c:set var="mensaje" value="${requestScope.mensaje}"/>
				      <c:if test="${mensaje!=null}">
				                      <div class="block-area" >
									       <div class="alert alert-success" style="font-size: 20px;">
									        <center>${mensaje}</center>
									       </div>
				                   </div>
				      </c:if> 
             
		                        
                               
                       </div>
                 
                 </div>
                 
                 <hr class="whiter m-t-20" />
                   <!--Botones  -->
                   <div class="block-area" id="input-masking">
                        <input class="btn btn-sm" type="submit" value="ACTUALIZAR">
                        <input class="btn btn-sm" type="reset" value="LIMPIAR">
                   </div>
                 
            </div>
                   
                   
                   
                   
                  
                   
             </fieldset>
         </form><!--FIN DEL FORMULARIO  -->
                    
    </div><!-- Fin del contenedor del form -->
                
                
                
                
    
                            

                         
                         
                  
             
         <!--Chat  -->       
                <div class="chat">
                    
                    <!-- Chat List -->
                    <div class="pull-left chat-list">
                        <div class="listview narrow">
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/1.jpg" width="30" alt="">
                                <div class="media-body p-t-5">
                                    Alex Bendit
                                </div>
                            </div>
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/2.jpg" width="30" alt="">
                                <div class="media-body">
                                    <span class="t-overflow p-t-5">David Volla Watkinson</span>
                                </div>
                            </div>
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/3.jpg" width="30" alt="">
                                <div class="media-body">
                                    <span class="t-overflow p-t-5">Mitchell Christein</span>
                                </div>
                            </div>
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/4.jpg" width="30" alt="">
                                <div class="media-body">
                                    <span class="t-overflow p-t-5">Wayne Parnell</span>
                                </div>
                            </div>
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/5.jpg" width="30" alt="">
                                <div class="media-body">
                                    <span class="t-overflow p-t-5">Melina April</span>
                                </div>
                            </div>
                            <div class="media">
                                <img class="pull-left" src="img/profile-pics/6.jpg" width="30" alt="">
                                <div class="media-body">
                                    <span class="t-overflow p-t-5">Ford Harnson</span>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    
                    <!-- Chat Area -->
                    <div class="media-body">
                        <div class="chat-header">
                            <a class="btn btn-sm" href="">
                                <i class="fa fa-circle-o status m-r-5"></i> Chat with Friends
                            </a>
                        </div>
                    
                        <div class="chat-body">
                            <div class="media">
                                <img class="pull-right" src="img/profile-pics/1.jpg" width="30" alt="" />
                                <div class="media-body pull-right">
                                    Hiiii<br/>
                                    How you doing bro?
                                    <small>Me - 10 Mins ago</small>
                                </div>
                            </div>
                            
                            <div class="media pull-left">
                                <img class="pull-left" src="img/profile-pics/2.jpg" width="30" alt="" />
                                <div class="media-body">
                                    I'm doing well buddy. <br/>How do you do?
                                    <small>David - 9 Mins ago</small>
                                </div>
                            </div>
                            
                            <div class="media pull-right">
                                <img class="pull-right" src="img/profile-pics/2.jpg" width="30" alt="" />
                                <div class="media-body">
                                    I'm Fine bro <br/>Thank you for asking
                                    <small>Me - 8 Mins ago</small>
                                </div>
                            </div>
                            
                            <div class="media pull-right">
                                <img class="pull-right" src="img/profile-pics/2.jpg" width="30" alt="" />
                                <div class="media-body">
                                    Any idea for a hangout?
                                    <small>Me - 8 Mins ago</small>
                                </div>
                            </div>
                        
                        </div>
                    
                        <div class="chat-footer media">
                            <i class="chat-list-toggle pull-left fa fa-bars"></i>
                            <i class="pull-right fa fa-picture-o"></i> 
                            <div class="media-body">
                                <textarea class="form-control" placeholder="Type something..."></textarea>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        </section>
        
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->




        <script src="js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
        <script src="js/select.min.js"></script> <!-- Custom Select -->
        <script src="js/chosen.min.js"></script> <!-- Custom Multi Select -->
        <script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
        <script src="js/colorpicker.min.js"></script> <!-- Color Picker -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        <script src="js/autosize.min.js"></script> <!-- Textare autosize -->
        <script src="js/toggler.min.js"></script> <!-- Toggler -->
        <script src="js/input-mask.min.js"></script> <!-- Input Mask -->
        <script src="js/spinner.min.js"></script> <!-- Spinner -->
        <script src="js/slider.min.js"></script> <!-- Input Slider -->
        <script src="js/fileupload.min.js"></script> <!-- File Upload -->


        <script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->
        <script src="js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Charts -->
        <script src="js/charts/jquery.flot.js"></script> <!-- Flot Main -->
        <script src="js/charts/jquery.flot.time.js"></script> <!-- Flot sub -->
        <script src="js/charts/jquery.flot.animator.min.js"></script> <!-- Flot sub -->
        <script src="js/charts/jquery.flot.resize.min.js"></script> <!-- Flot sub - for repaint when resizing the screen -->

        <script src="js/sparkline.min.js"></script> <!-- Sparkline - Tiny charts -->
        <script src="js/easypiechart.js"></script> <!-- EasyPieChart - Animated Pie Charts -->
        <script src="js/charts.js"></script> <!-- All the above chart related functions -->

        <!-- Map -->
        <script src="js/maps/jvectormap.min.js"></script> <!-- jVectorMap main library -->
        <script src="js/maps/usa.js"></script> <!-- USA Map for jVectorMap -->

        <!--  Form Related -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->

        <!-- UX -->
        <script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

        <!-- Other -->
        <script src="js/calendar.min.js"></script> <!-- Calendar -->
        <script src="js/feeds.min.js"></script> <!-- News Feeds -->
        

        <!-- All JS functions -->
        <script src="js/functions.js"></script>
        <script src="js/depmain.js"></script>
        
		
</body>
</html>