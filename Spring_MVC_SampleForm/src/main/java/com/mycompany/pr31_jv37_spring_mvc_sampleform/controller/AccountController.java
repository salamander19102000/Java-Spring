/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_sampleform.controller;

import com.mycompany.pr31_jv37_spring_mvc_sampleform.emuns.Gender;
import com.mycompany.pr31_jv37_spring_mvc_sampleform.entity.AccountEntity;
import com.mycompany.pr31_jv37_spring_mvc_sampleform.service.AccountService;
import javax.enterprise.context.Initialized;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hi_XV
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "message", required = false) String message) {
        model.addAttribute("accounts", accountService.getAccounts());
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "home";
    }

    @RequestMapping("/create-account")
    public String displayAccountForm(Model model) {
        model.addAttribute("account", new AccountEntity());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("action", "create-account");
        return "account";
    }

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public String createAccount(Model model,
            @Valid @ModelAttribute("account") AccountEntity account,
            BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("account", account);
            model.addAttribute("genders", Gender.values());
            model.addAttribute("action", "create-account");
            return "account";
        } else {
            accountService.save(account);
            return "redirect:/home";
        }
    }

    @RequestMapping("/update/{id}")
    public String updateAccount(Model model,
            @PathVariable("id") int id) {
        AccountEntity account = accountService.findAccountById(id);
        if (account.getId() > 0) {
            model.addAttribute("account", account);
            model.addAttribute("genders", Gender.values());
            model.addAttribute("action", "update");
            return "account";
        } else {
            return "redirect:/home?type=error&message= Not Found Id: " + id;
        }
    }

   @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAccount(Model model,
            @Valid @ModelAttribute("account") AccountEntity account,
            BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("account", account);
            model.addAttribute("genders", Gender.values());
            model.addAttribute("action", "create-account");
            return "account";
        } else {
            accountService.save(account);
            return "redirect:/home";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteAccount(Model model,
            @PathVariable("id") int id) {
        if (!accountService.delete(id)) {
            return "redirect:/home?type=success&message=delete success";
        } else {
            return "redirect:/home?type=error&message=delete fail";
        }
    }
}
