package GUI;

import Data_parser.JsonReader;
import Entity.Vacancy;
import Data_parser.Query_for_get_data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TableMethod {
    private String sql; 
    private final DBConnection dbcon;
    private Query_for_get_data query;
    
    public TableMethod(String sql){
        this.dbcon = new DBConnection();
         this.sql = sql;
     }
    public TableMethod(){
        this.dbcon = new DBConnection();
         sql = "";
     }
 //fill arraylist from DB   
    public void fillArray(ArrayList<Vacancy> list){
        if(sql == null || sql.equals("")) sql = "SELECT * FROM vacancy;";
        try {
            dbcon.pstat = dbcon.con.prepareStatement(sql);
            dbcon.rs = dbcon.pstat.executeQuery();
            while(dbcon.rs.next()){
                Vacancy vac = new Vacancy();
                vac.setName(dbcon.rs.getString(1));
                vac.setDate(dbcon.rs.getString(2));
                vac.setOrganization(dbcon.rs.getString(3));
                vac.setPayment(dbcon.rs.getString(4));
                vac.setID(Integer.parseInt(dbcon.rs.getString(5)));
                if(!list.contains(vac)) list.add(vac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //update array from URL, set the number of area and specialization
    //and get it to the speciment of class Query_for_get_data
    //then set queri to the func get_list_vacancies_from_URL
    //and get the array which returns 
    //TODO share this function, it's too big
    
    public ArrayList <Vacancy> updateArrayFromURL(double area, double spec){
        int i = 0;
        ArrayList <Vacancy> vac = new ArrayList();
        int summ = vac.size();
        while(true){
            vac.addAll(new JsonReader().get_list_vacancies_from_URL(query.getQuery(area, spec) + i));
            i++;
            if (summ != vac.size()) summ += vac.size(); 
             else break;
        }
        return vac;
    }
    
    //get two arrays and make one, without reiteratives
    
    public ArrayList <Vacancy> arrSynchronization(ArrayList<Vacancy> list1, ArrayList<Vacancy> list2){
        for(Vacancy el1 : list2){
            if(!list1.contains(el1)) list1.add(el1);
        }
        return list1;
    }
    
    //insert new data in database from site
    
    public void updateDB(ArrayList <Vacancy> arr){
        for(Vacancy vac : arr){
        sql = "INSERT INTO headhunter.vacancy (`name`, `date`, oranization, payment) \n" +
"	VALUES ('%s', '%s', '%s', '%s')";
        executeSQLQ(String.format(sql, vac.getName(), vac.getDate(), vac.getOrganization(), vac.getPayment()), "Inserted");
        
        }
    }
    
    //execute SQL query, set query and short description
    
    public void executeSQLQ(String query, String message)//выполнить запрос SQL
    {
        try 
        {
            if((dbcon.pstat.executeUpdate(query)) == 1)
            {
                JOptionPane.showMessageDialog(null, "Data " + message + " succesfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data not " + message);
            }
        } 
        catch (SQLException ex) 
        {
            System.err.println("Smth wrong with SQL, it write's this message: " + ex);
        }
   }
}
