package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona implements Serializable {

  private static final long serialVersionUID = 1L;

  @Basic
  private String profesion;
  @OneToMany
  private List<Reserva> listaReservas;


  public String getProfesion() {
    return profesion;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }

  public List<Reserva> getListaReservas() {
    return listaReservas;
  }

  public void setListaReservas(List<Reserva> listaReservas) {
    this.listaReservas = listaReservas;
  }
  

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDireccionDomicilio() {
    return direccionDomicilio;
  }

  public void setDireccionDomicilio(String direccionDomicilio) {
    this.direccionDomicilio = direccionDomicilio;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }


}
