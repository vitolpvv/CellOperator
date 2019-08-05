package p.vitaly.celloperator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TariffController {
    @GetMapping
    public String goToTariffs() {
        return "redirect:tariffs";
    }

    @GetMapping("tariffs")
    public String view() {
        return "tariffs";
    }
}
