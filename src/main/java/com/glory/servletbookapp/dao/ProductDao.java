package com.glory.servletbookapp.dao;

import com.glory.servletbookapp.beans.IssuedProductBean;
import com.glory.servletbookapp.beans.ProductBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {

    public static void insertProduct(ProductBean product) {

        //String sql = "INSERT INTO product(bookCode, title, author, name, published_year, issued) VALUES(?,?,?,?,?,?)";
        try {
            Connection connect = DataBasConnection.getPostgresConnection();
            PreparedStatement statement = connect.prepareStatement("INSERT INTO product(bookCode, title, author, name, published_year, issued) VALUES(?,?,?,?,?,?)");
            statement.setString(1, product.getBookCode());
            statement.setString(2,product.getBookName());
            statement.setString(3, product.getBookAuthor());
            statement.setString(4, product.getBookPublisher());
            statement.setInt(5, product.getBookQuantity());
            statement.setInt(6, product.getBookIssued());

            statement.executeUpdate();
        } catch (SQLException insertingProduct) {
            System.out.println(insertingProduct);

        }

    }
    public static int saveProduct(ProductBean productBean) {
        int status = 0; // method starts, STATUS will tell if the save worked(No of Rows affected)

        try {
            Class.forName("org.postgresql.Driver"); // this loads the Postgresql driver
            Connection con = DataBasConnection.getPostgresConnection(); // and gets DB connection
            PreparedStatement prepared = con.prepareStatement("INSERT INTO product values (?,?,?,?,?,?)");
            // Prepares an SQL command to insert a new row into productTable.

            prepared.setString(1, productBean.getBookCode()); // Fills in the placeholders with values from
            prepared.setString(2, productBean.getBookName()); // the ProductBean object.
            prepared.setString(3, productBean.getBookAuthor());
            prepared.setString(4, productBean.getBookPublisher());
            prepared.setInt(5, productBean.getBookQuantity());
            prepared.setInt(6, productBean.getBookIssued());

            status = prepared.executeUpdate(); // Executes the insert, If it's successful, status = 1(1 row inserted)

           // but if it fails, status = 0.

        } catch (Exception updating) { // If something goes wrong, it prints the error and stil returns 0.
            System.out.println(updating);
        }
        return status;
    }

    public static List<ProductBean> viewProduct() {
        List<ProductBean> list = new ArrayList<>();

        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparing = connecting.prepareStatement("select * from product");
            ResultSet set = preparing.executeQuery();

            while (set.next()) {

                ProductBean prop = new ProductBean();

                prop.setBookCode(set.getNString("books"));
                prop.setBookAuthor(set.getNString("author"));
                prop.setBookName(set.getString("name"));
                prop.setBookPublisher(set.getString("publisher"));
                prop.setBookQuantity(set.getInt("quantity"));
                prop.setBookIssued(set.getInt("issuedTime"));

                list.add(prop);

            }

        } catch (Exception e) {
            System.out.println(e);
        }


        return list;
    }

    public static int delete(String bookCode){
        int user = 0;
        try {
            Connection connection = DataBasConnection.getPostgresConnection();
            PreparedStatement state = connection.prepareStatement("delete from product where bookCode=?");
            state.setString(1, bookCode);
            user = state.executeUpdate();
            connection.close();
        } catch (SQLException deleting) {
            System.out.println(deleting);
        }

        return user;
    }

}
