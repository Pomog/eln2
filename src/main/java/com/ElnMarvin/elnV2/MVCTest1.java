package com.ElnMarvin.elnV2;

import com.ElnMarvin.elnV2.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping ("/bootstrapTest")
    public String bootStrapTest(Model model) {
        List people = new ArrayList();
        people.add(new Person(1L, "John", "Doe", 20));
        people.add(new Person(2L, "Jane", "Doe", 15));
        people.add(new Person(3L, "John", "Smith", 30));

        model.addAttribute("people", people);
        return "bootstrapTest";
    }
}
