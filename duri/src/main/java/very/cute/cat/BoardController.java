package very.cute.cat;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import very.cute.domain.BoardAttachVO;
import very.cute.domain.BoardVO;
import very.cute.domain.Criteria;
import very.cute.domain.PageDTO;
import very.cute.service.BoardService;


@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
// 글쓰기 화면 폼
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get..............................................");
	}

	// 글쓰기
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, Model model) throws Exception {
		logger.info("register post..............................................");
		
		logger.info("BoardVO에 저장되어있는값 : " + vo);
		service.create(vo);
		model.addAttribute("result", "success");

		return "redirect:/board/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model, Criteria cri) throws Exception {
		logger.info("list get..............................................  ");
//		model.addAttribute("list", service.listAll());
		model.addAttribute("list", service.listPage(cri));
		model.addAttribute("pageMaker",new PageDTO(cri,service.getTotalCount(cri)));
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO board, Model model, @ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("read get.............................................." + board);
		model.addAttribute("read", service.read(board));
	}
//	 수정 화면 이동을 위한 것
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO board, @ModelAttribute("cri") Criteria cri,  Model model) throws Exception{
		logger.info("modify get..............................................");
		model.addAttribute("modify",service.read(board));
	}
//	실제로 수정이 이루어지는 곳
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board, Model model, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("modify post..............................................");
		service.update(board);
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public String removePost(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("remove post...................");
		service.delete(board);
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addFlashAttribute("msg", "DSUCCESS");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="getAttachList", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(int bno) throws Exception{
		logger.info("getAttachList"+bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	@RequestMapping("qna")
	public void qnaView() throws Exception{
		logger.info("Q&A view");
	}
}