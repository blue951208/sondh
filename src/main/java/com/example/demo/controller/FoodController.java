package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.model.dto.Note;
import com.example.demo.service.DevService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/food")
public class FoodController {
	@Autowired
	DevService devService;
		
	private String path = "D:\\dev\\work\\sondh\\src\\main\\webapp\\image";
	
	@RequestMapping("/food_list")
	public String Main(Model model) {
		System.out.println("Food");
		return "food/food_list";
	}
		
	@RequestMapping("/insert")
	public String Insert() {
		return "food/food_form";
	}
	
	@RequestMapping("/insert_proc")
	public String InsertProc(MultipartHttpServletRequest req) {
		System.out.println("img : "+req.getFile("img"));
		MultipartFile file = req.getFile("img");
		String uploadPath = "";
		String name = file.getOriginalFilename();
		uploadPath = path + name;
		System.out.println("uploadPath : "+ uploadPath);
		
		try {
			file.transferTo(new File(uploadPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:insert";
	}
}
