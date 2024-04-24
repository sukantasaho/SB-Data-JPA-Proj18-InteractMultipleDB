package com.main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.entity.prod.Product;
import com.main.entity.promotion.Offers;
import com.main.repo.prod.IProductRepo;
import com.main.repo.promotion.IOffersRepo;
import com.main.services.IMultipleDBServices;

@SpringBootApplication
public class SbDataJpaProj18InteractMultipleDbApplication {
 
	 
	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(SbDataJpaProj18InteractMultipleDbApplication.class, args);
		IMultipleDBServices service = ctx.getBean("dbService", IMultipleDBServices.class);
		Product p1 = new Product("Hp Laptop-1", 3, 60000d);
		Product p2 = new Product("Hp Laptop-2", 5, 89000d);
		Product p3 = new Product("Hp Laptop-3", 7, 90000d);
		service.saveAllProduct(List.of(p1, p2, p3));
		System.out.println("Product is saved in oracle db");
		System.out.println("*****************************************");
		
		Offers off1 = new Offers("Buy1-Get2", "B1G2", 10d, LocalDateTime.now());
		Offers off2 = new Offers("Buy2-Get3", "B2G3", 20d, LocalDateTime.now());
		Offers off3 = new Offers("Buy3-Get5", "B3G5", 30d, LocalDateTime.now());
		service.saveAllOffers(List.of(off1, off2, off3));
		System.out.println("Offers are saved in mysql db");
		
		//display product records
		service.getAllProducts().forEach(System.out::print);
		//display offer records
		service.getAllOffers().forEach(System.out::print);
		
		
		
		
		 
	}

}
