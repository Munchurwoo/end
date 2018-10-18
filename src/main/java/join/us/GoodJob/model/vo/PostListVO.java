package join.us.GoodJob.model.vo;

import java.util.List;

import join.us.GoodJob.model.service.PagingBean;

//게시물 페이징 처리를 위한 클래스
public class PostListVO {
	//페이징 처리
	private PagingBean pagingBean;
	
	//기업정보 게시물 리스트 
	private List<MemberVO> cmvoList;
	
	//구인공고 게시물 리스트
	private List<CompanyMemberVO> jobPostingList;

	public PostListVO() {
		super();
	}

	public PostListVO(PagingBean pagingBean, List<MemberVO> cmvoList, List<CompanyMemberVO> jobPostingList) {
		super();
		this.pagingBean = pagingBean;
		this.cmvoList = cmvoList;
		this.jobPostingList = jobPostingList;
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

	public List<CompanyMemberVO> getJobPostingList() {
		return jobPostingList;
	}

	public void setJobPostingList(List<CompanyMemberVO> jobPostingList) {
		this.jobPostingList = jobPostingList;
	}

	@Override
	public String toString() {
		return "PostListVO [pagingBean=" + pagingBean + ", cmvoList=" + cmvoList + ", jobPostingList=" + jobPostingList
				+ "]";
	}
	
	
	

}
