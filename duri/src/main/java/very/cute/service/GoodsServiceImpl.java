package very.cute.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import very.cute.domain.CartListVO;
import very.cute.domain.CartVO;
import very.cute.domain.GoodsVO;
import very.cute.mapper.GoodsMapper;
@Repository
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsMapper mapper;

	@Override
	public List<GoodsVO> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		mapper.addCart(cart);	
	}

	@Override
	public List<CartListVO> cartList(String userid) throws Exception{
		return mapper.cartList(userid);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		System.out.println("sesrvice CartVO"+cart);
		mapper.deleteCart(cart);
	}
}