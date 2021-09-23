package br.com.harley.bar.service;

import org.springframework.stereotype.Service;

import br.com.harley.bar.entity.BarItemMessage;
import br.com.harley.bar.repository.OrderRepository;

@Service
public class OrderService {

	OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public BarItemMessage addOrder(BarItemMessage order) {
		return orderRepository.save(order);
	}
}
