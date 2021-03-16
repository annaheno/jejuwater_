package very.cute.cat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import very.cute.domain.AttachFileDTO;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
//	@Resource(name = "uploadPath")
//	private String uploadPath;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "UploadForm", method = RequestMethod.GET)
	public void UploadForm() {
		logger.info("파일 업로드 화면");
	}

	@RequestMapping(value = "UploadForm", method = RequestMethod.POST)
	public void UploadForm(MultipartFile[] file) throws Exception {
		String uploadPath="C:\\Users\\imme0\\hann\\";
		for (MultipartFile multipartFile : file) { 
			
			logger.info("파일 명 : " + multipartFile.getOriginalFilename());
			logger.info("파일 크기 : " + multipartFile.getSize());
			logger.info("파일 종류 : " + multipartFile.getContentType());
			logger.info("파일 저장 위치 : " + uploadPath);

			File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	}
	
//	년 월 일 폴더 생성하는 getFolder() 메소드
//	년월일(날짜), 오늘 날짜를 어떻게 구할 것 인지?
	private String getFolder() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date(); // 오늘 날짜를 date 변수에 저장
	String str = sdf.format(date);
	System.out.println("오늘 날짜 : = " + str);
	return str.replace("-", File.separator);
	}
	
	// 이미지 파일을 판단할 수 있게 해주는 메소드
	private boolean checkImageType(File file) {
		try {
		String contentType=Files.probeContentType(file.toPath());
		return contentType.startsWith("image");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("파일 업로드 ajax 화면");
	}
	@ResponseBody
	@RequestMapping(value="uploadAjax",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] file) throws Exception{
		logger.info("파일 업로드 ajax로 처리");
		String uploadPath="C:\\Users\\imme0\\hann\\";
	
		// AttachFileDTO클래스를 배열로 생성하여 list 배열로 생성
		List<AttachFileDTO> list = new ArrayList<>();
		
		// '안녕','hi','java' = List<String> list = new ArrayList<>();
		// '1','2','3' = List<Integer> list = new ArrayList<>();
		// 'AttachFileDTO','AttachFileDTO','AttachFileDTO' = List<AttachFileDTO> list = new ArrayList<>();
		
		File uploadFolder = new File(uploadPath, getFolder());
		logger.info("파일 업로드 폴더 "+uploadFolder);
		
//			년 월일 폴더 만들기
//			exists() 메소드를 활용하여 생성하고자 하는 폴더가 존재하지 않으묜 폴더를 만들어라
		if(uploadFolder.exists()==false) {
			uploadFolder.mkdirs();
		} // make yyyy\\MM\\dd folder
		
		for (MultipartFile multipartFile : file) { // 저장할 이미지가 3개이니 attach도 3개가 되어야하고 for문으로 반복해줌
			logger.info("파일 명 : " + multipartFile.getOriginalFilename());
			logger.info("파일 크기 : " + multipartFile.getSize());
			logger.info("파일 종류 : " + multipartFile.getContentType());
//			logger.info("파일 저장 위치 : " + uploadPath);
			
			AttachFileDTO attach = new AttachFileDTO();
			
			String fileName = multipartFile.getOriginalFilename(); // fileName
			attach.setFileName(fileName); // = 000.jpg
			
			String uploadFileName=multipartFile.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+uploadFileName;

			try {
//			그냥 파일 저장							
				File saveFile = new File(uploadFolder,uploadFileName); //파일업로드 경로
				multipartFile.transferTo(saveFile); // transferTo 폴더에 파일을 저장
				System.out.println("getFolder()="+getFolder());
				attach.setUploadPath(getFolder());
				attach.setUuid(uuid.toString()); // AttachFileDTO 클래스에 UUID 변수에 UUID 저장
				
				// 파일 저장할 때 이미지 파일이면 썸네일 만들어서 저장
				if(checkImageType(saveFile)) {
					
					// 업로드 된 파일이 이미지라는 뜻
					attach.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"th_"+uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,300,300);
					thumbnail.close();
				}
				
				list.add(attach);
				logger.info("list="+list);
			} catch (Exception e) {
				logger.info(e.getMessage());
	}
		}
		return new ResponseEntity<> (list,HttpStatus.OK);
//		return new ResponseEntity<String> ("SUCCESS",HttpStatus.OK);
}
	// display (업로드 파일이 이미지)
	@RequestMapping(value="display",method=RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		logger.info("fileName : "+fileName);
		File file = new File("C:\\Users\\imme0\\hann\\"+fileName);
		logger.info("file = " + file);
		ResponseEntity<byte[]> result=null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result=new ResponseEntity<> (FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	// download (업로드 파일이 이미지가 아닌 것)
	@RequestMapping(value="download",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_OCTET_STREAM_VALUE) // 다운로드용
	public ResponseEntity<Resource> downloadFile(String fileName){
		logger.info("download file : " + fileName);
		
		Resource resource = new FileSystemResource("C:\\Users\\imme0\\hann\\"+fileName);
		logger.info("resource : "+resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Diposition","attachment; filename="+new String(resourceName.getBytes("UTF-8")
					,"ISO-8859-1"));
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return new ResponseEntity<Resource> (resource, header, HttpStatus.OK);
		
	} // download 끝
	
//	 파일 삭제 시작
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName, String type){
		logger.info("fileName="+fileName);
		logger.info("type="+type);
		
		File file;
		
		try {
			file = new File("C:\\Users\\imme0\\hann\\"+URLDecoder.decode(fileName,"UTF-8"));
//			file = C:\Users\imme0\hann\2020\08\27\70bb1b11-7f91-4a7b-9d24-a780ebda4b31_clip.png
			file.delete();
			if(type.equals("image")) {
				String OriginalFile=file.getAbsolutePath().replace("th_", "");
				// replace : 문자열 변경 ex) ("han","na") > han에서 na로 변경
				file = new File(OriginalFile);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	return new ResponseEntity<>("deleted", HttpStatus.OK);
	}
// 파일 삭제 끝
}