package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Usuario;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String usuario = request.getParameter("usr");
    String contrasenia = request.getParameter("pass");

    ControladoraLogica controlL = new ControladoraLogica();
    boolean autorizado = controlL.verificarUsuario(usuario, contrasenia);

    if (autorizado) {
      HttpSession misesion = request.getSession(true);
      misesion.setAttribute("usuario", usuario);
      misesion.setAttribute("contrasenia", contrasenia);

      Usuario usu = controlL.buscarPorUsuarioYContrasenia(usuario, contrasenia);
      Object id = usu.getId();
      misesion.setAttribute("idUsuario", id);

      response.sendRedirect("index.jsp");
    } else {
      response.sendRedirect("login.jsp");
    }

  }
}
