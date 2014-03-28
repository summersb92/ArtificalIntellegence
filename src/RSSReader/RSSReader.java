package RSSReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RSSReader {
	
	public RSSReader(String link, String Site) throws IOException{
		URL rssUrl = new URL(link);
		BufferedReader in = new BufferedReader
				(new InputStreamReader(rssUrl.openStream()));
		String sourcode = "";
		String line;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
		in.close();
	}


}
