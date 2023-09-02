package com.ElnMarvin.elnV2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @RequestMapping(value = {"/", "/elntest"})
    public String index() {
        return "elntest";
    }
}
