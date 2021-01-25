package exams.exam2;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

//Поток Writer рассылает сообщения клиентам, которые хранятся в мапе или сете.
public class ServerWriter implements Runnable {

    private CopyOnWriteArraySet<Connection> clientSocketSet;
    private ArrayBlockingQueue<Message> messageQueue;

    public ServerWriter(CopyOnWriteArraySet<Connection> clientSocketSet,
                        ArrayBlockingQueue<Message> messageQueue) {
        this.clientSocketSet = clientSocketSet;
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {

        while (true) {


            try {
                Message messageFromQueue = messageQueue.take();
                System.out.println("Server take message from queue: " + messageFromQueue);
                for (Connection connection : clientSocketSet) {

                    if (!(connection.getSocket().toString().contains(String.valueOf(messageFromQueue.getPort())))) {
                        System.out.println("Server pull message: " + messageFromQueue);
                        connection.writeMessage(messageFromQueue);
                    }

                }


            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}



