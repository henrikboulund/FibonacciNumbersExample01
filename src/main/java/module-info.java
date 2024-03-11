module dk.easv.fibonaccinumbersexample01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.fibonaccinumbersexample01 to javafx.fxml;
    exports dk.easv.fibonaccinumbersexample01;
}