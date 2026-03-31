package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{
    int n =0;
    public CircuitSerie(List<Composant> composants) {
        calculerResistance(composants, n);
    }

    public double calculerResistance(List<Composant> composants, int n) {
        if (composants.isEmpty()){
            return 0;}
        else if (composants.size() == 1){
            return composants.indexOf(n);
        }
        return composants.indexOf(n) + calculerResistance(composants, n + 1);
    }
}
