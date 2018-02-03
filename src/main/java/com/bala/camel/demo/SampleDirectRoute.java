package com.bala.camel.demo;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class SampleDirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and header is ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}

