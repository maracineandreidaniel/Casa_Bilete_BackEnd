package Model;

public class Admin {

    private String nume;
    private String parola;

    public Admin(String nm, String prl){
        this.nume=nm;
        this.parola=prl;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString(){
        return "Acest admin se numeste "+ nume+".";
    }
}
