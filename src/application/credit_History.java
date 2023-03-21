package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
  
public class credit_History extends Application {
  
  
    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Make Payment");
        
         
        BorderPane make_payment = new BorderPane();
        make_payment.setPadding(new Insets(10,50,50,50));
       
         
        //Adding HBox
        HBox hb_makepayment = new HBox(200);
        hb_makepayment.setPadding(new Insets(20,20,20,30));
        
        //Adding GridPane
        GridPane gridPane_makepayment = new GridPane();
//        gridPane_makepayment.setPadding(new Insets(20,20,20,20));
//        gridPane_makepayment.setHgap(5);
//        gridPane_makepayment.setVgap(5);
//        gridPane_makepayment.setAlignment(Pos.CENTER);
         
       //Implementing Nodes for GridPane
        try {
			Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");
			  Statement stmt= con.createStatement();
			  ResultSet rs=stmt.executeQuery("select DISTINCT c.name AS NAME,c.cre_money AS AMOUNT,c.date AS DATE from Personal_Details p,Credit c,Debit d where(select name from Personal_Details where person_id=3)=c.name");
			  
			  ResultSet rs1=stmt.executeQuery("select DISTINCT c.name AS NAME,c.cre_money AS AMOUNT,c.date AS DATE from Personal_Details p,Credit c,Debit d where(select name from Personal_Details where person_id=3)=c.name");
			  	while(rs1.next())
			  	{
			  		System.out.println(rs1.getString(1)+"         "+rs1.getInt(2)+"       "+rs1.getString(3)+"  ");	
			  	}
		
				
		}
		catch(Exception ae) {
			System.out.println("Caught Exception "+ae);
		}
		
		
        //Adding Nodes to GridPane layout
        
                 
        //Reflection for gridPane_makepayment
        Reflection reflection_makepayment = new Reflection();
        reflection_makepayment.setFraction(0.7f);
        gridPane_makepayment.setEffect(reflection_makepayment);
         
        //DropShadow effect 
        DropShadow dropShadow_makepayment = new DropShadow();
        dropShadow_makepayment.setOffsetX(5);
        dropShadow_makepayment.setOffsetY(5);
         
        //Adding text and DropShadow effect to it
        Image image_makepayment = new Image("FinCorp.png");
		ImageView logo_makepayment = new ImageView(image_makepayment);
		logo_makepayment.setFitHeight(200);
		logo_makepayment.setFitWidth(800);
        Text text_makepayment = new Text("Payment");
        text_makepayment.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text_makepayment.setEffect(dropShadow_makepayment);

        
        //Adding back Button
		Button Makepaymentback=new Button("Back");
		Makepaymentback.setAlignment(Pos.CENTER_RIGHT);

         
        //Adding text to HBox
        hb_makepayment.getChildren().addAll(logo_makepayment,Makepaymentback);
        
        //Adding text paymnet to other Hbox
                           
        //Add ID's to Nodes
        make_payment.setId("bp");
        gridPane_makepayment.setId("root");
        text_makepayment.setId("text");
        Makepaymentback.setId("bck_makepayment");
        Makepaymentback.setMinWidth(80);
        Makepaymentback.setMinHeight(20);
        Makepaymentback.setAlignment(Pos.CENTER);
                 
        
        
        //Add HBox and GridPane layout to BorderPane Layout
        make_payment.setTop(hb_makepayment);
        make_payment.setCenter(gridPane_makepayment);  
         
        //Adding BorderPane to the scene and loading CSS
     Scene scene_makepayment = new Scene(make_payment);
     scene_makepayment.getStylesheets().add(credit_History.class.getResource("application.css").toExternalForm());
     primaryStage.setScene(scene_makepayment);
//       
     primaryStage.show();
    }
}