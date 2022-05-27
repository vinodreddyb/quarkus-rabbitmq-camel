package com.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RabbitRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Emp.class);
        from("rabbitmq:prices?queue=prices&declare=false&autoDelete=false" +
                "&connectionFactory=#rabbitConnectionFactory" +
                "&concurrentConsumers=2" +
                "&threadPoolSize=2").id("updateQueue1")
                .unmarshal().json(JsonLibrary.Jackson, Emp.class)
                .bean("empService","testEmp")
                .end();

    }
}
