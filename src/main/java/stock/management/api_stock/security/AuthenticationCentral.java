package stock.management.api_stock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stock.management.api_stock.dto.DataAuthentication;
import stock.management.api_stock.models.User;
import stock.management.api_stock.repositories.UserRepository;

@Service
public class AuthenticationCentral {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User cryptography (DataAuthentication dataAuthentication) {
        UserDetails login = userRepository.findByUsername(dataAuthentication.username());

        if (login != null) {
            throw new RuntimeException("This username is registered! Please, choose another one!");
        }

        String password = passwordEncoder.encode(dataAuthentication.password());
        User user = new User(dataAuthentication.username(), password);
        userRepository.save(user);
        return user;
    }
}
