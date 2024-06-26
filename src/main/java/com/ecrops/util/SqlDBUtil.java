package com.ecrops.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NIC
 */
public class SqlDBUtil implements Serializable {

    public Connection getConnection() throws Exception {
        Connection con = null;
        Class.forName("org.postgresql.Driver");

        //  con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/eseednew", "postgres", "SWATHI");
        // con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/eseeddev", "postgres", "SWATHI");
        // con = DriverManager.getConnection("jdbc:postgresql://10.72.4.33:5433/ekarshak", "postgres", "admin");
        //con = DriverManager.getConnection("jdbc:postgresql://192.168.148.149:5432/ekarshak", "postgres", "eKarshak@2012");
        //con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/ecroplocal", "postgres", "root");
        con = DriverManager.getConnection("jdbc:postgresql://10.72.5.187:5433/ecrop", "postgres", "postgres");
        //con = DriverManager.getConnection("jdbc:postgresql://10.72.5.166:5432/ecrop_local", "postgres", "admin");
        return con;

    }

    public void closeConnection(Connection con) {

        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                con = null;
            }

        }

    }

    public void closeStatements(PreparedStatement pst) {

        if (pst != null) {
            try {
                pst.close();
            } catch (Exception e) {
                pst = null;
            }

        }

    }

    public void closeResultSet(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                rs = null;
            }

        }

    }
}

