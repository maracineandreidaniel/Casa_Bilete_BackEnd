package Repositories;

import Model.Bilet;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiletRepository {
        private String jdbcurl = "jdbc:mysql://localhost:3306/casa_bilete_db?autoreconnect=true&useSSL=false";
        private String user = "root";
        private String password = "root";
        private Connection connection = null;
        private Statement statement = null;

        public BiletRepository() {
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


        public void insertBilet(Bilet bilet) {
            String insertTo = " ";
            insertTo = insertTo + "insert into bilete (numar,client,data,autobuz) values (";
            insertTo = insertTo + String.format("%d,'%s','%s','%s'",bilet.getNumar(),bilet.getClient(),Bilet.convertLDTtoStringTFormat(bilet.getData()),bilet.getAutobuz());
            insertTo = insertTo + ");";
            this.executeStatement(insertTo);
        }

        public void removeBilet(int numar){
            String removeTo="";
            removeTo+=String.format("%s", "delete from bilete where numar='"+numar+"';");
            executeStatement(removeTo);

        }

        public void updateNumar(int numar,int numarNou){
            String update="";
            update+=String.format("update bilete set numar=%d", numarNou);
            update+=String.format(" where numar=%d", numar);
            executeStatement(update);
        }

        public void updateClient(int numar , String clientNou){
            String update="";
            update+=String.format("update bilete set client='%s'", clientNou);
            update+=String.format(" where numar=%d", numar);
            executeStatement(update);
        }

    public void updateData(int numar , String dataNoua){
        String update="";
        update+=String.format("update bilete set data='%s'", Bilet.convertLDTtoStringTFormat(Bilet.convertStringLocalDateTime(dataNoua)));
        update+=String.format(" where numar=%d", numar);
        executeStatement(update);
    }

    public void updateAutobuz(int numar , String autobuzNou){
        String update="";
        update+=String.format("update bilete set autobuz='%s'", autobuzNou);
        update+=String.format(" where numar=%d", numar);
        executeStatement(update);
    }

        private ResultSet lista(){
            executeStatement("select * from bilete");
            try {
                return statement.getResultSet();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }


        public List<Bilet> allBilete(){
            ResultSet set=lista();
            List<Bilet> bilete = new ArrayList<>();
            try {
                while (set.next()){
                    bilete.add(new Bilet(set.getInt(2),set.getString(3),Bilet.parameterStringConvert(set.getString(4)),set.getString(5)));
                }
            }catch (Exception e){
                System.out.println("Nu s-a creat lista");
                return null;
            }
            return bilete;
        }





}
