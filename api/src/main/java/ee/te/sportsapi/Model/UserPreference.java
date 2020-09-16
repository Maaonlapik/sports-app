package ee.te.sportsapi.Model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPreference {

    private int id;
    private List<Integer> sportIds;
    private List<Integer> leagueIds;

}
