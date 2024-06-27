package com.sample.loginform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.loginform.Entity.Deepthi;
import com.sample.loginform.services.DeepthiService;

@Controller
@RequestMapping("/api")
public class DeepthiController {

    @Autowired
    private DeepthiService serv;

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }


@PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody Deepthi deep) {
        serv.saveDetails(deep);
        return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
   }

    @PostMapping("/login")
    public String loginUser(@RequestParam("userid") String userid, 
                            @RequestParam("password") String password, 
                            RedirectAttributes redirectAttributes, 
                            Model model) {
        boolean isAuthenticated = serv.authenticate(userid, password);
        if (isAuthenticated) {
            redirectAttributes.addFlashAttribute("message", "Login Successful");
            return "redirect:/api/success"; 
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; 
        }
    }

    @GetMapping("/success")
    public String success(Model model) {
        return "success"; 
    }
}
