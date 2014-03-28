import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import Parser.ParsePage;
import RSSReader.RSSReader;


public class Main {

	/**
	 * @param args
	 * 
	 * Using jSoup
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}
	Main(){
		RSSReader rss;
		String site = "CNN";
		try {
			rss = new RSSReader("http://rss.cnn.com/rss/cnn_topstories.rss", site);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		String Link = null;
		String Site = null;
		
		//focus on CNN first
		ParsePage page = new ParsePage(Site,Link);
		
		//entry for every p tag, arraylist for each page
		
		//entire list can be run through NLP in one go.
		
	}
	
	/**
	 * TODO:
	 * Scrape RSS feed
	 * Store RSS Feed
	 * Access page html file with RSS site link
	 * Parse the site (CNN, FOX, Yahoo)
	 * Store site site text
	 * Take text run through NLP
	 * Store NLP results
	 */

}
