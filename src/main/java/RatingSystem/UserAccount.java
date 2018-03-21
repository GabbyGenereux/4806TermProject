package RatingSystem;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {
	@Id
	@GeneratedValue
	private long userID;
	private String username;
	private String description;
	@OneToMany
	private Set<Review> reviews;
	@OneToMany
	private Set<Product> postedProducts;
	@ManyToMany
	private Set<UserAccount> followedUsers;
	
	public UserAccount() {}
	
	public UserAccount(String username)
	{
		this.username = username;
	}
	
	public long getUserID() {
		return userID;
	}
	private void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Set<Product> getPostedProducts() {
		return postedProducts;
	}
	public void setPostedProducts(Set<Product> postedProducts) {
		this.postedProducts = postedProducts;
	}
	public Set<UserAccount> getFollowedUsers() {
		return followedUsers;
	}
	public void setFollowedUsers(Set<UserAccount> followedUsers) {
		this.followedUsers = followedUsers;
	}
	
	
	public void review(Product p, double rating, String comment) {
		this.getReviews().add(new Review(this, p, rating, comment));
	}
	
	public Product postProduct(String URL, String name, String description) {
		Product p = new Product();
		p.setUrl(URL);
		p.setName(name);
		p.setDescription(description);
		this.getPostedProducts().add(p);
		return p;
	}
	
	public void follow(UserAccount usr) {
		this.getFollowedUsers().add(usr);
	}
	
	@Override
	public String toString()
	{
		return String.format("User[userID=%d, username=%s]", userID, username);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof UserAccount) {
			return ((UserAccount)o).getUserID() == this.getUserID();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)this.getUserID();
	}
}
