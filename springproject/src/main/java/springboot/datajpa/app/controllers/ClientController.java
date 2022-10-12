package springboot.datajpa.app.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.datajpa.app.entities.Client;
import springboot.datajpa.app.services.IClientService;

import javax.validation.Valid;
import java.util.Map;

/*
    Sessions works to save store information between HTTP requests, because it's stateless
    (cuz' it doesn't save any information about the last connections)
*/

@Controller
@SessionAttributes("client")
public class ClientController {

    @Qualifier("ClientDaoJPA")
    private final IClientService clientService;

    public ClientController(IClientService clientDao) {
        this.clientService = clientDao;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("tittle", "Clients");
        model.addAttribute("clients", clientService.findAll());
        return "all";
    }


    @GetMapping(value = "/form")
    public String saveClient(Map<String, Object> model) {
        Client client = new Client();
        model.put("tittle", "Save Client");
        model.put("client", client);

        return "form";

    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(@Valid Client client,
                       BindingResult result,
                       Model model,
                       RedirectAttributes flash,
                       SessionStatus status){

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Form");
            return "form";
        }

        clientService.save(client);
        status.setComplete();
        flash.addFlashAttribute("success", "Client has been save");
        return "redirect:getAll";
    }
    @RequestMapping(value = "/form/{id}")
    public String update(@PathVariable(value = "id") Long id,
                         Map<String, Object> model,
                         RedirectAttributes flash){
        Client client = null;
        if (id > 0 ){
            client =  clientService.findClient(id);
        }else{
            flash.addFlashAttribute("error", "Client's id couldn't be 0");
            return "redirect:/getAll";
        }

        model.put("client", client);
        model.put("title", "edite client");

        return "form";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id,
                         RedirectAttributes flash){
        Client client = null;
        if (id > 0 ){
            clientService.deleteClient(id);
            flash.addFlashAttribute("success", "Client has been delete");
        }

        return "redirect:/getAll";
    }



}
