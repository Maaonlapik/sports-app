package ee.te.sportsapi.Service;

import ee.te.sportsapi.Model.UserPreference;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class UserPreferenceService {

    public UserPreference getUserPreference( int preferenceId ) {
        return UserPreference.builder()
                .id(1)
                .sportIds( asList( 102, 103, 111 ) )
                .leagueIds( asList( 4328, 4370, 4464) )
                .build();
    }

}
