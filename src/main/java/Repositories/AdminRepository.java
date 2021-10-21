package Repositories;

import Model.Admin;
import Model.Bilet;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
        private String jdbcurl = "jdbc:mysql://localhost:3306/casa_bilete_db?autoreconnect=true&useSSL=false";
        private String user = "root";
        private String password = "root";
        private Connection connection = null;
        private Statement statement = null;

        public AdminRepository() {
            try {
                this.connection = DriverManager.getConnection(this.jdbcurl, this.user, this.password);
                this.statement = this.connection.createStatement();
            } catch (SQLException var2) {
                System.out.println("eroare de conectare baza de date");
            }

        }

        public void executeStatement(String execute) {
            try {
                this.statement.execute(execute);
            } catch (SQLException var3) {
                System.out.println("Nu am reusit " + execute);
            }
        }


        public void insertAdmin(Admin admin) {
            String insertTo = " ";
            insertTo = insertTo + "insert into admini (nume,parola) values (";
            insertTo = insertTo + String.format("'%s','%s'",admin.getNume(),admin.getParola());
            insertTo = insertTo + ");";
            this.executeStatement(insertTo);
        }

        public void removeAdmin(String nume){
            String removeTo="";
            removeTo+=String.format("%s", "delete from admini where nume='"+nume+"';");
            executeStatement(removeTo);

        }

        public void updateNume(String nume, String numeNou){
            String update="";
            update+=String.format("update admini set nume='%s'", numeNou);
            update+=String.format(" where nume='%s'", nume);
            executeStatement(update);
        }

        public void updateParola(String nume , String parolaNoua){
            String update="";
            update+=String.format("update admini set parola='%s'", parolaNoua);
            update+=String.format(" where nume='%s'", nume);
            executeStatement(update);
        }

        private ResultSet lista(){
            executeStatement("select * from admini");
            try {
                return statement.getResultSet();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }


        public List<Admin> allAdmini(){
            ResultSet set=lista();
            List<Admin> admini = new ArrayList<>();
            try {
                while (set.next()){
                    admini.add(new Admin(set.getString(2),set.getString(3)));
                }
            }catch (Exception e){
                System.out.println("Nu s-a creat lista");
                return null;
            }
            return admini;
        }


}
