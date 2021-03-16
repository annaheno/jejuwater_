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
		logger.info("���� ���ε� ȭ��");
	}

	@RequestMapping(value = "UploadForm", method = RequestMethod.POST)
	public void UploadForm(MultipartFile[] file) throws Exception {
		String uploadPath="C:\\Users\\imme0\\hann\\";
		for (MultipartFile multipartFile : file) { 
			
			logger.info("���� �� : " + multipartFile.getOriginalFilename());
			logger.info("���� ũ�� : " + multipartFile.getSize());
			logger.info("���� ���� : " + multipartFile.getContentType());
			logger.info("���� ���� ��ġ : " + uploadPath);

			File saveFile = new File(uploadPath, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	}
	
//	�� �� �� ���� �����ϴ� getFolder() �޼ҵ�
//	�����(��¥), ���� ��¥�� ��� ���� �� ����?
	private String getFolder() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date(); // ���� ��¥�� date ������ ����
	String str = sdf.format(date);
	System.out.println("���� ��¥ : = " + str);
	return str.replace("-", File.separator);
	}
	
	// �̹��� ������ �Ǵ��� �� �ְ� ���ִ� �޼ҵ�
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
		logger.info("���� ���ε� ajax ȭ��");
	}
	@ResponseBody
	@RequestMapping(value="uploadAjax",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] file) throws Exception{
		logger.info("���� ���ε� ajax�� ó��");
		String uploadPath="C:\\Users\\imme0\\hann\\";
	
		// AttachFileDTOŬ������ �迭�� �����Ͽ� list �迭�� ����
		List<AttachFileDTO> list = new ArrayList<>();
		
		// '�ȳ�','hi','java' = List<String> list = new ArrayList<>();
		// '1','2','3' = List<Integer> list = new ArrayList<>();
		// 'AttachFileDTO','AttachFileDTO','AttachFileDTO' = List<AttachFileDTO> list = new ArrayList<>();
		
		File uploadFolder = new File(uploadPath, getFolder());
		logger.info("���� ���ε� ���� "+uploadFolder);
		
//			�� ���� ���� �����
//			exists() �޼ҵ带 Ȱ���Ͽ� �����ϰ��� �ϴ� ������ �������� ������ ������ ������
		if(uploadFolder.exists()==false) {
			uploadFolder.mkdirs();
		} // make yyyy\\MM\\dd folder
		
		for (MultipartFile multipartFile : file) { // ������ �̹����� 3���̴� attach�� 3���� �Ǿ���ϰ� for������ �ݺ�����
			logger.info("���� �� : " + multipartFile.getOriginalFilename());
			logger.info("���� ũ�� : " + multipartFile.getSize());
			logger.info("���� ���� : " + multipartFile.getContentType());
//			logger.info("���� ���� ��ġ : " + uploadPath);
			
			AttachFileDTO attach = new AttachFileDTO();
			
			String fileName = multipartFile.getOriginalFilename(); // fileName
			attach.setFileName(fileName); // = 000.jpg
			
			String uploadFileName=multipartFile.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+uploadFileName;

			try {
//			�׳� ���� ����							
				File saveFile = new File(uploadFolder,uploadFileName); //���Ͼ��ε� ���
				multipartFile.transferTo(saveFile); // transferTo ������ ������ ����
				System.out.println("getFolder()="+getFolder());
				attach.setUploadPath(getFolder());
				attach.setUuid(uuid.toString()); // AttachFileDTO Ŭ������ UUID ������ UUID ����
				
				// ���� ������ �� �̹��� �����̸� ����� ���� ����
				if(checkImageType(saveFile)) {
					
					// ���ε� �� ������ �̹������ ��
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
	// display (���ε� ������ �̹���)
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
	// download (���ε� ������ �̹����� �ƴ� ��)
	@RequestMapping(value="download",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_OCTET_STREAM_VALUE) // �ٿ�ε��
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
		
	} // download ��
	
//	 ���� ���� ����
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
				// replace : ���ڿ� ���� ex) ("han","na") > han���� na�� ����
				file = new File(OriginalFile);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	return new ResponseEntity<>("deleted", HttpStatus.OK);
	}
// ���� ���� ��
}