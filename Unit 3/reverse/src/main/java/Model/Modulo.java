// default package
// Generated 30 nov. 2022 10:40:10 by Hibernate Tools 5.2.12.Final

package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name = "Modulo", catalog = "DocenciaConsultas")
public class Modulo implements java.io.Serializable {
	
	static final long serialVersionUID=13L;

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", nombre=" + nombre + "]";
	}

	private Long idModulo;
	private String nombre;
	private Set<Examen> examens = new HashSet(0);
	private Set<Profesor> profesors = new HashSet(0);

	public Modulo() {
	}

	public Modulo(String nombre, Set<Examen> examens, Set<Profesor> profesors) {
		this.nombre = nombre;
		this.examens = examens;
		this.profesors = profesors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idModulo", unique = true, nullable = false)
	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
	public Set<Examen> getExamens() {
		return this.examens;
	}

	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "modulos")
	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

}