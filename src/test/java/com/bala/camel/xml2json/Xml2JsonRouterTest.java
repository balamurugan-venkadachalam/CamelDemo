package com.bala.camel.xml2json;

import com.bala.camel.demo.SimpleMockRouter;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class Xml2JsonRouterTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new Xml2JsonRouter();
    }

    @Test
    public void marshalEmployeeJSON2XML(){

        String expected = "{\"id\":\"123 \",\"name\":\"ABC\",\"type\":\"senior\"}";
        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";

        final String response = template.requestBody("direct:marshalEmployeexml2json", request, String.class);
        System.out.println("response is : " + response);

        assertEquals(expected, response);

    }

  /*  @Test
    public void unMarshalEmployeeJSON2XML(){

        final String request = "{\"name\":\"ABC\",\"id\":\"123 \",\"type\":\"senior\"}";

        final String response = template.requestBody("direct:unMarshalEmployeejson2xml", request, String.class);
        System.out.println("response is : " + response);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";
        assertEquals(expected, response);

    }*/
}
