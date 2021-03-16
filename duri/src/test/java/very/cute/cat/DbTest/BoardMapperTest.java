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
	
//	@Test //�׽�Ʈ �Ϸ�
//	public void testCreate() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setTitle("���ο� �� ����");
//		board.setContent("���ο� ����");
//		board.setWriter("�ѳ�");
//		bomapper.create(board);
//	}
	
//	@Test //�׽�Ʈ �Ϸ�
//	public void testRead() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		logger.info("������ Ŭ���� �� select="+bomapper.read(board));
//	}
	
//	@Test //�׽�Ʈ�Ϸ�
//	public void testUpdate() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		board.setTitle("������ ����");
//		board.setContent("������ ����");
//		
//		bomapper.update(board);
//	}
	
//	@Test // �׽�Ʈ �Ϸ�
//	public void testDelete() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(2);
//		bomapper.delete(board);
//	}
	
//	@Test //�׽�Ʈ �Ϸ�
//	public void testList() throws Exception{
//		bomapper.listAll().forEach(board->logger.info(" " +board));
//	}
}
