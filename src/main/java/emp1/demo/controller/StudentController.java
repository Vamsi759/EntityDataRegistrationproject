package emp1.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import emp1.demo.StudentDto.StudentDto;
import emp1.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
//--------------------
	
	@Autowired
	private StudentService studentService;

	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAll());
		return "students"; // students.html
	}

	@GetMapping("/add")
	public String addStudentForm() {
		return "addstudent";
	}

	@GetMapping("/ap1")
	public String apap1() {
		return "home";
	}

	@PostMapping("/add")
	public String save(@ModelAttribute StudentDto dto, RedirectAttributes redirectAttributes) {
		studentService.save(dto);
		redirectAttributes.addFlashAttribute("message", dto.getFirstName() + " added successfully!");
		return "redirect:/students";

	}

	@PostMapping("/edit/{id}")
	public String update(@PathVariable Long id, @ModelAttribute StudentDto dto, RedirectAttributes redirectAttributes) {

		studentService.update(id, dto);

		redirectAttributes.addFlashAttribute("message", dto.getFirstName() + " updated successfully!");

		return "redirect:/students";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.get(id));
		return "editstudent";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		StudentDto student = studentService.get(id); // get before delete

		studentService.delete(id);

		redirectAttributes.addFlashAttribute("message",   student.getFirstName() + " deleted successfully!");

		return "redirect:/students";
	}
}

//starting___
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import emp1.demo.StudentDto.StudentDto;
//import emp1.demo.service.StudentService;
//
//@Controller
//@RequestMapping("/")
//public class StudentController {
//
//    @Autowired
//    private StudentService service;
//
//    // Show list/
//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("ss", service.getAll());
//        return "list";
//        
//        // return java is robust and secure
//        // will return in tne home may be
//    }
//    
//    @GetMapping("dd")
//    @ResponseBody
//    public String lists(Model model) {
//        model.addAttribute("ss", service.getAll());
//        return "DEn is dare ";
//        
//        // return java is robust and secure
//        // will return in tne home may be
//        //by deafut retunrn the views only
//    }
//    
//    
//
//    // Open form
//    @GetMapping("/add")
//    public String addForm(Model model) {
//        model.addAttribute("student", new StudentDto());
//        return "add";
//    }
//
//    // Handle form submit3
//    @PostMapping("/add")
//    public String save(@ModelAttribute StudentDto dto) {
//        service.save(dto);
//        return "redirect:/";
//    }
//    
//    @GetMapping("/den")
//    public String addFormm(Model model) {
//       // model.addAttribute("student", new StudentDto());
//        return "den";
//    }
//    @PostMapping("/aps")
//    public String savee(@ModelAttribute StudentDto dto) {
//       // service.save(dto);
//        return "redirect:/";
//    }
//
//    // Edit form
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Long id, Model model) {
//        model.addAttribute("student", service.get(id));
//        return "edit";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String update(@PathVariable Long id, @ModelAttribute StudentDto dto) {
//        service.update(id, dto);
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        service.delete(id);
//        return "redirect:/";
//    }
//} ___ ending_controller_for_jsp
