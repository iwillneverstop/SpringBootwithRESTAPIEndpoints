package sample.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.spring.repository.ReviewRepository;

@Controller
public class ReviewController {

	@Autowired
	ReviewRepository repo;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("review", repo.getAll());
		return "index";
	}
	
	
}
