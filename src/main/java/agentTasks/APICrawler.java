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
	    
	    String[] dortmund = {"witsel", "reus", "hazard", "hakimi", "bürki", "hitz", 
  				"Akanji", "Hummels",
  				"Piszczek", "schmelzer", "schulz", "zagadou", "brandt",
  				"bruun larsen", "dahoud", "Delaney",
  				"Guerreiro", "Sancho","weigl", "götze", "Alc"};
	    
	    String[] bayern = {"Lewandowski", "Perisic", "Coutinho", "Gnabry", "Coman", "Alaba", 
  				"Pavard", "Davies",
  				"Süle", "Neuer", "Boateng", "Kimmich", "Müller", 
  				"Martínez",
  				 "Thiago", "Goretzka",
  				"Hernández",
  				 "Tolisso","Cuisance"};
	    
	   String transfermarktlinkDortmund = "https://www.transfermarkt.de/borussia-dortmund/startseite/verein/16";
	   String transfermarktlinkBayern = "https://www.transfermarkt.de/fc-bayern-munchen/startseite/verein/27";

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
	    
	    String ligaallgemeinlinkDortmund = "https://www.ligainsider.de/borussia-dortmund/14/kader/";
	    String ligaallgemeinlinkBayern = "https://www.ligainsider.de/fc-bayern-muenchen/1/kader/";

	    
	    String understatlinkDortmund = "https://understat.com/team/Borussia_Dortmund/2019";
	    String understatlinkBayern = "https://understat.com/team/Bayern_Munich/2019";

	    String kickerDortmund = "https://www.kicker.de/borussia-dortmund-17/kader/1-bundesliga/2019-20/";
	    String kickerBayern = "https://www.kicker.de/bayern-muenchen-14/kader/1-bundesliga/2019-20";

	   
	    System.out.println("BIN IN API CRAWLER");
	    
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
		HtmlPage myPageDortmund = ((HtmlPage) webClient.getPage(understatlinkDortmund));
		HtmlPage myPageBayern = ((HtmlPage) webClient.getPage(understatlinkBayern));
	    webClient.getOptions().setCssEnabled(false);
		webClient.waitForBackgroundJavaScript(10 * 500);

		String theContentDortmund = myPageDortmund.asXml();
		String theContentBayern = myPageBayern.asXml();

		


		 for(String player : dortmund) {
		    	
		    	Player playerC = new Player(
		    			//Name
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(0),
		    			//Alter
		    	    	ligaallgemein(ligaallgemeinlinkDortmund,player).get(2),
		    	    	//AbgefangeneBaelle
		    	    	ligainsider(ligainsiderslink[0],player),
		    	    	//Overall Assists
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(2),
		    	    	//OverallBalleroberungen
		    	    	ligainsider(ligainsiderslink[1],player),
		    	    	//OverallBallverlust
		    	    	ligainsider(ligainsiderslink[7],player),
		    	    	//OverallBewertung
		    		    kicker(player,kickerDortmund),
		    		    //OverallBlockschuss
		    	    	ligainsider(ligainsiderslink[11],player),
		    	        //OverallDribblings
		    	    	ligainsider(ligainsiderslink[10],player),
		    	    	//OverallEinsatzquote
		    	    	ligaallgemein(ligaallgemeinlinkDortmund,player).get(4),
		    	    	//OverallFouls
		    	    	ligainsider(ligainsiderslink[15],player),
		    	    	//OverallGeklärteBälle
		    	    	ligainsider(ligainsiderslink[13],player),
		    	    	//OverallGoals
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(1),
		    	    	//OverallKP9
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(4),
		    	    	//OverallKreierteGroßchancen
		    	    	ligainsider(ligainsiderslink[14],player),
		    	    	//OverallMinPlayed
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(9),
		    	    	//OverallPassquote
		    	    	ligainsider(ligainsiderslink[2],player),
		    	    	//OverallSchussgenauigkeit
		    	    	ligainsider(ligainsiderslink[5],player),
		    	    	//OverallSH9
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(3),
		    	        //OverallTacklingquote
		    	  	    ligainsider(ligainsiderslink[9],player),
		    	        //OverallTorschussvorlagen
		    		  	ligainsider(ligainsiderslink[12],player),
		    		  	//OverallZweikampfquote
		    		  	ligainsider(ligainsiderslink[4],player),
		    		  	//OverallxA
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(6),
		    	    	//OverallxA90
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(8),
		    	    	//OverallxG
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(5),
		    	    	//OverallxG90
		    	    	understat(understatlinkDortmund,player,theContentDortmund).get(7),
		    	    	//Position
		    	    	ligaallgemein(ligaallgemeinlinkDortmund,player).get(3),
		    		    //overallTorschuesse
		    		  	ligainsider(ligainsiderslink[3],player),
		    		    //overallLuftkampf
		    		  	ligainsider(ligainsiderslink[6],player),
		    		  	//Transfermarktwert
		    		  	transfermarkt(transfermarktlinkDortmund,player)
		    	);
		    	DataStorage.getSharedDataStorage().getSoccerplayerList().add(playerC);
			  }

	        
	    for(String player : bayern) {
	    	
	    	Player playerC = new Player(
	    			//Name
	    	    	understat(understatlinkBayern,player,theContentBayern).get(0),
	    			//Alter
	    	    	ligaallgemein(ligaallgemeinlinkBayern,player).get(2),
	    	    	//AbgefangeneBaelle
	    	    	ligainsider(ligainsiderslink[0],player),
	    	    	//Overall Assists
	    	    	understat(understatlinkBayern,player,theContentBayern).get(2),
	    	    	//OverallBalleroberungen
	    	    	ligainsider(ligainsiderslink[1],player),
	    	    	//OverallBallverlust
	    	    	ligainsider(ligainsiderslink[7],player),
	    	    	//OverallBewertung
	    		    kicker(player,kickerBayern),
	    		    //OverallBlockschuss
	    	    	ligainsider(ligainsiderslink[11],player),
	    	        //OverallDribblings
	    	    	ligainsider(ligainsiderslink[10],player),
	    	    	//OverallEinsatzquote
	    	    	ligaallgemein(ligaallgemeinlinkBayern,player).get(4),
	    	    	//OverallFouls
	    	    	ligainsider(ligainsiderslink[15],player),
	    	    	//OverallGeklärteBälle
	    	    	ligainsider(ligainsiderslink[13],player),
	    	    	//OverallGoals
	    	    	understat(understatlinkBayern,player,theContentBayern).get(1),
	    	    	//OverallKP9
	    	    	understat(understatlinkBayern,player,theContentBayern).get(4),
	    	    	//OverallKreierteGroßchancen
	    	    	ligainsider(ligainsiderslink[14],player),
	    	    	//OverallMinPlayed
	    	    	understat(understatlinkBayern,player,theContentBayern).get(9),
	    	    	//OverallPassquote
	    	    	ligainsider(ligainsiderslink[2],player),
	    	    	//OverallSchussgenauigkeit
	    	    	ligainsider(ligainsiderslink[5],player),
	    	    	//OverallSH9
	    	    	understat(understatlinkBayern,player,theContentBayern).get(3),
	    	        //OverallTacklingquote
	    	  	    ligainsider(ligainsiderslink[9],player),
	    	        //OverallTorschussvorlagen
	    		  	ligainsider(ligainsiderslink[12],player),
	    		  	//OverallZweikampfquote
	    		  	ligainsider(ligainsiderslink[4],player),
	    		  	//OverallxA
	    	    	understat(understatlinkBayern,player,theContentBayern).get(6),
	    	    	//OverallxA90
	    	    	understat(understatlinkBayern,player,theContentBayern).get(8),
	    	    	//OverallxG
	    	    	understat(understatlinkBayern,player,theContentBayern).get(5),
	    	    	//OverallxG90
	    	    	understat(understatlinkBayern,player,theContentBayern).get(7),
	    	    	//Position
	    	    	ligaallgemein(ligaallgemeinlinkBayern,player).get(3),
	    		    //overallTorschuesse
	    		  	ligainsider(ligainsiderslink[3],player),
	    		    //overallLuftkampf
	    		  	ligainsider(ligainsiderslink[6],player),
	    		  	//Transfermarktwert
	    		  	transfermarkt(transfermarktlinkBayern,player)
	    	);
	    	DataStorage.getSharedDataStorage().getSoccerplayerList().add(playerC);
		  }
	    	   
	}
	
	public String transfermarkt(String transfermarkt, String player) {
		Document doc;  

		try {
				doc = Jsoup.connect(transfermarkt).get();		    
			    Element table = doc.select("table").get(1); //select the first table.
			    Elements rows = table.select("tr");
			    String spielerpreis = "0";
			    System.out.println("bin im TRANSFERMARKT+++++++++++++++++++++++++");
			    
			    for (int k = 1; k < rows.size(); k++) { //first row is the col names so skip it.
			    	Element row = rows.get(k);
			        Elements name = row.getElementsByClass("hide");
			        Elements preis = row.getElementsByClass("rechts hauptlink");
			        
			        if(name.text().toLowerCase().contains(player.toLowerCase())) {
						 System.out.println(name.text());
						 String[] preiss = preis.text().split("\\s+");
						 if (preiss[0].contains(",")) {
							 String temp = preiss[0].toString();
							 spielerpreis = temp;
							 System.out.println(spielerpreis);
							 System.out.println("cash cash cash cash");
						 }else {
							 String temp = preiss[0].toString();
							 spielerpreis = "0," + temp;
							 System.out.println("cash cash cash cash");
						 }
						 return spielerpreis;
			        }
			   } 
			   return "0";
		     
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		    
		
		
		return null;
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
	
	
	public String kicker(String player, String kickerlink){
	    Document document;
		
		//Get Document object after parsing the html from given url.
		try {
			document = Jsoup.connect(kickerlink).get();
		    Elements kicker = document.getElementsByTag("tr");
		    System.out.println("bin im Kicker");
	        for (Element paragraph : kicker) {	  
        		String note = paragraph.getElementsByClass("kick__table--ranking__number kick__table--ranking__master kick__respt-m-w-70").text().toString();
 			    String name = paragraph.getElementsByTag("strong").text();
 			    
 			    if (player.toLowerCase().equals("hernández")) {
 			    	player = "Hernandez";	
 			    }
 			    
 			   if (player.toLowerCase().equals("martínez")) {
 				   	System.out.println("Bin bei Martin");
			    	player = "Martinez";	
			    }
		    
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

