package com.mini_core_banking_app.controller.admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mini_core_banking_app.model.Transaction;
import com.mini_core_banking_app.service.CustomerService;
import com.mini_core_banking_app.service.TransactionService;



@Controller
public class AdminTransactionController {
	
	@Autowired
    private TransactionService transactionService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/admin/customer/fund_transfer")
	public String getTransferPage(Model model) {
	    
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
	    return "/admin/customer/fund_transfer";
	}
	

	
//	@PostMapping("/admin/customer/fund_transfer")
//	@ResponseBody
	@RequestMapping(value="/admin/customer/fund_transfer", method=RequestMethod.POST)
	public String makeTransfer(
			@RequestParam("sender") String sender,
			@RequestParam("recipient") String recipient,
			@RequestParam("amount") String amount,
			Transaction transaction )
	{

		
		// check amount is > 0 first
		Boolean amountIsNegativeOrZeroValue = transactionService.amountIsNegativeOrZeroValue(Float.parseFloat(amount));
		if (amountIsNegativeOrZeroValue == true) {
			return "redirect:/admin/customer/fund_transfer?error=Invalid amount";
		}
		

		// ensure sender_balance - amount >= 0
		Boolean hasSufficientBalance = customerService.isSufficientBlance(sender, Float.parseFloat(amount));
		if (hasSufficientBalance == false) {
			return "redirect:/admin/customer/fund_transfer?error=Insufficient balance";
		}
		
		// if we have come this far, subtract amount from senders balance and add to recipient
		
		
		customerService.deductAmountFromSender(sender, Float.parseFloat(amount));		
		customerService.addAmountFromRecipient(recipient, Float.parseFloat(amount));
		
		transaction.setPaymentMethod("transfer");
		transactionService.save(transaction);
		
//		System.out.println("-----================------");
		
		return "redirect:/admin/customer/fund_transfer?success";

	}
	
	
	
}
