package no.ntnu.mycbr.rest;

import de.dfki.mycbr.core.Project;
import jade.wrapper.StaleProxyException;
import no.ntnu.mycbr.CBREngine;
import objects.DataStorage;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import agentTasks.APICrawler;
import agentTasks.FilterTask;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import agents.MainContainer;

/**
 * Hello world!
 *
 */

@SpringBootApplication 
@ComponentScan({"controller"})
public class App {
//
//    public static Project getProject() {
//        return project;
//    }
//
//    private static CBREngine engine;
//    private static Project project;

    public static void main(String[] args) throws StaleProxyException {
    	DataStorage dataStorage = DataStorage.getSharedDataStorage();
   
    	//Start main container, CBR engine and Spring
		MainContainer maincontainer = new MainContainer();
		maincontainer.startMainContainer();
//        engine = new CBREngine();
//        System.out.println("###################");
//        System.out.println(engine.getConceptName());
//        project = engine.createProjectFromPRJ();
        SpringApplication.run(App.class, args);
    }

}
