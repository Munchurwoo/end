package join.us.GoodJob.model.vo;

import java.util.List;

import join.us.GoodJob.model.service.PagingBean;

public class PostListVO {
	//페이징 처리
	private PagingBean pagingBean;
	
	//기업정보 게시물 리스트 
	private List<MemberVO> cmvoList;

	public PostListVO() {
		super();
	}

	public PostListVO(PagingBean pagingBean, List<MemberVO> cmvoList) {
		super();
		this.pagingBean = pagingBean;
		this.cmvoList = cmvoList;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	public List<MemberVO> getCmvoList() {
		return cmvoList;
	}

	public void setCmvoList(List<MemberVO> cmvoList) {
		this.cmvoList = cmvoList;
	}

	@Override
	public String toString() {
		return "PostListVO [pagingBean=" + pagingBean + ", cmvoList=" + cmvoList + "]";
	}
	
	

}
