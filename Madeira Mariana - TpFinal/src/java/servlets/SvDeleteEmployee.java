
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvDeleteEmployee", urlPatterns = {"/SvDeleteEmployee"})
public class SvDeleteEmployee extends HttpServlet {

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
    ctrl.borrarEmpleado(id);
    
    request.getSession().setAttribute("listaEmpleados", ctrl.traerEmpleados());
    response.sendRedirect("users.jsp");
  
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
