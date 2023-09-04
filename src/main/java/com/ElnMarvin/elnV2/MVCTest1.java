package com.ElnMarvin.elnV2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCTest1 {
    @RequestMapping(value = {"/MVCDemoServlet"})
    public ModelAndView doGet() {
        String structure = "water";

        ModelAndView modelAndView = new ModelAndView("MVCDemoView");
        modelAndView.addObject("structure", structure);

        return modelAndView;
    }

    @GetMapping ("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "John Doe");
        return "hello";
    }

    @GetMapping ("/addCSS-JS-Test")
    public String style(Model model) {
        return "addCSS-JS-Test";
    }
}
