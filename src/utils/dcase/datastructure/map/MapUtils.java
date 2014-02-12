package utils.dcase.datastructure.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "b"); 
		map.put("c", "d"); 
		map.put("e", "f"); 
		List<Object> list = 
		valueToList(map);
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).toString());
		}
		
	}
	
	/**
	 * 
	 * @param <T>
	 * @param <T1>
	 * @param map
	 * @return
	 */
	public static <T,T1> List<T1> valueToList(Map<T, T1> map){
		 List<T1>  list = new ArrayList<T1> ();
		list.addAll(map.values());
		return list;
	}
	
	/**
	 * @param <T>
	 * @param <T1>
	 * @param map
	 * @return
	 */
	public static <T, T1> List<T> keyToList(Map<T, T1> map){
		 List<T>  list = new ArrayList<T> ();
		list.addAll(map.keySet());
		return list;
	}


}
