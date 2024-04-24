package com.main.entity.promotion;

import java.time.LocalDateTime;

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
@Table(name="MDS_OFFERS")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Offers 
{
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer offerId;
	  
	  @NonNull
	  @Column(length = 20)
      private String offerName;
	  
	  @Column(length = 20)
	  @NonNull
      private String offerCode;
	  
	  @NonNull
      private Double discountPercentage;
	  @NonNull
      private LocalDateTime expireDate;
}
