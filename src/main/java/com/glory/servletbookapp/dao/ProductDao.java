package com.glory.servletbookapp.dao;

import com.glory.servletbookapp.beans.ProductBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
    public static int saveProduct(ProductBean productBean) {
        int status = 0;

        try {
            Class.forName("org.postgres.Diver");
            Connection con = DataBasConnection.getPostgresConnection();
            PreparedStatement prepared = con.prepareStatement("INSERT INTO products values (?,?,?,?,?,?)");
            prepared.setString(1, productBean.getBookCode());
            prepared.setString(2, productBean.getBookName());
            prepared.setString(3, productBean.getBookAuthor());
            prepared.setString(4, productBean.getBookPublisher());
            prepared.setInt(5, productBean.getBookQuantity());
            prepared.setInt(6, productBean.getBookIssued());
            status = prepared.executeUpdate();


        } catch (Exception updating) {
            System.out.println(updating);
        }
        return status;
    }

    public static List<ProductBean> viewProduct() {
        List<ProductBean> list = new ArrayList<>();

        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement preparing = connecting.prepareStatement("select * from products");
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
