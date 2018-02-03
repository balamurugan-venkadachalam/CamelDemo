import com.bala.camel.demo.SampleDirectRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRoutTest() throws InterruptedException {
        template.sendBody("direct:sampleInput","1234, bala, Udemy" );
        Thread.sleep(5000);


        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName") );
    }
}
