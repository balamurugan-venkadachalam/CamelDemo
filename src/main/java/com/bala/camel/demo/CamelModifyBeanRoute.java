package com.bala.camel.demo;

import com.bala.camel.demo.bean.CamelBean;

import com.bala.camel.exception.process.ExceptionProcess;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.util.logging.Logger;


/**
 * Created by z001qgd on 6/14/17.
 */
public class CamelModifyBeanRoute extends RouteBuilder {

    public void configure() throws Exception {

        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retriesExhaustedLogLevel(LoggingLevel.WARN));

        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).redeliveryDelay(3000)
                .process(new ExceptionProcess()).log(LoggingLevel.INFO);

        from("direct:beanInput")
              .bean(new CamelBean())
                //.bean(new CamelBean(), "map")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");

    }
}