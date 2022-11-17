/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author joange
 */
@Entity
@Table(name = "Modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private Long idModulo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = "losModulos")
    private Set<Profesor> losProfesores=new HashSet<>();;

    public void addProfesor(Profesor p) {
        if (!this.losProfesores.contains(p)) {
            losProfesores.add(p);
            p.addModulo(this);
        }
        
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Profesor> getLosProfesores() {
        return losProfesores;
    }

    public void setLosProfesores(Set<Profesor> losProfesores) {
        this.losProfesores = losProfesores;
    }

    public Modulo(String nombre) {
        this.nombre = nombre;
    }

    public Modulo() {
        
    }

    @Override
    public String toString() {
        return "Modulo{" + "idModulo=" + idModulo + ", nombre=" + nombre + '}';
    }

    public String mostrarProfesores() {
        String res = "";
        for (Profesor p : losProfesores) {
            res += p.getNomProfe() + "\n";
        }
        return res;
    }

}
