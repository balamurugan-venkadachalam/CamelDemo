package com.bala.camel.xml2json;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class Xml2JsonRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:marshalEmployeexml2json")
                .log("Received Message is ${body} and header is ${headers}")
                .marshal().xmljson()
                .log("Processed Message is ${body} and header is ${headers}");
    }

}
