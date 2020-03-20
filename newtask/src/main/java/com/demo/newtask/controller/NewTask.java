package com.demo.newtask.controller;

import com.demo.newtask.NewTaskApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

@RestController
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    @RequestMapping("/")
    public String index() throws Exception {
//        return "Greetings from Spring Boot! NewTask";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            String[] argv = NewTaskApplication.str;
//            Object arv = CodeCache.codeMap.get("key");
            String message = String.join(" ", argv);

            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }

        return "success!";

    }

}