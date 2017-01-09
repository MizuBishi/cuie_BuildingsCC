package ch.fhnw.cuie.CC_Buildings;

import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Floor extends Region {
    private static final double ARTBOARD_SIZE = 400;
    private static final double PREFERRED_SIZE = ARTBOARD_SIZE;
    private static final double MINIMUM_SIZE = 14;
    private static final double MAXIMUM_SIZE = 800;

    //declare all Properties

    private Label numFloors;
    private Label labelFloors;
    private Slider floorSlider;

    private final IntegerProperty minValue    = new SimpleIntegerProperty(0);
    private final IntegerProperty maxValue     = new SimpleIntegerProperty(160);
    private final IntegerProperty currentValue = new SimpleIntegerProperty();

    private Rectangle r1, r2, r3;
    // Floor windows. First index is floor (0=lowest), second index windows left to right.
    private Rectangle[][] fws;

    //needed for resizing
    private Pane drawingPane;


    public Floor() {
        initializeSelf();
        initializeParts();
        layoutControls();
        layoutParts();
        addBindings();
        addValueChangeListeners();

    }

    private void initializeSelf() {
        // load stylesheets
        String fonts = getClass().getResource("fonts.css").toExternalForm();
        getStylesheets().add(fonts);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        // initialize resizing constraints
        Insets padding = getPadding();
        double verticalPadding = padding.getTop() + padding.getBottom();
        double horizontalPadding = padding.getLeft() + padding.getRight();
        setMinSize(MINIMUM_SIZE + horizontalPadding, MINIMUM_SIZE + verticalPadding);
        setPrefSize(PREFERRED_SIZE + horizontalPadding, PREFERRED_SIZE + verticalPadding);
        setMaxSize(MAXIMUM_SIZE + horizontalPadding, MAXIMUM_SIZE + verticalPadding);
    }

    private void initializeParts() {

        numFloors = new Label();
        numFloors.setMaxWidth(Double.MAX_VALUE);
        numFloors.setAlignment(Pos.CENTER);
        numFloors.setTextFill(Color.rgb(255, 255, 255));
        numFloors.setLayoutX(35.0);
        numFloors.setLayoutY(41.0);
        numFloors.setPrefHeight(33.0);
        numFloors.setPrefWidth(54.00);
        numFloors.getStyleClass().add("numFloorsLabel");

        labelFloors = new Label ("Number of Floors");
        labelFloors.setLayoutX(0.00);
        labelFloors.setLayoutY(440.00);
        labelFloors.setPrefHeight(14.8712121);
        labelFloors.setPrefWidth(123.00);
        labelFloors.getStyleClass().add("labelFloorsLabel");


        floorSlider = new Slider(0, 160, 20);
        floorSlider.setLayoutX(0.00);
        floorSlider.setLayoutY(460.00);
        floorSlider.setPrefHeight(14.8712121);
        floorSlider.setPrefWidth(123.00);
        floorSlider.getStyleClass().add("floorSliderStyle");



        //Main Building
        r1 = new Rectangle(30, 31, 64, 49);
        r1.setFill(Color.rgb(64, 64, 64));
        r2 = new Rectangle(0, 80, 123, 349);
        r2.setFill(Color.rgb(64, 64, 64));
        r3 = new Rectangle(52, 1, 20, 31);
        r3.setFill(Color.rgb(64, 64, 64));

        fws = new Rectangle[10][4];


        for (int y = 0; y<10; y++) {
            for (int x = 0; x<4; x++) {
                fws[y][x] = new Rectangle(13 + (x * 28), 388.128788 - (y * 32), 13, 14.8712121);
                fws[y][x].setFill(Color.rgb(255, 255, 255));
            }
        }

        drawingPane = new Pane();
        drawingPane.setMaxSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setMinSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setPrefSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.getStyleClass().add("Floors");
    }

    private void layoutParts() {
        drawingPane.getChildren().addAll(r1, r2, r3, numFloors, floorSlider, labelFloors);
        getChildren().add(drawingPane);
        for (int y = 0; y<10; y++) {
            for (int x = 0; x<4; x++) {
                drawingPane.getChildren().addAll(fws[y][x]);
            }
        }

    }

    private void illuminatedWindows(int value) {
        double calcFloors = ((double) value / maxValue.getValue()) * 10;
        int wholeFloors = (int) calcFloors;
        double calcWindows = (calcFloors - wholeFloors) * 4;


        //illuminated Windows back to white
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 4; x++) {
                fws[y][x].setFill(Color.rgb(255, 255, 255));
            }
        }

        //illuminated entire floors in yellow
        for (int y = 0; y < wholeFloors; y++) {
            for (int x = 0; x < 4; x++) {
                fws[y][x].setFill(Color.rgb(255, 231, 0));
            }
        }
        //illuminate partial floors
        for (int x = 0; x < calcWindows; x++) {
            fws[wholeFloors][x].setFill(Color.rgb(255, 231, 0));
        }
    }

    private void addValueChangeListeners() {
        currentValue.addListener((observable, oldValue, newValue) -> {
            illuminatedWindows(newValue.intValue());
            System.err.println(newValue);
        });
    }

    /**
     * Returns the number of floors of this building (see {@link #setValue(int)}.
     */
    public int getValue() {
        return currentValue.getValue();
    }

    /**
     * Sets number of floors of this building. The number of illuminated windows corresponds to the number of floors
     * (highest building = all windows illuminated, lowest building = no windows illuminated).
     */
    public void setValue(int newValue) {
        currentValue.setValue(newValue);
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        getChildren().addAll(numFloors, floorSlider);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        resize();
    }

    private void addBindings() {
        floorSlider.valueProperty().bindBidirectional(currentValue);
        numFloors.textProperty().bind(currentValue.asString());
    }

    //resize by scaling
    private void resize() {
        Insets padding = getPadding();
        double availableWidth = getWidth() - padding.getLeft() - padding.getRight();
        double availableHeight = getHeight() - padding.getTop() - padding.getBottom();
        double size = Math.max(Math.min(Math.min(availableWidth, availableHeight), MAXIMUM_SIZE), MINIMUM_SIZE);

        double scalingFactor = size / PREFERRED_SIZE;

        if (availableWidth > 0 && availableHeight > 0) {
            drawingPane.relocate((getWidth() - PREFERRED_SIZE) * 0.5, (getHeight() - PREFERRED_SIZE) * 0.5);
            drawingPane.setScaleX(scalingFactor);
            drawingPane.setScaleY(scalingFactor);
        }

    }

    public IntegerProperty minValueProperty() {
        return minValue;
    }

    public IntegerProperty maxValueProperty() {
        return maxValue;
    }


}
