package com.mfanw.helloworld.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQ示例之生产者
 *
 * @author mengwei
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        //1 创建一个ConnectionFactory, 并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //2 通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3 通过connection创建一个Channel
        Channel channel = connection.createChannel();

        //4 通过Channel发送数据
        System.out.println("开始生产数据");
        int i = 0;
        while (true) {
            String msg = "Hello World RabbitMQ " + i++;
            //1 exchange   2 routingKey
            channel.basicPublish("", "test001", null, msg.getBytes());
            Thread.sleep(200);
        }

        //5 记得要关闭相关的连接
        // channel.close();
        // connection.close();
    }
}