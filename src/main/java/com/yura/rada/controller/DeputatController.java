package com.yura.rada.controller;

import com.yura.rada.model.Deputat;
import com.yura.rada.service.DeputatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yuriismac on 2020-06-06.
 * @project VerkhovnaRada
 */

@Controller
public class DeputatController {
    private DeputatService deputatService;

    @Autowired(required = true)
    @Qualifier(value = "deputatService")
    public void setDeputatService(DeputatService deputatService) {
        this.deputatService = deputatService;
    }

    @RequestMapping(value = "deputats", method = RequestMethod.GET)
    public String listDeputats(Model model) {
        model.addAttribute("deputat", new Deputat());
        model.addAttribute("listDeputats", this.deputatService.listDeputats());

        return "deputats";
    }

    @RequestMapping(value = "/deputats/add", method = RequestMethod.POST)
    public String addDeputat(@ModelAttribute("deputat") Deputat deputat) {
        if (deputat.getId() == 0) {
            this.deputatService.addDeputat(deputat);
        } else {
            this.deputatService.updateDeputat(deputat);
        }
        return "redirect:/deputats";
    }

    @RequestMapping("/remove/{id}")
    public String removeDeputat(@PathVariable("id") int id) {
        this.deputatService.removeDeputat(id);

        return "redirect:/deputats";
    }

    @RequestMapping("edit/{id}")
    public String editDeputat(@PathVariable("id") int id, Model model) {
        model.addAttribute("deputat", this.deputatService.getDeputatById(id));
        model.addAttribute("deputats", this.deputatService.listDeputats());

        return "deputats";
    }

    /**
     * Method gets deputat data in separate page
     */
    @RequestMapping("deputatdata/{id}")
    public String deputatData(@PathVariable("id") int id, Model model) {
        model.addAttribute("deputat", this.deputatService.getDeputatById(id));

        return "deputatdata";
    }

}
