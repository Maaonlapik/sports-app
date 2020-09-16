package ee.te.sportsapi.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sport {

    private int sportId;
    private String strSport;

}
