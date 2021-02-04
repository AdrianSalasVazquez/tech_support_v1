
import java.util.Random;
import java.util.ArrayList;
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

    private Random random;
    private ArrayList<String> respuestas;
    private HashMap<HashSet<String>, String> filtro;
    private HashSet<String> windowsProblem;
    private HashSet<String> linuxCrash;
    private HashSet<String> interfaceBug;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        respuestas = new ArrayList<String>();
        windowsProblem = new HashSet<>();
        windowsProblem.add("windows");
        windowsProblem.add("problem");
        linuxCrash = new HashSet<>();
        linuxCrash.add("linux");
        linuxCrash.add("crash");
        interfaceBug = new HashSet<>();
        interfaceBug.add("interface");
        interfaceBug.add("bug");
        filtro = new HashMap<>();
        filtro.put(windowsProblem, "Our software dont run on windows, only run on android.");
        filtro.put(linuxCrash, "Our software dont run on linux, only run on android.");
        filtro.put(interfaceBug, "Sorry maybe we have a problem in our interface we will look into it.");
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
    public String generateResponse(HashSet<String> userInput)
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
