package ru.skfl.socketgames.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.dtos.request.SignUpRequest;
import ru.skfl.socketgames.entities.User;
import ru.skfl.socketgames.entities.UserRole;
import ru.skfl.socketgames.entities.UserState;
import ru.skfl.socketgames.exception.custom.UserAlreadyExistsWithEmailException;
import ru.skfl.socketgames.exception.custom.UserAlreadyExistsWithUsernameException;
import ru.skfl.socketgames.repository.UserRepository;
import ru.skfl.socketgames.dtos.response.ResponseInfo;
import ru.skfl.socketgames.dtos.response.ResultCode;
import ru.skfl.socketgames.dtos.response.StandardResponse;
import ru.skfl.socketgames.services.interfaces.SignUpService;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StandardResponse signUp(SignUpRequest signUpForm) {

        if (userRepository.existsByEmail(signUpForm.getEmail())) {
            throw new UserAlreadyExistsWithEmailException();
        }

        if (userRepository.existsByUsername(signUpForm.getUsername())){
            throw new UserAlreadyExistsWithUsernameException();
        }

        User user = User.builder()
                .userRole(UserRole.USER)
                .email(signUpForm.getEmail())
                .username(signUpForm.getUsername())
                .passwordHash(passwordEncoder.encode(signUpForm.getPassword()))
                .userState(UserState.NOT_CONFIRMED)
                .build();

        userRepository.save(user);
        return new StandardResponse(ResponseInfo.getInstance(ResultCode.OK,"User successfully created"));
    }
}
