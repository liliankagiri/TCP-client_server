# TCP-client_server

import java.net.*; // Used to create and manage server sockets
import java.io.*; // Used to handle input and output streams
import java.util.Scanner; // Used to read user input from the console
java.net.* → Provides classes for networking operations, like ServerSocket and Socket.
java.io.* → Provides classes for handling input/output operations, such as PrintWriter for sending data.
java.util.Scanner → Allows reading user input from the console.
Class Declaration
public class Server {
Declares a class named Server.
Main Method
public static void main(String[] args) {
The entry point of the program.
Try-Catch Block
try {
Since networking operations can cause errors (e.g., port already in use, connection failure), we use a try-catch block to handle exceptions.
Creating a Server Socket
ServerSocket ss = new ServerSocket(5000); 
System.out.println("Waiting for the client ");
Creates a server socket bound to port 5000.
The server waits for a client to connect.
Accepting Client Connection
Socket server = ss.accept();
System.out.println("Server is connected");
ss.accept() blocks execution until a client connects.
Once a client connects, a Socket object (server) is created to facilitate communication between the server and the client.
User Input Setup
Scanner input = new Scanner(System.in);
Scanner is used to read user input from the console.
Creating Output Stream
PrintWriter pw = new PrintWriter(server.getOutputStream());
PrintWriter is used to send data to the client through the server socket’s output stream.
Infinite Loop to Send Data
while(true) {
Runs indefinitely, allowing continuous data transmission.
Reading Data from User
System.out.print("Enter data: ");
String data = input.nextLine();
Prompts the user to enter text.
Reads the input string from the console.
Sending Data to Client
pw.println(data);
pw.flush();
println(data) → Sends the data to the client.
flush() → Ensures the data is sent immediately by clearing the buffer.
Exception Handling
} catch (Exception e) {
    System.out.println(e);
}
Catches and prints any exceptions that occur.
Summary
The server starts and waits for a client to connect.
Once a client connects, the server accepts the connection.
The server continuously reads user input and sends it to the client.
Data is transmitted using PrintWriter.
The loop runs indefinitely, allowing continuous communication.
Let's go through the Client code line by line to understand its functionality.

Imports
import java.net.*; // Used for networking functionalities, including Socket
import java.io.*; // Used for input and output streams
import java.nio.Buffer; // (Unused import, not needed here)
java.net.* → Provides classes for networking (Socket to connect to the server).
java.io.* → Provides classes for handling data input and output (BufferedReader, InputStreamReader).
java.nio.Buffer → This import is unnecessary and can be removed.
Class Declaration
public class Client {
Declares a class named Client.
Main Method
public static void main(String[] args){
The entry point of the program.
Try-Catch Block
try {
Encapsulates network operations to handle potential errors (e.g., connection failure).
Creating a Client Socket
Socket client = new Socket("localhost", 5000);
System.out.println("Client is connected ");
The client connects to the server running on localhost (IP 127.0.0.1) at port 5000.
If the connection is successful, it prints "Client is connected".
Reading Data from Server
BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
client.getInputStream() → Gets an input stream to receive data from the server.
InputStreamReader(client.getInputStream()) → Converts byte stream to character stream.
BufferedReader → Efficiently reads data from the character stream line by line.
Infinite Loop to Receive Data
while(true) {
    String data = br.readLine();
    System.out.println("Data from the server: " + data);
}
The client continuously listens for incoming messages from the server.
br.readLine() → Reads one line of text sent by the server.
System.out.println("Data from the server: " + data); → Prints the received data.
Exception Handling
} catch (Exception e) {
    System.out.println(e);
}
Catches and prints any exceptions (e.g., if the server is down or unreachable).
Summary
The client connects to the server at localhost:5000.
It listens for incoming messages from the server.
Messages are received line by line and displayed.
The program runs infinitely, continuously receiving data.
How It Works with the Server
Server waits for a client connection and sends messages entered by the user.
Client connects to the server and continuously receives messages.
This is a basic TCP-based communication system where:

The server sends data.
The client receives and displays the data.
