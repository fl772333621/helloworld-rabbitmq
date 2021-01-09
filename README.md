# helloworld RabbitMQ

> 简单模拟 RabbitMQ 的生产者和消费者

## 一、安装 RabbitMQ

必要步骤，不可跳过。网上找安装攻略即可，建议安装到本地。本次使用的软件版本如下：

- RabbitMQ 3.8.9
- Erlang 23.2

## 二、启动 RabbitMQ

必要步骤，不可跳过。能访问 http://localhost:15672/ 表名安装成功。

## 三、启动多个 Producer 和多个 Consumer

启动多个实例后，一般而言会有如下几种情况

- 如果先启动 Producer 后启动 Consumer 则会造成积压，启动 Consumer 瞬间会将全部消息发送过来。
- 如果先启动 Consumer 后启动 Producer 无任何消息积压
- 多个 Consumer 之间消费消息一般会负载均衡
- 访问 http://localhost:15672/ 可以详细的看到消息的生产和消费过程
- 可以模拟消息积压过程，如设置 Consumer 消费速度降低
