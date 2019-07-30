package p.vitaly.celloperator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "index"})
public class IndexController {

    @GetMapping
    public String view() {
        return "index";
    }
}
