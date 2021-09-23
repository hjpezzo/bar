package br.com.harley.bar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.harley.bar.entity.BarItemMessage;
import br.com.harley.bar.enums.Status;

public interface OrderRepository extends MongoRepository<BarItemMessage, String> {

	BarItemMessage findByOrderId(String orderId);

	List<BarItemMessage> findAllByStatus(Status status);

}
