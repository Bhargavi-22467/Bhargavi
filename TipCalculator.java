import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label billLabel = new Label("Enter bill amount:");
        TextField billTextField = new TextField();
        billTextField.setPromptText("e.g., 100.00");

        Label tipLabel = new Label("Select tip percentage:");
        ComboBox<Integer> tipComboBox = new ComboBox<>();
        tipComboBox.getItems().addAll(10, 15, 20, 25, 30); 
        tipComboBox.setValue(15); 

        Button calculateButton = new Button("Calculate Tip");

        Label tipAmountLabel = new Label("Tip Amount: $0.00");
        Label totalAmountLabel = new Label("Total Amount: $0.00");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(billLabel, billTextField, tipLabel, tipComboBox, calculateButton, tipAmountLabel, totalAmountLabel);

        calculateButton.setOnAction(e -> {
            try {
                double billAmount = Double.parseDouble(billTextField.getText());
                int tipPercentage = tipComboBox.getValue();
                
                double tipAmount = (tipPercentage / 100.0) * billAmount;
                double totalAmount = billAmount + tipAmount;

                tipAmountLabel.setText(String.format("Tip Amount: $%.2f", tipAmount));
                totalAmountLabel.setText(String.format("Total Amount: $%.2f", totalAmount));
            } catch (NumberFormatException ex) {                
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number for the bill amount.");
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
