package RatingSystem;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long productID;
	private String url;
	private String name;
	private String description;
	private UserAccount creator;
	@OneToMany
	private Set<Review> reviews;
	
	private Product() {};
	
	public Product(String url, String name, String description, UserAccount creator) {
		this();
		this.setUrl(url);
		this.setName(name);
		this.setDescription(description);
		this.setCreator(creator);
	}

	public long getProductID() {
		return productID;
	}

	@SuppressWarnings("unused")
	private void setProductID(long productID) {
		this.productID = productID;
	}


	public UserAccount getCreator() {
		return creator;
	}

	private void setCreator(UserAccount creator) {
		this.creator = creator;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review r) {
		this.getReviews().add(r);
		r.setProduct(this);
	}
	
	public double averageRating(){
		double sum = 0, counter = 0;
		if(reviews == null) {
			return 0;
		}
		for (Review r : reviews){
			sum+=r.getRating();
			counter++;
		}
		return round(sum/counter,1);
	}

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Product) {
			return ((Product)o).getProductID() == this.getProductID();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)this.getProductID();
	}
}	
