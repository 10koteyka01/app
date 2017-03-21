package GUI;

import Data_parser.JsonReader;
import Entity.Vacancy;
import Data_parser.Query_for_get_data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableMethod {
    private String sql; 
    private DBConnection dbcon;
    private Query_for_get_data query;
    
    public TableMethod(String sql){
         this.sql = sql;
     }
    public TableMethod(){
         sql = "";
     }
    
    public void fillArray(ArrayList<Vacancy> list){
        if(sql == null || sql.equals("")) sql = "SELECT * FROM headhunter.vacancy;";
        try {
            dbcon.pstat = dbcon.con.prepareStatement(sql);
            dbcon.rs = dbcon.pstat.executeQuery();
            while(dbcon.rs.next()){
                Vacancy vac = new Vacancy();
                vac.setID(Integer.parseInt(dbcon.rs.getString(1)));
                vac.setName(dbcon.rs.getString(2));
                vac.setDate(dbcon.rs.getString(3));
                vac.setOrganization(dbcon.rs.getString(4));
                vac.setPayment(dbcon.rs.getString(5));
                if(!list.contains(vac)) list.add(vac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <Vacancy> updateArrayFromURL(double area, double spec){
        int i = 0;
        int summ;
        ArrayList <Vacancy> vac = new ArrayList();
        while(true){
            try {
                vac.addAll(new JsonReader().get_list_vacancies_from_URL(query.getQuery((int) area, (int) spec) + i));
            } catch (IOException ex) {
                System.out.println("there are no else elements.");
                break;
            }
        }
        return vac;
    }
    
}
