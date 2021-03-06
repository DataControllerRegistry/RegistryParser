package parser;
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Mohammad Ali
 *
 */
public class DatabaseBuilder {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//RegistryParser.parse(args[0]);
		buildRegistry("files/registryFiles/registry_example_test.xml");
		addStatistics();
		System.out.println("done!");
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public static void buildRegistry(String fileName){
		try {
			File file= new File(fileName);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new RegistryParser();
			saxParser.parse(file, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void addStatistics(){
		try {
			StatisticsBuilder statsBuilder = new StatisticsBuilder();
			statsBuilder.buildStatistics();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
