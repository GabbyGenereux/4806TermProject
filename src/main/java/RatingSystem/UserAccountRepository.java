package RatingSystem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

	List<UserAccount> findByUsername(String username);
}
