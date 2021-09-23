package br.com.harley.bar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.harley.bar.entity.BarItemMessage;
import br.com.harley.bar.service.OrderService;

@RestController
@RequestMapping("/bar-orders")
public class OrderController {

	OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("/{orderId}")
    public String finishOrder(@PathVariable("orderId") String orderId) {
        return orderService.finishOrder(orderId);
    }
    
    @GetMapping
    public List<BarItemMessage> getOrders() {
    	return orderService.getOrders();
    }
}
