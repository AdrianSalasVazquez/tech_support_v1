
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
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
    private HashMap<String, String> filtro;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        respuestas = new ArrayList<String>();
        filtro = new HashMap<>();
        filtro.put("windows", "Your computer software could be the problem.");
        filtro.put("linux", "Your computer software could be the problem.");
        filtro.put("bug", "Sorry for the problems we will try to solve it.");
        filtro.put("slow", "Maybe your hardware could be problem. Try with a better hardware.");
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
    public String generateResponse(String userInput)
    {
        String respuesta = "";
        if (filtro.containsKey(userInput)){
            respuesta = filtro.get(userInput);
        }
        else {
            respuesta = respuestas.get(random.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}
