import java.util.ArrayList;
import java.util.List;

public class CampoVazioException extends Exception {
    public CampoVazioException(String campo) {
        super("O campo \"" + campo + "\" não pode estar vazio.");
    }
}