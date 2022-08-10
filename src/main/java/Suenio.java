import javax.persistence.*;

public abstract class Suenio {

    private String descripcion;
    private String categoria;
    private int felicidonios;
    private boolean cumplido;


    public Suenio(String _desc, int _felic) {
        descripcion = _desc;
        felicidonios = _felic;
        cumplido = false;
    }

    public Suenio() {

    }


    public int getFelicidonios() {
        return felicidonios;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void cumplirParaPersona(Persona _p) {
        if (!_p.getDreams().contains(this)) {
            throw new ExSuenioNoPendiente();
        }
        this.validarParaPersona(_p);
        this.realizarPersona(_p);
        this.cumplido = true;
        _p.sumarFelicidonios(this.getFelicidonios());
    }

    protected abstract void realizarPersona(Persona _p);

    protected abstract void validarParaPersona(Persona _p);

    public boolean esAmbicioso() {
        return getFelicidonios() >= 100;
    }
}
