package com.main.entity.prod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDS_PRODUCT")
@AllArgsConstructor
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
	
	@Column(length = 20)
	@NonNull
    private String pname;
	
	@NonNull
    private Integer qty;
	
	@NonNull
    private Double price;
}
