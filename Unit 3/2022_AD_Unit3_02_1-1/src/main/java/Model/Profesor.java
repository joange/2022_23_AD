/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author joange
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="Profesor")
public class Profesor {
    static final long serialVersionUID = 1L;
       
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idTeacher;
    
    @Column
    private String name;

    public Profesor(String name) {
        this.name = name;
    }
    
    @OneToOne(mappedBy= "tutor") 
    private Grupo elGrupo;

    @Override 
    public String toString() {
        return "{" + idTeacher + "," + name + "," + elGrupo.getCourse()+"}";
    }
    
}
