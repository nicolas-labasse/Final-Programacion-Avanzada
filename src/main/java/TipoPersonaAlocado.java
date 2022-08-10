import java.util.List;
import java.util.Random;

public class TipoPersonaAlocado extends TipoPersona{
    public TipoPersonaAlocado() {
        super("ALOCADO");
    }

    public Suenio determinarSuenio(List<Suenio> _l) {

        return _l.get(new Random().nextInt(_l.size()));
    }
}
