package com.ElnMarvin.elnV2;

import org.springframework.stereotype.Controller;
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
}
