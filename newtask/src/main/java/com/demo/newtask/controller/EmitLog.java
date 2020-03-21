package com.demo.newtask.controller;

import com.demo.newtask.NewTaskApplication;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    @RequestMapping("/EmitLog")
    String index() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String[] argv = NewTaskApplication.str;
//            String[] argv = {"First", "Second", "Third", "Fourth", "Fourth", "Fifth"};

            String message = argv.length < 1 ? "info: Hello World!" :
                    String.join(" ", argv);

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }

        return "EmitLog ! ";
    }
}
