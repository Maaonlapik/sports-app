package ee.te.sportsapi.Controller;

import ee.te.sportsapi.Model.Sport;
import ee.te.sportsapi.Model.UserPreference;
import ee.te.sportsapi.Service.SportsService;
import ee.te.sportsapi.Service.UserPreferenceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.security.Principal;
import java.util.List;

import static ee.te.sportsapi.Util.Constants.API;

@Controller
@RequestMapping( API )
public class SportsController {

    @Resource
    private SportsService sportsService;
    @Resource
    private UserPreferenceService userPreferenceService;

    @GetMapping( "/sports/{preferenceId}" )
    public List<Sport> getUserSports(@PathVariable int preferenceId, Principal principal ) {

        UserPreference userPreference = userPreferenceService.getUserPreference( preferenceId );

        return sportsService.getUserSports( userPreference );
    }
}
