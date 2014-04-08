package Parser;

import java.util.ArrayList;
import java.io.*;
import java.net.*;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class ParsePage {

	/******************************************************************************
	 * ParsePage: parses through the web page given
	 * @param site: name of news site
	 * @param link: the link to the article 
	 * calls getHTML to grab code from the web page then uses Jsoup to grab 
	 * everything in the paragraph tags
	 * */
	public ParsePage(String site, String link){

		//create the list to store the <p>'s in
		ArrayList<String> pList = new ArrayList<String>();

		//use jsoup to get all <p> of a doc and put them in the list
		Document doc = Jsoup.parse(getHTML(link)); //this should receive a webpage
		Element p= doc.select("p").first(); //this should grab all p tagged items from the page
		String text = p.text(); //this would be added to the array list
		pList.add(text); // adds the text to the array list
		
		//debug
		//System.out.print("Site: "+site+"\n");
		System.out.print("Site: " + site + "\n" + "paragraphs" + pList.toString());
		//might have to loop through and add tags separately 
	}
	/**************************************************************************************************
	 * getHTML: gets all the html from the url
	 * method found online: http://www.breakingpar.com/bkp/home.nsf/0/87256B280015193F87256DC80053681B
	 * @param urlToRead is the link to the desired page												  
	 **************************************************************************************************/
	public String getHTML(String urlToRead) {
		URL url; // The URL to read
		HttpURLConnection conn; // The actual connection to the web page
		BufferedReader rd; // Used to read results from the web page
		String line; // An individual line of the web page HTML
		String result = ""; // A long string containing all the HTML
		try {
			url = new URL(urlToRead);
			//set up connection
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			//gets line by line and adds to the result string
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			//close connection
			rd.close();
			
			//debug
			System.out.print("HTML code: " + result + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
