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
	
	//normal 회원 리스트 <다 가지고 올 필요없어서 normal id 값만 불러옴 
	private List<NormalMemberVO> nmList;
	public PostListVO() {
		super();
	}
	public PostListVO(PagingBean pagingBean, List<MemberVO> cmvoList, List<CompanyMemberVO> jobPostingList,
			List<NormalMemberVO> nmList) {
		super();
		this.pagingBean = pagingBean;
		this.cmvoList = cmvoList;
		this.jobPostingList = jobPostingList;
		this.nmList = nmList;
	}
	@Override
	public String toString() {
		return "PostListVO [pagingBean=" + pagingBean + ", cmvoList=" + cmvoList + ", jobPostingList=" + jobPostingList
				+ ", nmList=" + nmList + "]";
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
	public List<NormalMemberVO> getNmList() {
		return nmList;
	}
	public void setNmList(List<NormalMemberVO> nmList) {
		this.nmList = nmList;
	}
}
