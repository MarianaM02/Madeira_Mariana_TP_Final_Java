package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Habitacion;

@WebServlet(name = "SvUpdateRoom", urlPatterns = {"/SvUpdateRoom"})
public class SvUpdateRoom extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Long id = Long.parseLong(request.getParameter("id"));
    int piso = Integer.parseInt(request.getParameter("piso"));
    String nom = request.getParameter("nombre");
    String tipo = request.getParameter("tipo");
    double precio = Double.parseDouble(request.getParameter("precio"));
    
    ControladoraLogica ctrl = new ControladoraLogica();
  
    Habitacion hab = ctrl.buscarHabitacion(id);
    hab.setPiso(piso);
    hab.setNombre(nom);
    hab.setTipo(tipo);
    hab.setPrecioNoche(precio);
    
    try {
      ctrl.modificarHabitacion(hab);
    } catch (Exception ex) {
      Logger.getLogger(SvUpdateRoom.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    request.getSession().setAttribute("listaHabitaciones", ctrl.traerHabitaciones());
    response.sendRedirect("rooms.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    long id = Long.parseLong(request.getParameter("id"));
    
    ControladoraLogica ctrl = new ControladoraLogica();
    Habitacion hab = ctrl.buscarHabitacion(id);
    
    HttpSession misesion = request.getSession();
    misesion.setAttribute("habitacion", hab);
    response.sendRedirect("updateRoom.jsp");
  }

}
