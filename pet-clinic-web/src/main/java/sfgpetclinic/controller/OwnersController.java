package sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sfgpetclinic.service.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners" , ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    private String findOwners(){
        return "notimplemented";
    }



}
