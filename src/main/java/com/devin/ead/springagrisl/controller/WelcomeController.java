
package com.devin.ead.springagrisl.controller;

import com.devin.ead.springagrisl.model.Contact;
import com.devin.ead.springagrisl.model.Event;
import com.devin.ead.springagrisl.service.ContactService;
import com.devin.ead.springagrisl.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class WelcomeController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/contacts")
	public String contact(Model model) {

		// create model attribute to bind form data
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@PostMapping("/saveContact")
	public String saveEvent (@ModelAttribute("contact") Contact contact) {
		// save contact to database
		contactService.saveContact(contact);
		return "redirect:/";
	}



}
