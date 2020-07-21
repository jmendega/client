package com.springboot.repositories;

import java.util.List;

import com.springboot.models.Product;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RepositoryInterface {
	
	 @GET("product/all")
	 Call<List<Product>> getProducts();
	 
	 @POST("product")
	 Call<Product> createProduct(@Body Product product, @Header("Content-Type") String contentType);
	 
	 @PUT("product/{id}")
	 Call<Product> updateProduct(@Path("id") String id, @Body Product product, @Header("Content-Type") String contentType);
	 
	 @DELETE("product/{id}")
	 Call<Product> deleteProduct(@Path("id") String id, @Header("Content-Type") String contentType);
	 

}
