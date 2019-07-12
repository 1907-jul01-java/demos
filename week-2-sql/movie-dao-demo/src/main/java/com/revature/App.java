package com.revature;

import com.revature.entities.*;
import com.revature.models.*;
import com.revature.util.*;

public class App {
    public static void main(String[] args) {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        MovieDao movieDao = new MovieDao(connectionUtil.getConnection());
        movieDao.insert(new Movie("The Dark Knight", 2007));
        System.out.println(movieDao.getAll());
        System.out.println("Kevin Bacon id:" + movieDao.getActorIdByName("Kevin Bacon"));
        connectionUtil.close();
    }
}
