package reverse;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Model.Alumno;
import Model.Examen;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.ForIndex;

public class App {

	public static void main(String[] args) {
		// get a Session and start a transaction
		// java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); // or whatever
																										// level you
		/*																								// need
		System.out.println("Query 1");HQL1();
		
		 * System.out.println("Query 2"); HQL2();
		 * 
		 * System.out.println("Query 3"); HQL3();
		 * 
		 * System.out.println("Query 4"); HQL4();
		 * 
		 * System.out.println("Query 5"); HQL5();
		 * 
		 * System.out.println("Query 6"); HQL6();
		 * 
		 * System.out.println("Query 7"); HQL7();
		 * 
		 * System.out.println("Query 8"); HQL8();
		 * 
		 * System.out.println("Query 9"); HQL9();
		 * 
		 * System.out.println("Query 10"); HQL10();
		 */

	}

	
	public static void CRUD1() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Alumno a=new Alumno();
		a.setApellidos("Hamilton");
		a.setNombre("Lewis");
		a.setEdad(42);
		a.setRepetidor(false);

		laSesion.persist(a);
		
		System.out.println(a);
		
		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void CRUD2() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Alumno a=laSesion.get(Alumno.class, 7L);
		a.setEdad(44);
		a.setRepetidor(true);

		laSesion.update(a);
		System.out.println(a);
		
		
		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void CRUD3() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q=laSesion.createQuery("Update from Alumno a set a.edad=a.edad+1 where a.repetidor=true");
		
		int howMany=q.executeUpdate();
		
		System.out.println(howMany + " alumnos actualizados");
		
		
		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void CRUD4() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Alumno a=laSesion.get(Alumno.class, 7L);
		laSesion.delete(a);
		
		System.out.println(a);
		
		
		
		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void CRUD5() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		

		
		
		
		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void HQL1() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a");

		// Query<Alumno> q=laSesion.createQuery("from Alumno");

		// Query q = laSesion.createQuery("from Alumno");

		List<Alumno> losAlumnos = q.list();

		Alumno a = losAlumnos.get(0);

		for (Alumno alumno : losAlumnos) {
			System.out.println(alumno);
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL2() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a where a.edad>22");

		List<Alumno> losAlumnos = q.list();

		for (Alumno alumno : losAlumnos) {
			System.out.println(alumno);
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL3() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a where length(a.apellidos)>15");

		List<Alumno> losAlumnos = q.list();

		for (Alumno alumno : losAlumnos) {
			System.out.println(alumno);
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL4() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q = laSesion.createQuery("Select a from Alumno a where a.idAlumno=1");

		Alumno alumno = (Alumno) q.uniqueResult();

		System.out.println(alumno);

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL5() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();
		


		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a where a.idAlumno=1");

		Alumno alumno = q.uniqueResult();

		System.out.println(alumno);

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL6() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q = laSesion.createQuery("Select a.nombre,a.edad from Alumno a");
	
		

		List<Object[]> result = q.list();

		for (Object[] objects : result) {
			System.out.print("Alumno: ");
			for (int i = 0; i < objects.length; i++) {
				System.out.print(objects[i] + " ");
			}
			System.out.println();
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL7() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q = laSesion.createQuery("Select a.nombre,size(a.examens) from Alumno a");

		List<Object[]> result = q.list();

		for (Object[] alu : result) {
			System.out.println("Alumno: " + alu[0] + " has done " + alu[1] + " exams.");
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void HQL7_b() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q = laSesion.createQuery("Select a from Alumno a");

		List<Alumno> result = q.list();

		for (Alumno alu : result) {
			System.out.println("Alumno: " + alu.getNombre() + " has done " + alu.getExamens().size() + " exams.");
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}

	public static void HQL8() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query q = laSesion.createQuery(
				"Select a.nombre,size(a.examens) from Alumno a where not exists(select aa from Alumno aa where size(aa.examens)<size(a.examens))");

		List<Object[]> result = q.list();

		for (Object[] alu : result) {
			System.out.println("Alumno: " + alu[0] + " has done " + alu[1] + " exams.");
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void HQL9	() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a where a.edad=?1");
		q.setParameter(1, 24);
	
		
		List<Alumno> losAlumnos = q.list();

		for (Alumno alumno : losAlumnos) {
			System.out.println(alumno);
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	public static void HQL10	() {
		Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
		laSesion.getTransaction().begin();

		Query<Alumno> q = laSesion.createQuery("Select a from Alumno a where a.edad=:edad and a.repetidor=:repetidor");
		q.setParameter("edad", 24);
		q.setParameter("repetidor", true);
		
		List<Alumno> losAlumnos = q.list();

		for (Alumno alumno : losAlumnos) {
			System.out.println(alumno);
		}

		// close all
		laSesion.getTransaction().commit();
		laSesion.close();
	}
	
	
}
