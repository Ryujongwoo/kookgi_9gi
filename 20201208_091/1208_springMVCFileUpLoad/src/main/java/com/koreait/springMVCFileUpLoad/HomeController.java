package com.koreait.springMVCFileUpLoad;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/fileUploadTest")
	public String fileUploadTest(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 fileUploadTest() 메소드 실행");
		return "fileUploadTest";
	}
	
	@RequestMapping("/fileUploadResult")
//	폼의 enctype 속성이 multipart/form-data일 경우 HttpServletRequest 인터페이스 객체가 아니라 MultipartHttpServletRequest 인터페이스 객체로
//	받는다.
	public String fileUploadResult(MultipartHttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 fileUploadResult() 메소드 실행");
		
//		업로드 하는 파일이 저장될 업로드 디렉토리를 지정한다.
//		System.out.println(File.separator);
		String rootUploadDir = "C:" + File.separator + "Upload";			// C:/Upload
		File dir = new File(rootUploadDir + File.separator + "testfile");	// C:/Upload/testfile
		
//		업로드 디렉토리가 존재하지 않을 경우 업로드 디렉토리를 만든다.
//		File 클래스 객체 dir에 디렉토리가 존재하지 않을 경우 mkdirs() 메소드로 디렉토리를 만든다.
		if (!dir.exists()) { 
			dir.mkdirs();
		}
		
//		업로드 되는 파일 정보 수집(2개 : file1, file2)
		Iterator<String> iterator = request.getFileNames();
		String uploadFileName = "";
		MultipartFile multipartFile = null;
		String orgFileName = "";		// 원래 파일명
		ArrayList<String> list = new ArrayList<String>();
		
		while (iterator.hasNext()) {
			uploadFileName = iterator.next();
			multipartFile = request.getFile(uploadFileName);
			orgFileName = multipartFile.getOriginalFilename();
			System.out.println(orgFileName);
			
			if (orgFileName != null && orgFileName.length() != 0) {
				try {
//					MultipartFile 인터페이스 객체에서 transferTo() 메소드로 파일을 File 객체를 만들어 업로드 한다.
					multipartFile.transferTo(new File(dir + File.separator + orgFileName));		// C:/Upload/testfile/orgFileName
					System.out.println("원본 파일명 : " + orgFileName);
					list.add("원본 파일명 : " + orgFileName);
				} catch (Exception e) {
					e.printStackTrace();
					list.add("파일 업로드 중 에러 발생!!!");
				}
			}
		}
		
		model.addAttribute("list", list);
		return "fileResult";
	}
	
}
















