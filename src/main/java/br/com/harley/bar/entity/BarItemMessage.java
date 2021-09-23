package br.com.harley.bar.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "orders")
@Getter
@Setter
public class BarItemMessage {

	private String orderId;
	private List<BarItem> barItens;
	
}
