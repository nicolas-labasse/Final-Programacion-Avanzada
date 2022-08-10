import javax.persistence.*;

@Entity
@Table(name = "Suenio")
public class SuenioSimple {
    @Id
    private int id;
    private String descripcion;
    private int felicidonios;
    private String categoria;


    public SuenioSimple(String descripcion,int felicidonios,String categoria){

        this.descripcion = descripcion;
        this.felicidonios = felicidonios ;
        this.categoria = categoria ;

    }

    public SuenioSimple() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFelicidonios() {
        return felicidonios;
    }

    public void setFelicidonios(int felicidonios) {
        this.felicidonios = felicidonios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
