package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{
    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }
    @Override
    protected String getUserName() {
        int num = (int) (Math.random()*100);
        return "date_bot_"+num;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] data = message.split(": ");
            if (data.length!=2) return;
            SimpleDateFormat f=null;
            switch (data[1]){
                case "date":
                    f = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "day":
                    f = new SimpleDateFormat("d");
                    break;
                case "month":
                    f = new SimpleDateFormat("MMMM");
                    break;
                case "year":
                    f = new SimpleDateFormat("YYYY");
                    break;
                case "time":
                    f = new SimpleDateFormat("H:mm:ss");
                    break;
                case "hour":
                    f = new SimpleDateFormat("H");
                    break;
                case "minutes":
                    f = new SimpleDateFormat("m");
                    break;
                case "seconds":
                    f = new SimpleDateFormat("s");
                    break;
            }
            if (f!=null) {
                String reply = "Information for " + data[0] + ": " + f.format(Calendar.getInstance().getTime());
                sendTextMessage(reply);
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage( "Hello, there. I'm a bot. I understand the following commands: " +
                    "date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }
    }
}
