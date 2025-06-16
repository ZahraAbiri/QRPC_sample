package org.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.GreeterServiceGrpc;
import org.example.grpc.HelloReply;
import org.example.grpc.HelloRequest;

public class UsageGrpc {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Use plaintext for testing
                .build();
        GreeterServiceGrpc.GreeterServiceBlockingStub stub = GreeterServiceGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder().setName("Alice").build();
        HelloReply response = stub.sayHello(request);
        System.out.println("Response: " + response.getMessage());
        channel.shutdown();
    }
}
