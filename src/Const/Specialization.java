package Const;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;

public final class Specialization {
    //{"id":"1.172","laboring":false,"name":"Начальный уровень, Мало опыта"}
    private static final Map<Double, String> spec = new HashMap();
    public Specialization(){
        spec.put(1.0, "IT");
        spec.put(4.0, "Административный персонал");
    }
    
    public static Map getSpec(){
        return spec;
    }
    
    public static double getKey(JComboBox<String> box) throws IOException{
        for (Map.Entry<Double, String> e : spec.entrySet()){
            if (box.getSelectedItem().toString().equals(e.getValue())) return e.getKey();
        }
        throw new IOException();
    }
}
