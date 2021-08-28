package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Controller
public class PublisherController {
	private final PublisherRepository publisherRepository;
	
	public PublisherController(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
	
	@RequestMapping("/publishers")
	public String getPublisher(Model model) {
		model.addAttribute("publishers", publisherRepository.findAll());
		return "publishers/list";
	}
}
