package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.service.Service;
import p.vitaly.celloperator.service.UserService;

@Controller
@RequestMapping("manager/clients")
public class ManagerClientsController {
    @Autowired
    private UserService userService;
    @Autowired
    private Service<RoleDto, Integer> roleService;

    @GetMapping
    public String clientsView(Model model) {
        model.addAttribute("users", userService.getAllClients());
        return "manager/clients";
    }

    @GetMapping("add")
    public String addView(Model model) {
        UserDto user = new UserDto();
        user.setRole(roleService.get(0));
        model.addAttribute("user", new UserDto());
        return "manager/clientadd";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "manager/clientedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute UserDto user) {
        if (user.getId() == null) {
            Integer id = userService.add(user);
            return "redirect:clients/edit?id=" + id;
        }
        else {
            userService.update(user);
            return "redirect:clients";
        }
    }
}
