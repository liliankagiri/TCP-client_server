import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class Client {

    public static void main(String[] args){
        try {

            Socket client = new Socket("localhost", 5000);// this is a socekt object bind with server which is local host running on our system locally  which has port number 127.0.0.1 and bind port number 5000
            System.out.println("Client is connected ");
            // read data from server
            
            //GET SREAM OPBJECT  we user buffered read  has external buffer and we can read more data and we can read line by line
            // buffered reader is a character oriented stream and socket is abyte oriented stream so to converet from character to byte, we use inputSream reader
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // run infintely since the server sends multiple data
            while(true){
                String data = br.readLine();
                System.out.println("Data from the server: " + data);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
