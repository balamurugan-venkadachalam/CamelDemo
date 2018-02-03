package com.bala.camel.demo;

import com.bala.camel.process.CamelFileTransformProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class SampleProcessRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and header is ${headers}")
                .process(new CamelFileTransformProcessor())
                .to("file:sampleOutput?fileName=output.txt") ;
    }
}

