package ie.kbc.mocks;

import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.fabric8.kubernetes.assertions.Assertions.assertThat;

/**
 * Created by kamil on 26/01/2018 at 11:24
 */
@Slf4j
@RunWith(Arquillian.class)
public class KubernetesIntegrationKT {

    @ArquillianResource
    KubernetesClient client;

    @Test
    public void testAppProvisionsRunningPods() throws Exception {
        assertThat(client).deployments().pods().isPodReadyForPeriod();
    }
}
