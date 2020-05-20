package fr.epsi.b3.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class IndexController {

    @GetMapping({"/"})
    public String getIndex(Model model){
        return "index";
    }

}
