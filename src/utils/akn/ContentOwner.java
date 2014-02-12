package utils.akn;

import java.util.ArrayList;
import java.util.List;

public class ContentOwner {
	private String ownerid = "";
	private String ownername = "";
	
	
public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

public static List<ContentOwner> getOwnerList(){ 
		List<ContentOwner> list = new ArrayList<ContentOwner>();
		ContentOwner owner = null;
		owner = new ContentOwner();
		owner.setOwnerid("m3th");
		owner.setOwnername("m3th");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("acme");
		owner.setOwnername("acme");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("d-platinum");
		owner.setOwnername("platinum");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("ei");
		owner.setOwnername("ei games");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("fugumobile");
		owner.setOwnername("fugumobile");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("gx");
		owner.setOwnername("gx wireless");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("iec");
		owner.setOwnername("iec(debuzz)");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("inlogic");
		owner.setOwnername("inlogic");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("intersong");
		owner.setOwnername("intersong");
		list.add(owner);
		
		owner = new ContentOwner();
		owner.setOwnerid("moindy");
		owner.setOwnername("moindy");
		list.add(owner);
		owner = new ContentOwner();
		owner.setOwnerid("nmusic");
		owner.setOwnername("nmusic");
		list.add(owner);
		return list;
	}
	
	public static void main(String[] args) {
		List<ContentOwner> list = getOwnerList();
		for(int i = 0; i < list.size(); i++ ){
			System.out.println(list.get(i).getOwnerid());
			System.out.println(list.get(i).getOwnername());
			System.out.println("-------------------------");
		}
	}
}
