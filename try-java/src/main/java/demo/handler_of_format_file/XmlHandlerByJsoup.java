package demo.handler_of_format_file;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.net.URL;

public class XmlHandlerByJsoup {
	private Document document;

	public static void main(String[] args) throws Exception {
		XmlHandlerByJsoup xhbj = new XmlHandlerByJsoup("JavaModifier.xml");
		xhbj.printInfo();
	}
	
	private XmlHandlerByJsoup(String fileName) throws Exception {
		URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
		this.document = Jsoup.parse(new File(url.getPath()), "UTF-8");		
	}
	
	private void printInfo() {
		for(Element element : document.getAllElements()) {
			System.out.println(element.tagName());
		}		
	}
	
	private String getHill() {
		
		return null;
	}
}
