package sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/","","/index","/index.html"}, produces = "application/json; charset=UTF-8")
    public String index(){
        return "index";
    }


    @RequestMapping({"/oups"})
    private String oupsHandler(){
        return "notimplemented";
    }

}
