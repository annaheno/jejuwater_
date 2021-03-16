package very.cute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import very.cute.domain.AdminVO;
import very.cute.mapper.AdminMapper;

@Repository
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper mapper;
	
	@Transactional
	@Override
	public void register(AdminVO vo) throws Exception {
		mapper.register(vo);
	}

	@Override
	public List<AdminVO> list() throws Exception {
		return mapper.list();
	}

	@Transactional
	@Override
	public AdminVO read(AdminVO vo) throws Exception {
		return mapper.read(vo);
	}

	@Override
	public void modify(AdminVO notice) throws Exception {
		mapper.modify(notice);
		System.out.println(notice+"¼­ºñ½º");
	}

	@Override
	public void delete(AdminVO notice) throws Exception {
		mapper.delete(notice);
	}

}
