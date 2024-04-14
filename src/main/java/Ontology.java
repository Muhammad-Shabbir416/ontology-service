package main.java;

/**
 * A class representing ontology details fetched from the Ontology Lookup Service API.
 * 
 * <p>
 * This class represents the details of an ontology fetched from the Ontology Lookup Service API.
 * It includes the ontology ID, title, description, number of terms, status, and configuration.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */

public class Ontology {
    private String ontologyId;
    private String title;
    private String description;
    private int numberOfTerms;
    private String status;
    private Config config;

    public String getOntologyId() {
        return this.ontologyId;
    }

    public void setOntologyId(String ontologyId) {
        this.ontologyId = ontologyId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfTerms() {
        return this.numberOfTerms;
    }

    public void setNumberOfTerms(int numberOfTerms) {
        this.numberOfTerms = numberOfTerms;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Config getConfig() {
        return this.config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return  "Ontology Details:" + '\n' +
                "-----------------" + '\n' +
                "ontologyId: " + ontologyId + '\n' +
                "title: " + config.title + '\n' +
                "description: " + config.description + '\n' +
                "numberOfTerms: " + numberOfTerms + '\n' +
                "status: " + status;
    }

    /**
     * A nested class representing the configuration of an ontology.
     * 
     * <p>
     * This class represents the configuration of an ontology, including the title and description.
     * </p>
     */

    public static class Config {
        private String title;
        private String description;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
