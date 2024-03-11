package dk.easv.fibonaccinumbersexample01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtFibNumber;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblProgressText;

    @FXML
    private Label lblResult;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCalculateClick(ActionEvent actionEvent) {
        //get the valued entered by the user!
        int input = Integer.parseInt(txtFibNumber.getText());

        //create, configure and launch FibonacciTask
        FibonacciTask task = new FibonacciTask(input);

        // display task's messages in progress label.
        lblProgressText.textProperty().bind(task.messageProperty());

        // clear the progress label and ensure the user cannot enter a value while the system calculates!
        task.setOnRunning((succeededEvent) -> {
            btnCalculate.setDisable(true);
            lblResult.setText("");
        });

        // set the result label with value returned from the task and ensure the button is clickable again!
        task.setOnSucceeded((succeededEvent) -> {
            lblResult.setText(task.getValue().toString());
            btnCalculate.setDisable(false);
        });

        // create ExercutorService to manage the threads!
        ExecutorService executorService = Executors.newFixedThreadPool(1); //pool of one thread!
        executorService.execute(task);
        executorService.shutdown();

    }
}