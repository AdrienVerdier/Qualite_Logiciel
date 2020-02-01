package controler;

import javax.persistence.*;

/**
 * Cette classe fournit les méthode permettant la connexion avec la base de donnée
 * @author adrien
 *
 */
public class Connexion {
	
	private Connexion() {
		
	}
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("initialisation");
		em = emf.createEntityManager();
	}
	
	public static void modification()
	{
		emf = Persistence.createEntityManagerFactory("modification");
		em = emf.createEntityManager();
	}
	
	public static void test()
	{
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}

	static public EntityManager getEM() {
		return em;
	}

	static public void fermerconnexion() {
		em.close();
	}
}