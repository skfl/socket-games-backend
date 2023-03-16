package ru.skfl.socketgames.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.dtos.UserDTO;
import ru.skfl.socketgames.dtos.UserSignUpForm;
import ru.skfl.socketgames.entities.User;
import ru.skfl.socketgames.entities.UserRole;
import ru.skfl.socketgames.entities.UserState;
import ru.skfl.socketgames.exception.custom.UserAlreadyExistsWithEmailException;
import ru.skfl.socketgames.exception.custom.UserAlreadyExistsWithUsernameException;
import ru.skfl.socketgames.mappers.UserMapper;
import ru.skfl.socketgames.repository.UserRepository;
import ru.skfl.socketgames.services.interfaces.SignUpService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO signUp(UserSignUpForm signUpForm) {

        Optional<User> foundByEmail =
                userRepository.findByEmail(signUpForm.getEmail());
        if (foundByEmail.isPresent()) {
            throw new UserAlreadyExistsWithEmailException();
        }

        Optional<User> foundByUsername =
                userRepository.findByUsername(signUpForm.getUsername());
        if (foundByUsername.isPresent()) {
            throw new UserAlreadyExistsWithUsernameException();
        }

        User user = User.builder()
                .userRole(UserRole.USER)
                .email(signUpForm.getEmail())
                .username(signUpForm.getUsername())
                .passwordHash(passwordEncoder.encode(signUpForm.getPassword()))
                .userState(UserState.NOT_CONFIRMED)
                .build();

        return UserMapper.INSTANCE.toDTO(userRepository.save(user));
    }
}
