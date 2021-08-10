
<%@page import="logica.Habitacion"%>
<%@page import="logica.ControladoraLogica"%>
<%@page import="logica.Huesped"%>
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

    <title>Modificar Habitación</title>
  </head>
  <body>
    <%
      HttpSession misesion = request.getSession();
      String usr = (String) misesion.getAttribute("usuario");
      if (usr == null) {
        response.sendRedirect("login.jsp");
      } else {
    %>

    <div class="container">

      <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
          <!-- Nested Row within Card Body -->
          <div class="row">
            
            <div class="col-lg-12">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4">Modificar Habitación</h1>
                </div>

                <!-- FORM -->
                <form class="user" action="SvUpdateRoom" method="GET">
                  <% Habitacion hab = (Habitacion) misesion.getAttribute("habitacion");
                  %>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <input type="number" class="form-control form-control-user" id="" placeholder="Piso"  name="piso" value="<%=hab.getPiso()%>" min="1" max="5" required>
                    </div>
                    <div class="col-sm-6">
                      <input type="text" class="form-control form-control-user" id="" placeholder="Nombre" name="nombre" value="<%=hab.getNombre()%>" required>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <select name="tipo" class="form-control form-control-user custom-select">
                        <option selected>Tipo</option>
                        <option value="single">Single</option>
                        <option value="doble">Doble</option>
                        <option value="triple">Triple</option>
                        <option value="multiple">Multiple</option>
                      </select>
                    </div>
                    <div class="col-sm-6">
                      <input type="number" class="form-control form-control-user" id="" placeholder="Precio" name="precio" value="<%=hab.getPrecioNoche()%>" required>
                    </div>
                  </div>

                  <hr>
                  <input type="hidden" name="id" value="<%=hab.getId()%>" />
                  <input type="submit" href=".jsp" class="btn btn-primary btn-user btn-block" value="Actualizar Datos">
                </form>                <!-- FIN FORM -->

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
  <%}%>
  <!-- Bootstrap core JavaScript-->
      <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

      <!-- Core plugin JavaScript-->
      <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

      <!-- Custom scripts for all pages-->
      <script src="js/sb-admin-2.min.js"></script>
</body>
</html>
