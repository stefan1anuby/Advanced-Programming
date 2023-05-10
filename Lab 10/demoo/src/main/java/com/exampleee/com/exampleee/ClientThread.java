package com.exampleee;

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {
    private Socket socket;
    private GameServer gameServer;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

	public Socket getSocket(){
		return socket;
	}

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                if (inputLine.startsWith("stop")) {
                    out.println("Server stopped");
                    gameServer.stop();
                    break;
                } else {
                    out.println("Server received the request: " + inputLine);
					System.out.println("Server received the request: " + inputLine);
					
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
