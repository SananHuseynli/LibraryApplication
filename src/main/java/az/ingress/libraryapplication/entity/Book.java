package az.ingress.libraryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Double rating;
    private Integer view;
    private String description;
    private String image;

    private Category category;

    @CreatedDate
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
