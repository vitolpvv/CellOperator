package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.vitaly.celloperator.service.TariffService;

@Controller
@RequestMapping("")
public class TariffController {
    @Autowired
    private TariffService tariffService;

    @GetMapping
    public String goToTariffs() {
        return "redirect:tariffs";
    }

    @GetMapping("tariffs")
    public String view(Model model) {
        model.addAttribute("tariffs", tariffService.getAllActive());
        return "tariffs";
    }
}
