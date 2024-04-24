package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.prod.Product;
import com.main.entity.promotion.Offers;
import com.main.repo.prod.IProductRepo;
import com.main.repo.promotion.IOffersRepo;

@Service("dbService")
public class MultipleDBServiceImp implements IMultipleDBServices 
{
	
	@Autowired
	private IProductRepo pRepo;
	@Autowired
	private IOffersRepo oRepo;

	@Override
	public List<Product> saveAllProduct(List<Product> pList) 
	{
		 
		return pRepo.saveAll(pList);
	}

	@Override
	public List<Offers> saveAllOffers(List<Offers> oList) 
	{
		 
		return oRepo.saveAll(oList);
	}

	@Override
	public List<Product> getAllProducts()
	{
		 
		return pRepo.findAll();
	}

	@Override
	public List<Offers> getAllOffers()
	{
		 
		return oRepo.findAll();
	}

}
