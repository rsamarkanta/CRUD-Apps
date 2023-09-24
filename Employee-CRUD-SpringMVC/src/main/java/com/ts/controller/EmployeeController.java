package com.ts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ts.entity.Employee;
import com.ts.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	IEmployeeMgmtService empService;// will inject dao from XML file

	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}

	@GetMapping("/empform")
	public String showform(@ModelAttribute("emp") Employee emp) {
		return "empform";
	}

	@PostMapping("/empform")
	public String save(@ModelAttribute("emp") Employee emp) {
		empService.save(emp);
		return "redirect:/viewemp";// will redirect to viewemp request mapping
	}

	@GetMapping("/viewemp")
	public String viewemp(Map<String, Object> map) {
		List<Employee> empsList = empService.getEmployees();
		map.put("empsList", empsList);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = empService.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}

	@PostMapping("/editsave")
	public String editsave(@ModelAttribute("emp") Employee emp) {
		System.out.println(emp+"-----"+emp.getId());
		empService.update(emp, emp.getId());
		return "redirect:/viewemp";
	}

	@GetMapping("/deleteemp/{id}")
	public String delete(@PathVariable int id) {
		empService.delete(id);
		return "redirect:/viewemp";
	}
}
