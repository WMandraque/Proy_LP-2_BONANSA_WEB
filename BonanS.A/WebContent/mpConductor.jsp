<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>Bonan S.A.</title>

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
<link href="css/menu.css" rel ="stylesheet">

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

	<div class="clearfix"></div>

	<section id="main" class="p-relative" role="main"> <aside
		id="sidebar">

	<div class="side-widgets overflow">
		<!-- Profile Menu -->
		<div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
			<a href="" data-toggle="dropdown"> <img
				class="profile-pic animated"
				src="gestionaEmpleado?operacion=mostrarFoto&idEmpleado=${sessionScope.idEmpleado}">
			</a>
			<ul class="dropdown-menu profile-menu">
				<li><a href="">Mi Perfil</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="">Mensajes</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="">Ajustes</a><i class="icon left">&#61903;</i><i
					class="icon right">&#61815;</i></li>
				<li><a href="gestionaUsuario?operacion=salir">Desconectar</a> <i
					class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
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
				<ul class="main-menu mainmenu-menu">
<%-- 					 <li class="subitem1"><a href="gestionaOrdenRecojo?operacion=listar&idEmpleado=${sessionScope.idEmpleado}&nivel=condu">Mis Ordenes de recojo</a></li>
 --%>				     <%-- <li class="subitem1"><a href="gestionaGRT?operacion=listar&nivel=CONDUCTOR&idEmpleado=${sessionScope.idEmpleado}">Listar GRT</a></li> --%>
					 <li class="subitem2"><a href="pcRegistrarGRT.jsp">Generar Guia de Remision del Transportista</a></li>
					 <li class="subitem2"><a href="pcEntregaMercaderia.jsp">Entregar Mercaderia</a></li>
			  </ul>
            </li>

			
			

			<li class="nivel1 s-widget m-b-25"><a href="#"><img width="30" src="img/icon/ruta.png"> Control de Ruta</a>
				<ul class="main-menu mainmenu-menu">
                    <li class="subitem2"><a href="pcRegistrarIncidencias.jsp">Registrar Incidencias</a></li>				
               </ul>
            </li>


			



		</ul>
		</nav>
	</div>
	</aside> <section id="content" class="container">
	<div id="messages" class="tile drawer animated">
		<div class="listview narrow">
			<div class="media">
				<a href="">Enviar un Nuevo Mensaje</a> <span class="drawer-close">&times;</span>

			</div>
			<div class="overflow" style="height: 254px">
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/1.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
						<a class="t-overflow" href="">Mauris consectetur urna nec
							tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing
							lectus</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/2.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">David Villa - 5 Hours ago</small><br>
						<a class="t-overflow" href="">Suspendisse in purus ut nibh
							placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
							pharetra</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/3.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Harris worgon - On 15/12/2013</small><br>
						<a class="t-overflow" href="">Maecenas venenatis enim
							condimentum ultrices fringilla. Nulla eget libero rhoncus,
							bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
							ornare turpis id</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/4.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Mitch Bradberry - On 14/12/2013</small><br>
						<a class="t-overflow" href="">Phasellus interdum felis enim,
							eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci,
							sed viverra felis aliquet quis. Curabitur vel blandit odio.
							Vestibulum sagittis quis sem sit amet tristique.</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/1.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
						<a class="t-overflow" href="">Ipsum wintoo consectetur urna
							nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu
							adipiscing lectus</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/2.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">David Villa - On 16/12/2013</small><br>
						<a class="t-overflow" href="">Suspendisse in purus ut nibh
							placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
							pharetra</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/3.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Harris worgon - On 17/12/2013</small><br>
						<a class="t-overflow" href="">Maecenas venenatis enim
							condimentum ultrices fringilla. Nulla eget libero rhoncus,
							bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
							ornare turpis id</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/4.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Mitch Bradberry - On 18/12/2013</small><br>
						<a class="t-overflow" href="">Phasellus interdum felis enim,
							eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci,
							sed viverra felis aliquet quis. Curabitur vel blandit odio.
							Vestibulum sagittis quis sem sit amet tristique.</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/5.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Wendy Mitchell - On 19/12/2013</small><br>
						<a class="t-overflow" href="">Integer a eros dapibus, vehicula
							quam accumsan, tincidunt purus</a>
					</div>
				</div>
			</div>
			<div class="media text-center whiter l-100">
				<a href=""><small>VIEW ALL</small></a>
			</div>
		</div>
	</div>
	<div id="notifications" class="tile drawer animated">
		<div class="listview narrow">
			<div class="media">
				<a href="">Ajustes de Notificaciones</a> <span class="drawer-close">&times;</span>
			</div>
			<div class="overflow" style="height: 254px">
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/1.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
						<a class="t-overflow" href="">Mauris consectetur urna nec
							tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing
							lectus</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/2.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">David Villa - 5 Hours ago</small><br>
						<a class="t-overflow" href="">Suspendisse in purus ut nibh
							placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
							pharetra</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/3.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Harris worgon - On 15/12/2013</small><br>
						<a class="t-overflow" href="">Maecenas venenatis enim
							condimentum ultrices fringilla. Nulla eget libero rhoncus,
							bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
							ornare turpis id</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/4.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Mitch Bradberry - On 14/12/2013</small><br>
						<a class="t-overflow" href="">Phasellus interdum felis enim,
							eu bibendum ipsum tristique vitae. Phasellus feugiat massa orci,
							sed viverra felis aliquet quis. Curabitur vel blandit odio.
							Vestibulum sagittis quis sem sit amet tristique.</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/1.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
						<a class="t-overflow" href="">Ipsum wintoo consectetur urna
							nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu
							adipiscing lectus</a>
					</div>
				</div>
				<div class="media">
					<div class="pull-left">
						<img width="40" src="img/profile-pics/2.jpg" alt="">
					</div>
					<div class="media-body">
						<small class="text-muted">David Villa - On 16/12/2013</small><br>
						<a class="t-overflow" href="">Suspendisse in purus ut nibh
							placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
							pharetra</a>
					</div>
				</div>
			</div>
			<div class="media text-center whiter l-100">
				<a href=""><small>VER TODO</small></a>
			</div>
		</div>
	</div>

	<marquee behavior="slide"><h4 class="page-title">Bienvenido ${sessionScope.nombreCompleto}</h4></marquee>
	<div class="block-area shortcut-area">
		<center>
		
			<a class="shortcut tile" href="gestionaOrdenRecojo?operacion=listar&idEmpleado=${sessionScope.idEmpleado}&nivel=condu"> <img
				src="img/shortcuts/ordenrecojo.png" alt=""> <small
				class="t-overflow">Recojo</small>
			</a>
			
			<a class="shortcut tile" href="pcRegistrarGRT.jsp"> <img
				src="img/shortcuts/grt.png" alt=""> <small
				class="t-overflow">GRT</small>
			</a>
			
			<a class="shortcut tile" href=""> <img
				src="img/shortcuts/logs.png" alt=""> <small
				class="t-overflow">Incidencias</small>
			</a>
			
			<a class="shortcut tile" href="gestionaUsuario?operacion=salir"> <img
				src="img/shortcuts/salir.png" alt=""> <small
				class="t-overflow">Salir</small>
			</a>
		 </center>
	</div>
	<hr class="whiter" />
	
	<hr class="whiter" />
	<div class="block-area">
		<div class="row">
			<div class="col-md-8">
				<!-- Main Chart -->
				<div class="tile">
					<h2 class="tile-title">Statistics</h2>
					<div class="tile-config dropdown">
						<a data-toggle="dropdown" href="" class="tile-menu"></a>
						<ul class="dropdown-menu pull-right text-right">
							<li><a class="tile-info-toggle" href="">Chart
									Information</a></li>
							<li><a href="">Actualizar</a></li>
							<li><a href="">Ajustes</a></li>
						</ul>
					</div>
					<div class="p-10">
						<div id="line-chart" class="main-chart" style="height: 250px"></div>

						<div class="chart-info">
							<ul class="list-unstyled">
								<li class="m-b-10">Ventas Totales 1200 <span
									class="pull-right text-muted t-s-0"> <i
										class="fa fa-chevron-up"></i> +12%
								</span>
								</li>
								<li><small> Local 640 <span
										class="pull-right text-muted t-s-0"><i
											class="fa m-l-15 fa-chevron-down"></i> -8%</span>
								</small>
									<div class="progress progress-small">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%"></div>
									</div></li>
								<li><small> Foreign 560 <span
										class="pull-right text-muted t-s-0"> <i
											class="fa m-l-15 fa-chevron-up"></i> -3%
									</span>
								</small>
									<div class="progress progress-small">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
											style="width: 60%"></div>
									</div></li>
							</ul>
						</div>
					</div>
				</div>

				

				<!--  Recent Postings -->
				
				<div class="clearfix"></div>
			</div>

			<div class="col-md-4">
				<!-- USA Map -->
				<div class="tile">
					<h2 class="tile-title">Live Visits</h2>
					<div class="tile-config dropdown">
						<a data-toggle="dropdown" href="" class="tile-menu"></a>
						<ul class="dropdown-menu pull-right text-right">
							<li><a href="">Actualizar</a></li>
							<li><a href="">Ajustes</a></li>
						</ul>
					</div>

					<div id="usa-map"></div>
				</div>

				<!-- Dynamic Chart -->
				<div class="tile">
					<h2 class="tile-title">Proceso del Servidor</h2>
					<div class="tile-config dropdown">
						<a data-toggle="dropdown" href="" class="tile-menu"></a>
						<ul class="dropdown-menu pull-right text-right">
							<li><a href="">Refresh</a></li>
							<li><a href="">Settings</a></li>
						</ul>
					</div>

					<div class="p-t-10 p-r-5 p-b-5">
						<div id="dynamic-chart" style="height: 200px"></div>
					</div>

				</div>

				<!-- Activity -->
				<div class="tile">
					<h2 class="tile-title">Social Media activities</h2>
					<div class="tile-config dropdown">
						<a data-toggle="dropdown" href="" class="tile-menu"></a>
						<ul class="dropdown-menu pull-right text-right">
							<li><a href="">Refresh</a></li>
							<li><a href="">Settings</a></li>
						</ul>
					</div>

					<div class="listview narrow">

						<div class="media">
							<div class="pull-right">
								<div class="counts">367892</div>
							</div>
							<div class="media-body">
								<h6>FACEBOOK LIKES</h6>
							</div>
						</div>

						<div class="media">
							<div class="pull-right">
								<div class="counts">2012</div>
							</div>
							<div class="media-body">
								<h6>GOOGLE +1s</h6>
							</div>
						</div>

						<div class="media">
							<div class="pull-right">
								<div class="counts">56312</div>
							</div>
							<div class="media-body">
								<h6>YOUTUBE VIEWS</h6>
							</div>
						</div>

						<div class="media">
							<div class="pull-right">
								<div class="counts">785879</div>
							</div>
							<div class="media-body">
								<h6>TWITTER FOLLOWERS</h6>
							</div>
						</div>
						<div class="media">
							<div class="pull-right">
								<div class="counts">68</div>
							</div>
							<div class="media-body">
								<h6>WEBSITE COMMENTS</h6>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

		</section> </section>

	<script src="js/jquery.min.js"></script>
	<!-- jQuery Library -->
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