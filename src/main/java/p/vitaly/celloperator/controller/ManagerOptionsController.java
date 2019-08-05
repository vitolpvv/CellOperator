package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.option.OptionDto;
import p.vitaly.celloperator.service.OptionService;
import p.vitaly.celloperator.service.PaymentPeriodService;
import p.vitaly.celloperator.service.Service;

import java.util.List;

@Controller
@RequestMapping("manager/options")
public class ManagerOptionsController {
    @Autowired
    private OptionService optionService;
    @Autowired
    private PaymentPeriodService paymentPeriodService;

    @GetMapping
    public String optionsView(Model model) {
        model.addAttribute("options", optionService.getAll());
        return "manager/options";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("payPeriods", paymentPeriodService.getAll());
        model.addAttribute("options", optionService.getAll());
        model.addAttribute("option", new OptionDto());
        return "manager/optionadd";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("payPeriods", paymentPeriodService.getAll());
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
        if (option.getId() == null) {
            Integer id = optionService.add(option);
            return "redirect:options/edit?id=" + id;
        }
        else {
            optionService.update(option);
            return "redirect:options";
        }
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        optionService.removeWith(id);
        return  "redirect:../options";
    }
}
