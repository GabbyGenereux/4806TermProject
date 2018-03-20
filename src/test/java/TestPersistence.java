//import static org.junit.Assert.assertEquals;
//
//import java.util.HashSet;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import org.junit.Test;
//
//import RatingSystem.Product;
//import RatingSystem.Review;
//import RatingSystem.UserAccount;
//
//public class TestPersistence {
//	
//	@Test
//	public void test() {
//		UserAccount a = new UserAccount();
//		a.setUsername("Alice");
//		
//		UserAccount b = new UserAccount();
//		b.setUsername("Bob");
//		
//		Product p = new Product();
//		p.setUrl("google.com");
//		p.setName("Google Search");
//		p.setDescription("Finds things.");
//		
//		Review r = new Review();
//		r.setComment("Better than Bing!");
//		r.setRating(4.0/5.0);
//		
//		a.setPostedProducts(new HashSet<Product>());
//		a.getPostedProducts().add(p);
//		a.setReviews(new HashSet<Review>());
//		a.getReviews().add(r);
//		p.setReviews(new HashSet<Review>());
//		p.getReviews().add(r);
//		r.setCreator(a);
//		r.setProduct(p);
//		b.setFollowedUsers(new HashSet<UserAccount>());
//		b.getFollowedUsers().add(a);
//
//
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
//        EntityManager em = factory.createEntityManager();
//        
//        em.getTransaction().begin();
//        em.persist(a);
//        em.persist(b);
//        em.persist(p);
//        em.persist(r);
//        em.getTransaction().commit();
//        
//        Query q = em.createQuery("SELECT r FROM Review r");
//
//        @SuppressWarnings("unchecked")
//        Review result = (Review) q.getResultList().get(0);
//
//
//        assert(r.equals(result));
//        assert(result.getCreator().equals(a));
//        assert(result.getProduct().equals(p));
//        
//        List<UserAccount> usrList = (List<UserAccount>) em.createQuery("SELECT b FROM UserAccount b").getResultList();
//        UserAccount bob = null;
//        for(UserAccount i : usrList) {
//        	if(i.getUsername().equals("Bob"))
//        		bob = i;
//        }
//
//        assert(bob.equals(b));
//        assert(bob.getFollowedUsers().iterator().next().equals(a));
//        
//        em.close();
//		
//	}
//}
