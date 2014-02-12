package utils.dcase.string;




public class CleanSp{
	
	public static String clean(String str){
		try{
		if(str!=null &&!str.equals(""))
			str = str.trim();
		if(str==null)
			str="";
		}catch(Exception e){
			
		}
		return str;
	}
	
	public static int clean(Integer i){
		if(i == null){
			return 0;
		}else{
			return i;
		}
		
	}
}
