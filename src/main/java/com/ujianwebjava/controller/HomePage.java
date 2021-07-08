package com.ujianwebjava.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ujianwebjava.entity.CuriculumVitaeModel;
import com.ujianwebjava.interfaces.CuriculumVitaeRepository;
import com.ujianwebjava.util.FileUploadUtil;

@Controller
public class HomePage {
	
	@Autowired
	CuriculumVitaeRepository curiculumVitaeRepo;
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		model.addAttribute("curiculumvitaemodel" , new CuriculumVitaeModel());
	
		return "index.html";
	}
	
	@PostMapping("/curiculumvitae/add")
	public String addCuriculumVitae(@RequestParam("fullname")String fullname,@RequestParam("email")String email,@RequestParam("favouriteplatform")String favouriteplatform,
							 @RequestParam("curiculumvitae") MultipartFile file,Model model) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		CuriculumVitaeModel curiculumVitaeModel = new CuriculumVitaeModel(0,fullname,email,favouriteplatform,fileName);
		curiculumVitaeModel.setCuriculumvitae(fileName);
		this.curiculumVitaeRepo.save(curiculumVitaeModel);
		
		String uploadDir = "c:/cvupload/"+fileName;
		try {
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return "redirect:/";
	}
}
