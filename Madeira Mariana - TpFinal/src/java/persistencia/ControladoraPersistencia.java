package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Empleado;
import logica.Habitacion;
import logica.Huesped;
import logica.Reserva;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

  UsuarioJpaController usuarioJPA = new UsuarioJpaController();
  EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
  HuespedJpaController huespedJPA = new HuespedJpaController();
  HabitacionJpaController habitacionJPA = new HabitacionJpaController();
  ReservaJpaController reservaJPA = new ReservaJpaController();

  // --- SELECT * FROM ----------------
  public List<Usuario> traerUsuarios() {
    return usuarioJPA.findUsuarioEntities();
  }

  public List<Empleado> traerEmpleados() {
    return empleadoJPA.findEmpleadoEntities();
  }

  public List<Huesped> traerHuespedes() {
    return huespedJPA.findHuespedEntities();
  }

  public List<Habitacion> traerHabitaciones() {
    return habitacionJPA.findHabitacionEntities();
  }

  public List<Reserva> traerReservas() {
    return reservaJPA.findReservaEntities();
  }

  // --- ALTAS ----------------
  public void crearUsuario(Usuario usu) {
    usuarioJPA.create(usu);
  }

  public void crearEmpleado(Empleado emple) {
    empleadoJPA.create(emple);
  }

  public void crearHuesped(Huesped huesp) {
    huespedJPA.create(huesp);
  }

  public void crearHabitacion(Habitacion hab) {
    habitacionJPA.create(hab);
  }

  public void crearReserva(Reserva reser) {
    reservaJPA.create(reser);
  }

  // --- BÚSQUEDA POR ID ----------------
  public Empleado buscarEmpleado(long id) {
    return empleadoJPA.findEmpleado(id);
  }

  public Usuario buscarUsuario(long id) {
    return usuarioJPA.findUsuario(id);
  }

  public Habitacion buscarHabitacion(long id) {
    return habitacionJPA.findHabitacion(id);
  }

  public Reserva buscarReserva(long id) {
    return reservaJPA.findReserva(id);
  }

  public Huesped buscarHuesped(long id) {
    return huespedJPA.findHuesped(id);
  }

  // --- BAJAS ----------------
  public void borrarEmpleado(long id) {
    try {
      empleadoJPA.destroy(id);
    } catch (NonexistentEntityException ex) {
      Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void borrarUsuario(long id) throws NonexistentEntityException {
    usuarioJPA.destroy(id);
  }

  public void borrarHuesped(long id) throws NonexistentEntityException {
    huespedJPA.destroy(id);
  }

  public void borrarReserva(long id) throws NonexistentEntityException {
    reservaJPA.destroy(id);
  }

  public void borrarHabitacion(long id) throws NonexistentEntityException {
    habitacionJPA.destroy(id);
  }

  // --- MODIFICACIONES ----------------
  public void modificarEmpleado(Empleado emple) throws Exception {
    empleadoJPA.edit(emple);
  }

  public void modificarUsuario(Usuario usu) throws Exception {
    usuarioJPA.edit(usu);
  }

  public void modificarHuesped(Huesped hue) throws Exception {
    huespedJPA.edit(hue);
  }

  public void modificarHabitacion(Habitacion hab) throws Exception {
    habitacionJPA.edit(hab);
  }

  public void modificarReserva(Reserva res) throws Exception {
    reservaJPA.edit(res);
  }

}
