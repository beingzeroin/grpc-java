package in.beingzero.grpc.server;

import in.beingzero.grpc.*;
import io.grpc.stub.*;
public class GreeingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
    public void greeting(HelloRequest request, 
        StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                                .setGreeting("Hello there, " + request.getName())
                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}