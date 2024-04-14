package main.java;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

/**
 * A class to interact with the Ontology Lookup Service API.
 * 
 * <p>
 * This class provides methods to fetch ontology details from the Ontology Lookup Service
 * and print them in human-readable or machine-readable format.
 * </p>
 * 
 * @author Muhammad Shabbir
 * @version 1.0
 */

public class OntologyLookupService {
    
    /**
     * Fetches and returns ontology details based on the given ontology ID and output type.
     * 
     * <p>
     * This method interacts with the Ontology Lookup Service API to fetch details about
     * the specified ontology. The output type determines the format of the returned details:
     * <ul>
     *     <li>1: Human-readable format</li>
     *     <li>2: Machine-readable format (JSON)</li>
     * </ul>
     * </p>
     * 
     * @param ontologyId The ontology ID to fetch details for.
     * @param outputType The output type (1 for human-readable, 2 for machine-readable).
     * @return The ontology details in the specified format.
     */

    public static String getOntologyDetails(String ontologyId, int outputType) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI("https://www.ebi.ac.uk/ols4/api/ontologies/" + ontologyId))
            .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            // System.out.println(getResponse.body());
            Ontology ontology = new Ontology();
            Gson gson = new Gson();
            ontology = gson.fromJson(getResponse.body(), Ontology.class);

            if (outputType == 1) {
                return ontology.toString();
            }
            else {
                return gson.toJson(ontology);
            }
        }
        catch (URISyntaxException e) {
            System.out.println("Invalid URI syntax: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());    
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("It looks like you entered an invalid ontology ID");
            System.out.println("System error: " + e.getMessage());
        }
        return "";
    }
    
    /**
     * The main method to interact with the Ontology Lookup Service API from the command line or shell.
     * 
     * <p>
     * This method receives an ontology ID and an output type as command-line arguments.
     * It fetches details about the specified ontology and prints them to the standard output.
     * </p>
     * 
     * <p>
     * The output type determines the format of the printed details:
     * <ul>
     *     <li>1: Human-readable format</li>
     *     <li>2: Machine-readable format (JSON)</li>
     * </ul>
     * </p>
     * 
     * <p>
     * Example usage:
     * <ul>
     *     <li>
     *         To print human-readable details for ontology with ID 'efo':
     *         <code>java OntologyLookupService efo 1</code>
     *     </li>
     *     <li>
     *         To print machine-readable details for ontology with ID 'efo':
     *         <code>java OntologyLookupService efo 2</code>
     *     </li>
     * </ul>
     * </p>
     * 
     * @param args An array of command-line arguments. The first argument should be the ontology ID,
     *             and the second argument should be the output type (1 for human-readable, 2 for machine-readable).
     */
    
    public static void printMenuMessage() {
            System.out.println("Invalid type for output type.");
            System.out.println("Please provide the following:");
            System.out.println("    - An ontology ID as an argument.");
            System.out.println("    - 1 or 2 for a human readable or machine readable (JSON) output respectively.");
    };

        public static void main(String[] args) {
            if (args.length == 2) {
                try {
                    String ontologyId = args[0];
                    int outputType = Integer.parseInt(args[1]);
                    
                    if (outputType != 1 && outputType != 2) {
                        printMenuMessage();
                        return;
                    }
                    System.out.println(getOntologyDetails(ontologyId, outputType));
                }
                catch(Exception e)  {
                    System.out.println("Invalid type/input for output type.");
                    printMenuMessage();
                }
            } else {
                System.out.println("Please provide the following:");
                printMenuMessage();
            }
        }

}
