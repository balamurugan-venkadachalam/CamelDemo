package com.bala.camel.exception.process;

import org.apache.camel.Exchange;

/**
 * Created by engan.bala on 01-02-2018.
 */
public class ExceptionProcess implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        //exchange.getIn().getExchange().getException();
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        String failedEndPoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
    }
}
