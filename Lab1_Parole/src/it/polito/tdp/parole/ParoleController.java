package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco = new Parole() ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;
    
    @FXML
    private Button generarandom;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML // fx:id="secondatextarea"
    private TextArea secondatextarea; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	long adesso = System.nanoTime();
    	
    	elenco.addParola( txtParola.getText() );
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	txtParola.clear();//svuota il campo dove inserisco le parole
    	
    	long fine = System.nanoTime();
    	
    	secondatextarea.appendText((fine-adesso)+"nanosecondi per inserire una parola in una LinkedList\n");
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	long adesso = System.nanoTime();
    
    	elenco.reset() ;
    	txtResult.clear() ;

    	long fine = System.nanoTime();    	
    	secondatextarea.appendText((fine-adesso)+"nanosecondi per resettare in una LinkedList\n");
    }

    @FXML
    void doCancella(ActionEvent event) {
    	long adesso = System.nanoTime();
    	
    	String s = txtResult.getSelectedText();
    	elenco.eliminaParola(s);
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);   	
    	txtParola.clear(); 
    	
    	long fine = System.nanoTime();   	
    	secondatextarea.appendText((fine-adesso)+"nanosecondi per cancellare la parola selezionata da una LinkedList\n");
    }
    
    @FXML
    void doRandom(ActionEvent event) {
    	long adesso = System.nanoTime();
    	String s="";
    	
    	for(int i=0; i<1000; i++)
    		 s += i+"ciao\n";

    	elenco.addParola( s );    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);    	
    	txtParola.clear();
    	
    	long fine = System.nanoTime();   	
    	secondatextarea.appendText((fine-adesso)+"nanosecondi per inserire 1000 parole random in una LinkedList\n");
    	
    	
    }


	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert secondatextarea != null : "fx:id=\"secondatextarea\" was not injected: check your FXML file 'Parole.fxml'.";

        
    }
}
