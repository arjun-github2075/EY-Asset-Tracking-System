package com.ey.assettrackingsystem.controller;


import com.ey.assettrackingsystem.entity.Mobile;
import com.ey.assettrackingsystem.entity.Users;
import com.ey.assettrackingsystem.service.UsersService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private LaptopProductController laptopProductController;

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/mobile")
    public String showMobilePage() {
        return "mobile";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @GetMapping("/laptop")
    public String showLaptopPage(Model model) {
        model.addAttribute("products",laptopProductController.getAllProducts());
        return "laptop";
    }

    @GetMapping("/googlecloudservices")
    public String showGoogleCloudServicesPage(Model model) {
        return "googlecloudservices";
    }

    @GetMapping("/mobiledataform")
    public String showMobileDataFormPage() {
        return "mobiledataform";
    }

    @GetMapping("/creditcard")
    public String showCreditcardPage() {
        return "creditcard";
    }

    @GetMapping("/requestform")
    public String showRequestformPage() {
        return "requestform";
    }

    @GetMapping("/product")
    public String showProductPage() {
        return "product";
    }

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }

    @GetMapping("/cloudasset")
    public String showCloudassetPage() {
        return "cloudasset";
    }

    @GetMapping("/track")
    public String showTrackPage() {
        return "track";
    }

    @PostMapping("/save-user")
    public String saveUsers(@RequestBody Users users) {
        usersService.saveUsers(users);
        return "user saved successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String email,
                        @RequestParam("password") String password,
                        Model model, HttpSession session, HttpServletResponse response) {

        boolean isAuthenticated = usersService.authenticate(email, password);

        if (isAuthenticated) {
            // Redirect to the laptop page
            return "redirect:/laptop";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }

    @PostMapping("/users")
    public String createUser(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("mobile") Long mobile,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("confirmPassword") String confirmPassword) {

        // Create a new User object and set the properties
        Users user = new Users();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMobileNumber(mobile);
        user.setEmail(email);
        user.setPassword(password);

        // Save the user to the database using the UserRepository
        usersService.createUser(user);

        // Redirect to a success page or perform any other necessary actions
        return "redirect:/laptop";
    }

    @Autowired
    private MobileController mobileController;
    @PostMapping("/addmobiledata")
    public String addMobileData(@ModelAttribute Mobile mobile, RedirectAttributes redirectAttributes) {
        mobileController.addMobile(mobile);
        redirectAttributes.addFlashAttribute("successMessage", "Mobile Data Added successfully");
        return "redirect:/mobiledataform";
    }
}
