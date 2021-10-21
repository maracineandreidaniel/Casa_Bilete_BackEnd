package Views;

import Controllers.AdminController;
import Controllers.BiletController;
import Controllers.ClientController;
import Model.Admin;
import Model.Client;
import Repositories.AutobuzRepository;

import java.util.Scanner;

public class ViewAdmin {
    private Scanner scanner;
    private Admin admin;
    private BiletController bilete;
    private ClientController clienti;
    private AdminController admini;
    private AutobuzRepository autobuze;


    public ViewAdmin(Admin admin) {
        this.admin = admin;
        scanner = new Scanner(System.in);
        bilete = new BiletController();
        clienti = new ClientController();
        admini = new AdminController();
        autobuze = new AutobuzRepository();
    }

    private String meniu() {
        String text = "";
        text += "Apasati 0 pentru a incheia.\n";
        text += "Apasati tasta 1 pentru a introduce un admin.\n";
        text += "Apasati tasta 2 pentru a introduce un client.\n";
        text += "Apasati tasta 3 pentru a introduce un autobuz.\n";
        text += "Apasati tasta 4 pentru a sterge un admin.\n";
        text += "Apasati tasta 5 pentru a sterge un client.\n";
        text += "Apasati tasta 6 pentru a sterge un autobuz.\n";
        text += "Apasati tasta 7 pentru a edita username-ul unui admin.\n";
        text += "Apasati tasta 8 pentru a edita username-ul unui client.\n";
        text += "Apasati tasta 9 pentru a edita numele unui autobuz.\n";
        text += "Apasati 10 pentru a edita parola unui admin.\n";
        text += "Apasati 11 pentru a edita parola unui client.\n";
        return text;
    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run = true;
        while (run) {
            int alegere = scanner.nextInt();
            switch (alegere) {
                case 0:
                    run = false;
                    break;
                case 1:
                    introduAdmin();
                    break;
                case 2:
                    introduClient();
                    break;
                case 3:
                    insertAutobuz();
                    break;
                case 4:
                    removeAdmin();
                    break;
                case 5:
                    removeClient();
                    break;
                case 6:
                    removeAutobuz();
                    break;
                case 7:
                    updateAdminNume();
                    break;
                case 8:
                    updateClientNume();
                    break;
                case 9:
                    updateAutobuzNume();
                    break;
                case 10:
                    updateAdminParola();
                    break;
                case 11:
                    updateClientParola();
                    break;
            }
        }
    }


    public void introduAdmin() {
        System.out.println("Introdu numele adminului:");
        String user = scanner.next();
        System.out.println("Introdu parola adminului:");
        String pass = scanner.next();
        Admin admin = new Admin(user, pass);
        admini.insert(admin);
    }

    public void introduClient() {
        System.out.println("Introdu numele clientului:");
        String user = scanner.next();
        System.out.println("Introdu parola clientului:");
        String pass = scanner.next();
        Client client = new Client(user, pass);
        clienti.insert(client);
    }

    public void insertAutobuz() {
        System.out.println("Introdu numele autobuzului:");
        String nume = scanner.next();
        autobuze.insertAutobuz(nume);
    }

    public void removeAdmin() {
        System.out.println("Introdu numele adminului:");
        String a = scanner.next();
        admini.remove(a);
    }

    public void removeClient() {
        System.out.println("Introdu numele clientului:");
        String c = scanner.next();
        clienti.remove(c);
    }

    public void removeAutobuz() {
        System.out.println("Introdu numele autobuzului:");
        String a = scanner.next();
        autobuze.removeAutobuz(a);
    }

    public void updateAdminNume() {
        System.out.println("Introdu numele adminului:");
        String nv = scanner.next();
        System.out.println("Introdu numele nou al adminului:");
        String nn = scanner.next();
        admini.updateNume(nv, nn);
    }

    public void updateClientNume() {
        System.out.println("Introdu numele clientului:");
        String nv = scanner.next();
        System.out.println("Introdu numele nou al clientului:");
        String nn = scanner.next();
        clienti.updateNume(nv, nn);
    }

    public void updateAutobuzNume() {
        System.out.println("Introdu numele autobuzului:");
        String nv = scanner.next();
        System.out.println("Introdu numele nou al autobuzului:");
        String nn = scanner.next();
        autobuze.updateNume(nv,nn);
    }

    public void updateAdminParola() {
        System.out.println("Introdu numele adminului:");
        String nv = scanner.next();
        System.out.println("Introdu parola noua a adminului:");
        String pn = scanner.next();
        admini.updateParola(nv, pn);
    }

    public void updateClientParola() {
        System.out.println("Introdu numele clientului:");
        String nv = scanner.next();
        System.out.println("Introdu parola noua a clientului:");
        String pn = scanner.next();
        clienti.updateParola(nv, pn);
    }



}
