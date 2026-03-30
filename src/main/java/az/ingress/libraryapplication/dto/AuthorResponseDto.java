package az.ingress.libraryapplication.dto;

import az.ingress.libraryapplication.entity.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AuthorResponseDto {

    private String name;
    private String surname;
    @Column(columnDefinition = "TEXT")
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Book> books;
}
