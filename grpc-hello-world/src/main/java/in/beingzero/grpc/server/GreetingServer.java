package in.beingzero.grpc.server;
import io.grpc.*;

public class GreetingServer {
    public static void main( String[] args ) throws Exception
    {
      // Create a new server to listen on port 9000
      Server server = ServerBuilder.forPort(9000)
        .addService(new GreeingServiceImpl())
        .build();

      // Start the server
      server.start();

      // Server threads are running in the background.
      System.out.println("Server started");
      // Don't exit the main thread. Wait until server is terminated.
      server.awaitTermination();
    }
}