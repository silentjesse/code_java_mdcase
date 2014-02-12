package utils.dcase.data;

/***********************************************************************
* 文 件 名 : DataUtils.java 
* <br/>包： utils.dcase.data 
* <br/>工程: aadcase  
* <br/>创 建 人： 洪建忠  
* <br/>日   期： 2012-6-17 下午07:06:01 
* <br/>描   述： used to deal the data, eg. number
* <br/>福建邮科电信业务部厦门研发中心                                                                                                                                                              
* <br/>http://www.fsti.com                                              
* <br/>CopyRright (c) 2011-2011   <br/><br/>
**********************************************************************/
public class DataUtils {
	
	 /**  
     *  check whether the formal parameter "checkedGoal" is a number
     * @author JZ.Hunt 
     * @date 2012-6-17 下午06:05:37
     * @param checkedGoal
     * @return
     * @return boolean
     */
    public static boolean isNumber(String checkedGoal){
		if(checkedGoal == null || checkedGoal.trim().length() == 0 || !checkedGoal.trim().matches("[0-9]*")){
			//check that wheather the parameter checkedGoal is legal
			return false;
		}
		
		
		
		
		return true;
	}
}
