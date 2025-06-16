package org.example.grpc.service;

import io.grpc.stub.StreamObserver;
import org.example.grpc.GreeterServiceGrpc;
import org.example.grpc.HelloReply;
import org.example.grpc.HelloRequest;

public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        // Extract the name from the request
        String name = request.getName();

        // Construct the response message
        String message = "Hello, " + name + "! This is a gRPC response.";

        // Build the HelloReply object
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(message)
                .build();
        System.err.println(reply);
        // Send the response back to the client
        responseObserver.onNext(reply);
        // Mark the RPC as completed
        responseObserver.onCompleted();
    }
}
