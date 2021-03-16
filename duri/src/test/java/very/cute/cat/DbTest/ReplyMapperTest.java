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
	
//	@Test // 댓글 쓰기 테스트 완료
//	public void testCreate() throws Exception{
//		ReplyVO  vo = new ReplyVO();
////		게시물 번호
//		vo.setBno(4);
////		게시글
//		vo.setReplytext("댓글 내용 테스트");
////		게시글 작석장
//		vo.setReplyer("관리자");
//		remapper.create(vo);
//	}
//	@Test // 댓글 수정 테스트 완료
//	public void testUpdate() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(2);
//		vo.setReplytext("댓글 수정 완료");
//		remapper.update(vo);
//	}
//	@Test // 댓글 삭제 테스트 완료
//	public void testDelete() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(3);
//		remapper.delete(vo);
//	}
}