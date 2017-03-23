package Const;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;

public class Areas {
    private static final Map <Double, String> area = new HashMap();
    public Areas(){
        area.put(4.0, "Новосибирск");
        area.put(1130.0, "Братск");
    }
    public static Map getArea(){
        return area;
    }
    
    public static double getKey(JComboBox<String> box) throws IOException{
        for (Map.Entry<Double, String> e : area.entrySet()){
            if (box.getSelectedItem().toString().equals(e.getValue())) return e.getKey();
        }
        throw new IOException();
    }
}
