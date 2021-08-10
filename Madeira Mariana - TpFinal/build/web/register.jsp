
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <title>Registrate</title>
  </head>
  <body>
    <%
      HttpSession misesion = request.getSession();
      String usr = (String) misesion.getAttribute("usuario");
      if (usr != null) {
        response.sendRedirect("login.jsp");
      } else {
    %>

    <div class="container">
      <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
          <!-- Nested Row within Card Body -->
          <div class="row">
            <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
            <div class="col-lg-7">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4">Registrate</h1>
                </div>

                <!-- FORM -->
                <form class="user" action="SvRegister" method="post">
                  
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <input type="text" class="form-control form-control-user" id="" placeholder="Nombres" name="nombre" required>
                    </div>
                    <div class="col-sm-6">
                      <input type="text" class="form-control form-control-user" id="" placeholder="Apellidos" name="apellido" required>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <input type="text" class="form-control form-control-user" id="" placeholder="DNI" name="dni" required>
                    </div>
                    <div class="col-sm-6">
                      <input type="text" class="form-control form-control-user" id="" placeholder="Domicilio" name="direccion" required>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <div class="input-group mb-3">
                                    <span class="input-group-text form-control form-control-user" id="basic-addon1">Fecha de Nac.</span>
                                    <input type="date" class="form-control form-control-user" id="datetimepicker1" placeholder="Fecha de Nacimiento (dd/mm/YYYY)" name="nacimiento" aria-label="Username" aria-describedby="basic-addon1" required>
                                  </div>
                    </div>
                    <div class="col-sm-6">
                      <input type="text" class="form-control form-control-user" id="" placeholder="Cargo" name="cargo" required>
                    </div>
                  </div>
                  <hr> 
                  <div class="form-group">
                    <input type="email" class="form-control form-control-user" id=""
                           placeholder="E-mail" name="usuario" required>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <input type="password" class="form-control form-control-user"
                             id="" placeholder="Contraseņa" name="contrasenia" required>
                    </div>
                    <div class="col-sm-6">
                      <input type="password" class="form-control form-control-user"
                             id="" placeholder="Repetir Contraseņa" name="contrasenia" required>
                    </div>
                  </div>

                  <input type="submit" href="login.jsp" class="btn btn-primary btn-user btn-block" value="Registrarse">

                </form>
                <!-- FIN FORM -->
                <hr>
                <div class="text-center">
                  <a class="small" href="login.jsp">Tienes cuenta? Logueate!</a>
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
