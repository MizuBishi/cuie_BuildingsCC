package ch.fhnw.cuie.CC_Buildings;

import ch.fhnw.cuie.module03.led.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FloorStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new ch.fhnw.cuie.module03.led.Floor();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Floors");
		primaryStage.setScene(scene);
		primaryStage.setWidth(300);
		primaryStage.setHeight(300);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
