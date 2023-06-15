package com.ey.assettrackingsystem.controller;

import com.ey.assettrackingsystem.entity.Mobile;
import com.ey.assettrackingsystem.service.MobileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class MobileController {
    @Autowired
    private MobileServices mobileServices;

    @PostMapping("/addMobile")
    public String addMobile(@RequestBody Mobile mobile) {
        mobileServices.addMobile(mobile);
        return "mobile data added successfully";
    }

    @GetMapping("/getMobile")
    public List<Mobile> getMobileData() {
        return mobileServices.getMobileData();
    }
}
