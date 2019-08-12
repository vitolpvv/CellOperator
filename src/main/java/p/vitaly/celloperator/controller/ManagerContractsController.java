package p.vitaly.celloperator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.vitaly.celloperator.dto.ContractDto;
import p.vitaly.celloperator.service.ContractService;

@Controller
@RequestMapping("manager/contracts")
public class ManagerContractsController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public String clientsView(@RequestParam(required = false) Integer userId, Model model) {
        model.addAttribute("contracts", userId == null ? contractService.getAll() : contractService.getContractsByUser(userId));
        model.addAttribute("userId", userId);
        return "manager/contracts";
    }

    @GetMapping("add")
    public String addView(@RequestParam Integer userId, Model model) {
        ContractDto contract = new ContractDto();
        contract.setUserId(userId);
        model.addAttribute("contract", contract);
        model.addAttribute("tariffs", contractService.getAllTariffs());
        return "manager/contractedit";
    }

    @GetMapping("edit")
    public String editView(@RequestParam Integer id, Model model) {
        model.addAttribute("contract", contractService.get(id));
        model.addAttribute("tariffs", contractService.getAllTariffs());
        return "manager/contractedit";
    }

    @PostMapping
    public String saveOption(@ModelAttribute ContractDto contract) {
        contractService.save(contract);
        return "redirect:contracts";
    }

    @GetMapping("delete")
    public String deleteOption(@RequestParam Integer id) {
        contractService.removeWith(id);
        return  "redirect:../contracts";
    }
}
