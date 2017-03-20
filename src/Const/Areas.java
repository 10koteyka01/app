package Const;

import java.util.HashMap;
import java.util.Map;

public class Areas {
    private static final Map <Double, String> area = new HashMap();
    public Areas(){
        area.put(4.0, "Новосибирск");
        area.put(1130.0, "Братск");
    }
    public static Map getArea(){
        return area;
    }
}
