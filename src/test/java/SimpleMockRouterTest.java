import com.bala.camel.demo.SimpleMockRouter;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class SimpleMockRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SimpleMockRouter();
    }

    @Test
    public void sampleMockRouterTest() throws InterruptedException {

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("hello");

        template.sendBody("direct:sampleInput", "hello");
        assertMockEndpointsSatisfied();
    }
}

