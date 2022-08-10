import java.util.List;

public class TipoPersonaObsesivo extends TipoPersona{

    public TipoPersonaObsesivo() {
        super("OBSESIVO");
    }

    public Suenio determinarSuenio(List<Suenio> _l) {
        return _l.get(0);
    }
}