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
import logica.ControladoraLogica;

@WebServlet(name = "SvNewGuest", urlPatterns = {"/SvNewGuest"})
public class SvNewGuest extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String nom = request.getParameter("nombre");
    String ape = request.getParameter("apellido");
    String dni = request.getParameter("dni");
    String dir = request.getParameter("direccion");
    String nac = request.getParameter("nacimiento");
    String pro = request.getParameter("profesion");

    ControladoraLogica controlL = new ControladoraLogica();

    try {
      Date fechaNac = controlL.convertirStringADate(nac);
      controlL.crearHuesped(nom, ape, dni, dir, fechaNac, pro);
    } catch (ParseException ex) {
      Logger.getLogger(SvNewGuest.class.getName()).log(Level.SEVERE, null, ex);
    }
    response.sendRedirect("guests.jsp");
  }

}
