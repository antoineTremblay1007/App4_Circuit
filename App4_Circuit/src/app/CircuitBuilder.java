package app;

import com.fasterxml.jackson.databind.JsonNode;
import electronique.CircuitParallele;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {

    public CircuitBuilder(){}

    public Composant construireCircuit(String composant){
        return null;
    }

    private Composant lireComposant(JsonNode node){
        String type = node.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        }else if ("serie".equals(type)) {
            List<Composant> composant = new ArrayList<>();
            for(JsonNode composantNode : node.get("composants")) {
                composant.add(lireComposant(composantNode));
            }
            return new CircuitSerie(composant);
        }
        else if("parallele".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for(JsonNode composantsNode : node.get("composants")) {
                composants.add(lireComposant(composantsNode));
            }
            return new CircuitParallele(composants);
        }
        throw new IllegalArgumentException("Type de circuit invalide : " + type);
    }
}
