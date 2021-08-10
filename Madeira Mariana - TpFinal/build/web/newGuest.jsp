
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <title>Nuevo Huesped</title>
  </head>
  <body id="page-top">
    <%
      HttpSession misesion = request.getSession();
      String usr = (String) misesion.getAttribute("usuario");
      if (usr == null) {
        response.sendRedirect("login.jsp");
      } else {
    %>
    <!-- Page Wrapper -->
    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
          <div class="sidebar-brand-icon">
            <i class="fas fa-hotel"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Hotel California</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
          Tablas
        </div>

        <!-- Nav Item -->
        <form name="SvNewEmployee" action="SvNewEmployee" method="get">
          <li class="nav-item">
            <a class="nav-link " href="users.jsp" >
              <i class="fas fa-fw fa-users"></i>
              <span>Empleados</span>
            </a>
          </li>
        </form>

        <form name="SvNewReservation" action="SvNewReservation" method="get">
          <li class="nav-item">
            <a class="nav-link " href="reservations.jsp" >
              <i class="fas fa-fw fa-calendar-check"></i>
              <span>Reservas</span>
            </a>
          </li>
        </form>

        <form name="SvNewGuest" action="SvNewGuest" method="get">
          <li class="nav-item">
            <a class="nav-link " href="guests.jsp" >
              <i class="fas fa-fw fa-users"></i>
              <span>Hu�spedes</span>
            </a>
          </li>
        </form>

        <form name="SvNewRoom" action="SvNewRoom" method="get">
          <li class="nav-item">
            <a class="nav-link " href="rooms.jsp" >
              <i class="fas fa-fw fa-bed"></i>
              <span>Habitaciones</span>
            </a>
          </li>
        </form>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <form action="SvLogout" method="POST">
          <li class="nav-item">
            <button type="submit" class="btn btn-link nav-link"><i class="fas fa-fw fa-sign-out-alt"></i> Logout</button>
          </li>
        </form>

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
          <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

      </ul>


      <!-- End of Sidebar -->

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

          <!-- Topbar -->

          <!-- End of Topbar -->

          <!-- Begin Page Content -->
          <div class="container-fluid">



            <!-- CONTENIDO = Content Row -->
            <div class="row mt-5">

              <!-- Begin Page Content -->
              <div class="container-fluid">
                <div class="container">

                  <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                      <!-- Nested Row within Card Body -->
                      <div class="row">

                        <div class="col-lg-12">
                          <div class="p-5">
                            <div class="text-center">
                              <h1 class="h4 text-gray-900 mb-4">Registrar nuevo cliente</h1>
                            </div>

                            <!-- FORM -->
                            <form class="user" action="SvNewGuest" method="POST">
                              <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                  <input type="text" class="form-control form-control-user" id=""
                                         placeholder="Nombres" name="nombre" required>
                                </div>
                                <div class="col-sm-6">
                                  <input type="text" class="form-control form-control-user" id=""
                                         placeholder="Apellidos" name="apellido" required>
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                  <input type="text" class="form-control form-control-user" id=""
                                         placeholder="DNI" name="dni" required>
                                </div>
                                <div class="col-sm-6">
                                  <input type="text" class="form-control form-control-user" id=""
                                         placeholder="Domicilio" name="direccion" required>
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                  <div class="input-group mb-3">
                                    <span class="input-group-text form-control form-control-user" id="basic-addon1">Fecha. de Nacimiento</span>
                                    <input type="date" class="form-control form-control-user" id="datetimepicker1" placeholder="Fecha de Nacimiento (dd/mm/YYYY)" name="nacimiento" aria-label="Username" aria-describedby="basic-addon1" required>
                                  </div>
                                </div>
                                <div class="col-sm-6">
                                  <input type="text" class="form-control form-control-user" id=""
                                         placeholder="Profesion" name="profesion" required>
                                </div>
                              </div>

                              <input type="submit" href="login.jsp" class="btn btn-primary btn-user btn-block" value="Registrar">

                            </form>
                            <!-- FIN FORM -->

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>
          <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer fixed-bottom" >
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright &copy; Your Website 2021</span>
            </div>
          </div>
        </footer>
        <!-- End of Footer -->

      </div>
      <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->


    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    <%}%>
  </body>
</html>
