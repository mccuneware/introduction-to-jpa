package codelook.example.introductiontojpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

	public void performJPA() {

		// Creating objects representing some products
		Product product1 = new Product();
		product1.setId(3);
		product1.setName("Tennis racket");

		Product product2 = new Product();
		product2.setId(4);
		product2.setName("Guitar");

		// Connecting to the database through EntityManagerFactory
		// connection details loaded from persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

		EntityManager em = emf.createEntityManager();

		// Creating a new transaction
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// Persisting the product entity objects
		em.persist(product1);
		em.persist(product2);

		tx.commit();

		@SuppressWarnings("unchecked")
		List<Product> results = em.createQuery("SELECT p FROM Product p")
			.getResultList();

		System.out.println("List of products\n----------------");

		for (Product p : results) {
			System.out.println(p.getName() + " (id=" + p.getId() + ")");
		}

		Long productCount = (Long) em.createQuery("select count(p) FROM Product p")
			.getSingleResult();
			
		System.out.println("There are " + productCount + " products");
		
		List<Object[]> nativeResults = em.createNativeQuery("select * from products")
			.getResultList();
			
		System.out.println("Native query results:");
		for(Object[] record : nativeResults) {
			System.out.println(record[0] + " | " + record[1]);
		}
		
		// Closing connection
		em.close();

		emf.close();
	}
}