
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
    <title>Login</title>
  </head>
  <body>
    <%
      HttpSession misesion = request.getSession();
      String usr = (String) misesion.getAttribute("usuario");
      if (usr != null) {
        response.sendRedirect("index.jsp");
      }else{
    %>
    <div class="container">

      <!-- Outer Row -->
      <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
          <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                <div class="col-lg-6">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h4 text-gray-900 mb-4">Ingresa al sistema</h1>
                    </div>
                    <form action="SvLogin" method="POST" class="user">
                      <div class="form-group">
                        <input type="email" class="form-control form-control-user validate-input" id="" aria-describedby="emailHelp" placeholder="E-mail" name="usr" required>
                      </div>
                      <div class="form-group">
                        <input type="password" class="form-control form-control-user validate-input" data-validate="La contraseņa es obligatoria" id="" placeholder="Contraseņa" name="pass" required>
                      </div>

                      <input type="submit" href="index.jsp" class="btn btn-primary btn-user btn-block" value="Entrar">
                    </form>
                    <hr>
                    <div class="text-center">
                      <a class="small" href="register.jsp">Registrarse</a>
                    </div>
                  </div>
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
