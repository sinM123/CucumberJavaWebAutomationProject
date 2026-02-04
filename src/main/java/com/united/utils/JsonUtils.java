package com.united.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.united.data.OrderData;

public class JsonUtils{
	
	
	@DataProvider(name = "orderData")
	public static Iterator<Object[]> readOrderData() {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\orderData.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<OrderData> data = mapper.readValue(file, new TypeReference<List<OrderData>>() {});
			System.out.println(data.get(0));
			for (OrderData order : data) {
				System.out.println(order.getVeggies());
			}
			return data.stream().map(d -> new Object[] {d}).iterator();
			
		} catch (IOException e) {
			System.out.println("Error reading json file: " + e.getMessage());
		}
		return null;
		
	}

}
