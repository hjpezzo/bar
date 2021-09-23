package br.com.harley.bar.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.harley.bar.amqp.RabbitConfig;
import br.com.harley.bar.entity.BarItemMessage;
import br.com.harley.bar.enums.Status;
import br.com.harley.bar.exception.OrderAlreadyDoneException;
import br.com.harley.bar.exception.ResourceNotFoundException;
import br.com.harley.bar.repository.OrderRepository;

@Service
public class OrderService {

	OrderRepository orderRepository;
    RabbitTemplate rabbitTemplate;

	public OrderService(OrderRepository orderRepository, RabbitTemplate rabbitTemplate) {
		this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
	}

	public BarItemMessage addOrder(BarItemMessage order) {
		return orderRepository.save(order);
	}

	public String finishOrder(String orderId) {
		BarItemMessage order = orderRepository.findByOrderId(orderId);
		
		if (order == null) {
			throw new ResourceNotFoundException();
		}
		
		if (order.getStatus().equals(Status.DONE)) {
			throw new OrderAlreadyDoneException();
		}
		
		order.setStatus(Status.DONE);
		orderRepository.save(order);

		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY_BAR_TO_ORDER, order);

		return orderId;
	}
	
	public List<BarItemMessage> getOrders() {
		return orderRepository.findAllByStatus(Status.PREPARING);
	}
}
