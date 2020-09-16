package ee.te.sportsapi.Service;

import ee.te.sportsapi.Model.User;
import ee.te.sportsapi.Model.UserPrincipal;
import ee.te.sportsapi.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static java.util.Objects.isNull;

@Service
public class SportsAppUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername( username );

        if( isNull( user ) ) {
            throw new UsernameNotFoundException( username );
        }
        return new UserPrincipal( user );
    }
}
