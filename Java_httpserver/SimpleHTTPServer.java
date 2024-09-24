import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

public class SimpleHTTPServer {

    public static void main(String args[] ) throws IOException {

        ServerSocket server = new ServerSocket(8080,50,InetAddress.getByName("0.0.0.0"));

        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket clientSocket = server.accept();
            InputStreamReader isr 
          =  new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();            
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }
            String httpResponse="HTTP/1.1 200 OK\r\n\r\nHELLO World!";
            clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            clientSocket.close();
        }
    }

}



