/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idLibro;
    
    @Column
    private String titol;
    
    @Column
    private String tipus;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="idAutor",
                foreignKey = @ForeignKey(name = "FK_LIB_AUT" ))
    private Autor elAutor;

    public Libro(String titol, String tipus) {
        this.titol = titol;
        this.tipus = tipus;
    }
        
    
    public void setElAutor(Autor a){
       this.elAutor=a;
       a.addLlibre(this);
    }

    @Override
    public String toString() {
        return "Libro{" + "titol=" + titol + ", tipus=" + tipus + ", elAutor=" + elAutor.getNom() + '}';
    }
    
    
}
