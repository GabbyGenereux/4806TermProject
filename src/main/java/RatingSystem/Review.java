package RatingSystem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long reviewID;
	private UserAccount creator;
	private Product product;
	
	private double rating;
	private String comment;
	
	public Review() {}
	
	public Review(UserAccount usr, Product p, double rating, String comment) {
		this.setCreator(usr);
		this.setProduct(p);
		this.setRating(rating);
		this.setComment(comment);
		p.getReviews().add(this);
	}

	public long getReviewID() {
		return reviewID;
	}
	private void setReviewID(long reviewID) {
		this.reviewID = reviewID;
	}
	public UserAccount getCreator() {
		return creator;
	}
	public void setCreator(UserAccount creator) {
		this.creator = creator;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Review) {
			return ((Review)o).getReviewID() == this.getReviewID();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)this.getReviewID();
	}
}
