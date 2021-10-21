package Repositories;

import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutobuzRepository {
    private String jdbcurl = "jdbc:mysql://localhost:3306/casa_bilete_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public AutobuzRepository() {
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


    public void insertAutobuz(String autobuz) {
        String insertTo = " ";
        insertTo = insertTo + "insert into autobuze (nume) values (";
        insertTo = insertTo + String.format("'%s'",autobuz);
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }

    public void removeAutobuz(String nume){
        String removeTo="";
        removeTo+=String.format("%s", "delete from autobuze where nume='"+nume+"';");
        executeStatement(removeTo);

    }

    public void updateNume(String nume, String numeNou){
        String update="";
        update+=String.format("update autobuze set nume='%s'", numeNou);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }


    private ResultSet lista(){
        executeStatement("select * from autobuze");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<String> allAutobuze() {
        ResultSet set = lista();
        List<String> autobuze = new ArrayList<>();
        try {
            while (set.next()) {
                autobuze.add(new String(set.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
            return null;
        }
        return autobuze;
    }

    public boolean existAutobuz(String nume){
        for(String s:allAutobuze())
            if(s.equals(nume))
                return true;
        return false;
    }

    public String getAutobuzNume(String nume){
        if(existAutobuz(nume)==true)
            for(String s:allAutobuze())
                if(s.equals(nume))
                    return s;
        return null;
    }
}
