package utils.dcase.expression.regular;


 


import java.util.ArrayList;
import java.util.List;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/***********************************************************************
* 文 件 名 : PatternUtils.java 
* <br/>包： utils.dcase.expression.regular 
* <br/>工程: aadcase  
* <br/>创 建 人： 洪建忠  
* <br/>日   期： 2011-8-18 下午02:36:38 
* <br/>描   述： 
* 在使用正则表达式中,有三种方式<br/>
* 1、(全匹配)用于在字符中做限制,正则表达式用于匹配整串字符串,例如:
* <br/>&nbsp;&nbsp;&nbsp;&nbsp;在页面中一个固定电话输入框的限制验证
* <br/>&nbsp;&nbsp;&nbsp;&nbsp;例如:0596-8281761
* <br/>&nbsp;&nbsp;&nbsp;&nbsp;则这时就可以使用正则表达式对整个输入的字符串做验证
* <br/>&nbsp;&nbsp;&nbsp;&nbsp;使用的正则表达式为:0[\d]{2,3}-[\d]{7,8}
* <br/>
* 2、(全匹配)并取出其中一些分组数据, 例如:<br/>
* &lt;book&gt;
* 	&lt;name&gt;the life of a programmer&lt;name/&gt;
* &lt;book/&gt;<br/>
* &lt;book&gt;
* 	&lt;name&gt;the life of java&lt;name/&gt;
* &lt;book/&gt;<br/>
* &lt;book&gt;
* 	&lt;name&gt;the technology of java&lt;name/&gt;
* &lt;book/&gt;<br/>
* &lt;name&gt;outside of the book tag&lt;name/&gt;<br/>
* 要取得book标签中的name里面的数据,这时正则表达式为:&lt;book&gt;&lt;name&gt;([.]*)&lt;name/&gt;&lt;book/&gt;.*
* <br/>这时取不到book标签外的name的数据
* <br/>
* 3、(部分匹配)并取得字符串中的分组数据<br/>
* 取得name里面的字符串<br/>
* 这时正则表达式为:&lt;name&gt;([.])*&lt;name/&gt;<br/>
* 这时也会将book标签外的name也返回
* 
* 
* 
*  <br/><br/>福建邮科电信业务部厦门研发中心                                                                                                                                                              
* <br/>http://www.fsti.com                                              
* <br/>CopyRright (c) 2011-2011   <br/><br/>
**********************************************************************/
public class PatternUtils { 
	/**
	 * @param args
	 * @throws MalformedPatternException 
	 */
	/*public static void main(String[] args) throws MalformedPatternException {
		String head = "GET / HTTP/1.1\r\nAuthorization: userid=m3tech;password=123456\r\nAccept: *
		 * /*\r\nAccept-Language: zh-CN\r\nUser-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2; Tablet PC 2.0; CIBA)\r\nAccept-Encoding: gzip, deflate\r\nHost: 192.168.0.245:8389\r\nConnection: Keep-Alive\r\n\r\n";
		/*String testStr = " <?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
				"<m3tech-mt-req><message><telco>dtac</telco><channeltype>ivr</channeltype><linkid>adfa<linkid></linkid>" +
		"<serviceid>Aknservicetype</serviceid><srcnumber>aaaaff</srcnumber><destnumber>dafd</destnumber><chargenumber>afs</chargenumber><extencode>adfas</extencode>" +
		"<msgtype>fadfadsf</msgtype><content>fadfsdfs</content></message></m3tech-mt-req>";
		testStr = "adflkjllllllllllldfalkdjl\n" + testStr;
		System.out.println(testStr);
		String patternStr = "\\s*<\\?xml\\s+version\\s*=\"1.0\"\\s+encoding\\s*=\\s*\"UTF-8\"\\s+\\?>\\s*";
		patternStr += "<m3tech-mt-req>\\s*<message>\\s*<telco>.*</telco>\\s*<channeltype>.*</channeltype>\\s*<linkid>.*</linkid>\\s*";
		patternStr += "<serviceid>.*</serviceid>\\s*<srcnumber>.*</srcnumber>\\s*<destnumber>.*</destnumber>\\s*<chargenumber>.*</chargenumber>\\s*";
		patternStr += "<extencode>.*</extencode>\\s*<msgtype>.*</msgtype>\\s*<content>.*</content>\\s*</message>\\s*</m3tech-mt-req>\\s*";
		String patternStr1 = "\\s*<\\?xml\\s+version\\s*=\"1.0\"\\s+encoding\\s*=\\s*\"UTF-8\"\\s+\\?>\\s*";
		patternStr += "<m3tech-mt-req>\\s*<message>\\s*<telco>.*</telco>\\s*<channeltype>.*</channeltype>\\s*<linkid>.*</linkid>\\s*";
	 	patternStr += "<serviceid>.*</serviceid>\\s*<srcnumber>.*</srcnumber>\\s*<destnumber>.*</destnumber>\\s*<chargenumber>.*</chargenumber>\\s*";
	 	patternStr += "<extencode>.*</extencode>\\s*<msgtype>.*</msgtype>\\s*<content>.*</content>\\s*</message>\\s*</m3tech-mt-req>\\s*";
		
		  String patternStr = ".*<\\?xml\\s+version\\s*=\"1.0\"\\s+encoding\\s*=\\s*\"UTF-8\"\\s+\\?>\\s*";
			patternStr += "<m3tech-mt-req>\\s*<message>\\s*<telco>.*</telco>\\s*<channeltype>.*</channeltype>\\s*<linkid>.*</linkid>\\s*";
			patternStr += "<serviceid>.*</serviceid>\\s*<srcnumber>.*</srcnumber>\\s*<destnumber>.*</destnumber>\\s*<chargenumber>.*</chargenumber>\\s*";
			patternStr += "<extencode>.*</extencode>\\s*<msgtype>.*</msgtype>\\s*<content>.*</content>\\s*</message>\\s*</m3tech-mt-req>\\s*";
		
		
		
		
		//System.out.println(testStr.matches(patternStr));
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern = null;
		try {
			pattern = compiler.compile(patternStr, Perl5Compiler.CASE_INSENSITIVE_MASK);
		} catch (MalformedPatternException e) {
			throw e;
		}
		PatternMatcher matcher = new Perl5Matcher();
		if(matcher.matches(testStr, pattern)){
			MatchResult result = matcher.getMatch();
			System.out.println(result.group(1));
		}
		String testStr = "";
		//testStr  = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><message id=\"routerpbifh_SMSGW1@pbifh_mr1:379066894\"><sms type=\"mo\"><retry count=\"0\" max=\"0\"/><destination messageid=\"42ECE78A\"><address><number type=\"abbreviated\">4541403</number></address</destination><source><address><number type=\"international\">668xxxxxxxx</number></address></source><ud type=\"text\">R</ud><scts>2009-05-15T13:19:30Z</scts><service-id>0101102156</service-id></sms><from>SMPP_CMG1</from><to>HttpAdapter:: 0101102156</to></message>";
		testStr = "POST http://202.9.104.116:80/TrueMove/Psa.aspx HTTP/1.1\r\n" +
						"Content-Length: 481\r\n" +
						"Connection: Close\r\n" +
						"Host: 202.9.104.116\r\n" +
						"Content-Type: text/xml; charset=ISO-8859-1\r\n\r\n" +
						"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
						"<message id=\"routerTestbed@Testbed:3104400\">" +
						"<sms type=\"mo\">" +
						"<retry count=\"0\" max=\"0\"/>" +
						"<destination messageid=\"6156634A\"><address>" +
						"<number type=\"abbreviated\">1042</number></address></destination><source><address>" +
						"<number type=\"international\">668xxxxxxxx</number></address></source>" +
						"<ud type=\"text\">R</ud><scts>2009-05-21T11:03:20Z</scts><service-id>0101102156</service-id></sms>" +
						"<from>SMPP_CMG1</from><to>HttpAdapter:: 0101102156</to>" +
						"</message>";
		
		String patternStr ="";
		
		patternStr = "[\\s\\S]*<\\?xml\\s*version=\"1.0\"\\s*encoding=\"ISO-8859-1\"\\?>\\s*(<message[^<|^>]*>.*</message>)\\s*";
		PatternUtils pu = new PatternUtils();
		pu.init(patternStr);
		if(pu.matches(testStr)){
			
				try {
					System.out.println(pu.getMessageXML(testStr));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		}else{
			System.out.println("not patch");
		}
		
	}*/
	@Deprecated
	private  String patternStr = "";
	@Deprecated
	private static Pattern pattern = null;
	public PatternUtils(){}
	
