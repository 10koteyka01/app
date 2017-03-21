package Entity;

import java.util.Objects;

public class Vacancy {
    private int ID;
    private String name;
    private String date;
    private String organization;
    private String payment;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    @Override
    public String toString(){
        return "Название вакансии: " + name 
                + " дата: " + date + " организация: " 
                + organization + " зарплата: " + payment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + Objects.hashCode(this.organization);
        hash = 83 * hash + Objects.hashCode(this.payment);
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if (!(o instanceof Vacancy))return false;
        if((Vacancy) o == this) return true;
        Vacancy vac = (Vacancy) o;
        if(vac.getName() != null ? !this.name.equals(vac.getName()) : this.name != null) return false;
        if(vac.getDate() != null ? !this.date.equals(vac.getDate()) : this.date != null) return false;
        if(vac.getOrganization() != null ? !this.organization.equals(vac.getOrganization()) : this.organization != null) return false;
        if(vac.getPayment() != null ? !this.payment.equals(vac.getPayment()) : this.payment != null) return false;
        return this.hashCode() == o.hashCode();
    }

}
