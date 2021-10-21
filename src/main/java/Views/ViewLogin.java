package Views;

import Controllers.AdminController;
import Controllers.BiletController;
import Controllers.ClientController;
import Model.Admin;
import Model.Client;

import java.util.Scanner;

public class ViewLogin {

    private Scanner scanner;
    private AdminController admini;
    private ClientController clienti;
    private BiletController bilete;

    public ViewLogin() {
        this.scanner = new Scanner(System.in);
        this.admini = new AdminController();
        this.clienti = new ClientController();
        this.bilete = new BiletController();
    }

    private String meniu() {
        String text = "";
        text += "Apasati tasta 0 pentru a incheia\n";
        text += "Apasati tasta 1 pentru a va loga\n";
        return text;
    }

    private void login() throws Exception {

        System.out.println("Introduceti statusul dvs(ex:admin,client)");
        String status = scanner.nextLine();
        if (status.equals("admin") == false && status.equals("client") == false) {
            System.out.println("Nu ati introdus un status valid.");
        } else {
            System.out.println("Introduceti numele dvs:");
            String nume = scanner.nextLine();
            System.out.println("Introduceti parola dvs:");
            String parola = scanner.nextLine();

            if (status.equals("admin")) {
                if (admini.existAdmin(nume) == false || admini.getAdminNumeParola(nume, parola).getParola().equals(parola) == false) {
                    System.out.println("nume sau parola incorecta!");
                } else {
                    Admin a = admini.getAdminNumeParola(nume, parola);
                    ViewAdmin viewAdmin = new ViewAdmin(a);
                    viewAdmin.play();
                }

            } else if (status.equals("client")) {
                if (clienti.existClient(nume) == false || clienti.getClientNumeParola(nume, parola).getParola().equals(parola) == false) {
                    System.out.println("nume sau parola incorecte!");
                } else {
                    Client c = clienti.getClientNumeParola(nume, parola);
                    ViewClient client = new ViewClient(c);
                    client.play();

                }
            }
        }
    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run = true;
        while (run) {
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 0:
                    run = false;
                    break;
                case 1:
                    login();
                    break;
                default:
                    System.out.println(meniu());
            }
        }
    }
}