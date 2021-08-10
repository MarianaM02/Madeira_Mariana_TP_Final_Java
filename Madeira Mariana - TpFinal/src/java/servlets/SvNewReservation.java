
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
import logica.Reserva;

@WebServlet(name = "SvNewReservation", urlPatterns = {"/SvNewReservation"})
public class SvNewReservation extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    ControladoraLogica controlL = new ControladoraLogica();
    HttpSession misesion = request.getSession();
    List<Reserva> listaReservas = controlL.traerReservas();
    List<Huesped> listaHuespedes = controlL.traerHuespedes();
    misesion.setAttribute("listaReservas", listaReservas);
    misesion.setAttribute("listaHuespedes", listaHuespedes);
    response.sendRedirect("newReservations.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    HttpSession misesion = request.getSession();
    Long idUsu = (Long)(misesion.getAttribute("idUsuario"));
   
    String in = request.getParameter("checkin");
    String out = request.getParameter("checkout");
    String fCrea = request.getParameter("fechaCreacion");
    String cant = request.getParameter("cantPersonas");
    Long idHue = Long.parseLong(request.getParameter("idHuesped"));
    Long idHab = Long.parseLong(request.getParameter("idHabitacion"));
    
    ControladoraLogica controlL = new ControladoraLogica();

    try {
      controlL.crearReserva(in, out, cant, idUsu, idHue, idHab, fCrea);
    } catch (Exception ex) {
      Logger.getLogger(SvNewReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    response.sendRedirect("reservations.jsp");
  }


}
