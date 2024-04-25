package mx.utng.lmlc.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ListaDeseosMueble {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    private String nombre;

    @Column(length = 60)
    private String muebles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMuebles() {
        return muebles;
    }

    public void setMuebles(String muebles) {
        this.muebles = muebles;
    }

    @Override
    public String toString() {
        return "ListaDeseosMueble [id=" + id + ", nombre=" + nombre + ", muebles=" + muebles + "]";
    }

    
}
