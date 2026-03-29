package emp1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emp1.demo.entity.Studentrecord;
import emp1.demo.entity.UserRecord;
import emp1.demo.service.InsService;

@Controller
@RequestMapping("/ins")
public class InsController {

	@Autowired
	private InsService i;

	@GetMapping("home")
	public String listStudents(Model model) {
		model.addAttribute("studentrecords", i.getAll());
		UserRecord ap=new UserRecord();
		ap.setEmail("emil@com");
		ap.setFirstname("vamsi");
		i.usave(ap);
		
		return "home"; // students.html
	}
	
	@GetMapping("/add")
	public String add() {
		return "registration";
	}
	
	@GetMapping
	public String addap(Model model) {
		model.addAttribute("ins",i.getAll());
		List<Studentrecord>ap=i.getAll();
		for(int i=0;i<ap.size();i++) {
			System.out.println(ap.get(i).getName());
		}
		
		return "registeredData";
	}
	@PostMapping("/add")
	public String save(@ModelAttribute Studentrecord s) {
		i.save(s);
		return "redirect:/ins/home";
	}
	
}
