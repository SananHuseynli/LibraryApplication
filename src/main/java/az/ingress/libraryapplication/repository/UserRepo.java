package az.ingress.libraryapplication.repository;

import az.ingress.libraryapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
