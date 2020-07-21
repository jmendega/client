package com.springboot.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.models.Product;
import com.springboot.repositories.RepositoryInterface;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
@Slf4j
public class ProductService {
	
	private RepositoryInterface service;

	public ProductService() {
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:9001/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
		service = retrofit.create(RepositoryInterface.class);
	}
	
	public List<Product> getProducts() throws IOException {
        Call<List<Product>> retrofitCall = service.getProducts();

        Response<List<Product>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
        	log.error(response.errorBody().string());
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

	public Product createProduct(Product product) throws IOException{
		Call <Product> retrofitCall  = service.createProduct(product, "application/json");
		
		Response<Product> response = retrofitCall.execute();
		
		if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
		
		return response.body();
	}
	
	public Product UpdateProduct(String id, Product product) throws IOException{
		Call <Product> retrofitCall  = service.updateProduct(id, product, "application/json");
		
		Response<Product> response = retrofitCall.execute();
		
		if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
		
		return response.body();
	}
	
	public Product deleteProduct(String id) throws IOException{
		Call <Product> retrofitCall  = service.deleteProduct(id, "application/json");
		
		Response<Product> response = retrofitCall.execute();
		
		if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
		
		return response.body();
	}
	
	
	

}
