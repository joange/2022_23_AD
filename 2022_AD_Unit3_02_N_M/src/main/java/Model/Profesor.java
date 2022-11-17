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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author joange
 */

@Entity
@Table(name="Profesor")
public class Profesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProfe")
    private Long idProfe;
    
    @Column(name="nomProfe")
    private String nomProfe;
    
//    @OneToOne(mappedBy = "elProfe")     // el camp on he descrit la relació, d'on ix la clau aliena
//    private Grupo elGrupo; 

    public Profesor() {
        
    }

    public Profesor(String nomProfe) {
        this.nomProfe = nomProfe;
    }

    
    public Long getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(Long idProfe) {
        this.idProfe = idProfe;
    }

    public String getNomProfe() {
        return nomProfe;
    }

    public void setNomProfe(String nomProfe) {
        this.nomProfe = nomProfe;
    }

    @Override
    public String toString() {
        return "Professor{" + "idProfe=" + idProfe + ", nomProfe=" + nomProfe + '}';
    }

    @ManyToMany(cascade=CascadeType.PERSIST,
                fetch=FetchType.LAZY)
    @JoinTable(name="Docencia",
              joinColumns = {@JoinColumn(name="idProfesor",foreignKey = @ForeignKey(name = "FK_DOC_PROF" ))},
              inverseJoinColumns = {@JoinColumn(name="idModulo",foreignKey = @ForeignKey(name = "FK_DOC_MOD" ))}        
        )
    private Set<Modulo> losModulos=new HashSet<>();;

    public void addModulo(Modulo m){        
        if (!this.losModulos.contains(m)){
            losModulos.add(m); 
            m.addProfesor(this);
        }
        
    }
    
}
