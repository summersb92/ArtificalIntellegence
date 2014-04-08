import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import Parser.ParsePage;
import RSSReader.RSSReader;


public class Main {

	private ParsePage page;
	/**
	 * @param args
	 * 
	 * Using jSoup
	 */
	public static void main(String[] args) {
		Main m = new Main();
	}
	Main(){
		RSSReader rss;
		String site = "CNN";
		rss = new RSSReader();
		rss.RSSReader("http://rss.cnn.com/rss/cnn_topstories.rss");
		int rssSize = rss.getLinks().size();
		for(int i=2; i<rssSize; i++){
			rss.getALink(i);
			System.out.println(rss.getALink(i));
			page = new ParsePage(site, rss.getALink(i));
			
				
		}
	}
	//2ed1f62a1eade93a597e7945861b34aabxFzdP3R52IoANjDin1B9WrlUkCp8TJM - key
	//https://api.sentigem.com/external/get-sentiment - url
	//@param - key, text
	//https://api.sentigem.com/external/get-sentiment?api-key=<your-api-key>&text=<text-to-analyze-for-sentiment>
	public void URLConnectionReader(String key, String text) {
		try {
	        URL address = new URL("https://api.sentigem.com/external/get-sentiment?api-key=<"+
	        					key +
	        					">&text=<"+
	        					text+">");
	        URLConnection yc = address.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	/**
	 * TODO:
	 * Scrape RSS feed - done
	 * Store RSS Feed - done
	 * Access page html file with RSS site link - done
	 * Parse the site (CNN, FOX, Yahoo) - partial
	 * Store site site text
	 * Take text run through NLP - partial
	 * Store NLP results
	 */

}
