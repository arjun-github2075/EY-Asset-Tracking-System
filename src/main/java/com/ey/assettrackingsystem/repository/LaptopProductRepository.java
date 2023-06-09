package com.ey.assettrackingsystem.repository;

import com.ey.assettrackingsystem.entity.LaptopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopProductRepository extends JpaRepository<LaptopProduct,Long> {
}
