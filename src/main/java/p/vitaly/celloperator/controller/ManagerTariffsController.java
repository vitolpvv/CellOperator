package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.TariffDto;
import p.vitaly.celloperator.service.TariffService;

@Controller
@RequestMapping("manager/tariffs")
public class ManagerTariffsController {
    @Autowired
    private TariffService tariffService;

    @GetMapping
    public String tariffsView(Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "manager/tariffs";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("payPeriods", tariffService.getPaymentPeriodAll());
        model.addAttribute("tariff", new TariffDto());
        return "manager/tariffedit";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("payPeriods", tariffService.getPaymentPeriodAll());
        model.addAttribute("tariff", tariffService.get(id));
        return "manager/tariffedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute TariffDto tariff) {
        tariffService.save(tariff);
        return "redirect:tariffs";
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        tariffService.removeWith(id);
        return  "redirect:../tariffs";
    }
}
