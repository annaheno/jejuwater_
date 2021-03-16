package very.cute.cat.DbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import very.cute.domain.BoardVO;
import very.cute.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardMapperTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardMapper bomapper;
	
//	@Test //테스트 완료
//	public void testCreate() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setTitle("새로운 글 제목");
//		board.setContent("새로운 내용");
//		board.setWriter("한나");
//		bomapper.create(board);
//	}
	
//	@Test //테스트 완료
//	public void testRead() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		logger.info("제목을 클릭한 후 select="+bomapper.read(board));
//	}
	
//	@Test //테스트완료
//	public void testUpdate() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		
//		bomapper.update(board);
//	}
	
//	@Test // 테스트 완료
//	public void testDelete() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		bomapper.delete(board);
//	}
	
//	@Test //테스트 완료
//	public void testList() throws Exception{
//		bomapper.listAll().forEach(board->logger.info(" " +board));
//	}
}
