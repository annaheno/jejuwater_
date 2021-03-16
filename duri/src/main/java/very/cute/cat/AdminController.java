package very.cute.cat;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import very.cute.domain.AdminVO;
import very.cute.service.AdminService;

@Controller
@RequestMapping(value="/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
//	������ ȭ��
	@RequestMapping(value="index", method=RequestMethod.GET)
	public void indexGet() throws Exception{
		logger.info("������ ������");
	}
	
//	���� ��� ȭ��
	@RequestMapping(value="noticewrite",method=RequestMethod.GET)
	public void noticeGet() throws Exception{
		logger.info("���� ��� ȭ��");
	}
	
//	���� ���
	@RequestMapping(value="noticewrite",method=RequestMethod.POST)
	public String noticePost(AdminVO vo) throws Exception{
		logger.info("���� ���");
		service.register(vo);
		return "redirect:/admin/index";
		
	}
//	���� ���
	@RequestMapping(value= {"notice","noticelist"},method=RequestMethod.GET)
	public void getNotice(Model model) throws Exception{
		logger.info("���� ���");
		List <AdminVO> list = service.list();
		model.addAttribute("list",list);
	}
	
//	���� ��ȸ
	@RequestMapping(value="noticeread", method=RequestMethod.GET)
	public void noticeread(AdminVO notice, Model model) throws Exception{
		model.addAttribute("read",service.read(notice));
		logger.info("���� ��ȸ"+notice);
	}
//	���� ���� ȭ��
	@RequestMapping(value="noticemodify",method=RequestMethod.GET)
	public void getModify(AdminVO notice,Model model) throws Exception{
		model.addAttribute("modify",service.read(notice));
		logger.info("���� ����"+notice);		
	}
//	���� ����
	@RequestMapping(value="noticemodify",method=RequestMethod.POST)
	public String postModify(AdminVO notice, Model model) throws Exception{
		service.modify(notice);
		model.addAttribute(notice);
		logger.info("���� ���� �Ϸ�");
		return "redirect:/admin/notice";
	}
//	���� ����
	@RequestMapping(value="noticedelete",method=RequestMethod.POST)
	public String postDelete(AdminVO notice)throws Exception{
		logger.info("���� ����");
		service.delete(notice);
		return "redirect:/admin/notice";
	}

}
