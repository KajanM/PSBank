package com.kajan.springmvc.psbankapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kajan.springmvc.psbankapp.model.Account;

@Controller
public class AccountController {
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "newAccount";
	}
	
	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}
	
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(Model model, HttpServletRequest request) {
		
		String accountNo = request.getParameter("accountNo");
		String customerName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");
		
		Account account = new Account();
		account.setAccountNo(Integer.parseInt(accountNo));
		account.setAccountHolderName(customerName);
		account.setBalance(Integer.parseInt(balance));
		
		model.addAttribute("account", account);
		
		return "showAccount";
	}

}
