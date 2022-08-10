public class ExAdoptarHijo extends RuntimeException {
    public ExAdoptarHijo() {
        super ("No puede adoptar, ya tiene hijos");
    }
}
