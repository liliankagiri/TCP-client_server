import java.net.*; //? we use it to create a server socket
import java.io.*; //? to read and write data in socket
import java.util.Scanner; //? to read user input

public class Server {

    public static void main(String[] args) {
        //? most of the functions in tcp programming generate exception so we have to use try catch block
        try {
            //? configure the server side program application
            // create a server socket
            ServerSocket ss = new ServerSocket(5000); // giving it port number like 50000 or any
            System.out.println("Waiting for the client ");// the state of the server is waiting for the client
            Socket server = ss.accept(); // this is what will be returned once the client is connected like it returns a server socket once client is connected
            System.out.println("Server is connected"); // ensure the client server is connected to client

            // send data to client
            // take data from the user using Scanner class
            Scanner input = new Scanner(System.in);

            // after getting the data from the user, we have to write the data to the socket,  
            PrintWriter pw = new PrintWriter(server.getOutputStream()); // print writer opens a stream highly for character oriented data wiht

            // write the data infinitly
            while(true){
                System.out.print("Enter data: ");
                String data = input.nextLine(); // gets the data the user has entered
            
                // to write  the data in a socket already we have socket stream
                pw.println(data);
                pw.flush(); // write data immediately in a socet and clears the buffer

            }
        } catch (Exception e) {
            System.out.println(e);

        }
        
    }
}
