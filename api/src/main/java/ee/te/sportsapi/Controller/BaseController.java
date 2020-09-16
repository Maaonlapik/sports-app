package ee.te.sportsapi.Controller;

import ee.te.sportsapi.Exception.BadRequestException;
import ee.te.sportsapi.Model.Login;
import ee.te.sportsapi.Model.User;
import ee.te.sportsapi.Model.UserPreference;
import ee.te.sportsapi.Service.UserPreferenceService;
import ee.te.sportsapi.Service.UserService;
import ee.te.sportsapi.Service.ValidationService;
import ee.te.sportsapi.Util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static ee.te.sportsapi.Util.Constants.API;
import static ee.te.sportsapi.Util.Constants.AUTHENTICATION_FAILED;

@Slf4j
@RestController
@RequestMapping( API )
public class BaseController {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private UserService userService;
    @Resource
    private UserPreferenceService userPreferenceService;
    @Resource
    private ValidationService validationService;
    @Resource
    private JwtTokenUtil tokenUtil;

    @PostMapping( value = "/login")
    public Login login(@RequestBody User user) {
        validationService.validateUserLogin( user );
        authenticate( user.getUsername(), new String( user.getPassword() ) );
        final UserDetails userDetails = userDetailsService.loadUserByUsername( user.getUsername() );
        final String token = tokenUtil.generateToken( userDetails );
        final User authenticatedUser = userService.findByName( user.getUsername() );
        log.info("User logged in: {}", authenticatedUser.getUsername());
        return Login.builder()
                .id( authenticatedUser.getId() )
                .token( token )
                .build();
    }

    private void authenticate( String username, String password ) {
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( username, password ) );
        } catch (DisabledException | BadCredentialsException e) {
            throw new BadRequestException( AUTHENTICATION_FAILED );
        }
    }


    @GetMapping( value = "/preference/{preferenceId}" )
    public UserPreference getLoggedInUserPreference(@PathVariable int preferenceId) {
        return userPreferenceService.getUserPreference( preferenceId );
    }
}
