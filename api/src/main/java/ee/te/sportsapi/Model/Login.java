package ee.te.sportsapi.Model;

import ee.te.sportsapi.Util.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Login {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String eMail;
    private String token;
    private List<String> roles;
    private Role role;
    private UserPreference preference;

}

