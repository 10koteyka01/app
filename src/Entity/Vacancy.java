package Entity;

public class Vacancy {
    private String name;
    private String date;
    private String organization;
    private String payment;

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

}
