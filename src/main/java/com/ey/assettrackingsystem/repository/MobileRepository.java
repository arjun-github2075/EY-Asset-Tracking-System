package com.ey.assettrackingsystem.repository;

import com.ey.assettrackingsystem.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Long> {
}
