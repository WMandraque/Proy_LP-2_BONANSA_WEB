<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="descripcion" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>RegistrarEmpleado</title>
            
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
<body id="skin-blur-violate">
        <header id="header" class="media">
            <a href="" id="menu-toggle"></a> 
            <a class="logo pull-left" href="Indice.jsp">Bonan S.A.</a>
            
            <div class="media-body">
                <div class="media" id="top-menu">
                    <div class="pull-left tm-icon">
                        <a data-drawer="messages" class="drawer-toggle" href="">
                            <i class="sa-top-message"></i>
                            <i class="n-count animated">5</i>
                            <span>Mensajesssssss</span>
                        </a>
                    </div>
                    <div class="pull-left tm-icon">
                        <a data-drawer="notifications" class="drawer-toggle" href="">
                            <i class="sa-top-updates"></i>
                            <i class="n-count animated">9</i>
                            <span>Actualizaciones</span>
                        </a>
                    </div>
                    <div id="time" class="pull-right">
                        <span id="hours"></span>
                        :
                        <span id="min"></span>
                        :
                        <span id="sec"></span>
                    </div>
                    
                    <div class="media-body">
                        <input type="text" class="main-search">
                    </div>
                </div>
            </div>
        </header>
        

        
        	<aside id="sidebar">
        	
                <div class="side-widgets overflow">
                    <!-- Profile Menu -->
                    <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                        <a href="" data-toggle="dropdown">
                            <img class="profile-pic animated" src="img/profile-pic.jpg" alt="">
                        </a>
                        <ul class="dropdown-menu profile-menu">
                            <li><a href="">Mi Perfil</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="">Mensajes</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="">Ajustes</a><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="gestionaUsuario?operacion=salir">Desconectar</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                        </ul>
                        
                        <!-- Datos del empleado  -->
                        <h4 class="m-0" style="color: orange;">Usuario:</h4>
                        <h4 class="m-0">${sessionScope.usuario}</h4>
                        <br>
                        <h4 class="m-0" style="color: orange;">Tipo:</h4>
                         <h4 class="m-0">${sessionScope.tipoEmpleado}</h4>
                         
                         
                    </div>
                    <div class="s-widget m-b-25">
                        <div id="sidebar-calendar"></div>
                    </div>
                    <nav id="wrapper">
                    <ul class="menu">
    
						<a href="mpAdministrador.jsp">Inicio</a>
						
        				<li class="item2"><a href="#">Mantenimiento Clientes</a>
						    <ul>
                				<li class="subitem1"><a href="#">Registrar Cliente</a></li>
                				<li class="subitem2"><a href="#">Actualizar Cliente</a></li>
                				<li class="subitem3"><a href="#">Listar Cliente</a></li>
            				</ul>
        				</li>
        				
        				
        				<li class="item3"><a href="#">Mantenimiento Empleados</a>
						    <ul>
                				<li class="subitem1"><a href="mpAdRegistrarEmpleado.jsp">Registrar Empleado</a></li>
                				<li class="subitem2"><a href="">Actualizar Empleado</a></li>
                				<li class="subitem3"><a href="#">Listar Empleado</a></li>
            				</ul>
        				</li>
        				
        				
        				<li class="item4"><a href="#">Mantenimiento Vehiculos</a>
						    <ul>
                				<li class="subitem1"><a href="paRegistrarVehiculo.jsp">Registrar Vehiculo</a></li>
                				<li class="subitem2"><a href="paActualizarVehiculo.jsp">Actualizar Vehiculo</a></li>
                				<li class="subitem3"><a href="paListarVehiculos.jsp">Listar Vehiculos</a></li>
            				</ul>
        				</li>
        				
        				
        			
                	</ul>
                	</nav>
                    </div>
        	</aside>
        	
        <section id="content" class="container">
                
               
                <ol class="breadcrumb hidden-xs">
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Libreria</a></li>
                    <li class="active">Datos</li>
                </ol>
                <h4 class="page-title">REGISTRAR EMPLEADOS</h4>
                
                
                
                
                <!--Espacio para el formulario  -->
                <div class="block-area">
                    
                    
                     <div class="block-area" id="text-input">
                    <h3 class="block-title">Text Input</h3>
                    
                    
                    <p>Text Inputs with different sizes by height and column.</p>
                    
                    <input class="form-control input-lg m-b-10" type="text" placeholder=".input-lg">
                    <input type="text" class="form-control m-b-10" placeholder="Default">
                    <input class="form-control input-sm m-b-10" type="text" placeholder=".input-sm">
                    
                    <div class="row">
                        <div class="col-lg-2">
                            <input type="text" class="form-control m-b-10" placeholder=".col-lg-2">
                        </div>
                        <div class="col-lg-3">
                            <input type="text" class="form-control m-b-10" placeholder=".col-lg-3">
                        </div>
                        <div class="col-lg-4">
                            <input type="text" class="form-control m-b-10" placeholder=".col-lg-4">
                        </div>
                        <div class="col-lg-5">
                            <input type="text" class="form-control m-b-10" placeholder=".col-lg-5">
                        </div>
                        <div class="col-lg-6">
                            <input type="text" class="form-control m-b-10" placeholder=".col-lg-6">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                     <p></p>
                    <p>Input focus</p>
                    <input class="form-control input-focused" type="text" value="This is focused...">
                    <p></p>
                    <p>Disabled</p>
                    <input class="form-control" type="text" value="This is disabled..." disabled>
                </div>
                    
                 <hr class="whiter m-t-20" />
                
                <!-- Textarea -->
                <div class="block-area" id="textarea">
                    <h3 class="block-title">Textarea</h3>   
                    
                    
                    <p>Form control which supports multiple lines of text. Change 'rows' attribute as necessary.</p>
                    <textarea class="form-control overflow" rows="3" placeholder="This is a default Textarea..."></textarea>
                    
              
                    <p></p>
                    </div>
                   
    <!-- Select -->
                <div class="block-area" id="select">
                    <h3 class="block-title">Select</h3>
                    <p>Use Grid classes to adjust column sizes</p>
                    
                    <select class="form-control input-lg m-b-10">
                        <option>Option 1</option>
                        <option>Option 2</option>
                        <option>Option 3</option>
                    </select>
                    
                    <select class="form-control m-b-10">
                        <option>Option 1</option>
                        <option>Option 2</option>
                        <option>Option 3</option>
                    </select>
                    
                    <select class="form-control input-sm m-b-10">
                        <option>Option 1</option>
                        <option>Option 2</option>
                        <option>Option 3</option>
                    </select>
                    
                    <div class="select-container"> <!-- Hack to hide scrollbars -->
                        <select multiple class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>

                    <p></p>
                    <p>Disabled</p>
                    <select class="form-control" disabled>
                        <option>Option 1</option>
                        <option>Option 2</option>
                        <option>Option 3</option>
                    </select>
                </div>
    
    <hr class="whiter m-t-20" />
                
                <!-- Checkbox + Radio-->
                <div class="block-area" id="check">
                    <h3 class="block-title">Checkbox + Radio</h3>
                    <p>Default Checkbox</p>
                    
                    <div class="checkbox m-b-5">
                        <label>
                            <input type="checkbox" checked>
                            This is an awesome sample Checkbox
                        </label>
                    </div>
                    
                    <div class="clearfix"></div>
                    
                    <div class="checkbox m-b-5">
                        <label>
                            <input type="checkbox">
                            This is another awesome sample Checkbox
                        </label>
                    </div>
                    
                    <div class="clearfix"></div>
                    
                    <div class="checkbox m-b-5">
                        <label>
                            <input type="checkbox">
                            One more awesome sample Checkbox
                        </label>
                    </div>
                    
                    <br/>
                    
                    <p>Inline Checkboxes</p>
                    <label class="checkbox-inline">
                        <input type="checkbox">
                        1
                    </label>
                    
                    <label class="checkbox-inline">
                        <input type="checkbox">
                        2
                    </label>
                    
                    <label class="checkbox-inline">
                        <input type="checkbox">
                        3
                    </label>

                    <p class="m-t-20">Radio</p>
                    <div class="radio">
                        <label>
                            <input type="radio" name="radio">
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                                        
                    <div class="radio">
                        <label>
                            <input type="radio" name="radio">
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    
                    <div class="clearfix"></div>
                    
                    <p class="m-t-20">Disabled</p>
                    <div class="radio">
                        <label>
                            <input type="radio" checked disabled>
                            This Radio is checked and disabled
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" disabled>
                            This Radio is not checked and disabled
                        </label>
                    </div>
                    
                    <div class="checkbox m-t-10 m-b-5">
                        <label>
                            <input type="checkbox" checked disabled>
                            This is an awesome sample Checkbox checked and disabled
                        </label>
                    </div>
                    
                    <div class="checkbox">
                        <label class="m-t-10">
                            <input type="checkbox" disabled>
                            This is too disabled
                        </label>
                    </div>
                    
                    <br/><br/><br/>
    
    
    
    
    
    
    
    
    
                    
                </div>
                
                
                
                
    
                            

                         
                         
                  
             
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