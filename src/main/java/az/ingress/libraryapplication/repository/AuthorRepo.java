package az.ingress.libraryapplication.repository;

import az.ingress.libraryapplication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
