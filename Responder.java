
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
    private HashSet<String> linuxCrashProblem;
    private HashSet<String> interfaceBugProblem;
    private String respuestaAnt;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        random = new Random();
        respuestas = new ArrayList<String>();
        respuestaAnt = "";
        windowsProblem = new HashSet<>();
        windowsProblem.add("windows");
        windowsProblem.add("problem");
        linuxCrashProblem = new HashSet<>();
        linuxCrashProblem.add("linux");
        linuxCrashProblem.add("crash");
        linuxCrashProblem.add("problem");
        interfaceBugProblem = new HashSet<>();
        interfaceBugProblem.add("interface");
        interfaceBugProblem.add("bug");
        interfaceBugProblem.add("problem");
        filtro = new HashMap<>();
        filtro.put(windowsProblem, "Our software dont run on windows, only run on android.");
        filtro.put(linuxCrashProblem, "Our software dont run on linux, only run on android.");
        filtro.put(interfaceBugProblem, "Sorry maybe we have a problem in our interface we will look into it.");
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
        int coincAnteriores = 0;
        Iterator<HashSet<String>> ite = filtro.keySet().iterator();
        while (ite.hasNext()){
            int coincidencias = 0;
            HashSet<String> coleccion = ite.next();
            for (String palabra : userInput){
                if (coleccion.contains(palabra)){
                    coincidencias++;
                }
            }
            if (coincidencias > 0 && coincAnteriores <= coincidencias){
                respuesta = filtro.get(coleccion);
                coincAnteriores = coincidencias;
            }

        }
        if (respuesta.equals("") || respuestaAnt.equals(respuesta)) {
            respuesta = respuestas.get(random.nextInt(respuestas.size()));
        }
        respuestaAnt = respuesta;
        return respuesta;
    }
}
