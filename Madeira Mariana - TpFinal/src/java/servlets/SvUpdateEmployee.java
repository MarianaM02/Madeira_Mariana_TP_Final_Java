
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
import logica.Empleado;

@WebServlet(name = "SvUpdateEmployee", urlPatterns = {"/SvUpdateEmployee"})
public class SvUpdateEmployee extends HttpServlet {

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
    String car = request.getParameter("cargo");
    
    ControladoraLogica ctrl = new ControladoraLogica();
    Date fechaNac = null;
    try {
      fechaNac = ctrl.convertirStringADate(nac);
    } catch (ParseException ex) {
      Logger.getLogger(SvUpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
    Empleado emple = ctrl.buscarEmpleado(id);
    emple.setNombres(nom);
    emple.setApellidos(ape);
    emple.setDni(dni);
    emple.setDireccionDomicilio(dir);
    emple.setFechaNacimiento(fechaNac);
    emple.setCargo(car);
    
    try {
      ctrl.modificarEmpleado(emple);
    } catch (Exception ex) {
      Logger.getLogger(SvUpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    request.getSession().setAttribute("listaEmpleados", ctrl.traerEmpleados());
    response.sendRedirect("users.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    long id = Long.parseLong(request.getParameter("id"));
    
    ControladoraLogica ctrl = new ControladoraLogica();
    Empleado emple = ctrl.buscarEmpleado(id);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    HttpSession misesion = request.getSession();
    misesion.setAttribute("empleado", emple);
    misesion.setAttribute("sdf", sdf);
    response.sendRedirect("updateEmployee.jsp");
    
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
