/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackfx;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ticket.Ticket;


/**
 *
 * @author szeman
 */
public class TicketMLController implements Initializable {
    
    private final ObservableList<Ticket> boxContent = FXCollections.observableArrayList();
    Set<Ticket> tkets = new HashSet<>();
    
    @FXML private void handleButtonAction(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML private void handle_Action(ActionEvent event){
        System.out.println("_");  
    }
    
    @FXML private void onKeyTyped(KeyEvent event){
//        event.consume();
        if(event.getCode().equals(KeyCode.ENTER)){
            Ticket o = (Ticket) cBox.getSelectionModel().getSelectedItem();
            setCurrentTicket( o);
            if(!tkets.contains(o)){
                tkets.add(new Ticket( o.id));
            }
            cBox.hide();
        }
        if(event.getCode().equals(KeyCode.UP) || event.getCode().equals(KeyCode.DOWN)) return;
                
        
        if(!cBox.getEditor().getText().equals("")) cBox.show(); else cBox.hide();
        boxContent.setAll(tkets
                .stream()
                .filter(s->s.id.startsWith(cBox.getEditor().getText()) )
                .collect(Collectors.toList()) 
        );
        cBox.setItems(boxContent);
//        cBox.setCellFactory(null);
    }
    @FXML void bDataViewClicked(MouseEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("TicketMLlist.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, 200,450));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(TicketMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tkets.add(new Ticket("E001", "HP1", "FFS", "Some comment"));        
        tkets.add(new Ticket("E002", "HP2", "FFS", "Some comment"));
        tkets.add(new Ticket("E003", "HP3", "FFS", "Some comment"));
        tkets.add(new Ticket("E004", "HP4", "FFS", "Some comment"));
        tkets.add(new Ticket("E005", "HP5", "FFS", "Some comment"));
        tkets.add(new Ticket("E101", "HP6", "FFS", "Some comment"));
        tkets.add(new Ticket("E102", "HP7", "FFS", "Some comment"));
        tkets.add(new Ticket("E203", "HP8", "FFS", "Some comment"));
        tkets.add(new Ticket("E204", "HP9", "FFS", "Some comment"));
        tkets.add(new Ticket("E205", "HPx", "FFS", "Some comment"));
    }    
    
    
    
    @FXML private Label label;
    @FXML private ComboBox cBox;
    @FXML private ComboBox companyCB;
    @FXML private ComboBox catwCB;
    @FXML private TextArea commentA;
    
    
    private void setCurrentTicket(Ticket input){
        System.out.println("Current ID: " + input.id);
        
        catwCB.getEditor().setText(input.catwCode);
        companyCB.getEditor().setText(input.company);
        
        commentA.setText(input.comment);
        
    }
    
    
}
