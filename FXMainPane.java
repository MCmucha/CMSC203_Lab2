import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox 
{

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1; 
	Button button2; 
	Button button3; 
	Button button4; 
	Button button5;
	
	Label feedbackLabel;
	TextField textField;
	
	//  declare two HBoxes
	HBox box1 = new HBox();
	HBox box2 = new HBox();

	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataM = new DataManager(); 

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() 
	{
		
		//student Task #2:
		//  instantiate the buttons, label, and text field 
		button1 = new Button("Hello"); 
		button2 = new Button("Howdy"); 
		button3 = new Button("Chinese"); 
		button4 = new Button("Clear"); 
		button5 = new Button("Exit"); 
		
		feedbackLabel = new Label("Feedback:");
		textField = new TextField(); 
		
		//  set margins and set alignment of the components
		HBox.setMargin(button1, new Insets(0, 10, 0, 0));
		box1.setAlignment(Pos.CENTER);
        box2.setAlignment(Pos.CENTER);
        box1.setSpacing(10);
        box2.setSpacing(10);
        
        button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
        
		//student Task #3:
		//  add the label and text field to one of the HBoxes
	    box2.getChildren().addAll(feedbackLabel, textField);

		//  add the buttons to the other HBox
		box1.getChildren().addAll(button1, button2,button3,button4, button5); 
		
		
        
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1,box2); 
		
		
		  
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> 
	{
	    @Override
	    public void handle(ActionEvent event) 
	    {
	        Button clickedButton = (Button) event.getSource();

	        if (clickedButton == button1) 
	        {
	            String response = dataM.getHello();
	            textField.setText(response);
	        } else if (clickedButton == button2) 
	        {
	            String response = dataM.getHowdy();
	            textField.setText(response);
	        } else if (clickedButton == button3) 
	        {
	            String response = dataM.getChinese();
	            textField.setText(response);
	        } else if (clickedButton == button4) 
	        {
	            textField.setText("");
	        } else if (clickedButton == button5) 
	        {
	            Platform.exit();
	            System.exit(0);
	        }
	    }
}
	}


