package com.gameclient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String hostname = "localhost";
        int port = 8000; 
        GameClient gameClient = new GameClient(hostname, port);
        gameClient.start();
    }
}
