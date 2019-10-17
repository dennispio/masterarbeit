package agentTasks;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import objects.DataStorage;
import objects.Player;

public class APICrawler {
	
	@SuppressWarnings("resource")
	public void crawlApi() throws JSONException, IOException {
		DataStorage dataStorage = DataStorage.getSharedDataStorage();
	    
	    String[] players = {"witsel", "reus", "hazard", "hakimi", "bürki", "hitz", 
  				"Akanji", "Hummels",
  				"Piszczek", "schmelzer", "schulz", "zagadou", "brandt",
  				"bruun larsen", "dahoud", "Delaney",
  				"Guerreiro", "Sancho","weigl", "götze", "Alc"};
	    
	    String[] ligainsiderslink = {
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/abgefangene-baelle/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/balleroberungen/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/passquote/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/torschuesse/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/zweikampfquote/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/schussgenauigkeit/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/luftkampfquote/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/ballverluste/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/error/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/tacklingquote/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/erfolgreiche-dribblings/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/geblockte-baelle/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/torschussvorlagen/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/geklaerte-baelle/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/grosschancen-kreiert/",
	    		"https://www.ligainsider.de/bundesliga/ranking-top-10/fouls/"}; 	
	    
	    String ligaallgemeinlink = "https://www.ligainsider.de/borussia-dortmund/14/kader/";
	    
	    String understatlink = "https://understat.com/team/Borussia_Dortmund/2019";
	    
	    System.out.println("BIN IN API CRAWLER");
	    
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
		HtmlPage myPage = ((HtmlPage) webClient.getPage(understatlink));
		webClient.waitForBackgroundJavaScript(10 * 500);

		String theContent = myPage.asXml();
	        
	    for(String player : players) {
	    	
	    	Player playerC = new Player(
	    			//Alter
	    	    	ligaallgemein(ligaallgemeinlink,player).get(2),
	    	    	//Name
	    	    	understat(understatlink,player,theContent).get(0),
	    	    	//AbgefangeneBaelle
	    	    	ligainsider(ligainsiderslink[0],player),
	    	    	//Overall Assists
	    	    	understat(understatlink,player,theContent).get(2),
	    	    	//OverallBalleroberungen
	    	    	ligainsider(ligainsiderslink[1],player),
	    	    	//OverallBallverlust
	    	    	ligainsider(ligainsiderslink[7],player),
	    	    	//OverallBewertung
	    		    kicker(player),
	    		    //OverallBlockschuss
	    	    	ligainsider(ligainsiderslink[11],player),
	    	        //OverallDribblings
	    	    	ligainsider(ligainsiderslink[10],player),
	    	    	//OverallEinsatzquote
	    	    	ligaallgemein(ligaallgemeinlink,player).get(4),
	    	    	//OverallFouls
	    	    	ligainsider(ligainsiderslink[15],player),
	    	    	//OverallGeklärteBälle
	    	    	ligainsider(ligainsiderslink[13],player),
	    	    	//OverallGoals
	    	    	understat(understatlink,player,theContent).get(1),
	    	    	//OverallKP9
	    	    	understat(understatlink,player,theContent).get(4),
	    	    	//OverallKreierteGroßchancen
	    	    	ligainsider(ligainsiderslink[14],player),
	    	    	//OverallMinPlayed
	    	    	understat(understatlink,player,theContent).get(9),
	    	    	//OverallPassquote
	    	    	ligainsider(ligainsiderslink[2],player),
	    	    	//OverallSchussgenauigkeit
	    	    	ligainsider(ligainsiderslink[5],player),
	    	    	//OverallSH9
	    	    	understat(understatlink,player,theContent).get(3),
	    	        //OverallTacklingquote
	    	  	    ligainsider(ligainsiderslink[9],player),
	    	        //OverallTorschussvorlagen
	    		  	ligainsider(ligainsiderslink[12],player),
	    		  	//OverallZweikampfquote
	    		  	ligainsider(ligainsiderslink[4],player),
	    		  	//OverallxA
	    	    	understat(understatlink,player,theContent).get(6),
	    	    	//OverallxA90
	    	    	understat(understatlink,player,theContent).get(8),
	    	    	//OverallxG
	    	    	understat(understatlink,player,theContent).get(5),
	    	    	//OverallxG90
	    	    	understat(understatlink,player,theContent).get(7),
	    	    	//Position
	    	    	ligaallgemein(ligaallgemeinlink,player).get(3),
	    	    	//Spieltag
	    		    kicker(player)
	    	);
	    	DataStorage.getSharedDataStorage().getSoccerplayerList().add(playerC);
		  }
	   
	}
	    	 
	
	public ArrayList<String> understat(String understatlink, String player, String theContent) {
		
		ArrayList<String> understatlist = new ArrayList<String>();

		Document doc1 = Jsoup.parse(theContent);

		Element table = doc1.select("table").get(1); //select the first table.
		Elements rows = table.select("tr");
		    
		for (int k = 1; k < rows.size(); k++) {
			
	    	Element row = rows.get(k);
		    Elements cols = row.select("td");
			if(cols.get(1).text().toLowerCase().contains(player.toLowerCase())){
				System.out.println(cols.get(5).text() + "A");
			    
				String[] xG = cols.get(9).text().split("\\s+");
				String[] xA = cols.get(10).text().split("\\s+");
				
			    //Name
			    understatlist.add(cols.get(1).text());
			    //Goals
			    understatlist.add(cols.get(5).text());
			    //Assists
			    understatlist.add(cols.get(6).text());
			    //SH90
			    understatlist.add(cols.get(7).text());
			    //KP90
			    understatlist.add(cols.get(8).text());
			    //xG
			    understatlist.add(xG[0]);
			    //xA
			    understatlist.add(xA[0]);
			    //xG90
			    understatlist.add(cols.get(11).text());
			    //xA90
			    understatlist.add(cols.get(12).text());
			    //minPlayed
			    understatlist.add(cols.get(4).text());
			    			    
			    return understatlist;
			}
		}
	
		return null;	
	}
	
