package ch.fhnw.cuie.module04.eventhandling;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class EventHandlingExample extends StackPane {
	private static final String DEFAULT_TEXT = "Click Me!";

	private Button button;

	public EventHandlingExample() {
		initializeControls();
		layoutControls();
		addEvents();
	}

	private void initializeControls() {
		button = new Button(DEFAULT_TEXT);
	}

	private void layoutControls() {
		getChildren().add(button);
	}

	private void addEvents() {
		button.setOnAction(event -> button.setText("Action performed!"));

		button.setOnZoom(event1 -> {
			button.setScaleX(event1.getTotalZoomFactor());
			button.setScaleY(event1.getTotalZoomFactor());
		});

		button.setOnRotate(event1 -> button.setRotate(event1.getTotalAngle()));

		setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ESCAPE) {
				button.setText(DEFAULT_TEXT);
			}
		});
	}

}
