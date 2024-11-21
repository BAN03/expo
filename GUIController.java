import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class GUIController {
    @FXML
    TextField nombre, peso, categoria;
    @FXML
    Button crear;
    @FXML
    RadioButton libras, kilos;

    private ToggleGroup pesos = new ToggleGroup();
    private Boxeador boxeador;

    @FXML
    public void initialize() {
        libras.setToggleGroup(pesos);
        kilos.setToggleGroup(pesos);
    }


    @FXML
    public void crearBoxeador() {
        if (nombre.getText().isEmpty() || categoria.getText().isEmpty() || peso.getText().isEmpty()) {
            return;
        }
        this.boxeador = new Boxeador(nombre.getText(), categoria.getText(), Double.parseDouble(peso.getText()));
        crear.setDisable(true);
    }

    @FXML
    public void mostarPeso() {
        if (libras.isSelected()) {
            this.boxeador.toLibras();
            peso.setText(String.valueOf(this.boxeador.getPeso()));
        } else if (kilos.isSelected()) {
            this.boxeador.toKilos();
            peso.setText(String.valueOf(this.boxeador.getPeso()));
        }
    }
    @FXML
    public void salir() {
        System.exit(0);
    }
}
