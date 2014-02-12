package utils.dcase.expression.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
public class SunPattern {
	 /**�Ҿ��ã� 
     *  1. positive lookaheadӦ�÷���ɿ϶���Ԥ�飬��������Ԥ�顣 
     *  2. negative lookaheadӦ�÷���ɷ���Ԥ�飬���Ǹ���Ԥ�顣 
     *  3. positive lookbehind��negative lookbehind��ͬ�� 
     */  
    static void lookahead_and_lookbehind_in_regexp() {  
        /** 
         *   (?=pattern) ����Ԥ�飬���κ�ƥ�� pattern ���ַ�����ʼ��ƥ������ַ����� 
         * ����һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�û���˵:����ͨ�� 
         * matcher.group(i)�õ�����(i!=0). 
         *   ���磬'Windows (?=95|98|NT|2000)' ��ƥ�� "Windows 2000" �е� "Windows" �� 
         * ������ƥ�� "Windows 3.1" �е� "Windows"�� 
         *   Ԥ�鲻�����ַ���Ҳ����˵����һ��ƥ�䷢���������һ��ƥ��֮��������ʼ 
         * ��һ��ƥ��������������ǴӰ���Ԥ����ַ�֮��ʼ��  
         */  
        Pattern pat = Pattern.compile("win(?=98|nt)[x]");  
        Matcher mat = pat.matcher("winntx");  
        while (mat.find()) {  
            //��ƥ��: Ԥ�鲻�����ַ�, ��û��ƥ�䵽[x]��  
            System.out.println("1:" + mat.group());  
        }  
        pat = Pattern.compile("win(?=98|nt)[n]");  
        mat = pat.matcher("winntx");  
        while (mat.find()) {  
            System.out.println("2:" + mat.group());//ƥ��.  
        }  
        /** 
         * (?:pattern), ��Ҳ��δ�����飬������������������ƥ�䡣 
         */  
        pat = Pattern.compile("win(?:98|nt)[n]");  
        mat = pat.matcher("winntx");  
        while (mat.find()) {  
            //��ƥ��: ����������һ��������ƥ��  
            System.out.println("3:" + mat.group());//��ƥ��,��Ϊ[n]δ��ƥ�䡣  
        }  
        pat = Pattern.compile("win(?:98|nt)[n]");  
        mat = pat.matcher("winntn");  
        while (mat.find()) {  
            System.out.println("4:" + mat.group());//ƥ��, [n]��ƥ��.  
        }  
        /** 
         * ��(?!pattern) ����Ԥ�飬���κβ�ƥ�� pattern ���ַ�����ʼ��ƥ������ַ����� 
         * ����һ���ǻ�ȡƥ�䣬Ҳ����˵����ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á� 
         * ������'Windows (?!95|98|NT|2000)' ��ƥ�� "Windows 3.1" �е� "Windows"�� 
         * ������ƥ�� "Windows 2000" �е� "Windows"��Ԥ�鲻�����ַ��� 
         *  
         */  
        pat = Pattern.compile("win(?!98|nt)[x]");  
        mat = pat.matcher("win97x");  
        while (mat.find()) {  
            //��ƥ��: Ԥ�鲻�����ַ�, ��û��ƥ�䵽[x]��  
            System.out.println("11:" + mat.group());  
        }  
        pat = Pattern.compile("win(?!98|nt)[9]");  
        mat = pat.matcher("win97x");  
        while (mat.find()) {  
            //ƥ�䣺��δƥ����[9]������ƥ�䵽��9����  
            System.out.println("12:" + mat.group());  
        }  
        /** 
            ?=  ������������ 
            ?!  ������治����    
            ?<= ����ǰ�������(positive lookbehind)    
            ?<! ����ǰ�治����(negative lookbehind) 
         */  
        pat = Pattern.compile("(?<=98)win");  
        mat = pat.matcher("97win");  
        while (mat.find()) {  
            System.out.println("13:" + mat.group());//��ƥ��: win����ǰ��98  
        }  
        pat = Pattern.compile("(?<!98)win");  
        mat = pat.matcher("97win");  
        while (mat.find()) {  
            System.out.println("14:" + mat.group());//ƥ��, ��Ϊwin��ǰ��98  
        }  
        
        pat = Pattern.compile("abc(?!e)[d]");  
        mat = pat.matcher("abcd");  
        while (mat.find()) {  
            System.out.println("15:" + mat.group());//ƥ��, ��Ϊwin��ǰ��98  
        }  
    }  
    
    public static void main(String[] args) {
    	lookahead_and_lookbehind_in_regexp();
	}
}
