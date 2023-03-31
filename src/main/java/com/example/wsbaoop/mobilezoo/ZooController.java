package com.example.wsbaoop.mobilezoo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoo")
public class ZooController {

    @GetMapping("/test")
    public String test() {
        Animal dog = new Animal("canis", "szarik", true);
        String html = "<html><body><h1>no elo</h1>" +
                "<h2>" + dog.name + "</h2>" +
                "</body></html>";
        return html;
    }

    @GetMapping("/test2")
    public String test2() {
        return "pozdrawiam 2000";
    }
}
