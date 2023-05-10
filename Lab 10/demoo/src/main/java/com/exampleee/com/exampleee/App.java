package com.exampleee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        int port = 8000;
        GameServer gameServer = new GameServer(port);
        gameServer.start();
    }
}
