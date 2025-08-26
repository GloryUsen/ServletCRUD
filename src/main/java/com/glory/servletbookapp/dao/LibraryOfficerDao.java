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
            statement.setLong(5, officer.getMobile());

            user2 = statement.executeUpdate();
            connected.close();
        } catch (Exception saving) {
            System.out.println(saving);

        }

        return user2;
    }

    private static int updateProduct(LibraryOfficerBean lab){
        int step = 0;
        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparedStatement = connecting.prepareStatement("update product set name=?,email=?,password=?,mobile=?,," +
                    "where id=?");
            preparedStatement.setString(1, lab.getName());
            preparedStatement.setString(2, lab.getPassword());
            preparedStatement.setString(3, lab.getEmail());
            preparedStatement.setLong(4, lab.getMobile());
            preparedStatement.setInt(5,lab.getId());


        } catch (Exception updatingProduct) {
            System.out.println(updatingProduct);

        }

        return step;
    }

    private static List<LibraryOfficerBean> viewListOfProduct(){
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
                librarian.setMobile(setting.getLong("mobile"));

                list.add(librarian);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static LibraryOfficerBean viewProductById(int id){
        LibraryOfficerBean librarian = new LibraryOfficerBean();
        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparedStatement = connecting.prepareStatement("select * from product where id =?");
            preparedStatement.setInt(1, id);

            ResultSet setStatement = preparedStatement.executeQuery();
            if (setStatement.next()){
                librarian.setId(setStatement.getInt(1));
                librarian.setName(setStatement.getString(2));
                librarian.setEmail(setStatement.getString(3));
                librarian.setMobile(setStatement.getLong(4));
                librarian.setPassword(setStatement.getString("password"));

            }

            connecting.close();
        } catch (Exception viewingProduct) {
            System.out.println(viewingProduct);
        }

        return librarian;
    }

    public static boolean authentication(String email, String password){
        boolean status = false;
        try {
            Connection cont = DataBasConnection.getPostgresConnection();
            PreparedStatement statement = cont.prepareStatement("select * from product where email=? and password=?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet set = statement.executeQuery();
            cont.close();

        } catch (Exception auth) {
            System.out.println(auth);

        }

        return status;
    }

    public static int deleteProduct(int id){
        int status = 0;
        try {
            Connection con = DataBasConnection.getPostgresConnection();
            PreparedStatement prep = con.prepareStatement("delete * from product wher id=?");
            prep.setInt(1, id);
            status = prep.executeUpdate();
            con.close();

        } catch (Exception deletingOfProduct) {
            System.out.println(deletingOfProduct);

        }

        return status;
    }
}
