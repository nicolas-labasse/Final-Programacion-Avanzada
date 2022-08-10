public class SuenioHijos extends Suenio {
    int cantidad;
    boolean isAdoptado;

    public SuenioHijos(String _desc, int _felic, boolean _isAdoptado, int _cantidad) {
        super(_desc, _felic);
        cantidad = _cantidad;
        isAdoptado = _isAdoptado;
    }

    @Override
    public void validarParaPersona(Persona _p) {
        if(this.isCumplido()){
            throw new ExCarreraRealizada();
        }

        if(_p.getNumeroHijos() > 0){
            throw new ExAdoptarHijo();
        }

    }

    @Override
    public void realizarPersona(Persona _p) {
        _p.sumarNumeroHijos(this.cantidad);
    }
}