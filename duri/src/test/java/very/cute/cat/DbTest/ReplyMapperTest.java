package very.cute.cat.DbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import very.cute.domain.ReplyVO;
import very.cute.mapper.ReplyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReplyMapper remapper;
	
//	@Test // ��� ���� �׽�Ʈ �Ϸ�
//	public void testCreate() throws Exception{
//		ReplyVO  vo = new ReplyVO();
////		�Խù� ��ȣ
//		vo.setBno(4);
////		�Խñ�
//		vo.setReplytext("��� ���� �׽�Ʈ");
////		�Խñ� �ۼ���
//		vo.setReplyer("������");
//		remapper.create(vo);
//	}
//	@Test // ��� ���� �׽�Ʈ �Ϸ�
//	public void testUpdate() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(2);
//		vo.setReplytext("��� ���� �Ϸ�");
//		remapper.update(vo);
//	}
//	@Test // ��� ���� �׽�Ʈ �Ϸ�
//	public void testDelete() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(3);
//		remapper.delete(vo);
//	}
}