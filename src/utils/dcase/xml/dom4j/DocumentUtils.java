package utils.dcase.xml.dom4j;

import java.util.Iterator;
import java.util.List;



import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class DocumentUtils {
	Document doc = null;
	public DocumentUtils(String textStr) throws DocumentException{
		doc = DocumentHelper.parseText(textStr);
	}
	public DocumentUtils(){}
	
	public void initTextDocument(String textStr) throws DocumentException{
		doc = DocumentHelper.parseText(textStr);
	}
	
	public void createTextDocument(String encoding) {
		doc = DocumentHelper.createDocument();
		doc.setXMLEncoding(encoding);
	}
	
	public void createTextDocument() {
		doc = DocumentHelper.createDocument();
	}
	
	public Element createRootElement(String elementName){
		Element root = doc.addElement(elementName);
		return root;
	}
	
	public Element createSubElement(Element parentElement, String elementName){
		Element element = parentElement.addElement(elementName);
		return element;
	}
	

	 public void addAttribute(Element parentElement, String attributeName, String attributeValue){
		 parentElement.addAttribute(attributeName, attributeValue);
	 }
	 
	 public String getDocumentText(){
		 String str = doc.asXML();
		 return str;
	 }
	 
	 public void setText(Element element, String text){
		 element.setText(text);
	 }
	
	/**
	 * get the text value among the beginning and ending of a element<br/>
	 * e.g:<br/>
	 * 	&lt;child&gt;<br/>
	 * 		&lt;son&gt;Jesse&lt;/son&gt;<br/>
	 *		&lt;daughter&gt;Kate&lt;/daughter&gt;<br/>
	 * &lt;/child&gt;<br/>
	 * you can get "Jesse"  by : getNodeText("/child/son");<br/>
	 * @param elementPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getNodeText(String elementPath){
		List<Element> list = doc.selectNodes(elementPath);
		if(list.size() == 0){
			return "";
		}
		Iterator<Element> it = list.iterator();
		Element elem = it.next();
		return elem.getText();
	}
	
	/**
	 *get a attribute Value of a node<br/>
	 *e.g:<br/>
	 *	&lt;child&gt;<br/>
	 *		&lt;son name="Jesse"/&gt;<br/>
	 *		&lt;daughter name="Kate"/&gt;<br/>
	 *	&lt;/child&gt;<br/>
	 *
	 *you can get the value of name like this: getNodeAttributeValue("/child/son", "name");
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getNodeAttributeValue(String elementPath, String attributeName){
		List<Element> list = doc.selectNodes(elementPath);
		if(list.size() == 0){
			return "";
		}
		Iterator<Element> it = list.iterator();
		Element elem = it.next();
		return elem.attributeValue(attributeName);
	}
	
	
	
	
}
