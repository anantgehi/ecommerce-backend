package com.ecommerce.app.services;

import java.util.List;
import java.util.stream.Stream;

import com.ecommerce.app.dto.request.ProductDetailsRequest;
import com.ecommerce.app.dto.request.ShoppingCartProductsRequest;
import com.ecommerce.app.models.Product;

public interface IProductService {
	
	Product getProductById(String productId);

	Stream<ProductDetailsRequest> getLatestProducts();
	
	Stream<ProductDetailsRequest> getMostVisitedProducts();

	Product updateVisits(Product product);
	
	ProductDetailsRequest getWishListProductById(String productId);
	
	ShoppingCartProductsRequest getShoppingCartProductById(String productId, Integer quantity);
	
	boolean stockUnavailable(List<ShoppingCartProductsRequest> itemsList);

	void reduceStock(List<ShoppingCartProductsRequest> itemList);
}
