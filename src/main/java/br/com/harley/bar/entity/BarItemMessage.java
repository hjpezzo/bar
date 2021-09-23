package br.com.harley.bar.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.harley.bar.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "orders")
@Getter
@Setter
public class BarItemMessage {

	@Id
	@JsonIgnore
	private String id;
	
	private String orderId;
	private List<BarItem> barItens;
	private Status status;
	
}
