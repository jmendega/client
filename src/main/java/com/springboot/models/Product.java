package com.springboot.models;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Product {
//	@SerializedName("id")
	public String id;
//	@SerializedName("name")
	private String name;
//	@SerializedName("category")
	private String category;
//	@SerializedName("amount")
	private int amount;

}
