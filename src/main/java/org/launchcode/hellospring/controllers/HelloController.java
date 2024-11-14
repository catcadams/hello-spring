package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@Controller
public class HelloController {

    // handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create handler that handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//            return "Hello, " + name + "!";
//    }

    //handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value=''> English </option>" +
                "<option value='french'> French </option>" +
                "<option value='spanish'> Spanish </option>" +
                "<option value='greek'> Greek </option>"+
                "<option value='croatian'> Croatian </option>" +
                "<option value='lithuanian'> Lithuanian </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if(language =="french") {
            greeting = "Bonjour";
        } else if (language == "spanish") {
            greeting= "Hola";
        } else if (language == "greek") {
            greeting= "Γειά σου";
        } else if(language == "croatian"){
            greeting= "Zdravo";
        } else if (language == "lithuanian") {
            greeting="Sveiki";
        } else {
            greeting= "Hello";
        }

        return MessageFormat.format("{0}, {1}!", greeting, name);
    }

    @RequestMapping(value="hello",method = {RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, String language) {
        if (name=="") {
            name = "LaunchCode";
        }

        return createMessage(name, language);
    }
}
