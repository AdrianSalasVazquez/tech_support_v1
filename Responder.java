
import java.util.Random;
import java.util.ArrayList;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    
    private Random random;
    private ArrayList<String> respuestas;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        respuestas = new ArrayList<String>();
        respuestas.add("That sounds interesting. Tell me more...");
        respuestas.add("Ok, I understand...");
        respuestas.add("I will look at it...");
        respuestas.add("Keep telling me everything...");
        respuestas.add("Tell me everything that I will do everything I can...");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        String respuesta = respuestas.get(random.nextInt(respuestas.size()));
        return respuesta;
    }
}
