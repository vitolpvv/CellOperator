package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.user.RoleDto;
import p.vitaly.celloperator.service.Service;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private Service<RoleDto, Integer> service;

    @GetMapping
    public String view(Model model) {
        model.addAttribute("roles", service.getAll());
        model.addAttribute("role", new RoleDto());
        return "role";
    }

    @PostMapping
    @Transactional
    public String addRole(@ModelAttribute("role") RoleDto roleDto) {
        service.add(roleDto);
        return "redirect:role";
    }

    @PostMapping("{id}")
    @Transactional
    public String deleteRole(@PathVariable("id") Integer id) {
        service.removeWith(id);
        return "redirect:../role";
    }
}
