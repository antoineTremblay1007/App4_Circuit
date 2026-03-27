package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{
    int n =1;
    public CircuitSerie(List<Composant> composants) {
        calculerResistance(composants);
    }

    public double calculerResistance(List<Composant> composants) {
        if (composants.size() == 0){
            return 0;}
        else if (composants.size() == 1){

        }
        return 0;
    }
}
