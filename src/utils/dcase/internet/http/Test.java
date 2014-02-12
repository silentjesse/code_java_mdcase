package utils.dcase.internet.http;

import utils.dcase.internet.http.HttpUtils;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//String url = "http://192.168.10.80:8090/file/content/temp//\\cttsample\\wpp\\2011\\02\\1000005\\/1000005_pre.jpg";
		System.out.println(HttpUtils.ishttpFileExist("http://192.168.10.80:8090/file/content/temp", "\\cttsample\\wpp\\2011\\02\\1000005\\", "1000005_pre.jpg"));

	}

}
