/**
	This class represents a Booking app for Hotel Rooms.
	@author Haniya Ahmed
*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.text.NumberFormat; 

public class RoomGUI extends Application
{
	private TextField Name;
	private TextField numGuests;
	private TextField numBeds;
	private TextField numNights;

	private Text Info;
	private Text Checkout;
	private Text InfoCost;
	
	NumberFormat nf = NumberFormat.getCurrencyInstance();

	public static void main(String[] args)
	{
	  launch(args);
	}

	public void start(Stage primaryStage)
	{
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(20);
	
		Label l1 = new Label("Name:");
		pane.getChildren().add(l1);

		Name = new TextField();
        	Name.setPrefWidth(100);
		pane.getChildren().add(Name);
	
		Label l2 = new Label("Number of Guests:");
		pane.getChildren().add(l2);	

		numGuests = new TextField();
        	numGuests.setPrefWidth(50);
		pane.getChildren().add(numGuests);

					
		Label l3 = new Label("Number of Beds:");
		pane.getChildren().add(l3);	
	
		numBeds = new TextField();
        	numBeds.setPrefWidth(50);
		pane.getChildren().add(numBeds);			
		
		Label l4 = new Label("Number of Nights:");
		pane.getChildren().add(l4);

		numNights = new TextField();
        	numNights.setPrefWidth(50);
		pane.getChildren().add(numNights);	
	
		Button Suite = new Button("Suite");
        	Suite.setOnAction(this::processSuiteButton);
		pane.getChildren().add(Suite);	


		Button Standard = new Button("Standard");
        	Standard.setOnAction(this::processStandardButton);
		pane.getChildren().add(Standard);

		Button Reset = new Button("Reset");
        	Reset.setOnAction(this::processResetButton);
		pane.getChildren().add(Reset);	

		Info = new Text("Welcome to Hotels R Us!");
		pane.getChildren().add(Info);
	
		Checkout = new Text("Take note of your check-out time.");
		pane.getChildren().add(Checkout);

		InfoCost = new Text("Enter your information.");
		pane.getChildren().add(InfoCost);

	        Scene scene = new Scene(pane, 250, 400);
		primaryStage.setTitle("Booking");
        	primaryStage.setScene(scene);
        	primaryStage.show();


	}

	public void processResetButton(ActionEvent event)
	{	
		Name.setText("");
		numGuests.setText("");
		numBeds.setText("");
		numNights.setText("");

		Info.setText("Welcome to Hotels R Us!");
		Checkout.setText("Take note of your check-out time.");
		InfoCost.setText("Enter your information.");
	}

	public void processStandardButton(ActionEvent event)
	{
		String guestName = Name.getText();
		int Guests = Integer.parseInt(numGuests.getText());
		int Beds = Integer.parseInt(numBeds.getText());
		int Nights = Integer.parseInt(numNights.getText());
		
		StandardRoom r1 = new StandardRoom(guestName, Guests, Beds, Nights);
		double costr1 = r1.calcCost();
		String checktime = r1.getChekout();

		Info.setText("Breakfast included in room cost.");
		Checkout.setText("Please check-out by: " + checktime);
		InfoCost.setText("Total Cost:" + nf.format(costr1));
		
	}


	public void processSuiteButton(ActionEvent event)
	{
		String guestName = Name.getText();
		int Guests = Integer.parseInt(numGuests.getText());
		int Beds = Integer.parseInt(numBeds.getText());
		int Nights = Integer.parseInt(numNights.getText());
		
		SuiteRoom r1 = new SuiteRoom(guestName, Guests, Beds, Nights);
		double costr1 = r1.calcCost();
		String perk = r1.perks();

		Info.setText("Your room perk is: " + perk);
		Checkout.setText("Please check-out by: 12 noon");
		InfoCost.setText("Total Cost:" + nf.format(costr1));
		
	}	

}
