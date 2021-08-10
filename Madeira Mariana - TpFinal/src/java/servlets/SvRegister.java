package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvRegister", urlPatterns = {"/SvRegister"})
public class SvRegister extends HttpServlet {

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

    String usr = request.getParameter("usuario");
    String con = request.getParameter("contrasenia");

    ControladoraLogica controlL = new ControladoraLogica();

    try {
      controlL.crearUsuario(usr, con);
    } catch (ParseException ex) {
      Logger.getLogger(SvRegister.class.getName()).log(Level.SEVERE, null, ex);
    }
    HttpSession misesion = request.getSession(true);
    misesion.setAttribute("usuario", usr);
    misesion.setAttribute("contrasenia", con);
    Usuario usu = controlL.buscarPorUsuarioYContrasenia(usr, con);
    Long id = usu.getId();
    misesion.setAttribute("idUsuario", id);
    
    String nom = request.getParameter("nombre");
    String ape = request.getParameter("apellido");
    String dni = request.getParameter("dni");
    String dir = request.getParameter("direccion");
    String nac = request.getParameter("nacimiento");
    String car = request.getParameter("cargo");

    try {
      Date fechaNac = controlL.convertirStringADate(nac);
      controlL.crearEmpleado(nom, ape, dni, dir, fechaNac, car);
      Empleado emple = controlL.buscarEmpleadoAtributos(nom, ape, dni);
      usu.setEmpleado(emple);
      controlL.modificarUsuario(usu);
      
    } catch (ParseException ex) {
      Logger.getLogger(SvRegister.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
      Logger.getLogger(SvRegister.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    misesion.setAttribute("nombre", nom);
    
    response.sendRedirect("index.jsp");

  }

}
