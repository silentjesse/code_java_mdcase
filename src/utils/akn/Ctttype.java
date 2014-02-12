package utils.akn;

import java.util.ArrayList;
import java.util.List;

public class Ctttype {
	String shortName = "";
	String cnName = "";
	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @param shortName
	 * @return
	 */
	public static String getFullName(String shortName){
		String fullName = "";
		if(shortName.equalsIgnoreCase("THM")){
			fullName = "theme";
		}else if(shortName.equalsIgnoreCase("RNG")){
			fullName = "ring";
		}else if(shortName.equalsIgnoreCase("WPP")){
			fullName = "wallpaper";
		}else if(shortName.equalsIgnoreCase("GMS") || shortName.equalsIgnoreCase("GAM")){
			fullName = "game";
		}else if(shortName.equalsIgnoreCase("EBK")){
			fullName = "ebook";
		}else if(shortName.equalsIgnoreCase("VDO")){
			fullName = "video";
		}else if(shortName.equalsIgnoreCase("SCR")){
			fullName = "screensaver";
		}else if(shortName.equalsIgnoreCase("PAK")){
			fullName = "package" ;
		}else if(shortName.equalsIgnoreCase("FLA")){
			fullName = "flash" ;
		}
		return fullName;
	}
	
	/**
	 * @param fullName
	 * @return
	 */
	public static String getShortName(String fullName){
		String shortName = "";
		if(fullName.equalsIgnoreCase("theme")){
			shortName = "THM";
		}else if(fullName.equalsIgnoreCase("ring")){
			shortName = "RNG";
		}else if(fullName.equalsIgnoreCase("wallpaper")){
			shortName = "WPP";
		}else if(fullName.equalsIgnoreCase("game")){
			shortName = "GAM";
		}else if(fullName.equalsIgnoreCase("ebook")){
			shortName = "EBK";
		}else if(fullName.equalsIgnoreCase("video")){
			shortName = "VDO";
		}else if(fullName.equalsIgnoreCase("screensaver")){
			shortName = "SCR";
		}else if(fullName.equalsIgnoreCase("package")){
			shortName = "PAK";
		}else if(fullName.equalsIgnoreCase("flash")){
			shortName = "FLA";
		}else{
			shortName = "RNG";
		}
		return shortName;
	}
 
	 
	public  List<Ctttype> getCtttypeList(){
		List<Ctttype> list = new ArrayList<Ctttype>();
		Ctttype ctttype = null;
		
		ctttype = new Ctttype();
		ctttype.setShortName("RNG");
		ctttype.setCnName("ring");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("THM");
		ctttype.setCnName("theme");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("WPP");
		ctttype.setCnName("wallpaper");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("GAM");
		ctttype.setCnName("game");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("VDO");
		ctttype.setCnName("video");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("EBK");
		ctttype.setCnName("ebook");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("SCR");
		ctttype.setCnName("screensaver");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("PAK");
		ctttype.setCnName("package");
		list.add(ctttype);
		
		ctttype = new Ctttype();
		ctttype.setShortName("FLA");
		ctttype.setCnName("flash");
		list.add(ctttype);
		
		return list;
	}
}
