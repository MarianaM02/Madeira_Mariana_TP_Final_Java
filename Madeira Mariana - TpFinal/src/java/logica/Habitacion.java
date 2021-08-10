package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Basic
  private int piso;
  private String nombre;
  private String tipo;
  private double precioNoche;
  @OneToMany
  private List<Reserva> listaReservas;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getPiso() {
    return piso;
  }

  public void setPiso(int piso) {
    this.piso = piso;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getPrecioNoche() {
    return precioNoche;
  }

  public void setPrecioNoche(double precioNoche) {
    this.precioNoche = precioNoche;
  }

  public List<Reserva> getListaReservas() {
    return listaReservas;
  }

  public void setListaReservas(List<Reserva> listaReservas) {
    this.listaReservas = listaReservas;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Habitacion)) {
      return false;
    }
    Habitacion other = (Habitacion) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "logica.Habitacion[ id=" + id + " ]";
  }

  //Metodos extra
  public int capacidadMaxima() {
    switch (this.getTipo()) {
      case "single":
        return 1;
      case "doble":
        return 2;
      case "triple":
        return 3;
      default:
        return 8;
    }
  }

}
