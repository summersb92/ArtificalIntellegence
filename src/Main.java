import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

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
		
		
		//focus on CNN first
		//page = new ParsePage(site,Link);
		
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
