public class SuenioTrabajo extends Suenio {
    int sueldo;

    public SuenioTrabajo(String _desc, int _felic, int _sueldo) {
        super(_desc, _felic);
        sueldo = _sueldo;
    }



    @Override
    public void validarParaPersona(Persona _p) {
        if(this.isCumplido()){
            throw new ExCarreraRealizada();
        }

        if(this.sueldo < _p.getSueldoMin()){
            throw new ExSueldoNoDeseado();
        }
    }

    @Override
    public void realizarPersona(Persona _p) {

    }
}
