import Parser.ParsePage;


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
