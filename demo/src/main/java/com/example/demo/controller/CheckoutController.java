package com.example.demo.controller;

import com.example.demo.hostelRepository.BookingInformationRepo;
import com.example.demo.modal.BookingInformation;
import com.example.demo.modal.User;
import com.example.demo.payload.ChargeRequest;
import com.example.demo.securityConfiguration.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingInformationRepo bookingInformationRepo;
 
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
 
    @RequestMapping("/checkout")
    public String checkout(Model model) {

        String username = MainController.currentUserName();
        User user = userRepository.findByUserName(username);

        BookingInformation bookingInformation = bookingInformationRepo.findByBookedBy(user.getId());
        model.addAttribute("amount", bookingInformation.getHostelInfoModel().getPrice()); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "checkout";
    }
}