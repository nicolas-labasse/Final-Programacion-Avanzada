import java.util.ArrayList;
import java.util.List;

public class SuenioMultiple extends Suenio {
    List<Suenio> incDreams;

    String descripcion;

    public SuenioMultiple(List<Suenio> _s,String _d) {
        super(_d, 0);
        descripcion = _d;
        incDreams = _s;
    }

    public void add(Suenio _s) {
        incDreams.add(_s);
    }

    public List<Suenio> getIncDreams() {
        return incDreams;
    }

    @Override
    public int getFelicidonios() {
        return incDreams.stream().mapToInt(suenio->suenio.getFelicidonios()).sum();
    }

    @Override
    protected void realizarPersona(Persona _p) {
        incDreams.forEach(suenio-> suenio.realizarPersona(_p));
    }

    @Override
    protected void validarParaPersona(Persona _p) {

        incDreams.forEach(suenio-> suenio.validarParaPersona(_p));

    }
}