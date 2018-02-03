import com.bala.camel.demo.FileCopyRouter;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class FileRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FileCopyRouter();
    }
}
