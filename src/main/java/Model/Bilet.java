package Model;

import java.time.LocalDateTime;

public class Bilet {
    private String client;
    private LocalDateTime data;
    private String autobuz;
    private int numar;

    public Bilet(String client, String data, String autobuz){
        this.client=client;
        this.data=convertStringLocalDateTime(data);
        this.autobuz=autobuz;
        this.numar= (int) (Math.random()*10000+99999);
    }

    public Bilet(int numar,String client, String data, String autobuz){
        this.numar=numar;
        this.client=client;
        this.data=convertStringLocalDateTime(data);
        this.autobuz=autobuz;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getAutobuz() {
        return autobuz;
    }

    public void setAutobuz(String autobuz) {
        this.autobuz = autobuz;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Biletul "+numar+" a fost emis la data de "
                + data+" pentru clientul "+client+" la autobuzul "+autobuz+'\n';
    }



    public static String convertLDTtoStringTFormat(LocalDateTime ldt){
        return String.format("%s",ldt);
    }

    public static String parameterStringConvert(String data){
        String dataF="";
        String[] p1=data.split("T");
        String[] p2=p1[0].split("-");
        String[] p3=p1[1].split(":");
        dataF+=p2[2]+","+p2[1]+","+p2[0]+","+p3[0]+","+p3[1];
        return dataF;
    }

    public static LocalDateTime convertStringLocalDateTime(String data){
        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);
        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }
}
