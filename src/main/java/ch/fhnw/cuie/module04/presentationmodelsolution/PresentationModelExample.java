package ch.fhnw.cuie.module04.presentationmodelsolution;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Dieter Holz
 */
public class PresentationModelExample {
    private final IntegerProperty age     = new SimpleIntegerProperty();
    private final BooleanProperty isAdult = new SimpleBooleanProperty();

    public PresentationModelExample() {
        setupBinding();
    }

    private void setupBinding() {
        isAdult.bind(age.greaterThan(17));
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public boolean isIsAdult() {
        return isAdult.get();
    }

    public BooleanProperty isAdultProperty() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult.set(isAdult);
    }
}
