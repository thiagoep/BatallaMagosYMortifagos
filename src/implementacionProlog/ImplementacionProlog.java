package implementacionProlog;
import org.jpl7.Query;

public class ImplementacionProlog {

	    private static boolean prologCargado = false;

	    public ImplementacionProlog() {
	        if (!prologCargado) { // Verifica si Prolog ya ha sido cargado
	            String consultaCarga = "consult('reglas.pl')";
	            Query qCarga = new Query(consultaCarga);
	            prologCargado = qCarga.hasSolution(); // Solo carga una vez
	            System.out.println("Archivo Prolog cargado: " + (prologCargado ? "Éxito" : "Fallo"));
	        }
	    }

	    public boolean puedeLanzarHechizo(String personaje, String hechizo) {
	        String consulta = "puede_usar_hechizo(" + personaje + ", " + hechizo + ")";
	        Query q = new Query(consulta);
	        return q.hasSolution();  // Retorna true si la consulta tiene solución
	    }

	    public boolean esObjetivoPrioritario(String atacante, String objetivo) {
	        String consulta = "objetivo_prioritario(" + atacante + ", " + objetivo + ")";
	        Query q = new Query(consulta);
	        return q.hasSolution();
	    }
	}


