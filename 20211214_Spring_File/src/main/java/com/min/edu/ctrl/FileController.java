package com.min.edu.ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.min.edu.dtos.UploadFile;
import com.min.edu.validator.FileValidator;

@Controller
public class FileController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FileValidator fileValidator;
	
	@GetMapping(value = "/home.do")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/uploadForm.do", method = RequestMethod.GET)
	public String uploadForm() {
		logger.info("파일 업로드 폼으로 이동");
		return "uploadForm";
	}
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request,
							Model model, UploadFile uploadFile, BindingResult result) {
		fileValidator.validate(uploadFile, result);
		//BindingResult는 요청 화면의 <form:form의 객체를 바인딩한 후에 에러가 발생하면 해당 정보를 받는 객체 
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		//파일을 받아 옴
		MultipartFile file = uploadFile.getFile();
		System.out.println("*****"+file);
		
		String fileName = file.getOriginalFilename();
		System.out.println("*****"+fileName);
		
		//정보를 담아 줌 => DataBase에 저장된 DTO 한개
		UploadFile fileObj = new UploadFile();
		fileObj.setFilename(fileName);
		fileObj.setDesc(uploadFile.getDesc());
		
		//물리적인 파일을 저장
		//파일을 서버(절대경로/상대경로) IO로 업로드
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String path = null;
		try {
			//파일을 읽음
			inputStream = file.getInputStream();
			//저장위치를 만듦
			//상대경로
			path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			//절대경로 : 
//			path = "C:\\eclipse\\workspace2\\20211214_Spring_File\\src\\main\\webapp\\storage";
			System.out.println("*****" + request.getSession().getServletContext());
			System.out.println("***** 실제 업로드될 경로" + path);
			
			//만약 저장위치가 없다면
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			//저장할 파일이 없다면 만들어주고 override 함
			File newfile = new File(path+"/"+fileName);
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			//파일을 쓸 위치를 지정해줌
			outputStream = new FileOutputStream(newfile);
			
			//파일을 써줌 
			int read = 0;
			byte[] n = new byte[(int)file.getSize()];
			while((read = inputStream.read(n)) != -1) {
				outputStream.write(n, 0, read);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileObj", fileObj);
		model.addAttribute("path", path);
		return "uploadFile";
	}
	
	@RequestMapping(value = "/download.do", method = RequestMethod.POST)
	@ResponseBody
	public byte[] downLoad(HttpServletRequest request, // 상대경로를 나타냄
						   HttpServletResponse response, //헤더정보 입력
						   String filename) throws IOException {  //파일명
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		File file = new File(path+"/"+filename);
		
		//복제해서 넘겨줌
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		//파일명을 인코딩
		String outFileName = new String(file.getName().getBytes(), "8859_1");
		
		//브라우저에서 해당 파일을 페이지가 아닌 파일로 전송받기 위한 Header 정보 전송타입을 선언(ContentType)
		response.setHeader("Content-Disposition", "attachment; filename=\""+outFileName+"\"");
		response.setContentLength(bytes.length);
		response.setContentType("application/octet-stream");
		return bytes;
	}
	
}
