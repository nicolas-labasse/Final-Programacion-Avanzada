import java.util.List;

public abstract class TipoPersona {
    String descripcion;

    public TipoPersona(String _d) {
        descripcion = _d;
    }

    public abstract Suenio determinarSuenio(List<Suenio> _l);
}