	/**
	 * @param patternStr
	 */
	@Deprecated
	public void init(String patternStr){
		this.patternStr = patternStr;
		/*PatternCompiler compiler = new Perl5Compiler();
		try {
			pattern = compiler.compile(patternStr, Perl5Compiler.CASE_INSENSITIVE_MASK);
		} catch (MalformedPatternException e) {
		}*/
	}
	
	/**
	 * @param matchStr
	 * @return
	 */
	@Deprecated
	public boolean matches(String matchStr){
		return matchStr.matches(patternStr);
	}
	/**
	 * @param matchStr
	 * @param element
	 * @return
	 * @throws Exception 
	 */
	@Deprecated
	public  String getMessageXML(String moinputStr) throws Exception{
		String elementValue = "";
		if(moinputStr == null){
			return "";
		}
		String patternStrTmp = this.patternStr;
		
		PatternCompiler compiler = new Perl5Compiler();
		try {
			pattern = compiler.compile(patternStrTmp, Perl5Compiler.CASE_INSENSITIVE_MASK);
			PatternMatcher matcher = new Perl5Matcher();
			if(matcher.matches(moinputStr, pattern)){
				MatchResult result = matcher.getMatch();
				elementValue = result.group(1);
			}
		} catch (MalformedPatternException e) {
			throw new Exception("maybe patternStr is wrong");
		}
		
		return elementValue;
	}
	
	
	/**
	 * 对应到类注释中的方式1--验证匹配
	 * @param patternstr //正则表达式
	 * @param str  //欲匹配的字符
	 * @param CASE_SENSITIVE //true为大小写敏感,false为不敏感
	 * @return
	 * @throws MalformedPatternException 
	 */
	public static boolean verifyMatch(final String patternstr,final String str, final boolean CASE_SENSITIVE)
		throws MalformedPatternException{  
		Pattern pattern = getPattern(patternstr, CASE_SENSITIVE); 
		PatternMatcher matcher = new Perl5Matcher();
		if(matcher.matches(str, pattern)){
			return true;
		}else{
			return false;
		}
	}
	
