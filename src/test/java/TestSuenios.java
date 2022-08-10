import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

//     package test;
//
//        import static org.junit.Assert.*;
//
//        import java.util.Arrays;
//
//        import org.junit.Before;
//        import org.junit.Test;
//
//        import suenios.Persona;
//        import suenios.suenios.AdoptarHijo;
//        import suenios.suenios.Recibirse;
//        import suenios.suenios.SuenioMultiple;
//        import suenios.suenios.TenerHijos;
//        import suenios.suenios.Trabajar;
//        import suenios.suenios.Viajar;
//        import suenios.tipopersona.Alocado;
//        import suenios.tipopersona.Obsesivo;
//        import suenios.tipopersona.Realista;

public class TestSuenios
{
    SuenioHijos adoptar2Hijos;
    SuenioCarrera recibirseDeLicenciadoEnSistemas;
    SuenioHijos tener2Hijos;
    SuenioHijos tener1Hijo;
    SuenioViajar viajarABrasil;
    SuenioViajar viajarACataratas;
    SuenioViajar viajarAChapadmalal;
    SuenioTrabajo trabajarProgramador;
    SuenioTrabajo trabajarOficinista;
    SuenioMultiple suenioMultiple;
    Persona pedro;
    Persona juan;
    Persona pablo;

    @Before
    public void setUp() throws Exception
    {
        adoptar2Hijos=new SuenioHijos("adoptar 2 hijos",100,true,2);
        recibirseDeLicenciadoEnSistemas=new SuenioCarrera("estudio terciario en sistemas",60,"Licenciado en sistemas");
        tener2Hijos=new SuenioHijos("tener 2 hijos",150,false,2);
        viajarABrasil=new SuenioViajar("viajar a un lugar veraniego",190,"Brasil");
        viajarAChapadmalal=new SuenioViajar("viajar",110,"Chapadmalal");
        trabajarProgramador=new SuenioTrabajo("trabajar de ingeniero en sistemas",70,80000);

        viajarACataratas=new SuenioViajar("viajar por argentina",80,"Cataratas");
        tener1Hijo=new SuenioHijos("tener un hijo",140,false,1);
        trabajarOficinista=new SuenioTrabajo("trabajar de profesor de matematica",70,10000);
        suenioMultiple=new SuenioMultiple( Arrays.asList(viajarACataratas,tener1Hijo,trabajarOficinista),"1000");

        pedro=new Persona("Pedro", "Labasse",10,new TipoPersonaAlocado());
        pedro.ponerDreams(Arrays.asList(adoptar2Hijos,viajarAChapadmalal,recibirseDeLicenciadoEnSistemas));
        juan=new Persona("Juan","Retamar",100,new TipoPersonaRealista());
        juan.ponerDreams(Arrays.asList(tener2Hijos,viajarABrasil,suenioMultiple));
        pablo=new Persona("Pablo","apellido",200,new TipoPersonaObsesivo());
        pablo.ponerDreams(Arrays.asList(trabajarProgramador,viajarABrasil,tener2Hijos,adoptar2Hijos));
    }

    /*SUEÑOS*/
    @Test
    public void testTener1HijoEsAmbicioso()
    {
        assertTrue(tener1Hijo.esAmbicioso());
    }

    @Test
    public void testViajarACataratasNoEsAmbicioso()
    {
        assertFalse(viajarACataratas.esAmbicioso());
    }

    /*
     * PEDRO
     */


    @Test
    public void pedroCumpliSuenios()
    {
        pedro.setCarrerasQueQuiereEstudiar(Arrays.asList("Licenciado en sistemas"));
        pedro.cumplir(recibirseDeLicenciadoEnSistemas);
        pedro.cumplir(viajarAChapadmalal);
        pedro.cumplir(adoptar2Hijos);
    }

