package Views;

import Controllers.BiletController;
import Controllers.ClientController;
import Model.Bilet;
import Model.Client;

import java.util.Scanner;

public class ViewClient {
    private Scanner scanner;
    private Client client;
    private BiletController bilete;
    private ClientController clienti;


    public ViewClient(Client client){
        this.client=client;
        scanner=new Scanner(System.in);
        bilete=new BiletController();
        clienti=new ClientController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate biletele dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a cumpara un bilet.\n";
        text+="Apasati tasta 3 pentru a anula un bilet.\n";
        text+="Apasati tasta 4 pentru a edita username-ul.\n";
        text+="Apasati tasta 5 pentru a edita parola.\n";
        return text;
    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=scanner.nextInt();
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    vizualizareBilete();
                    break;
                case 2:
                    cumparaBilet();
                    break;
                case 3:
                    anuleazaBilet();
                    break;
                case 4:
                    modificaNume();
                    break;
                case 5:
                    modificaParola();
                    break;
            }
        }
    }

    public void vizualizareBilete(){
        for(Bilet b:bilete.allBilete())
            if(b.getClient().equals(client.getNume()))
                System.out.println(b);
    }

    public void cumparaBilet(){
        System.out.println("Introdu data la care doresti sa achizitionezi biletul");
        String data=scanner.next();
        System.out.println("Introdu numele autobuzului pe care vrei sa-l iei.");
        String buz=scanner.next();
        Bilet bilet=new Bilet(client.getNume(),data,buz);
        bilete.insert(bilet);
        System.out.println("Biletul a fost inserat.");
    }

    public void anuleazaBilet(){
        System.out.println("Introdu numarul biletului pe care vreti sa-l anulati.");
        int nr=scanner.nextInt();
        bilete.remove(nr);
        System.out.println("Biletul a fost anulat cu succes!");
    }

    public void modificaNume(){
        System.out.println("Introdu noul nume al dvs:");
        String nn=scanner.next();
        clienti.updateNume(client.getNume(),nn);
    }

    public void modificaParola(){
        System.out.println("Introdu noua parola a dvs:");
        String pn=scanner.next();
        clienti.updateParola(client.getNume(),pn);
    }


}
