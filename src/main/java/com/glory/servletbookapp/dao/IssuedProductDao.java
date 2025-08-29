package com.glory.servletbookapp.dao;

import com.glory.servletbookapp.beans.IssuedProductBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IssuedProductDao {

    public static int issuedProduct(IssuedProductBean issuedProducts){
        String bookCode = issuedProducts.getBookCode();
        boolean checkStatus = checkIssuedProduct(bookCode);
        System.out.println("Check Status: " + checkStatus);
        if (checkStatus) {
            int status1 = 0;
            try {
                Connection conny = DataBasConnection.getPostgresConnection();
                PreparedStatement state = conny.prepareStatement("insert into product values(?,?,?,?,?,?)");
                state.setString(1, issuedProducts.getStudentId());
                state.setString(2, issuedProducts.getBookCode());
                state.setString(3, issuedProducts.getStudentName());
                state.setLong(4, issuedProducts.getStudentMobile());
                state.setString(5, "no");
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                state.setDate(6, currentDate);

                status1 = state.executeUpdate();
                if (status1 > 0){
                    PreparedStatement prepared = conny.prepareStatement("update product set issued=? where bookCode=?");
                    prepared.setInt(1, getIssuedProduct(bookCode) + 1);
                    prepared.setString(2, bookCode);
                    status1 = prepared.executeUpdate();

                }

                conny.close();


            } catch (Exception issuedProduct) {
                System.out.println(issuedProducts);
            }
        }
        return 0;
    }

    public static int getIssuedProduct(String bookCode){
        int status2 = 0;
        try {
            Connection connecting = DataBasConnection.getPostgresConnection();
            PreparedStatement statement2 = connecting.prepareStatement("select * from product where bookCode =?");
            statement2.setString(1, bookCode);
            ResultSet setting = statement2.executeQuery();

            if (setting.next()){
                status2 = setting.getInt("issuedProduct");
            }

            connecting.close();
        } catch (Exception issuing) {
            System.out.println(issuing);

        }

        return status2;
    }



    public static boolean checkIssuedProduct(String bookCode){
        boolean status3 = false;
        try {
            Connection connection3 = DataBasConnection.getPostgresConnection();
            PreparedStatement statement3 = connection3.prepareStatement("select * from product where bookCode =?");
            statement3.setString(1, bookCode);
            ResultSet resulting = statement3.executeQuery();
            if (resulting.next()){
                status3 = true;
            }

            connection3.close();
        } catch (Exception checking) {
            System.out.println(checking);
        }


        return false;
    }

    public static List<IssuedProductBean>  viewIssuedProducts(){
        List<IssuedProductBean> listOfIssuedProduct = new ArrayList<>();

        try {
            Connection connecting4 = DataBasConnection.getPostgresConnection();
            PreparedStatement statement4 = connecting4.prepareStatement("select * from product order by issuedDate desc");
            ResultSet resultSet = statement4.executeQuery();


            while (resultSet.next()){
                IssuedProductBean newUpDate = new IssuedProductBean();

                newUpDate.setBookCode(resultSet.getString("bookCode"));
                newUpDate.setStudentId(resultSet.getString("studentId"));
                newUpDate.setStudentName(resultSet.getString("studentName"));
                newUpDate.setStudentMobile(resultSet.getLong("mobileNumber"));
                newUpDate.setIssuedDate(resultSet.getDate("issuedDate"));
                newUpDate.setReturnStatus(resultSet.getString("returnStatus"));

                listOfIssuedProduct.add(newUpDate);
            }


            connecting4.close();


        } catch (Exception viewingProduct) {
            System.out.println(viewingProduct);
        }
        return listOfIssuedProduct;
    }

    public static int returnedProduct(String bookCode, int studentId){
        int status5 = 0;
        try {
            Connection connection5 = DataBasConnection.getPostgresConnection();
            PreparedStatement statement5 = connection5.prepareStatement("update product set returnStatus ='Yes' where bookCode=? and studentId=?");
            statement5.setString(1, bookCode);
            statement5.setInt(2, studentId);

            status5 = statement5.executeUpdate();

            connection5.close();

        } catch (Exception returning) {
            System.out.println(returning);
        }

        return status5;
    }

    }
