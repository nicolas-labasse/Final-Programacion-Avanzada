import java.util.List;

public class TipoPersonaRealista extends TipoPersona{

    public TipoPersonaRealista() {
        super("REALISTA");
    }

    public Suenio determinarSuenio(List<Suenio> _l) {

        boolean primero = true;
        Suenio maxSueno = null;
        for (Suenio dream : _l) {
            if (primero) {
                maxSueno = dream;
                primero = false;
            } else {
                if (maxSueno.getFelicidonios() < dream.getFelicidonios()) {
                    maxSueno = dream;
                }
            }
        }
        System.out.println(maxSueno);
        return maxSueno;
    }
}
