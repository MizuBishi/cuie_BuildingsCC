package ch.fhnw.cuie.CC_Buildings;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class Floor extends Region {
    private static final double ARTBOARD_SIZE = 400;

    private static final double PREFERRED_SIZE = ARTBOARD_SIZE;
    private static final double MINIMUM_SIZE   = 14;
    private static final double MAXIMUM_SIZE   = 800;

    private TextField numFloors;
    private Button plus;
    private Button minus;

    private Rectangle r1, r2, r3;
    private Rectangle f1w1, f1w2, f1w3, f1w4;
    private Rectangle f2w1, f2w2, f2w3, f2w4;
    private Rectangle f3w1, f3w2, f3w3, f3w4;
    private Rectangle f4w1, f4w2, f4w3, f4w4;
    private Rectangle f5w1, f5w2, f5w3, f5w4;
    private Rectangle f6w1, f6w2, f6w3, f6w4;
    private Rectangle f7w1, f7w2, f7w3, f7w4;
    private Rectangle f8w1, f8w2, f8w3, f8w4;
    private Rectangle f9w1, f9w2, f9w3, f9w4;
    private Rectangle f10w1, f10w2, f10w3, f10w4;

    private Pane drawingPane;


    private static double sizeFactor() {
        return PREFERRED_SIZE / ARTBOARD_SIZE;
    }

    public Floor() {
        initializeSelf();
        initializeParts();
        layoutParts();
    }

    private void initializeSelf() {
        String fonts = getClass().getResource("fonts.css").toExternalForm();
        getStylesheets().add(fonts);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        Insets padding           = getPadding();
        double verticalPadding   = padding.getTop() + padding.getBottom();
        double horizontalPadding = padding.getLeft() + padding.getRight();

        setMinSize(MINIMUM_SIZE + horizontalPadding, MINIMUM_SIZE + verticalPadding);
        setPrefSize(PREFERRED_SIZE + horizontalPadding, PREFERRED_SIZE + verticalPadding);
        setMaxSize(MAXIMUM_SIZE + horizontalPadding, MAXIMUM_SIZE + verticalPadding);
    }

    private void initializeParts() {
        double center = getPrefWidth() * 0.5;

        //Textfield
        numFloors = new TextField("Floors");
        numFloors.setLayoutX(35.0);
        numFloors.setLayoutY(41.0);
        numFloors.setPrefHeight(33.0);
        numFloors.setPrefWidth(54.00);

        //Buttons
        plus = new Button("+");
        plus.setLayoutX(99.00);
        plus.setLayoutY(50.00);
        plus.setPrefHeight(19.00);

        minus = new Button("-");
        minus.setLayoutX(1.00);
        minus.setLayoutY(49.00);
        minus.setPrefHeight(20.00);


        //Main Building
        r1 = new Rectangle(30, 31, 64, 49);
        r2 = new Rectangle(0, 80, 123, 349);
        r3 = new Rectangle(52, 0, 20, 31);

        //1 Floor
        f1w1 = new Rectangle(13, 388.128788, 13, 14.8712121);
        f1w1.setFill(Color.rgb(255,255,255));
        f1w2 = new Rectangle(41, 388.128788, 13, 14.8712121);
        f1w2.setFill(Color.rgb(255,255,255));
        f1w3 = new Rectangle(69, 388.128788, 13, 14.8712121);
        f1w3.setFill(Color.rgb(255,255,255));
        f1w4 = new Rectangle(97, 388.128788, 13, 14.8712121);
        f1w4.setFill(Color.rgb(255,255,255));

        //2 Floor
        f2w1 = new Rectangle(13, 356.098485, 13, 14.8712121);
        f2w1.setFill(Color.rgb(255,255,255));
        f2w2 = new Rectangle(41, 356.098485, 13, 14.8712121);
        f2w2.setFill(Color.rgb(255,255,255));
        f2w3 = new Rectangle(69, 356.098485, 13, 14.8712121);
        f2w3.setFill(Color.rgb(255,255,255));
        f2w4 = new Rectangle(97, 356.098485, 13, 14.8712121);
        f2w4.setFill(Color.rgb(255,255,255));

        //3 Floor
        f3w1 = new Rectangle(13, 324.068182, 13, 14.8712121);
        f3w1.setFill(Color.rgb(255,255,255));
        f3w2 = new Rectangle(41, 324.068182, 13, 14.8712121);
        f3w2.setFill(Color.rgb(255,255,255));
        f3w3 = new Rectangle(69, 324.068182, 13, 14.8712121);
        f3w3.setFill(Color.rgb(255,255,255));
        f3w4 = new Rectangle(97, 324.068182, 13, 14.8712121);
        f3w4.setFill(Color.rgb(255,255,255));

        //4 Floor
        f4w1 = new Rectangle(13, 292.037879, 13, 14.8712121);
        f4w1.setFill(Color.rgb(255,255,255));
        f4w2 = new Rectangle(41, 292.037879, 13, 14.8712121);
        f4w2.setFill(Color.rgb(255,255,255));
        f4w3 = new Rectangle(69, 292.037879, 13, 14.8712121);
        f4w3.setFill(Color.rgb(255,255,255));
        f4w4 = new Rectangle(97, 292.037879, 13, 14.8712121);
        f4w4.setFill(Color.rgb(255,255,255));

        //5 Floor
        f5w1 = new Rectangle(13, 260.007576, 13, 14.8712121);
        f5w1.setFill(Color.rgb(255,255,255));
        f5w2 = new Rectangle(41, 260.007576, 13, 14.8712121);
        f5w2.setFill(Color.rgb(255,255,255));
        f5w3 = new Rectangle(69, 260.007576, 13, 14.8712121);
        f5w3.setFill(Color.rgb(255,255,255));
        f5w4 = new Rectangle(97, 260.007576, 13, 14.8712121);
        f5w4.setFill(Color.rgb(255,255,255));

        //6 Floor
        f6w1 = new Rectangle(13, 227.977273, 13, 14.8712121);
        f6w1.setFill(Color.rgb(255,255,255));
        f6w2 = new Rectangle(41, 227.977273, 13, 14.8712121);
        f6w2.setFill(Color.rgb(255,255,255));
        f6w3 = new Rectangle(69, 227.977273, 13, 14.8712121);
        f6w3.setFill(Color.rgb(255,255,255));
        f6w4 = new Rectangle(97, 227.977273, 13, 14.8712121);
        f6w4.setFill(Color.rgb(255,255,255));

        //7 Floor
        f7w1 = new Rectangle(13, 195.94697, 13, 14.8712121);
        f7w1.setFill(Color.rgb(255,255,255));
        f7w2 = new Rectangle(41, 195.94697, 13, 14.8712121);
        f7w2.setFill(Color.rgb(255,255,255));
        f7w3 = new Rectangle(69, 195.94697, 13, 14.8712121);
        f7w3.setFill(Color.rgb(255,255,255));
        f7w4 = new Rectangle(97, 195.94697, 13, 14.8712121);
        f7w4.setFill(Color.rgb(255,255,255));

        //8 Floor
        f8w1 = new Rectangle(13, 163.916667, 13, 14.8712121);
        f8w1.setFill(Color.rgb(255,255,255));
        f8w2 = new Rectangle(41, 163.916667, 13, 14.8712121);
        f8w2.setFill(Color.rgb(255,255,255));
        f8w3 = new Rectangle(69, 163.916667, 13, 14.8712121);
        f8w3.setFill(Color.rgb(255,255,255));
        f8w4 = new Rectangle(97, 163.916667, 13, 14.8712121);
        f8w4.setFill(Color.rgb(255,255,255));

        //9 Floor
        f9w1 = new Rectangle(13, 133.030303, 13, 14.8712121);
        f9w1.setFill(Color.rgb(255,255,255));
        f9w2 = new Rectangle(41, 133.030303, 13, 14.8712121);
        f9w2.setFill(Color.rgb(255,255,255));
        f9w3 = new Rectangle(69, 133.030303, 13, 14.8712121);
        f9w3.setFill(Color.rgb(255,255,255));
        f9w4 = new Rectangle(97, 133.030303, 13, 14.8712121);
        f9w4.setFill(Color.rgb(255,255,255));

        //10 Floor
        f10w1 = new Rectangle(13, 101, 13, 14.8712121);
        f10w1.setFill(Color.rgb(255,255,255));
        f10w2 = new Rectangle(41, 101, 13, 14.8712121);
        f10w2.setFill(Color.rgb(255,255,255));
        f10w3 = new Rectangle(69, 101, 13, 14.8712121);
        f10w3.setFill(Color.rgb(255,255,255));
        f10w4 = new Rectangle(97, 101, 13, 14.8712121);
        f10w4.setFill(Color.rgb(255,255,255));

        drawingPane = new Pane();
        drawingPane.setMaxSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setMinSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setPrefSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.getStyleClass().add("led");
    }

    private void layoutParts() {
        drawingPane.getChildren().addAll(r1, r2, r3,
                f1w1, f1w2, f1w3, f1w4,
                f2w1, f2w2, f2w3, f2w4,
                f3w1, f3w2, f3w3, f3w4,
                f4w1, f4w2, f4w3, f4w4,
                f5w1, f5w2, f5w3, f5w4,
                f6w1, f6w2, f6w3, f6w4,
                f7w1, f7w2, f7w3, f7w4,
                f8w1, f8w2, f8w3, f8w4,
                f9w1, f9w2, f9w3, f9w4,
                f10w1, f10w2, f10w3, f10w4,
                plus, minus, numFloors);
        getChildren().add(drawingPane);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        resize();
    }

    private void resize() {
        Insets padding         = getPadding();
        double availableWidth  = getWidth() - padding.getLeft() - padding.getRight();
        double availableHeight = getHeight() - padding.getTop() - padding.getBottom();
        double size            = Math.max(Math.min(Math.min(availableWidth, availableHeight), MAXIMUM_SIZE), MINIMUM_SIZE);

        double scalingFactor = size / PREFERRED_SIZE;

        if (availableWidth > 0 && availableHeight > 0) {
            drawingPane.relocate((getWidth() - PREFERRED_SIZE) * 0.5, (getHeight() - PREFERRED_SIZE) * 0.5);
            drawingPane.setScaleX(scalingFactor);
            drawingPane.setScaleY(scalingFactor);
        }
    }
}