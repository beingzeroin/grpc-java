package in.beingzero.grpc.client;

import in.beingzero.grpc.*;
import io.grpc.stub.*;
import io.grpc.*;

public class GreetingClient {
    public static void main( String[] args ) throws Exception
    {
      // Channel is the abstraction to connect to a service endpoint
      // Let's use plaintext communication because we don't have certs
      final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9000")
        .usePlaintext()
        .build();

      // It is up to the client to determine whether to block the call
      // Here we create a blocking stub, but an async stub,
      // or an async stub with Future are always possible.
      GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
      HelloRequest request = HelloRequest.newBuilder()
          .setName("Being Zero")
          .addHobbies("teaching")
          .addHobbies("mentoring")
          .build();

      // Finally, make the call using the stub
      HelloResponse response = stub.greeting(request);

      System.out.println(response);

      // A Channel should be shutdown before stopping the process.
      channel.shutdownNow();
    }   
}