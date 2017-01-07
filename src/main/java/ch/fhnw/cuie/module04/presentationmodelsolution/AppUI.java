package ch.fhnw.cuie.module04.presentationmodelsolution;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class AppUI extends VBox {
    private final PresentationModelExample pm;

    private Label  isAdultLabel;
    private Label  ageLabel;
	private Slider ageSlider;

	public AppUI(PresentationModelExample pm) {
        this.pm = pm;
        initializeControls();
		layoutControls();
		addBindings();
	}

	private void initializeControls() {
        isAdultLabel = new Label();
        ageLabel = new Label();
        ageSlider = new Slider(0, 100, 20);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setSpacing(10);

		getChildren().addAll(isAdultLabel, ageLabel, ageSlider);
	}

	private void addBindings() {
        ageSlider.valueProperty().bindBidirectional(pm.ageProperty());

        ageLabel.textProperty().bind(pm.ageProperty().asString());
        isAdultLabel.textProperty().bind(pm.isAdultProperty().asString());
	}
}
