package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.PaymentPeriodDto;
import p.vitaly.celloperator.dto.tariff.TariffDto;
import p.vitaly.celloperator.service.PaymentPeriodService;
import p.vitaly.celloperator.service.Service;
import p.vitaly.celloperator.service.TariffService;

@Controller
@RequestMapping("manager/tariffs")
public class ManagerTariffsController {
    @Autowired
    private TariffService tariffService;
    @Autowired
    private PaymentPeriodService paymentPeriodService;

    @GetMapping
    public String tariffsView(Model model) {
        model.addAttribute("tariffs", tariffService.getAll());
        return "manager/tariffs";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("payPeriods", paymentPeriodService.getAll());
        model.addAttribute("tariff", new TariffDto());
        return "manager/tariffadd";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("payPeriods", paymentPeriodService.getAll());
        model.addAttribute("tariff", tariffService.get(id));
        return "manager/tariffedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute TariffDto tariff) {
        if (tariff.getId() == null) {
            Integer id = tariffService.add(tariff);
            return "redirect:tariffs/edit?id=" + id;
        }
        else {
            tariffService.update(tariff);
            return "redirect:tariffs";
        }
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        tariffService.removeWith(id);
        return  "redirect:../tariffs";
    }
}
