package com.bala.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;

/**
 * Created by engan.bala on 31-01-2018.
 */
public class CamelFileTransformProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        GenericFile<File> fileContent= (GenericFile<File>)exchange.getIn().getBody();
        BufferedReader reader = new BufferedReader(new FileReader(fileContent.getFile())) ;
        //System.out.println(content);

    }
}
