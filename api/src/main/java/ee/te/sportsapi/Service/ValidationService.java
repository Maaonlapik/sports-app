package ee.te.sportsapi.Service;

import ee.te.sportsapi.Exception.BadRequestException;
import ee.te.sportsapi.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static ee.te.sportsapi.Util.Constants.PASSWORD_VALIDATION;
import static ee.te.sportsapi.Util.Constants.USERNAME_VALIDATION;
import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Slf4j
public class ValidationService {

    public void validateUserLogin( User user ) {
        validateUsername( user.getUsername() );
        validatePassword( user.getPassword() );
    }

    private void validateUsername(String username) throws BadRequestException {
        if ( isNull( username ) || isEmpty( username ) ) {
            throw new BadRequestException( USERNAME_VALIDATION );
        }
    }

    private void validatePassword(byte[] password) throws BadRequestException {
        if ( isNull( password ) || isEmpty( password ) ) {
            log.debug( "Password: ", password);
            throw new BadRequestException( PASSWORD_VALIDATION );
        }
    }
}
