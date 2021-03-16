package very.cute.cat;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import very.cute.domain.CartListVO;
import very.cute.domain.CartVO;
import very.cute.domain.MemberVO;
import very.cute.service.GoodsService;

@Controller
@RequestMapping(value="/*")
public class GoodsController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService service;
	@RequestMapping("intro")
	public void introView() throws Exception{
		logger.info("intro View");
	}
	
	@RequestMapping("item")
	public ModelAndView list(ModelAndView mav) throws Exception {
		mav.setViewName("/item");
		mav.addObject("list", service.list());
		return mav;
	}
	
	@RequestMapping("heavybuying")
	public void heavybuyingview() throws Exception{
		logger.info("heavy buying view");
	}
//	카트 담기
	@ResponseBody
	@RequestMapping(value="/item",method=RequestMethod.POST)
	public void addCart(CartVO cart, HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("login");
		cart.setUserid(member.getUserid());
		service.addCart(cart);
		}
	
//	카트 리스트
	@RequestMapping(value="/member/mypage",method=RequestMethod.GET)
	public void getCartList (CartListVO cart,HttpSession session, Model model) throws Exception{
		logger.info("get cart list");
		MemberVO member = (MemberVO)session.getAttribute("login");
		if(member != null) {
			String userid = member.getUserid();
			//List<CartListVO> cartList = service.cartList(userid);
			model.addAttribute("cartList",service.cartList(userid));
			logger.info(""+service.cartList(userid));
		}
	}
//	카트 삭제
	@ResponseBody
	@RequestMapping(value="deleteCart",method=RequestMethod.POST)
	public int deleteCart(HttpSession session, CartVO cart) throws Exception{
	//public void deleteCart(HttpSession session, CartVO cart) throws Exception{
		logger.info("카트 삭제");
		
		
		MemberVO member = (MemberVO)session.getAttribute("login");
		
		int result = 0;

		if(member != null) {  // 로그인 되었으면,
			cart.setUserid(member.getUserid());
				service.deleteCart(cart);	// 삭제해라~
			result = 1;
		}
		return result;
		
	}
	
}