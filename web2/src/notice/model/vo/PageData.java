package notice.model.vo;

import java.util.ArrayList;

public class PageData {
	private ArrayList<Notice> noticelist;
	private String pageNavi;
	public ArrayList<Notice> getNoticelist() {
		return noticelist;
	}
	public void setNoticelist(ArrayList<Notice> noticelist) {
		this.noticelist = noticelist;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
