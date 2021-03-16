package very.cute.cat.DbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import very.cute.domain.MemberVO;
import very.cute.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class MemberTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberMapper mmapper;
	
//	@Test
//	public void testInsertMember() {
//		MemberVO member = new MemberVO();
//		member.setUserid("duri");
//		member.setUserpw("1234");
//		member.setUsername("µÎ·ò");
//		member.setEmail("duri@na.na");
//		
//		mmapper.createMember(member);
//		
//	}
	
//	}
	

}
