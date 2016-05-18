package meituan.commons;

//分页
public class PageUtil {
	private int pageNo=1;
	private int pageSize=3;
	private int totalPages;	//总页数
	private int totalSize;	//总计数
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo<1){
			pageNo=1;
		}else{
			this.pageNo = pageNo;
		}
	}
	
	//下一页
	public int getNextPageNo(){
		int nextPageNo=1;
		if(this.pageNo<this.getTotalPages()){//如果当前页小于总页数
			nextPageNo=pageNo+1;
		}else{
			nextPageNo=this.getTotalPages();
		}
		return nextPageNo;
	}
	
	//上一页
	public int getProPage(){
		int proPageNo=1;
		if(pageNo>1){
			proPageNo=pageNo-1;
		}else{
			proPageNo=1;
		}
		return proPageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize<=0){
			pageSize=3;	//默认每页显示3条	
		}else{
			this.pageSize = pageSize;
		}
	}
	
	//总页数
	public int getTotalPages() {
		return this.getTotalSize() % this.getPageSize()==0 ? this.getTotalSize() / this.getPageSize() : this.getTotalSize() / this.getPageSize()+1;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		if(totalSize<0){
			totalSize=0;
		}else{
			this.totalSize = totalSize;
		}
	}
}
