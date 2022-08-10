import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Persona {
    private final String nombre;
    private final String apellido;
    private int sueldoMin;
    private final TipoPersona tipoPersona;
    private List<Suenio> dreams;
    private int numeroHijos;
    private int felicidonios;
    private List<String> carreras;

    private List<String> carrerasCompletadas;

    private List<String> lugaresVisitados;

    public Persona(String _n, String _a, int _sueldo, TipoPersona _tp) {
        nombre = _n;
        apellido = _a;
        dreams = new ArrayList<Suenio>();
        sueldoMin = _sueldo;
        tipoPersona = _tp;
        numeroHijos = 0;

        carreras = new ArrayList<String>();
        carrerasCompletadas = new ArrayList<String>();
        lugaresVisitados = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido;
    }

    public List<Suenio> getDreams() {
        return dreams;
    }

    public Integer getSueldoMin() {
        return sueldoMin;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void sumarNumeroHijos(int numeroHijos) {
        this.numeroHijos += numeroHijos;
    }

    public int getFelicidonios() {
        return felicidonios;
    }

    public void cumplirPorTipoPersona() {
        (tipoPersona.determinarSuenio(dreams)).cumplirParaPersona(this);
    }

    public void cumplir(Suenio _s) {
        _s.cumplirParaPersona(this);
    }

    public List<String> getLugaresVisitados() {
        return lugaresVisitados;
    }

    public void addLugaresVisitados (String _l) {
        lugaresVisitados.add(_l);
    }

    public boolean esAmbicioso() {
        int contador = 0;
        // Queremos saber si una persona es ambiciosa, esto se da si tiene más de 3 sueño (pendientes o cumplidos) con más de 100 felicidonios.
        for (Suenio dream : dreams) {
            if (dream.getFelicidonios() >= 100) {
                contador++;
            }
        }
        return contador == 3;
    }

    public void ponerDreams(List<Suenio> _d) {

        this.dreams = _d;

    }

    public int getFelicidoniosCumplidos() {
        int fel = 0;
        for (Suenio dream : dreams) {
            if (dream.isCumplido()) {
                fel += dream.getFelicidonios();
            }
        }
        return fel;
    }

    public int getFelicidoniosNoCumplidos() {
        int fel = 0;
        for (Suenio dream : dreams) {
            if (!dream.isCumplido()) {
                fel += dream.getFelicidonios();
            }
        }
        return fel;
    }

    public void sumarFelicidonios(int cantidad) {

        this.felicidonios += cantidad;

    }

    public boolean esFeliz() {
        return getFelicidoniosCumplidos() > getFelicidoniosNoCumplidos();
    }

    public Suenio getPorTipoPersona() {
        return (tipoPersona.determinarSuenio(dreams));
    }

    public List<String> getCarrerasCompletadas() {
        return carrerasCompletadas;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void moverCarrera(String _c) {
        carrerasCompletadas.add(_c);
    }
    public void setCarrerasQueQuiereEstudiar(List<String> _c) {
        carreras = _c;
    }

    public void setSueldoPretendido(int _s) {
        sueldoMin = _s;
    }

    public void addDream (Suenio _s) {
        List<Suenio> temp = new LinkedList<>(dreams);
        temp.add(_s);
        dreams = temp;
    }
}
