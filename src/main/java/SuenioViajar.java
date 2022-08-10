public class SuenioViajar extends Suenio{
    String destino;

    public SuenioViajar(String _desc, int _felic, String _destino) {
        super(_desc, _felic);
        destino = _destino;
    }

    @Override
    public void validarParaPersona(Persona _p) {
        if(this.isCumplido()){
            throw new ExCarreraRealizada();
        }

        if (_p.getLugaresVisitados().contains(destino)) {
            throw new RuntimeException(); ////
        }

    }

    @Override
    public void realizarPersona(Persona _p) {
        _p.addLugaresVisitados(destino);
    }
}