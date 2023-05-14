package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		BorderPane top = new BorderPane();
		Pane center = new Pane();
		BorderPane bottom = new BorderPane();
		
		addCity(14,pane);
		addCity(89,pane);
		addCity(62,pane);
		
		
		
		
		top.setStyle("-fx-border-color: black");
		bottom.setStyle("-fx-border-color: black");
		center.setStyle("-fx-border-color: black");
		
		StackPane topRight = new StackPane();
		topRight.getChildren().add(new Text("Next Level>>"));
		
		StackPane topMid = new StackPane();
		topMid.getChildren().add(new Text("Score:"));
		
		StackPane topLeft = new StackPane();
		topLeft.getChildren().add(new Text("Level:"));
		topLeft.setPadding(new Insets(2,2,2,2));
		
			
		StackPane bottomRight = new StackPane();
		bottomRight.setAlignment(Pos.CENTER_RIGHT);
		Font font = new Font(30);
		Button button = new Button("DRIVE");
		button.setFont(font);
		button.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
		
		bottomRight.getChildren().add(button);
		bottomRight.setPadding(new Insets(50,10,50,10));
		
		FlowPane bottomLeft = new FlowPane();
		bottomLeft.setPadding(new Insets(2,2,2,2));
		bottomLeft.setAlignment(Pos.TOP_LEFT);
		
		top.setLeft(topLeft);
		top.setRight(topRight);
		top.setCenter(topMid);
		bottom.setRight(bottomRight);
		bottom.setLeft(bottomLeft);
		pane.setTop(top);
		pane.setCenter(center);
		pane.setBottom(bottom);
			
		Scene scene = new Scene(pane,600,790);
		primaryStage.setTitle("Travel");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void addCity(int x,Pane pane){
		x=x-1;
		int a=x/10;
		int b=x%10;
		Circle c1 = new Circle(30+60*b,53+60*a, 30);
		pane.getChildren().add(c1);
	}
}



