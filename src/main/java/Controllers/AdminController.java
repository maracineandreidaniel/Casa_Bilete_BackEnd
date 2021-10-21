package Controllers;

import Model.Admin;
import Model.Client;
import Repositories.AdminRepository;
import Repositories.ClientRepository;

import java.util.List;

public class AdminController {

    private AdminRepository admini;

    public AdminController(){
        admini=new AdminRepository();
    }

    public void insert(Admin admin){
        admini.insertAdmin(admin);
    }

    public void remove(String nume){
        if(existAdmin(nume)==false)
            System.out.println("Adminul nu exista");
        else
            admini.removeAdmin(nume);
    }

    public void updateNume(String nume, String numeNou){
        if(existAdmin(nume)==false)
            System.out.println("Adminul nu exista");
        else
            admini.updateNume(nume,numeNou);
    }

    public void updateParola(String nume, String parolaNoua){
        if(existAdmin(nume)==false)
            System.out.println("Adminul nu exista");
        else
            admini.updateParola(nume,parolaNoua);
    }

    public List<Admin> allAdmini(){
        return admini.allAdmini();
    }

    public boolean existAdmin(String nume){
        for(Admin a:allAdmini())
            if(a.getNume().equals(nume))
                return true;
        return false;
    }

    public Admin getAdminNumeParola(String nume,String parola){
        if(existAdmin(nume)==true)
            for(Admin a:allAdmini())
                if(a.getNume().equals(nume) && a.getParola().equals(parola))
                    return a;
        return null;
    }



}