package pl.hal.ara.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hal.ara.core.model.User;
import pl.hal.ara.webapp.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, ModelMap modelMap) {
        userService.addUser(user.getUsername(), user.getEmail().asString(), user.getPassword().toString());

        return "result";
    }

}
