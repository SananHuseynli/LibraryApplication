package az.ingress.libraryapplication.dto;

import az.ingress.libraryapplication.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    private String name;
    private String surname;
    private String photo;
    private LocalDate birthday;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
