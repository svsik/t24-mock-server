package ie.kbc.mocks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by kamil on 26/01/2018 at 10:56
 */
@Slf4j @AllArgsConstructor @Getter
public class IPAddress {
    private final long id;
    private final String ipAddress;
}
