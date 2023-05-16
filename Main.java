package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	public static int level =0;
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		BorderPane top = new BorderPane();
		Pane center = new Pane();
		BorderPane bottom = new BorderPane();
		
	/*	addCity1(91,pane,center);
		addCity1(100,pane,center);
		addCity1(1,pane,center);
		addCity1(10,pane,center); */
				
		top.setStyle("-fx-border-color: black");
		bottom.setStyle("-fx-border-color: black");
		center.setStyle("-fx-border-color: black");
		
		StackPane topLeft = new StackPane();
		topLeft.getChildren().add(new Text("Level: " + level));
		topLeft.setPadding(new Insets(2,2,2,2));
		
		StackPane topRight = new StackPane();
        Button nextLevel = new Button("Next Level>>");
        class LevelHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent arg0) {
            	level++;
            	topLeft.getChildren().clear();
            	topLeft.getChildren().add(new Text("Level: " + level));
            	center.getChildren().clear();
            	levelInitializer("level"+level+".txt");
            	
            }
        }
        nextLevel.setOnAction(new LevelHandler());
        topRight.getChildren().add(nextLevel);
		
		StackPane topMid = new StackPane();
		topMid.getChildren().add(new Text("Score:"));
			
		Button deneme = new Button("O");
		Font asd = new Font(30);
		deneme.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
		deneme.setFont(asd);
		center.getChildren().add(deneme);
		deneme.setLayoutX(450);
		deneme.setLayoutY(500);
		deneme.setShape(new Circle(60));
		class Deneme implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent arg0) {
            	System.out.println("BAŞARILI");
            	
            }
        }
		deneme.setOnAction(new Deneme());
		
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

	public void addCity1(int x,Pane pane,Pane center, City city){
		x=x-1;
		int a=x/10;
		int b=x%10;
		File file = new File("levels\\house.jpg");
		Circle c1 = createCircle(30+60*b,53+60*a, 30, file.getAbsolutePath());
		c1.radiusProperty().bind((pane.heightProperty().subtract(190)).divide(20));
		c1.centerXProperty().bind((pane.heightProperty().subtract(190)).divide(10).multiply(b-5).add(300).add(c1.radiusProperty()).add((pane.widthProperty().divide(2)).subtract(300)));
		c1.centerYProperty().bind ((pane.heightProperty().subtract(196)).divide(10).multiply(a).add(28).add(c1.radiusProperty()));
		Button deneme = new Button("   ");
		Font asd = new Font(30);
		deneme.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
		deneme.setFont(asd);
		center.getChildren().add(deneme);
		deneme.setLayoutX(450);
		deneme.setLayoutY(300);
        Circle buttonCircle = new Circle(60);
        buttonCircle.radiusProperty().bind((pane.heightProperty().subtract(190)).divide(20));
		deneme.setShape(buttonCircle);
		deneme.layoutXProperty().bind((pane.heightProperty().subtract(190)).divide(10).multiply(b-5).add(300).add(c1.radiusProperty()).add((pane.widthProperty().divide(2)).subtract(328)));
		deneme.layoutYProperty().bind ((pane.heightProperty().subtract(196)).divide(10).multiply(a).subtract(34).add(c1.radiusProperty()));
		class Deneme implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent arg0) {
            	System.out.println("BAŞARILI");
            	
            }
        }
		deneme.setOnAction(new Deneme());
		
		pane.getChildren().add(c1);
		
	}
	public void levelInitializer(String filename) {
				
		try {
			java.io.File file = new java.io.File("levels\\"+filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String item = scanner.nextLine();
				if(addItem(item) instanceof City) {
					City city = (City)addItem(item);
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Object addItem(String item) {
		int first,second,third;
		switch (item.charAt(0)) {
			case 'C' : 	first = item.indexOf(',');
						second = item.indexOf(',', first+1);
						third = item.indexOf(',', second+1);
						City city = new City(item.substring(first+1, second), Integer.parseInt(item.substring(second+1, third)), Integer.parseInt(item.substring(third+1)));
						return (Object)city;
			case 'P' :	first = item.indexOf(',');
						second = item.indexOf(',', first+1);
						third = item.lastIndexOf(',');
						Passenger passenger = new Passenger(Integer.parseInt(item.substring(first+1, second)), Integer.parseInt(item.substring(second+1, third)), Integer.parseInt(item.substring(third+1)));
						return (Object)passenger;
			case 'V' :	first = item.indexOf(',');
						second = item.indexOf(',', first+1);
						third = item.indexOf(',', second+1);
						Vehicle vehicle = new Vehicle(Integer.parseInt(item.substring(first+1, second)), Integer.parseInt(item.substring(second+1)));
						return (Object)vehicle;
			case 'F' :	first = item.indexOf(',');
						second = item.indexOf(',', first+1);
						third = item.indexOf(',', second+1);
						Fixed fixed = new Fixed(Integer.parseInt(item.substring(first+1)));
						return (Object)fixed;
			default  :	return new Object();
		}
	}
	private Circle createCircle(double centerX, double centerY, double radius, String imagePath) {
        // Daire oluşturma
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(new ImagePattern(new Image(imagePath)));

        return circle;
    }
}
