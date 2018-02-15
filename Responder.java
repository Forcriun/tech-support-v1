import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<HashSet<String>,String> responseMap;

    /**
     * Constructor de la clase.
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        responseMap = new HashMap<>();
        fillResponseMap();

        respuestas.add("Respuesta 1");
        respuestas.add("Respuesta 2");
        respuestas.add("Respuesta 3");
        respuestas.add("Respuesta 4");
        respuestas.add("Respuesta 5");
    }

    /**
     * Devuelve una respuesta aleatoria de entre las que
     * conforman la coleccion "respuestas".
     * @return   A string that should be displayed as the response
     */
    public String pickDefaultresponse()
    {
        return respuestas.get(aleatorio.nextInt(respuestas.size()));
    }

    /**
     * Introduce en el HashMap de la clase varias respuestas predeterminadas
     * asociadas a claves de conjuntos de cadenas.
     */
    public void fillResponseMap(){
        HashSet<String> set001 = new HashSet<>();
        set001.add("free");
        set001.add("app");

        HashSet<String> set002 = new HashSet<>();
        set002.add("free");

        HashSet<String> set003 = new HashSet<>();
        set003.add("app");

        HashSet<String> set004 = new HashSet<>();
        set004.add("problem");
        set004.add("crash");
        set004.add("linux");

        responseMap.put(set001, "Respuesta \"free app\"/\"app free\"");
        responseMap.put(set002, "Respuesta \"free\"");
        responseMap.put(set003, "Respuesta \"app\"");
        responseMap.put(set004, "Respuesta \"problem crash linux/crash linux problem\"");
    }

    /**
     * Devuelve una respuesta especifica segun la palabra introducida como
     * parametro por el usuario (sensible a conjuntos de palabras). Si no
     * existe una respuesta asociada a dicha palabra devuelve una respuesta
     * aleatoria de la coleccion "respuestas".
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput){
        String response = null;
        response = responseMap.get(userInput);

        if(response == null){
            response = pickDefaultresponse();
        }

        return response;
    }
}