    @Test
    public void testPedroSeRecibeDeLicenciadoEnSistemas()
    {
        pedro.setCarrerasQueQuiereEstudiar(Arrays.asList("Licenciado en sistemas"));
        pedro.cumplir(recibirseDeLicenciadoEnSistemas);
        assertEquals(60,pedro.getFelicidonios(), 0.001);
        assertTrue(pedro.getCarrerasCompletadas().contains("Licenciado en sistemas"));
        assertTrue(recibirseDeLicenciadoEnSistemas.isCumplido());
    }

    @Test(expected= ExCarreraRealizada.class)
    public void testPedroYaEstaRecibidoDeLicenciadoEnSistemas()
    {
        pedro.setCarrerasQueQuiereEstudiar(Arrays.asList("Licenciado en sistemas"));
        pedro.cumplir(recibirseDeLicenciadoEnSistemas);
        pedro.cumplir(recibirseDeLicenciadoEnSistemas);
    }

    @Test(expected=ExSuenioNoPendiente.class)
    public void testPedroNoPuedeCumplirViajarABrasil()
    {
        pedro.cumplir(viajarABrasil);
    }

    @Test
    public void testPedroCumpleCualquierSueño()
    {
        pedro.cumplirPorTipoPersona();
        assertEquals(110,pedro.getFelicidonios(), 0.001);
        assertTrue(pedro.getDreams().stream().anyMatch(s -> s.isCumplido()));
    }

    @Test
    public void testPedroEsAmbiciosa()
    {
        pedroCumpliSuenios();
        assertFalse(pedro.esAmbicioso());
    }

    @Test
    public void testPedroEsFeliz()
    {
        pedroCumpliSuenios();
        assertTrue(pedro.esFeliz());
    }

    /*
     * JUAN
     */

    @Test
    public void testJuanViajaABrasil()
    {
        juan.cumplir(viajarABrasil);
        assertEquals(190,juan.getFelicidonios(), 0.001);
        assertTrue(juan.getLugaresVisitados().contains("Brasil"));
    }

    @Test
    public void testJuanNoPuedeCumplirSuenioMultiple()
    {
        juan.setSueldoPretendido(10000);
        juan.cumplir(suenioMultiple);
    }

    @Test(expected=ExCarreraNoDeseada.class)
    public void testJuanNoEstudiaAlgoQueNoQuiere()
    {
        juan.setCarrerasQueQuiereEstudiar(Arrays.asList("Medicina"));
        juan.addDream(recibirseDeLicenciadoEnSistemas);
        juan.cumplir(recibirseDeLicenciadoEnSistemas);
    }

    @Test
    public void testJuanCumpleElMayorSueño()
    {
        juan.setSueldoPretendido(10000);
        juan.cumplirPorTipoPersona();
        assertEquals(1,juan.getNumeroHijos(), 0.001);
        assertEquals(290,juan.getFelicidonios(), 0.001);
        assertFalse(tener1Hijo.isCumplido());
        assertTrue(suenioMultiple.isCumplido());
        assertEquals(290, suenioMultiple.getFelicidonios(), 0.001);
    }

    /*
     * PABLO
     */

    @Test
    public void testPabloViajaABrasil()
    {
        pablo.cumplir(viajarABrasil);
        assertEquals(190,pablo.getFelicidonios(), 0.001);
        assertTrue(pablo.getLugaresVisitados().contains("Brasil"));
    }

    @Test(expected=ExAdoptarHijo.class)
    public void testPabloNoAdoptarHijosLuegoDeTenerlos()
    {
        pablo.cumplir(tener2Hijos);
        pablo.cumplir(adoptar2Hijos);
    }

    @Test(expected=ExSueldoNoDeseado.class)
    public void testPabloNoAceptaTrabajarDeProgramador()
    {
        pablo.setSueldoPretendido(100000);
        pablo.cumplir(trabajarProgramador);
    }

    @Test
    public void testPabloCumpleElPrimeroSueño()
    {
        pablo.setSueldoPretendido(80000);
        pablo.cumplirPorTipoPersona();
        assertEquals(70,pablo.getFelicidonios(), 0.001);
        assertTrue(pablo.getSueldoMin().compareTo(80000) == 0);
        assertTrue(trabajarProgramador.isCumplido());
    }

}