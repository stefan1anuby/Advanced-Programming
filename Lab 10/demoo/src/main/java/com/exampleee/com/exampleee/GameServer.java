package com.exampleee;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    private int port;
    private ServerSocket serverSocket;
    private List<ClientThread> clients;
	private boolean running;

    public GameServer(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.running = true;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (running) {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	public void stop() {
        running = false;
        for (ClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Server stopped");
    }

}
