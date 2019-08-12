package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.user.UserDto;
import p.vitaly.celloperator.service.UserService;

@Controller
@RequestMapping("manager/clients")
public class ManagerClientsController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String clientsView(Model model) {
        model.addAttribute("users", userService.getAllClients());
        return "manager/clients";
    }

    @GetMapping("add")
    public String addView(Model model) {
        UserDto user = new UserDto();
        user.getRoleIds().add(1);
        model.addAttribute("user", user);
        return "manager/clientedit";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("user", userService.get(id));
        model.addAttribute("contracts", userService.getUserContracts(id));
        return "manager/clientedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute UserDto user) {
        boolean isNew = user.getId() == null;
        Integer id = userService.save(user);
        return isNew ? "redirect:clients/edit?userId=" + id : "redirect:clients";
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        userService.removeWith(id);
        return  "redirect:../clients";
    }
}
