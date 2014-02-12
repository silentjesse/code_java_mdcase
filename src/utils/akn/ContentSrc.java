package utils.akn;

import java.util.ArrayList;
import java.util.List;

public class ContentSrc {
	private String src = "";
	private String srcremark = "";
	public void setSrc(String src) {
		this.src = src;
	}

	public void setSrcremark(String srcremark) {
		this.srcremark = srcremark;
	}

	public String getSrc() {
		return src;
	}
	 
	public String getSrcremark() {
		return srcremark;
	}
	 
	
	
	public static List<ContentSrc> getContentSrcList(){
		
		List<ContentSrc> list = new ArrayList<ContentSrc>();
		ContentSrc src = new ContentSrc();
		src.setSrc("new");
		src.setSrcremark("from new content");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("latest");
		src.setSrcremark("from latest cslno downcount report");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("latestes");
		src.setSrcremark("from the report page use to compare the downcount with latest cslnos");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("medias");
		src.setSrcremark("from the report page use to compare the downcount with a few mediacodes");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("period");
		src.setSrcremark("from the report page use to compare the down count in one peroid");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("copy");
		src.setSrcremark("from the page use to copy content from other cslno");
		list.add(src);
		src = new ContentSrc();
		src.setSrc("prev");
		src.setSrcremark("this content belong to previous journal");
		list.add(src);
		
		return list;
	}
	
	public static void main(String[] args) {
		List<ContentSrc> list = getContentSrcList();
		for(int i = 0; i < list.size(); i++ ){
			System.out.println(list.get(i).getSrc());
			System.out.println(list.get(i).getSrcremark());
			System.out.println("-------------------------");
		}
	}
}
