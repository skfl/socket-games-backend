package ru.skfl.socketgames.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.entities.User;
import ru.skfl.socketgames.exception.custom.SignInCredentialException;
import ru.skfl.socketgames.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new SignInCredentialException();
        }
        UserDetails userDetails = new UserPrincipal(user.get());
        return userDetails;
    }
}
