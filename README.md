# Ontology Lookup Service (OLS) Client

A simple Java client to interact with the Ontology Lookup Service (OLS) API. This client allows you to fetch and display details of an ontology using its ID.

## Prerequisites

- Java 8 or higher
- Maven

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/ontology-service.git
    ```

2. Navigate to the project directory:

    ```bash
    cd ontology-service
    ```

3. Compile the project:

    ```bash
    mvn compile
    ```

## Usage

Run the following command to fetch ontology details:

```bash
mvn exec:java -Dexec.mainClass="main.java.OntologyLookupService" -Dexec.args="<OntologyID> <OutputType>"


<OntologyID>: The ID of the ontology (e.g., 'efo', 'agro').
<OutputType>:
1 for human-readable output
2 for machine-readable JSON output
Examples
To fetch details of the 'efo' ontology in human-readable format:

bash
Copy code
mvn exec:java -Dexec.mainClass="main.java.OntologyLookupService" -Dexec.args="efo 1"
To fetch details of the 'efo' ontology in machine-readable JSON format:

bash
Copy code
mvn exec:java -Dexec.mainClass="main.java.OntologyLookupService" -Dexec.args="efo 2"