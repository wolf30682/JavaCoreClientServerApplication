import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 6570;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//Создает новый PrintWriter из существующего потока вывода.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // считываем входящий поток
            System.out.println("New connection accepted");
            // Читаем строку и выводим её на экран вместе с номером порта клиента, с которого пришло соединение
            //out.println("New connection accepted");
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            serverSocket.close();

        }

    }
}
