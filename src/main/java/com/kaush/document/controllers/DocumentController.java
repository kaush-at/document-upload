package com.kaush.document.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.kaush.document.entities.Document;
import com.kaush.document.repos.DocumentRepository;

@Controller
public class DocumentController {

	@Autowired
	DocumentRepository repository;
	
	@RequestMapping("/displayUpload")
	public String displayUpload(ModelMap modelMap) {
		
		List<Document> documents = repository.findAll();  
		modelMap.addAttribute("documents", documents);
		
		return "documentUpload";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile, @RequestParam("id") long id, ModelMap modelMap) { 
		
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		try {
			document.setData(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		repository.save(document);
		
		List<Document> documents = repository.findAll();
		modelMap.addAttribute("documents", documents);
		
		return "documentUpload";
	}
	
	
	@RequestMapping("/download")
	public StreamingResponseBody downloadDocument(@RequestParam("id") long documentId, HttpServletResponse response) {

		System.out.println("documentId-----------------"+ documentId);
		Document document = repository.findById(documentId).get();
		byte[] data = document.getData();
		
		response.setHeader("Content-Disposition", "attachment;filename=downloaded.jpeg");  // this Content-Disposition tells to the web browser that attachement is comming in
		
		return outputStream -> {
			outputStream.write(data);
		};
	}
	
	
	
}
