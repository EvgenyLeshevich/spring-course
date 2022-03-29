package com.evgeniy.controller;

import com.evgeniy.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HelloController {

    @RequestMapping
    public String getFirst() {
        return "first";
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails(Model model) {

        model.addAttribute("employee", new Employee());

        return "ask-emp-details";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details";
        } else {
            return "show-emp-details";
        }
    }
}
