package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.dto.Note;
import com.example.demo.service.DevService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/dev")
public class DevController {
	private static final Logger log = LogManager.getLogger(DevController.class);
	
	@Autowired
	DevService devService;
		
	@RequestMapping("/")
	public String Main(Model model) {
		System.out.println("Main");
		log.debug("Main");
		return "index";
	}
	
	@RequestMapping("note_list")
	public String List(Model model) {
		System.out.println("test");
		List<Note> list = new ArrayList();
		list = devService.getAllNoteList();
		log.info("list : ",list);
		model.addAttribute("list", list); 
		
		return "dev/note_list";
	}
	
	@RequestMapping("note_form")
	public String devForm(@RequestParam("cmd") String cmd
			, HttpServletRequest req, Model model) {
		if ("update".equals(cmd) && null != req.getParameter("no")) {
			int no = Integer.parseInt(req.getParameter("no"));
			System.out.println("update no : "+no);
			Note note = devService.getNote(no);
			model.addAttribute("note", note);
		}
		return "dev/note_form";
	}
	
	@RequestMapping("insert_proc")
	public String insertProc(HttpServletRequest req) {
		String title   = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		Note note = new Note();
		note.setTitle(title);
		note.setContent(content);
		
		devService.insertNote(note);
		
		return "redirect:note_list";
	}
	
	@RequestMapping("update_proc")
	public String updateProc(HttpServletRequest req) {
		int no 		   =  Integer.parseInt(req.getParameter("no"));
		String title   = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		System.out.println("no : "+no);
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		Note note = new Note();
		note.setNo(no);
		note.setTitle(title);
		note.setContent(content);
		
		devService.updateNote(note);
		
		return "redirect:/dev/note_list";
	}
	
	@RequestMapping("del_proc")
	public void deleteProc(HttpServletRequest req) {
		String[] nos = req.getParameterValues("nos");
		System.out.println("nos : "+nos.length);
		for (String no : nos) {
			System.out.println("no : "+no);
		}
	}
	
	@RequestMapping("detail")
	public String detail(@RequestParam("no") int no, Model model) {
		System.out.println("detail no : "+no);
		Note note = devService.getNote(no);
		model.addAttribute("note", note);
		return "dev/detail";
	}	
	
}
