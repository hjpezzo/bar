package br.com.harley.bar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.harley.bar.entity.BarItemMessage;

public interface OrderRepository extends MongoRepository<BarItemMessage, String> {

}
