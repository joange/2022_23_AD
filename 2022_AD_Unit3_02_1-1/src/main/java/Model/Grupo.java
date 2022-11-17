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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "Grupo")
public class Grupo implements Serializable {

    
    static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGroup;

    @Column
    private String level;

    @Column
    private String course;
    
    @Column
    private int year;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name="id_tutor",
        referencedColumnName = "idTeacher",
        unique=true,
        foreignKey = @ForeignKey(name = "FK_GRP_TEACH"))
    private Profesor tutor;

    public Grupo(String level, String course, int year) {
        this.level = level;
        this.course = course;
        this.year = year;
    }  

}
