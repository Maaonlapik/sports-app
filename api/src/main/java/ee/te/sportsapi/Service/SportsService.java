package ee.te.sportsapi.Service;

import ee.te.sportsapi.Model.Sport;
import ee.te.sportsapi.Model.UserPreference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static ee.te.sportsapi.Util.Constants.SPORTS_URL;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

@Service
@Slf4j
public class SportsService {

    @Resource
    private RestTemplate restTemplate;

    public List<Sport> getUserSports(UserPreference userPreference) {

        return getAllSports().stream()
                .filter( sport -> userPreference.getSportIds().contains( sport.getSportId() ) )
                .collect(Collectors.toList());

    }

    private List<Sport> getAllSports() {
        List<Sport> allSports = asList( requireNonNull(restTemplate.getForEntity(SPORTS_URL, Sport[].class).getBody()) );
        log.info("Retrieved sports: {}", allSports);
        return allSports;
    }
}
