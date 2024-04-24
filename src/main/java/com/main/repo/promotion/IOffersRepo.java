package com.main.repo.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.promotion.Offers;

public interface IOffersRepo extends JpaRepository<Offers, Integer>
{

}
