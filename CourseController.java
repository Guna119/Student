
package com.example.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentManagement.Domain.Course;
import com.example.studentManagement.Service.CourseService;

@Controller
public class CourseController {
	
    @Autowired
	private CourseService service;
	
	// handler method to handle list students and return mode and view
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Course> listcourse = service.listAll();
		model.addAttribute("listcourse", listcourse);
		System.out.println("Get /");
		return "course";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		List<Course> listcourse = service.listAll();
	 	model.addAttribute("listcourse", listcourse);
		model.addAttribute("course", new Course());
		System.out.println("Get /");
		return "addcourse";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) {
		service.save(course);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Course course = service.get(id);
		mav.addObject("course",course);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteCoursePage(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
