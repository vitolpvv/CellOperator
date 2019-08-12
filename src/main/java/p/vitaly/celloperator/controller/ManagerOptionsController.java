package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.OptionDto;
import p.vitaly.celloperator.service.OptionService;

import java.util.List;

@Controller
@RequestMapping("manager/options")
public class ManagerOptionsController {
    @Autowired
    private OptionService optionService;

    @GetMapping
    public String optionsView(Model model) {
        model.addAttribute("options", optionService.getAll());
        return "manager/options";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("payPeriods", optionService.getPaymentPeriodAll());
        model.addAttribute("options", optionService.getAll());
        model.addAttribute("option", new OptionDto());
        return "manager/optionedit";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("payPeriods", optionService.getPaymentPeriodAll());
        List<OptionDto> options = optionService.getAll();
        OptionDto option = options.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (option != null) {
            options.remove(option);
        }
        model.addAttribute("options", options);
        model.addAttribute("option", option);
        return "manager/optionedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute OptionDto option) {
        optionService.save(option);
        return "redirect:options";
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        optionService.removeWith(id);
        return  "redirect:../options";
    }
}
