package vn.minhhai.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.minhhai.laptopshop.domain.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @SuppressWarnings("unchecked")
    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(long id);

    void deleteById(long id);

    boolean existsByEmail(String email);
}
