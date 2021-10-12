package com.devin.ead.springagrisl.repositary;

import com.devin.ead.springagrisl.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepositary extends JpaRepository<Supplier, Long> {
}
