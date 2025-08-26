package com.glory.servletbookapp.dao;

import com.glory.servletbookapp.beans.LibraryOfficerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryOfficerDao {
    private static int saveProduct(LibraryOfficerBean officer){
        int user2 = 0;

        try {
            Connection connected = DataBasConnection.getPostgresConnection();
            PreparedStatement statement = connected.prepareStatement("insert into product(id, name, email, password, mobile) values (?,?,?,?,?,?)");
            statement.setString(1, "1");
            statement.setString(2, officer.getName());
            statement.setString(3, officer.getEmail());
            statement.setString(4, officer.getPassword());
            statement.setString(5, officer.getMobile());

            user2 = statement.executeUpdate();
            connected.close();
        } catch (Exception saving) {
            System.out.println(saving);

        }

        return user2;
    }

    private static int update(LibraryOfficerBean lab){
        int step = 0;
        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparedStatement = connecting.prepareStatement("update product set name=?,email=?,password=?,mobile=?,," +
                    "where id=?");
            preparedStatement.setString(1, lab.getName());
            preparedStatement.setString(2, lab.getPassword());
            preparedStatement.setString(3, lab.getEmail());
            preparedStatement.setString(4, lab.getMobile());
            preparedStatement.setInt(5,lab.getId());


        } catch (Exception updatingProduct) {
            System.out.println(updatingProduct);

        }

        return step;
    }

    private static List<LibraryOfficerBean> viewProduct(){
        List<LibraryOfficerBean> list = new ArrayList<>();
        try {
            Connection conning = DataBasConnection.getPostgresConnection();
            PreparedStatement prepared = conning.prepareStatement("select * from product") ;
            ResultSet setting = prepared.executeQuery();


            while (setting.next()){
                LibraryOfficerBean librarian = new LibraryOfficerBean();

                librarian.setId(setting.getInt("id"));
                librarian.setName(setting.getString("name"));
                librarian.setEmail(setting.getString("email"));
                librarian.setPassword(setting.getString("password"));
                librarian.setMobile(setting.getString("mobile"));

                list.add(librarian);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
