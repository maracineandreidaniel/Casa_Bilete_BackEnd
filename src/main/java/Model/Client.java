package Model;

public class Client {

    private String nume;
    private String parola;

    public Client(String nm, String prl){
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
        return "Acest client se numeste "+ nume+".";
    }
}
