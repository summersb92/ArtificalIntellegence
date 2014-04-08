package RSSReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSSReader {
	
	List<String> titles;
	List<String> links;
	
	public RSSReader() {
		
	}

	public void RSSReader(String link){
		titles = new ArrayList<String>();
		links = new ArrayList<String>();
		try{
			URL rssUrl = new URL(link);
			BufferedReader in = new BufferedReader
					(new InputStreamReader(rssUrl.openStream()));
			String line;
			while((line = in.readLine()) != null){
				if(line.contains("<title>")){
					titles.add(getItem(line, "<title>", "</title>"));
				}
				if(line.contains("<link>")){
					links.add(getItem(line, "<link>", "</link>"));
				}
			}
			in.close();
			//System.out.println(linkCode);
			//return sourceCode;
		}catch(MalformedURLException e){
			System.out.println("Malformed URL");
		}catch(IOException ioe){
			System.out.println("Something went wrong in reading the content");
		}
	}
	private String getItem(String line, String openingTag, String closingTag){
		int firstPos = line.indexOf(openingTag);
		String temp = line.substring(firstPos);
		temp = temp.replace(openingTag, "");
		int lastPos = temp.indexOf(closingTag);
		temp = temp.substring(0,lastPos);
		return temp;
	}
	public List<String> getLinks(){
		return links;
	}
	public String getALink(int i){
		return links.get(i);
	}
	public List<String> getTitles(){
		return titles;
	}
	public String getATitle(int i){
		return titles.get(i);
	}

	
}
