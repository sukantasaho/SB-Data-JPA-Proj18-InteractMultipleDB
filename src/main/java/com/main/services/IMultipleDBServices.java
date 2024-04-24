package com.main.services;

import java.util.List;

import com.main.entity.prod.Product;
import com.main.entity.promotion.Offers;

public interface IMultipleDBServices
{
      public List<Product> saveAllProduct(List<Product> pList);
      public List<Offers> saveAllOffers(List<Offers> oList);
      public List<Product> getAllProducts();
      public List<Offers> getAllOffers();
}
