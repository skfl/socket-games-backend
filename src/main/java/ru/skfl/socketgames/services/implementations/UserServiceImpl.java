package ru.skfl.socketgames.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.dtos.response.UserInfoResponse;
import ru.skfl.socketgames.entities.User;
import ru.skfl.socketgames.mappers.UserMapper;
import ru.skfl.socketgames.repository.UserRepository;
import ru.skfl.socketgames.security.JwtService;
import ru.skfl.socketgames.services.interfaces.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public UserInfoResponse getUserData(String token) {
        String username = jwtService.extractUsername(token);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserInfoResponse.builder()
                .user(UserMapper.INSTANCE.toDTO(user.get()))
                .build();
    }
}
