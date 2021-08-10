package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import logica.Huesped;

@WebServlet(name = "SvUpdateGuest", urlPatterns = {"/SvUpdateGuest"})
public class SvUpdateGuest extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Long id = Long.parseLong(request.getParameter("id"));
    String nom = request.getParameter("nombre");
    String ape = request.getParameter("apellido");
    String dni = request.getParameter("dni");
    String dir = request.getParameter("direccion");
    String nac = request.getParameter("nacimiento");
    String pro = request.getParameter("profesion");
    
    ControladoraLogica ctrl = new ControladoraLogica();
    Date fechaNac = null;
    try {
      fechaNac = ctrl.convertirStringADate(nac);
    } catch (ParseException ex) {
      Logger.getLogger(SvUpdateGuest.class.getName()).log(Level.SEVERE, null, ex);
    }
    Huesped hue = ctrl.buscarHuesped(id);
    hue.setNombres(nom);
    hue.setApellidos(ape);
    hue.setDni(dni);
    hue.setDireccionDomicilio(dir);
    hue.setFechaNacimiento(fechaNac);
    hue.setProfesion(pro);
    
    try {
      ctrl.modificarHuesped(hue);
    } catch (Exception ex) {
      Logger.getLogger(SvUpdateGuest.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    request.getSession().setAttribute("listaHuespedes", ctrl.traerHuespedes());
    response.sendRedirect("guests.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    long id = Long.parseLong(request.getParameter("id"));
    
    ControladoraLogica ctrl = new ControladoraLogica();
    Huesped hue = ctrl.buscarHuesped(id);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    HttpSession misesion = request.getSession();
    misesion.setAttribute("huesped", hue);
    misesion.setAttribute("sdf", sdf);
    response.sendRedirect("updateGuest.jsp");
  }

}
