package com.example.myrecyclerviewexample.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static Model model;
    private List<Usuario> usuarios;
    private List<Oficio> oficios;

    private Model(){
        usuarios = new ArrayList<>();
        oficios = new ArrayList<>();
    }


    public static Model getInstance(){
        if(model==null)
            model = new Model();

        return model;
    }

    public List<Usuario> getUsuarios() {
        MysqlDB mysqlDB = new MysqlDB();
        usuarios = mysqlDB.getAllUsers();
        return usuarios;
    }
    public List<Oficio> getOficios(){
        MysqlDB mysqlDB = new MysqlDB();
        oficios = mysqlDB.getAllOcupations();;
        return oficios;
    }
}
