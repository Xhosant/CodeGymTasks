package com.codegym.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("The server is running.");

        while (true){
            try{
                Handler handler = new Handler(serverSocket.accept()); //beware
                handler.start();
            }
            catch (Exception e){
                serverSocket.close();
                ConsoleHelper.writeMessage("Closing server socket because of exception:" + e);
                break;
            }
        }
    }
    public static void sendBroadcastMessage(Message message){

        for (Connection connection: connectionMap.values()
        ) {
            try {
                connection.send(message);
            } catch (IOException e){
                ConsoleHelper.writeMessage("Couldn't message connection" + connection);
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket=socket;
        }

        public void run(){
            ConsoleHelper.writeMessage("New connection established with "+socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket)){
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating with remote address "
                        + socket.getRemoteSocketAddress());
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }
            }
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message response = new Message(MessageType.NAME_REQUEST);
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                response = connection.receive();
                if (response.getType()!=MessageType.USER_NAME) continue;
                String name = response.getData();
                if (name=="" || connectionMap.containsKey(name)) continue;
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return name;
            }
        }
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (String c: connectionMap.keySet()) {
                if (userName.equals(c)) continue;
                connection.send(new Message(MessageType.USER_ADDED, c));
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT){
                        sendBroadcastMessage(new Message(MessageType.TEXT,userName+": "+message.getData()));
                }
                else {
                    ConsoleHelper.writeMessage("Error: message type not, TEXT, instead "+message.getType());
                }
            }
        }
    }
}
