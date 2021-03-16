package very.cute.domain;

import java.util.List;

public class ReplyPageVO {
	
	private List<ReplyVO> list;
	private int replyCnt;
	
	public ReplyPageVO(List<ReplyVO> list, int replyCnt) {
		this.list = list;
		this.replyCnt = replyCnt;
	}
	
	public List<ReplyVO> getList() {
		return list;
	}
	public void setList(List<ReplyVO> list) {
		this.list = list;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
}