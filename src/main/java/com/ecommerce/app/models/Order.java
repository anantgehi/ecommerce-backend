package com.ecommerce.app.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ecommerce.app.dto.request.ShoppingCartProductsRequest;

import lombok.Data;

@Data
@Document(collection ="orders") 
public class Order {
	
		@Id  // Specify the MongoDB document’s primary key _id using the @Id annotation
		private String id;
		
		@Field(value = "order_amount")
		private Double orderAmount;
		
		@Field(value = "transaction_id")
		private String transactionId;
		
		@Field(value = "order_items_list")
		List<ShoppingCartProductsRequest> itemList=new ArrayList<>();
		
		@CreatedDate
		@Field(value = "order_date")
		private Instant orderDate;
		
		@NotBlank
		@Field(value = "order_status")
		private OrderStatus orderStatus;
		
		@NotBlank
		@Field(value = "payment_status")
		private PaymentStatus paymentStatus;
		
		@Field(value = "shipping_address")
		private Address shippingAddress;
		
		@Field(value = "billing_address")
		private Address billingAddress;

		
		
		public Order(Double orderAmount, List<ShoppingCartProductsRequest> itemList,
				   Address shippingAddress,Address billingAddress) {
			super();
			this.orderAmount = orderAmount;
			this.itemList = itemList;
			this.orderDate = Instant.now();
			this.orderStatus =  OrderStatus.PAYMENT_PENDING;
			this.paymentStatus = PaymentStatus.PENDING;
			this.shippingAddress = shippingAddress;
			this.billingAddress = billingAddress;
		}
		
		
}
