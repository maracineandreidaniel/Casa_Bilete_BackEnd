package Controllers;

import Model.Client;
import Repositories.ClientRepository;

import java.util.List;

public class ClientController {

    private ClientRepository clienti;

    public ClientController(){
        clienti=new ClientRepository();
    }

    public void insert(Client client){
        clienti.insertClient(client);
    }

    public void remove(String nume){
        if(existClient(nume)==false)
            System.out.println("Clientul nu exista");
        else
            clienti.removeClient(nume);
    }

    public void updateNume(String nume, String numeNou){
        if(existClient(nume)==false)
            System.out.println("Clientul nu exista");
        else
            clienti.updateNume(nume,numeNou);
    }

    public void updateParola(String nume, String parolaNoua){
        if(existClient(nume)==false)
            System.out.println("Clientul nu exista");
        else
            clienti.updateParola(nume,parolaNoua);
    }

    public List<Client> allClienti(){
        return clienti.allClienti();
    }

    public boolean existClient(String nume){
        for(Client c:allClienti())
            if(c.getNume().equals(nume))
                return true;
        return false;
    }

    public Client getClientNumeParola(String nume,String parola){
        if(existClient(nume)==true)
            for(Client c:allClienti())
                if(c.getNume().equals(nume) && c.getParola().equals(parola))
                    return c;
        return null;
    }



}
