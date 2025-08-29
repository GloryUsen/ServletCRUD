package com.glory.servletbookapp.dao;

import com.glory.servletbookapp.beans.LibraryOfficerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryOfficerDao {
    public static int saveProduct(LibraryOfficerBean officer){
        int user2 = 0;

        try {
            Connection connected = DataBasConnection.getPostgresConnection();
            PreparedStatement statement = connected.prepareStatement("insert into product(id, name, email, password, mobile) values (?,?,?,?,?,?)");
            statement.setInt(1, 1);
            statement.setString(2, officer.getLibrarianName());
            statement.setString(3, officer.getLibrarianEmail());
            statement.setString(4, officer.getLibrarianPassword());
            statement.setLong(5, officer.getLibrarianMobileNumber());

            user2 = statement.executeUpdate();
            connected.close();
        } catch (Exception saving) {
            System.out.println(saving);

        }

        return user2;
    }

    public static int updateProduct(LibraryOfficerBean lab){
        int step = 0;
        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparedStatement = connecting.prepareStatement("update product set name=?,email=?,password=?,mobile=?,," +
                    "where id=?");
            preparedStatement.setString(1, lab.getLibrarianName());
            preparedStatement.setString(2, lab.getLibrarianPassword());
            preparedStatement.setString(3, lab.getLibrarianEmail());
            preparedStatement.setLong(4, lab.getLibrarianMobileNumber());
            preparedStatement.setInt(5,lab.getLibrarianId());


        } catch (Exception updatingProduct) {
            System.out.println(updatingProduct);

        }

        return step;
    }



    public static List<LibraryOfficerBean> viewLibrarian(){
        List<LibraryOfficerBean> list = new ArrayList<>();
        try {
            Connection conning = DataBasConnection.getPostgresConnection();
            PreparedStatement prepared = conning.prepareStatement("select * from product") ;
            ResultSet setting = prepared.executeQuery();


            while (setting.next()){
                LibraryOfficerBean librarian1 = new LibraryOfficerBean();

                librarian1.setLibrarianId(setting.getInt("id"));
                librarian1.setLibrarianName(setting.getString("name"));
                librarian1.setLibrarianEmail(setting.getString("email"));
                librarian1.setLibrarianPassword(setting.getString("password"));
                librarian1.setLibrarianMobileNumber(setting.getLong("mobile"));

                list.add(librarian1);

            }
            conning.close();
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
                librarian.setLibrarianId(setStatement.getInt(1));
                librarian.setLibrarianName(setStatement.getString(2));
                librarian.setLibrarianEmail(setStatement.getString(3));
                librarian.setLibrarianMobileNumber(setStatement.getLong(4));
                librarian.setLibrarianPassword(setStatement.getString("password"));

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
