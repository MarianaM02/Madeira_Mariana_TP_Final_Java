package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraLogica {

  ControladoraPersistencia controlP = new ControladoraPersistencia();

  // a. Todas las reservas realizadas en un determinado día.
  public List<Reserva> traerReservasCreacionMismoDia(Date fecha) {

    List<Reserva> listaRes = null;
    List<Reserva> listaCompleta = traerReservas();

    for (Reserva r : listaCompleta) {
      if (r.getFechaCreacion().compareTo(fecha) == 0) {
        listaRes.add(r);
      }
    }
    return listaRes;
  }

  //c. Lista de las reservas realizadas por un determinado empleado.
  public List<Reserva> traerReservasPorEmpleado(Empleado emple) {
    List<Reserva> listaRes = emple.getListaReservas();

    return listaRes;
  }

  // d. Listas de todas las reservas realizadas por un determinado huésped en un período desde/hasta.
  public List<Reserva> traerReservasCreacionEnRango(Date fecha1, Date fecha2) {

    List<Reserva> listaRes = null;
    List<Reserva> listaCompleta = traerReservas();

    for (Reserva r : listaCompleta) {
      if (fechaEnRango(r.getFechaCreacion(), fecha1, fecha2)) {
        listaRes.add(r);
      }
    }
    return listaRes;
  }

  public boolean verificarUsuario(String usuario, String contrasenia) {
    List<Usuario> listaUsuarios = controlP.traerUsuarios();
    if (listaUsuarios != null) {
      for (Usuario usr : listaUsuarios) {
        if (usr.getContrasenia().equals(contrasenia) && usr.getUsuario().equals(usuario)) {
          return true;
        }
      }
    }
    return false;
  }

  public double gananciasDelDia() {
    double gananciaDiaria = 0;
    Date hoy = new Date("yyyy-MM-dd");
    List<Reserva> listaCompleta = traerReservas();
    List<Habitacion> listaHab = traerHabitaciones();
      
    for (Reserva r : listaCompleta) {
      if (r.getFechaCreacion().compareTo(hoy)==0){
        for (Habitacion h : listaHab){
          if (h.getListaReservas().contains(h)){
            gananciaDiaria += h.getPrecioNoche() * cantDiasReserva(r);
          }
        }
        
        
      }
    }
    
    
    return gananciaDiaria;
  }

  public int cantDiasReserva(Reserva res) {
    int diasTotales;
    diasTotales = res.getFechaCheckIn().compareTo(res.getFechaCheckOut());

    return diasTotales;

  }

  // --- ALTAS ----------------
  public void crearHuesped(String nom, String ape, String dni, String dir, Date nac, String car) throws ParseException {

    Huesped huesp = new Huesped();

    huesp.setNombres(nom);
    huesp.setApellidos(ape);
    huesp.setDni(dni);
    huesp.setDireccionDomicilio(dir);
    huesp.setFechaNacimiento(nac);
    huesp.setProfesion(car);

    controlP.crearHuesped(huesp);

  }

  public void crearEmpleado(String nom, String ape, String dni, String dir, Date nac, String car) throws ParseException {

    Empleado emple = new Empleado();

    emple.setNombres(nom);
    emple.setApellidos(ape);
    emple.setDni(dni);
    emple.setDireccionDomicilio(dir);
    emple.setFechaNacimiento(nac);
    emple.setCargo(car);

    controlP.crearEmpleado(emple);
  }

  public void crearUsuario(String usr, String con) throws ParseException {

    Usuario usu = new Usuario();
    usu.setUsuario(usr);
    usu.setContrasenia(con);

    controlP.crearUsuario(usu);

  }

  public void crearReserva(String in, String out, String cant, Long idUsu, Long idHue, Long idHab, String fechaCreacion) throws ParseException, Exception {

    Reserva res = new Reserva();

    res.setFechaCheckIn(convertirStringADate(in));
    res.setFechaCheckOut(convertirStringADate(out));
    res.setCantHuespedes(Integer.parseInt(cant));

    Usuario usu = controlP.buscarUsuario(idUsu);
    Empleado emple = controlP.buscarEmpleado(usu.getEmpleado().getId());
    Huesped hue = controlP.buscarHuesped(idHue);
    Habitacion hab = controlP.buscarHabitacion(idHab);

    emple.getListaReservas().add(res);
    hue.getListaReservas().add(res);
    hab.getListaReservas().add(res);

    controlP.crearReserva(res);

    controlP.modificarEmpleado(emple);
    controlP.modificarHuesped(hue);
    controlP.modificarHabitacion(hab);

  }

  public void crearHabitacion(int piso, String nom, String tipo, double pre) {

    Habitacion hab = new Habitacion();

    hab.setPiso(piso);
    hab.setNombre(nom);
    hab.setTipo(tipo);
    hab.setPrecioNoche(pre);

    controlP.crearHabitacion(hab);
  }

  // --- BAJAS ----------------
  public void borrarEmpleado(long id) {
    controlP.borrarEmpleado(id);
  }

  public void borrarUsuario(long id) throws NonexistentEntityException {
    controlP.borrarUsuario(id);
  }

  public void borrarHuesped(long id) throws NonexistentEntityException {
    controlP.borrarHuesped(id);
  }

  public void borrarReserva(long id) throws NonexistentEntityException {
    controlP.borrarReserva(id);
  }

  public void borrarHabitacion(long id) throws NonexistentEntityException {
    controlP.borrarHabitacion(id);
  }

  // --- MODIFICACIONES ----------------
  public void modificarEmpleado(Empleado emple) throws Exception {
    controlP.modificarEmpleado(emple);
  }

  public void modificarUsuario(Usuario usu) throws Exception {
    controlP.modificarUsuario(usu);
  }

  public void modificarHuesped(Huesped hue) throws Exception {
    controlP.modificarHuesped(hue);
  }

  public void modificarHabitacion(Habitacion hab) throws Exception {
    controlP.modificarHabitacion(hab);
  }

  // --- SELECT * FROM ----------------
  public List<Usuario> traerUsuarios() {
    return controlP.traerUsuarios();
  }

  public List<Empleado> traerEmpleados() {
    return controlP.traerEmpleados();
  }

  // b. Todos los huéspedes registrados en el sistema.
  public List<Huesped> traerHuespedes() {
    return controlP.traerHuespedes();
  }

  public List<Habitacion> traerHabitaciones() {
    return controlP.traerHabitaciones();
  }

  public List<Reserva> traerReservas() {
    return controlP.traerReservas();
  }

  // --- LECTURAS ----------------
  public Empleado buscarEmpleadoAtributos(String nom, String ape, String dni) {

    List<Empleado> listaEmple = controlP.traerEmpleados();
    for (Empleado empl : listaEmple) {
      if ((nom.equals(empl.getNombres())) && (ape.equals(empl.getApellidos())) && (dni.equals(empl.getDni()))) {
        return empl;
      }
    }
    return null;
  }

  public Usuario buscarPorUsuarioYContrasenia(String usuario, String contrasenia) {
    List<Usuario> listaUsuarios = controlP.traerUsuarios();
    for (Usuario usr : listaUsuarios) {
      if (verificarUsuario(usuario, contrasenia)) {
        return usr;
      }
    }
    return null;
  }

  public Empleado buscarEmpleado(long id) {
    return controlP.buscarEmpleado(id);
  }

  public Usuario buscarUsuario(long id) {
    return controlP.buscarUsuario(id);
  }

  public Habitacion buscarHabitacion(long id) {
    return controlP.buscarHabitacion(id);
  }

  public Reserva buscarReserva(long id) {
    return controlP.buscarReserva(id);
  }

  public Huesped buscarHuesped(long id) {
    return controlP.buscarHuesped(id);
  }

  // --- FECHAS ----------------
  public Date convertirStringADate(String fechaStr) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdf.parse(fechaStr);
    return date;
  }

  public String convertirDateAString(Date fechaDate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fecha = sdf.format(fechaDate);
    return fecha;
  }

  public int diasEntreFechas(Date fecha1, Date fecha2) {
    // diaEnMilisegs = milisegundos * segundos * minutos * horas
    return (int) ((fecha2.getTime() - fecha1.getTime()) / (1000 * 60 * 60 * 24));
  }

  public boolean rangoValido(Date checkin, Date checkout, Long idHabitacion) {
    List<Reserva> listaReserva = buscarHabitacion(idHabitacion).getListaReservas();
    if (checkin.compareTo(checkout) >= 0) {
      for (Reserva r : listaReserva) {
        Date checkin2 = r.getFechaCheckIn();
        Date checkout2 = r.getFechaCheckOut();
        return !reservasSolapadas(checkin, checkout, checkin2, checkout2);
      }
    }
    return true;
  }

  public boolean reservasSolapadas(Date fechain1, Date fechaout1, Date fechain2, Date fechaout2) {
    //Si fechas estan en rango
    boolean enRango = (fechaEnRango(fechain1, fechain2, fechaout2) || fechaEnRango(fechaout1, fechain2, fechaout2));
    //Si empieza antes
    boolean terminaAntes = (fechain1.compareTo(fechain2) < 0 && (fechaout1.compareTo(fechain2) < 0));
    //Si termina despues
    boolean empiezaDespues = (fechain1.compareTo(fechaout2) > 0 && (fechaout1.compareTo(fechaout2) > 0));
    return !(!enRango && terminaAntes && empiezaDespues);
  }

  public boolean fechaEnRango(Date fecha, Date fechain, Date fechaout) {
    return fecha.compareTo(fechain) >= 0 && fecha.compareTo(fechaout) <= 0;
  }
  // ------------metodos nuevos------------

}
