public class SuenioCarrera extends Suenio{
    String carrera;

    public SuenioCarrera(String _desc, int _felic, String _carrera) {
        super(_desc, _felic);
        carrera = _carrera;
    }

    public String getCarrera() {
        return carrera;
    }


    @Override
    public void validarParaPersona(Persona _p) {
        if(this.isCumplido()){
            throw new ExCarreraRealizada();
        }

        if (!_p.getCarreras().contains(carrera)) {
            throw new ExCarreraNoDeseada();
        }

        if (_p.getCarrerasCompletadas() != null && _p.getCarrerasCompletadas().contains(carrera)) {
            throw new RuntimeException(); // cambiar por exepcion personalizada
        }
    }

    @Override
    public void realizarPersona(Persona _p){
        _p.moverCarrera(carrera);
    }
}
