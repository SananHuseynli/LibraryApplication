package az.ingress.libraryapplication.dto;

import az.ingress.libraryapplication.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private String name;
    private String surname;
    private String photo;
    private LocalDate birthday;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
