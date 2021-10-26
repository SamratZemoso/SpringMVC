package com.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
// Parent Mapping
@RequestMapping("/form")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "show-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "process-form";
    }

    @RequestMapping("/processFormVersionTwo")
    public String shoutStudentName(HttpServletRequest request, Model model) {

        // Getting the name of student from Form
        String name = request.getParameter("studentName");

        // converting to Uppercase
        name = name.toUpperCase();

        // Adding message
        String result = "Yo !! " + name;

        // add message to the model with attribute name
        model.addAttribute("message", result);

        return "hello_world";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        // converting to Uppercase
        name = name.toUpperCase();

        // Adding message
        String result = "Yo !! " + name;

        // add message to the model with attribute name
        model.addAttribute("message", result);

        return "hello_world";
    }

}
