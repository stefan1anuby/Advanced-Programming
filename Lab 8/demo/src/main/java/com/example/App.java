package com.example;

/**
 * Hello world!
 *
 */

import java.sql.*;

public class App {

    public static void main(String args[]) {
        try {
            ArtistAO artists = new ArtistAO();

            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            System.out.println(artists.findById(1));
            System.out.println(artists.findByName("Pink Floyd"));

            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