	private static Pattern getPattern(final String patternstr, final boolean CASE_SENSITIVE) 
		throws MalformedPatternException{
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern = null; 
		pattern = CASE_SENSITIVE? compiler.compile(patternstr)://大小写敏感
				compiler.compile(patternstr,Perl5Compiler.CASE_INSENSITIVE_MASK);//大小写不敏感 
		return pattern;
	}
	
	/**
	 * 对应到类注释中的方式2--全匹配,并取得其中的分组数据
	 * 对于MatchResult可以通过访问<a href=""/>
	 * @return
	 * @throws MalformedPatternException 
	 */
	public static MatchResult fullMath(final String patternstr,final String str, final boolean CASE_SENSITIVE) 
		throws MalformedPatternException{
		Pattern pattern = getPattern(patternstr, CASE_SENSITIVE); 
		PatternMatcher matcher = new Perl5Matcher();
		if(matcher.matches(str, pattern)){
			return matcher.getMatch();
		}else{
			return null;
		} 
	}
	
	
	/**
	 * 对应到类注释中的方式3--部分匹配,并取得其中的分组数据
	 * @param patternstr
	 * @param str
	 * @param CASE_SENSITIVE
	 * @return
	 * @throws MalformedPatternException
	 */
	public static List<MatchResult> partMath(final String patternstr,final String str, final boolean CASE_SENSITIVE)
		throws MalformedPatternException{
		Pattern pattern = getPattern(patternstr, CASE_SENSITIVE); 
		PatternMatcher matcher = new Perl5Matcher();
		PatternMatcherInput input = new PatternMatcherInput(str);
		List<MatchResult> list = new ArrayList<MatchResult>();
		while(matcher.contains(input, pattern)){
			list.add(matcher.getMatch());
		}
		return list;
	}
	
	public static void main(String[] args) throws MalformedPatternException {
		String str = "<book> <name>the life of a programmer</name></book>" +
				"<book> <name>the life of java</name> </book>" +
				"<book> <name>the technology of java</name> </book>" +
				"<name>outside of the book tag</name>";
		String str2 = "<book> <name>the life of a programmer</name></book>" +
		"<book> <name>the life of java</name> </book>" +
		"<book> <name>the technology of java</name> </book>";
		String str1 = "<book><name>the life of a programmer</name> </book>";
		
		String pattern1 = "\\s*<book>\\s*<name>(.*)</name>\\s*</book>\\s*";
		String pattern2 = "<book><name>(.*)</name></book>";
		String pattern3 = "<(name)>(.*?)</\\1>";
		System.out.println(str.matches(pattern1));
		System.out.println(str2.matches(pattern1));
		System.out.println(str1.matches(pattern1));
		System.out.println(str1.matches(pattern2));
		System.out.println(str.matches(pattern3));
		System.out.println(partMath(pattern1, str, false).size());
		
		
		System.out.println("aac".matches("aa(?!b)"));
		
		System.out.println(partMath("aa?!b", "aac", false).size());
		
		List<MatchResult> mrl = partMath("((aa(?!b)))", "aac", false);
		for(MatchResult mr: mrl){
			System.out.println(mr.group(0));
			System.out.println(mr.group(1));
			System.out.println(mr.group(2));
			System.out.println(mr.group(3));
		}
		System.out.println("--------------------------");
		System.out.println(partMath(pattern3, str, false).get(0).group(2));
		
		
		String boundaryPattern = "<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>";
		System.out.println("<BOO>bold</B>".matches(boundaryPattern));
		
		System.out.println("abcc".matches("a(bc|b)c"));
		System.out.println("abc".matches("a(bc|b)c"));
		System.out.println("whole words only".matches(".*\\bwords\\b.*"));
		System.out.println("abce".matches("abc(?!d)[e]"));
		System.out.println("--------------------------2");
		List<MatchResult> mrl2 = partMath("(abc(?!d)[e])", "abce", false);
		for(MatchResult mr: mrl2){
			System.out.println(mr.group(0));
			System.out.println(mr.group(1));
			System.out.println(mr.group(2));
			System.out.println(mr.group(3));
		}
		
		System.out.println("cece".matches("^(?!cd)[a-z]{4}"));
		
		
	}
	
   

}
