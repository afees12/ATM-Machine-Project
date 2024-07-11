// src/main/java/com/example/atm/controller/ATMController.java
package com.example.atm.controller;

import com.example.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ATMController {
    @Autowired
    private ATMService atmService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("balance", atmService.checkBalance());
        return "index";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount, Model model) {
        atmService.deposit(amount);
        model.addAttribute("balance", atmService.checkBalance());
        return "index";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount, Model model) {
        try {
            atmService.withdraw(amount);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("balance", atmService.checkBalance());
        return "index";
    }
}

