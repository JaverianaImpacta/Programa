package edu.javeriana.ingenieria.social.programa.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Programa {
    @Id
    private Integer id;
    private Integer codigo, facultad;
    @Column(name="cantidad_creditos")
    private Integer cantidadCreditos;
    private String nombre;
    @Column(name="fecha_fundacion")
    private Date fechaFundacion;
}
