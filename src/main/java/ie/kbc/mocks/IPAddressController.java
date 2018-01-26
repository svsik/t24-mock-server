package ie.kbc.mocks;

import ie.kbc.mocks.domain.IPAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

/**
 * Created by kamil on 26/01/2018 at 10:52
 */
@Slf4j
@RestController
public class IPAddressController {
    private int counter;

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public IPAddress ipaddress() throws Exception {
        return new IPAddress(++counter, InetAddress.getLocalHost().getHostAddress());
    }
}
