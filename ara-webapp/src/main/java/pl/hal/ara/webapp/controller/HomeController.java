package pl.hal.ara.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome");

        return "index";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome " + name);
        return "index";
    }

}
