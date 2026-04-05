package az.ingress.libraryapplication.service;

import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import az.ingress.libraryapplication.mapper.UserMapper;
import az.ingress.libraryapplication.repository.UserRepo;
import lombok.RequiredArgsConstructor; // Lombok əlavə edildi
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Konstruktor inyeksiyası üçün
public class UserServiceImpl implements UserService {

    // 1. Static silindi, final əlavə edildi
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public String createUser(UserRequestDto userRequest) {
        User user = userMapper.toUser(userRequest);
        userRepo.save(user);
        return "User Created Successfully";
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        // 2. .get() əvəzinə orElseThrow istifadəsi daha təhlükəsizdir
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        // 3. Daha müasir və qısa yol (Stream API)
        return users.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequest) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepo.save(user);

        return userMapper.toUserResponse(user);
    }

    @Override
    public String deleteUser(Long id) {
        // Silməzdən əvvəl varlığını yoxlamaq yaxşı praktikadır
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
        return "User deleted successfully";
    }
}