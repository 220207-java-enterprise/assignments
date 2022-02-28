package com.revature.foundation.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;


        import com.revature.foundation.daos.UserDAO;
        import com.revature.foundation.services.UserService;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.time.LocalDateTime;

public class AppState {

    private static boolean appRunning;



    public AppState() {
        System.out.printf("Application initialization started at %s\n", LocalDateTime.now());

        appRunning = true;




        System.out.printf("Application initialization completed at %s\n", LocalDateTime.now());

    }



    public static void shutdown() {
        appRunning = false;
    }

}
