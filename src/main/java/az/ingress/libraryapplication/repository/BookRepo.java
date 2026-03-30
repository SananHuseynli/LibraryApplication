package az.ingress.libraryapplication.repository;

import az.ingress.libraryapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
