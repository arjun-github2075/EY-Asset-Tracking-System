package com.ey.assettrackingsystem.service;

import com.ey.assettrackingsystem.entity.Mobile;
import com.ey.assettrackingsystem.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileServices {
    @Autowired
    private MobileRepository mobileRepository;

    public void addMobile(Mobile mobile) {
        mobileRepository.save(mobile);
    }

    public List<Mobile> getMobileData() {
        return mobileRepository.findAll();
    }
}