	public ArrayList<String> ligaallgemein(String ligaallgemein, String player) {
		Document doc;  
		ArrayList<String> ligaallgemeinlist = new ArrayList<String>();

		try {
			doc = Jsoup.connect(ligaallgemein).get();

			
		    Elements tabelle = doc.getElementsByClass("leg_column_row");	
		    
		    for(Element spieler : tabelle) {
			    Element vorname = spieler.select("span").get(0);
			    Element geburtstag = spieler.getElementsByClass("process_inner_column4").get(0);
			    Element nachname = spieler.select("strong").get(0);
			    Element position = spieler.select("small").get(0);
			    Element einsatz = spieler.getElementsByClass("process_inner_column7").get(0);
			   
			    if(nachname.text().toLowerCase().contains(player.toLowerCase())) {
			        String[] alter = geburtstag.text().split("\\s+");

			        // Vorname
				    ligaallgemeinlist.add(vorname.text());
				    // Nachname
				    ligaallgemeinlist.add(nachname.text());
				    // Alter
				    ligaallgemeinlist.add(alter[0]);
				    // Position
				    ligaallgemeinlist.add(position.text());  
				    //Einsatzzeit
				    String[] einsatzzeit = einsatz.text().split("\\s+");			  
				    ligaallgemeinlist.add(einsatzzeit[2]);
				    
		            return ligaallgemeinlist;  
			    	}
		    }
		     
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		    
		
		
		return null;
	}
	
	
	public String kicker(String player){
	    Document document;
		
		//Get Document object after parsing the html from given url.
		try {
			document = Jsoup.connect("https://www.kicker.de/borussia-dortmund-17/kader/1-bundesliga/2019-20").get();
		    Elements kicker = document.getElementsByTag("tr");
	        for (Element paragraph : kicker) {	  
        		String note = paragraph.getElementsByClass("kick__table--ranking__number kick__table--ranking__master kick__respt-m-w-70").text().toString();
 			    String name = paragraph.getElementsByTag("strong").text();	
		    
			    if (name.toLowerCase().contains(player.toLowerCase())) {
	 				System.out.println(note);
	 				return note;
			    }		    
        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
		return null;
	}
	
	public String ligainsider(String ligalink, String player){
				
	try {
	    	Document doc;   
			doc = Jsoup.connect(ligalink).get();		    
		    Element table = doc.select("table").get(0); //select the first table.
		    Elements rows = table.select("tr");
		    int prozent = 0;
		    String wert = "";
	        switch(ligalink) {
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/passquote/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/abgefangene-baelle/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/torschuesse/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/zweikampfquote/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/balleroberungen/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/schussgenauigkeit/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/luftkampfquote/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/ballverluste/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/error/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/tacklingquote/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/erfolgreiche-dribblings/":
			    	prozent = 9;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/geblockte-baelle/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/torschussvorlagen/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/geklaerte-baelle/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/grosschancen-kreiert/":
			    	prozent = 8;
			    	break;
			    case "https://www.ligainsider.de/bundesliga/ranking-top-10/fouls/":
			    	prozent = 8;
			    	break;
		    }
		    
		    for (int k = 1; k < rows.size(); k++) { //first row is the col names so skip it.
		    	Element row = rows.get(k);
		        Elements cols = row.select("td");
		        
		        if((cols.get(2).text().toLowerCase().contains(player.toLowerCase()))) {
				        System.out.println(cols.get(prozent).text());
				        wert = cols.get(prozent).text();
			            return wert;
		        	}        
		        } 
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		return null;
	}
	}

