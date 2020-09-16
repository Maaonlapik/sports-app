package ee.te.sportsapi.Model;

import ee.te.sportsapi.Util.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String eMail;
    @Enumerated(EnumType.STRING)
    private Role role;
    private byte[] password;
    private int preferenceId;
}
