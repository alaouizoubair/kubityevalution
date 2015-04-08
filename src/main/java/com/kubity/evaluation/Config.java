package com.kubity.evaluation;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class Config extends ResourceConfig {

    public Config() {
        packages("com.kubity.evaluation");

        // Register Jackson as a jaxb/json provider
        register(JacksonJaxbJsonProvider.class, new Class[] { MessageBodyReader.class, MessageBodyWriter.class });
        register(ObjectMapperProvider.class);
    }
}
