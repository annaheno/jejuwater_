package very.cute.mapper;

import java.util.List;

import very.cute.domain.CartListVO;
import very.cute.domain.CartVO;
import very.cute.domain.GoodsVO;

public interface GoodsMapper {
	
	public List<GoodsVO> list() throws Exception;
	
	public void addCart(CartVO cart) throws Exception;
	
	public List<CartListVO> cartList(String userid) throws Exception;
	
	public void deleteCart(CartVO cart) throws Exception;


}
