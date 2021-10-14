package com.devin.ead.springagrisl.repositary;

import com.devin.ead.springagrisl.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepositary extends JpaRepository<Buyer, Long> {
}
