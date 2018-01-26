package ie.kbc.mocks;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kamil on 26/01/2018 at 11:22
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {IpRestApiTest.class, Application.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
@EnableAutoConfiguration
public class IpRestApiTest extends Assert {

    RestTemplate rest = new TestRestTemplate();

    @Autowired
    EmbeddedWebApplicationContext tomcat;

    int port;
    String baseUri;

    @Before
    public void before() {
        port = tomcat.getEmbeddedServletContainer().getPort();
        baseUri = "http://localhost:" + port;
    }

    @Test
    public void shouldExposeIpApi() throws InterruptedException {
        String ip = rest.getForObject(baseUri + "/ip", String.class);
        assertNotNull(ip);

        String ip2 = rest.getForObject(baseUri + "/ip", String.class);
        assertNotNull(ip2);

        // should not be same as there is a counter in the response
        assertNotSame(ip, ip2);
    }

}

