package com.revature;

import com.revature.movies.*;

public class App {
    public static void main(String[] args) {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        MovieDao movieDao = new MovieDao(connectionUtil.getConnection());
        movieDao.insert(new Movie("Batman Begins", 2005));
        System.out.println(movieDao.getAll());
        connectionUtil.close();
    }
}
