package Const;

import java.util.HashMap;
import java.util.Map;

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
}
