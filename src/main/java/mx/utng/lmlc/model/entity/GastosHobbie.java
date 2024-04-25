package mx.utng.lmlc.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GastosHobbie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 70)
    private String concepto;

    @Column
    private LocalDate fechaEstablecida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getFechaEstablecida() {
        return fechaEstablecida;
    }

    public void setFechaEstablecida(LocalDate fechaEstablecida) {
        this.fechaEstablecida = fechaEstablecida;
    }

    @Override
    public String toString() {
        return "GastosHobbie [id=" + id + ", concepto=" + concepto + ", fechaEstablecida=" + fechaEstablecida + "]";
    }

    
}
