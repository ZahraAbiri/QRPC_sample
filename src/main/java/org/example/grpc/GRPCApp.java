package org.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.grpc.service.GreeterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class GRPCApp
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        SpringApplication.run(GRPCApp.class, args);
        Server server = ServerBuilder.forPort(9090)
                .addService(new GreeterServiceImpl())
                .build()
                .start();
        System.out.println("Server started on port 9090");
        server.awaitTermination();
    }
}
