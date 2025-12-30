package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.Connection;
import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }

    public void run(){
        SocketThread socket = getSocketThread();
        socket.setDaemon(true);
        socket.start();

        try {
            synchronized (this){wait();}
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Exception occured, quitting");
            return;
        }
        if (clientConnected) ConsoleHelper.writeMessage("Connection established. To exit, enter 'exit'.");
        else ConsoleHelper.writeMessage("An error occurred while working with the client.");
        while (clientConnected) {
            String m = ConsoleHelper.readString();
            if (m.equals("exit")) clientConnected=false;
            if (shouldSendTextFromConsole()) sendTextMessage(m);
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Input IP or localhost");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Input port");
        return ConsoleHelper.readInt();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Input username");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            clientConnected=false;
            ConsoleHelper.writeMessage("Failed to send message");
        }
    }
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " has entered the chat");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " has left the chat");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {Client.this.notify();}
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) { // The server sent a message with text
                    processIncomingMessage(message.getData());
                } else if (MessageType.USER_ADDED == message.getType()) {
                    informAboutAddingNewUser(message.getData());
                } else if (MessageType.USER_REMOVED == message.getType()) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) { // The server asked for the user's name
                    // Ask for the name to be entered from the console
                    String name = getUserName();
                    // Send the name to the server
                    connection.send(new Message(MessageType.USER_NAME, name));

                } else if (message.getType() == MessageType.NAME_ACCEPTED) { // The server accepted the user's name
                    // Inform the main thread that it can continue
                    notifyConnectionStatusChanged(true);
                    return;

                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run(){
            try {
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
