package utils.dcase.ramdom;

import java.util.Date;

import utils.dcase.date.format.DateFormatUtil;

public class SynId {
	private static long ramdom =  System.currentTimeMillis();
	
	public static synchronized String generate(){
		ramdom ++;
		return DateFormatUtil.format(new Date(), "yyyyMMdd") + Long.toString(ramdom);
	}
	
	
	  public static void main(String[] args) {
		for(int i= 0; i < 1000; i++){
			System.out.println(SynId.generate());
		}
	}
}
