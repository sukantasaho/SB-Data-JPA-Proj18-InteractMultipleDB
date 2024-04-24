package com.main.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.prod.Product;

public interface IProductRepo extends JpaRepository<Product, Integer>
{

}
