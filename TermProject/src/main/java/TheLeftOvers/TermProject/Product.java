package TheLeftOvers.TermProject;

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
	@OneToMany
	private Set<Review> reviews;
	

	public long getProductID() {
		return productID;
	}

	private void setProductID(long productID) {
		this.productID = productID;
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
