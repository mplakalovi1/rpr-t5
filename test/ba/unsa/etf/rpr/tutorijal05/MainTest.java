package ba.unsa.etf.rpr.tutorijal05;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private Label display;

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("digitron.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void startWithZero (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        assertEquals("0", display.getText());
    }

    @Test
    public void numberOne (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        assertEquals("1", display.getText());
    }

    @Test
    public void number123 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        assertEquals("123", display.getText());
    }

    @Test
    public void number123Plus456 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        assertEquals("456", display.getText());
    }

    @Test
    public void number123Plus456Equals (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        robot.clickOn("#equalsBtn");
        assertEquals("579.0", display.getText());
    }

    @Test
    public void dotBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn1");
        robot.clickOn("#equalsBtn");
        assertEquals("89.88", display.getText());
    }

    @Test
    public void zeroBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        assertEquals("0", display.getText());
    }

    @Test
    public void zeroBtn2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        robot.clickOn("#btn1");
        robot.clickOn("#btn0");
        assertEquals("10", display.getText());
    }

    @Test       //  Ako operand vec ima tacku u sebi, ne moze se na njeg dodati jos jedna tacka
    public void dotBtn2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn8");
        robot.clickOn("#btn7");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn8");
        robot.clickOn("#btn9");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        assertEquals("87.895", display.getText());
    }

    @Test       //  Test kaskadnog minusa sa decimalnim brojevima
    public void number12Dot3Minus45Dot3Minus5 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn3");
        robot.clickOn("#minusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn3");
        robot.clickOn("#equalsBtn");
        robot.clickOn("#minusBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("-38.0", display.getText());
    }

    @Test       //  Test kaskadnog plusa
    public void number12Plus45Plus5 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("62.0", display.getText());
    }

    @Test       //  Test kaskadnog mnozenja
    public void number12Times20Times5 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#putaBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        robot.clickOn("#putaBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("1200.0", display.getText());
    }

    @Test       //  Test kaskadnog dijeljenja
    public void number120Divides20Divides3 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#podijeljenoBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        robot.clickOn("#podijeljenoBtn");
        robot.clickOn("#btn3");
        robot.clickOn("#equalsBtn");
        assertEquals("2.0", display.getText());
    }

    @Test       //  Test mnozenja s nulom
    public void number120Times20Iimes0 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#putaBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        robot.clickOn("#putaBtn");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        assertEquals("0.0", display.getText());
    }

    @Test       //  Test dijeljenja s nulom
    public void number120Divides0 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn0");
        robot.clickOn("#podijeljenoBtn");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        assertEquals("ERROR", display.getText());
    }

    @Test       //  Test ostatka
    public void mod (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn5");
        robot.clickOn("#modBtn");
        robot.clickOn("#btn7");
        robot.clickOn("#equalsBtn");
        assertEquals("1", display.getText());
    }
}