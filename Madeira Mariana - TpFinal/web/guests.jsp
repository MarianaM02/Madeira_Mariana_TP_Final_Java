
<%@page import="logica.Huesped"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControladoraLogica"%>
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

    <title>Huéspedes</title>
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
              <span>Huéspedes</span>
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
                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                  <h1 class="h3  text-gray-800">Huéspedes</h1>
                  <form action="SvNewGuest" method="POST"><a href="newGuest.jsp" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm"><i
                  class="fas fa-plus fa-sm text-white-50"></i> Nuevo Huésped</a></form>

                </div>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                  <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Huéspedes</h6>
                  </div>
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-hover table-sm" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                          <tr>
                            <th>Nombre</th>
                            <th>DNI</th>
                            <th>Profesión</th>
                            <th>F. Nacimiento</th>
                            <th>Domicilio</th>
                            <th></th>
                            <th></th>
                          </tr>
                        </thead>
                        <tfoot>
                          <tr>
                            <th>Nombre</th>
                            <th>DNI</th>
                            <th>Profesión</th>
                            <th>F. Nacimiento</th>
                            <th>Domicilio</th>
                            <th></th>
                            <th></th>
                          </tr>
                        </tfoot>
                        <tbody>
                          <%ControladoraLogica ctrl = new ControladoraLogica();
                            //List<Empleado> listaEmpleados = ctrl.traerEmpleados();
                            List<Huesped> listaHuespedes = ctrl.traerHuespedes();
                            if (listaHuespedes != null) {
                              for (Huesped u : listaHuespedes) {%>
                          <tr>
                            <%String nombreCompleto = u.getNombres() + " " + u.getApellidos();
                              String cargo = u.getProfesion();
                              String dni = u.getDni();
                              String nac = ctrl.convertirDateAString(u.getFechaNacimiento());
                              String dire = u.getDireccionDomicilio();
                              long id = u.getId();
                            %>
                            <td><%=nombreCompleto%></td>
                            <td><%=dni%></td>
                            <td><%=cargo%></td>
                            <td><%=nac%></td>
                            <td><%=dire%></td>

                            <td>
                              <form name="frmModificarHuesped" action="SvUpdateGuest" method="POST" style="display:inline">
                                <input type="hidden" name="id" value="<%=id%>" />
                                <button type="submit" style="display:inline" class="btn btn-link nav-link"/><i class="fas fa-fw fa-edit "></i></button>
                              </form>
                            </td>
                            <td>
                              <form name="frmBorrarHuesped" action="SvDeleteGuest" method="POST" style="display:inline">
                                <input type="hidden" name="id" value="<%=id%>" />
                                <button type="submit" style="display:inline" class="btn btn-link nav-link"/><i class="fas fa-fw fa-trash-alt text-danger"></i></button>
                              </form>
                            </td>
                          </tr>
                          <%}
                            }%>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>

              </div>
              
            </div>


            <!-- Content Row -->

            <!-- Area Chart -->


            <!-- Pie Chart -->

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
