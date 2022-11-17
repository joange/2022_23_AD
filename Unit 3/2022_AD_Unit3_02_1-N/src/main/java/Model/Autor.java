/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author joange
 */

@Entity
@Table(name="Libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor implements Serializable{
    
    static final long serialVersionUID = 137L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAutor;
    
    @Column
    private String nom;
    
    @Column
    private String nacionalitat;
    
    
    @OneToMany(mappedBy="elAutor",
            cascade=CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private Set<Libro> elsLlibres;
    
    public void setElsLlibres(Set<Libro> elsLlibres) {
        this.elsLlibres = elsLlibres;
    }
    
    public void addLlibre(Libro l){
        if (!this.elsLlibres.contains(l)){
            this.elsLlibres.add(l);
            l.setElAutor(this);
        }
    }
    

    public Autor(String nom, String nacionalitat) {
        this.nom = nom;
        this.nacionalitat = nacionalitat;
        this.elsLlibres=new HashSet<>();
    }
    
    public String listadoLibros(){
        if (elsLlibres.isEmpty())
            return "";
        String res="";
        for (Libro l : elsLlibres) {
            res+=l.getTitol()+"\n";
        }
        return res.substring(0, res.length()-1);
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nom=" + nom + ", nacionalitat=" + nacionalitat + '}';
    }
    
    
}
