package ee.te.sportsapi.Service;

import ee.te.sportsapi.Model.User;
import ee.te.sportsapi.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

/*    public User findByEmail(String eMail) {
        return userRepository.findByEMail(eMail);
    }*/

    public List<User> findAll() {
        return userRepository.findAll().stream().filter(user -> user.getUsername() != null).collect(Collectors.toList());
    }
}
