import java.util.ArrayList;
import java.util.Random;

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
    
    /**
     * Constructor de la clase.
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        
        respuestas.add("Respuesta 1");
        respuestas.add("Respuesta 2");
        respuestas.add("Respuesta 3");
        respuestas.add("Respuesta 4");
        respuestas.add("Respuesta 5");
    }

    /**
     * Genera una respuesta aleatoria de entre las que
     * conforman la coleccion "respuestas".
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return respuestas.get(aleatorio.nextInt(respuestas.size()));
    }
}
