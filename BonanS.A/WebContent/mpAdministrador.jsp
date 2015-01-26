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

			<a href="mpAdministrador.jsp">Inicio</a>
			
			 <li class="item2"><a href="#">Gestion de Recojo</a>
				<ul>
					<li class="subitem1"><a href="paRegistrarSolicitudRecojo.jsp">Registrar Solicitud de recojo</a></li>
					<!-- <li class="subitem2"><a href="#">Actualizar Solicitud de recojo</a></li>
					<li class="subitem2"><a href="#">Eliminar Solicitud de recojo</a></li> -->
					<li class="subitem2"><a href="gestionaOrdenRecojo?operacion=listar&nivel=admin">Listar Ordenes de recojo</a></li>
				</ul>
			</li>
			
			<li class="item3"><a href="#">Gestion de Transporte</a>
				<ul>
<!-- 				    <li class="subitem2"><a href="#">Actualizar GRT</a></li>
					<li class="subitem2"><a href="#">Eliminar GRT</a></li> -->
				    <li class="subitem1"><a href="gestionaGRT?operacion=listar&nivel=ADMINISTRADOR">Listar GRT</a></li>
					
				</ul>
			</li>



			<li class="item3"><a href="#">Control de Ruta</a>
				<ul>
					
				</ul>
			</li>

			<li class="item2"><a href="#">Mantenimiento Clientes</a>
				<ul>
					<li class="subitem1"><a href="paRegistrarCliente.jsp">Registrar Cliente</a></li>
					<li class="subitem2"><a href="paMenuActualizarCliente.jsp">Actualizar Cliente</a></li>
					<li class="subitem2"><a href="paMenuEliminarCliente.jsp">Eliminar Cliente</a></li>
					<li class="subitem3"><a href="gestionaCliente?operacion=listar">Listar Cliente</a></li>
				</ul></li>


			<li class="item3"><a href="#">Mantenimiento Empleados</a>
				<ul>
					<li class="subitem1"><a href="mpAdRegistrarEmpleado.jsp">Registrar Empleado</a></li>
					<li class="subitem2"><a href="paMenuActualizarEmpleado.jsp">Actualizar Empleado</a></li>
					<li class="subitem2"><a href="paMenuEliminarEmpleado.jsp">Eliminar Empleado</a></li>
					<li class="subitem3"><a href="gestionaEmpleado?operacion=listar">Listar Empleado</a></li>
				</ul>
			</li>


			<li class="item3"><a href="#">Mantenimiento Usuario</a>
				<ul>

					<li class="subitem1"><a href="paRegistrarUsuario.jsp">Registrar
							Usuario</a></li>
					<li class="subitem2"><a href="paActualizarUsuario.jsp">Actualizar
							Usuario</a></li>
					<li class="subitem2"><a href="paEliminarUsuario.jsp">Eliminar Usuario</a></li>
					<li class="subitem3"><a
						href="gestionaUsuario?operacion=listar">Listar Usuario</a></li>

				</ul>
			</li>

			<li class="item4"><a href="#">Mantenimiento Vehiculos</a>
				<ul>
					<li class="subitem1"><a href="paRegistrarVehiculo.jsp">Registrar
							Vehiculo</a></li>
					<li class="subitem2"><a href="paActualizarVehiculo.jsp">Actualizar
							Vehiculo</a></li>
					<li class="subitem2"><a href="paEliminarVehiculo.jsp">Eliminar
							Vehiculo</a></li>
					<li class="subitem3"><a
						href="gestionaVehiculo?operacion=listar">Listar Vehiculos</a></li>
				</ul></li>


			<li class="item4"><a href="#">Registro de acciones</a>
				<ul>
					<li class="subitem1"><a href="gestionaLog?operacion=listar">Listado
							de logs</a></li>
				</ul></li>



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

	<h1 class="page-title">Bienvenido Carlos Bonilla</h1>
	<div class="block-area shortcut-area">
		<center>
            <center>Acciones Principales</center>
			<a class="shortcut tile" href="paRegistrarCliente.jsp"> <img
				src="img/shortcuts/money.png" alt=""> <small
				class="t-overflow">Cliente</small>
			</a> <a class="shortcut tile" href="mpAdRegistrarEmpleado.jsp"> <img
				src="img/shortcuts/twitter.png" alt=""> <small
				class="t-overflow">Empleado</small>
			</a> <a class="shortcut tile" href="paRegistrarUsuario.jsp"> <img
				src="img/shortcuts/calendar.png" alt=""> <small
				class="t-overflow">Vehiculo</small>
			</a> <a class="shortcut tile" href="paRegistrarUsuario.jsp"> <img
				src="img/shortcuts/stats.png" alt=""> <small
				class="t-overflow">Usuario</small>
			</a> <a class="shortcut tile" href="prRegistrarSolicitudRecojo.jsp"> <img
				src="img/shortcuts/connections.png" alt=""> <small
				class="t-overflow">Orden Recojo</small>
			</a> <a class="shortcut tile" href="gestionaLog?operacion=listar"> <img
				src="img/shortcuts/reports.png" alt="" > <small
				class="t-overflow">Log general</small>
			</a>

		</center>
	</div>
	<hr class="whiter" />
	<div class="block-area">
		<div class="row">
			<div class="col-md-3 col-xs-6">
				<div class="tile quick-stats">
					<div id="stats-line-2" class="pull-left"></div>
					<div class="data">
						<h2 data-value="${sessionScope.s_cantidadLogueos}"></h2>
						<small>N° Logueos Realizados hoy</small>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-xs-6">
				<div class="tile quick-stats media">
					<div id="stats-line-3" class="pull-left"></div>
					<div class="media-body">
						<h2 data-value="${sessionScope.s_cantidadSOR}">0</h2>
						<small>N° de Solicitud de Orden Recojo</small>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-xs-6">
				<div class="tile quick-stats media">

					<div id="stats-line-4" class="pull-left"></div>

					<div class="media-body">
						<h2 data-value="${sessionScope.s_cantidadGRT}">0</h2>
						<small>N° de GRT del dia</small>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-xs-6">
				<div class="tile quick-stats media">
					<div id="stats-line" class="pull-left"></div>
					<div class="media-body">
						<h2 data-value="29356">0</h2>
						<small>N° de Incidencias del dia</small>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr class="whiter" />
	<div class="block-area">
		<div class="row">
			<div class="col-md-8">
				<!-- Main Chart -->
				<div class="tile">
					<h2 class="tile-title"></h2>
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
										class="fa fa-chevron-up"></i> +120%
								</span>
								</li>
								<li><small> Local 640 <span
										class="pull-right text-muted t-s-0"><i
											class="fa m-l-15 fa-chevron-down"></i> -80%</span>
								</small>
									<div class="progress progress-small">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%"></div>
									</div></li>
								<li><small> Foreign 560 <span
										class="pull-right text-muted t-s-0"> <i
											class="fa m-l-15 fa-chevron-up"></i> -30%
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