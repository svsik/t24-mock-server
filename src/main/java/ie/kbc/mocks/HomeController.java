package ie.kbc.mocks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kamil on 25/01/2018 at 15:37
 */
@Slf4j
@RestController
public class HomeController {

    @Value("${welcome}")
    private String welcome;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ipaddress() throws Exception {
        return "Reply: " + welcome;
    }

}
