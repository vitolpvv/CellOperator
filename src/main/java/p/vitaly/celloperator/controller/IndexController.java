package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.vitaly.celloperator.service.RoleService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private RoleService service;

    @GetMapping
    public String view(ModelMap model) {
        model.addAttribute("roles", service.getAll());
        return "index";
    }
}
