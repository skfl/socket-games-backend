package ru.skfl.socketgames.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.dtos.response.AuthResponse;
import ru.skfl.socketgames.dtos.request.LoginRequest;
import ru.skfl.socketgames.entities.User;
import ru.skfl.socketgames.repository.UserRepository;
import ru.skfl.socketgames.security.JwtService;
import ru.skfl.socketgames.security.UserPrincipal;
import ru.skfl.socketgames.services.interfaces.SignInService;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;


    @Override
    public AuthResponse signIn(LoginRequest loginForm) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        User user = userRepository.findByUsername(loginForm.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(new UserPrincipal(user));
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
}
