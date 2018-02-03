package com.bala.camel.demo;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class FileCopyRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:data/output");
    }
}
