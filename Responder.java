import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<String,String> responseMap;

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
     * Introduce en el HashMap de la clase varias respuestas predeterminadas.
     */
    public void fillResponseMap(){
        responseMap.put("fallo","Por favor indique el tipo de fallo.");
        responseMap.put("apaga","Pruebe a restablecer los valores de fábrica.");
        responseMap.put("roto","Indique el producto a reemplazar.");
        responseMap.put("humo","Corra por su vida...");
    }

    /**
     * Devuelve una respuesta especifica segun la palabra introducida como
     * parametro por el usuario. Si no existe una respuesta asociada a dicha
     * palabra devuelve una respuesta aleatoria de la coleccion "respuestas".
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput){
        String response = null;
        Iterator<String> it = userInput.iterator();
        
        while(it.hasNext() && response == null){
            response = responseMap.get(it.next());
        }
        
        if(response == null){
            response = pickDefaultresponse();
        }

        return response;
    }
}
