
package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
import persistencia.exceptions.NonexistentEntityException;

@WebServlet(name = "SvDeleteReservation", urlPatterns = {"/SvDeleteReservation"})
public class SvDeleteReservation extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    long id = Long.parseLong(request.getParameter("id"));
    
    ControladoraLogica ctrl = new ControladoraLogica();
    try {
      ctrl.borrarReserva(id);
    } catch (NonexistentEntityException ex) {
      Logger.getLogger(SvDeleteReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    request.getSession().setAttribute("listaReservas", ctrl.traerReservas());
    response.sendRedirect("reservations.jsp");
  
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
