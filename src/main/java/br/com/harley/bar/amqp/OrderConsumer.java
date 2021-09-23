package br.com.harley.bar.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.harley.bar.entity.BarItemMessage;
import br.com.harley.bar.service.OrderService;

@Component
public class OrderConsumer {

    OrderService orderService;

    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_TO_BAR)
    public void consumer(@Payload BarItemMessage order) {
        Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
        logger.info("Recebido pedido de Bar do pedido: ".concat(order.getOrderId()));
        orderService.addOrder(order);
    }

}
