package utils.dcase.string;

public class StringOperator {
	/**
	 * if deststr only include letter and data and space <br>
	 *  then return the string which has been remove space<br>or return null
	 * @param deststr
	 * @return
	 */
	public static String dataAndLetter(String deststr){
		if(deststr == null || deststr.trim().length() == 0) return null;
		deststr = deststr.replaceAll(" ", "");
		deststr = deststr.replaceAll
		("[\\.|\\(|\\)|\\*|&|\\^|\\$|\\#|@|\\!|\\+|\\-|_|%|~|`|\"|\'|\\\\|}|{|\\[|\\]|\\||:|;|\\?|/|>|<|,]", "");
		deststr = deststr.replaceAll("\\s+","");
		if(deststr.matches("^[A-Za-z0-9]+$")){
			return deststr;
		}else{
			return null;
		} 
	}
	
	public static void main(String[] args) {
		System.out.println(StringOperator.dataAndLetter("fdafdafa(&d[@^.<*-f]!>_\\{}:$\";?+/,||d'|`%~#)"));
	}
}
