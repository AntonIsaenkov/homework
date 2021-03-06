package exams.exam2;



import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

// 1. читает сообщения из консоли, формирует объекты Message и отправляет на сервер
public class ClientWriter implements Runnable {

    private Scanner scanner;
    private Connection connection;

    public ClientWriter(Connection connection) {
        this.connection = Objects.requireNonNull(connection);
    }

    @Override
    public void run() {

        scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя");
        String name = scanner.nextLine();
        String messageText;

        while (true) {
            System.out.println("Введите сообщение или введите /exit для завершения сеанса");
            messageText = scanner.nextLine();
            Message message = Message.getMessage(name, messageText);
            message.setDateTime();
            message.setSocket(connection.getSocket());
            message.setPort();
            try {
                connection.writeMessage(message);
                if ("/exit".equalsIgnoreCase(messageText)) {
                    System.out.println("ClientWriter Closed: /exit");
                    connection.close();
                    break;
                }
            } catch (IOException s) {
                System.out.println("ClientWriter Closed: " + s);
                break;
            }

        }

    }
}
