package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Habitacion;

@WebServlet(name = "SvNewRoom", urlPatterns = {"/SvNewRoom"})
public class SvNewRoom extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ControladoraLogica controlL = new ControladoraLogica();
    HttpSession misesion = request.getSession();
    List<Habitacion> listaHabitaciones = controlL.traerHabitaciones();
    misesion.setAttribute("listaHab", listaHabitaciones);
    response.sendRedirect("rooms.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    int piso = Integer.parseInt(request.getParameter("piso"));
    String nom = request.getParameter("nombre");
    String tipo = request.getParameter("tipo");
    double pre = Double.parseDouble(request.getParameter("precio"));

    ControladoraLogica controlL = new ControladoraLogica();
    controlL.crearHabitacion(piso, nom, tipo, pre);
    
    response.sendRedirect("rooms.jsp");
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
