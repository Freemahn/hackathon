package com.freemahn.web;

import java.util.concurrent.atomic.AtomicLong;

import com.freemahn.domain.entity.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/data")
public class DataController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Data getData(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Data(counter.incrementAndGet(), String.format(template, name));
    }

}