package Controllers;

import Model.Bilet;
import Repositories.AutobuzRepository;
import Repositories.BiletRepository;
import Repositories.ClientRepository;

import java.util.List;

public class BiletController {
    private BiletRepository bilete;
    private AutobuzRepository autobuze;
    private ClientController clienti;


    public BiletController(){
        bilete=new BiletRepository();
        autobuze=new AutobuzRepository();
        clienti=new ClientController();
    }

    public void insert(Bilet bilet){
        if(autobuze.existAutobuz(bilet.getAutobuz()) && clienti.existClient(bilet.getClient()))
            bilete.insertBilet(bilet);
        else
            System.out.println("Autobuzul/Clientul nu exista");
    }
    public void remove(int nr){
        if(existBilet(nr)==true)
            bilete.removeBilet(nr);
        else
            System.out.println("Biletul nu exista");
    }

    public void updateClient(int nr, String clientNou){
        if(existBilet(nr)==true)
            bilete.updateClient(nr,clientNou);
        else
            System.out.println("Biletul nu exista.");
    }

    public void updateData(int nr, String dataNoua){
        if(existBilet(nr)==true)
            bilete.updateData(nr,dataNoua);
        else
            System.out.println("Biletul nu exista.");
    }

    public void updateAutobuz(int nr, String autobuzNou){
        if(existBilet(nr)==true)
            bilete.updateAutobuz(nr,autobuzNou);
        else
            System.out.println("Biletul nu exista.");
    }

    public List<Bilet> allBilete(){
        return bilete.allBilete();
    }

    public boolean existBilet(int nr){
        for(Bilet b:this.allBilete())
            if(b.getNumar()==nr)
                return true;
        return false;
    }

    public Bilet getBiletNr(int nr){
        if(existBilet(nr)==true)
            for(Bilet b:allBilete())
                if(b.getNumar()==nr)
                    return b;
        return null;
    }
}
