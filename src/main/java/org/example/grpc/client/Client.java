//package org.example.grpc.client;
//
//
//import org.example.grpc.UserServiceGrpc;
//import org.example.grpc.UsernameRequest;
//import org.springframework.util.StopWatch;
//
//public class Client {
//
//    //It uses a blocking stub (StudentServiceBlockingStub), which means the call will block until a response is received.
//    public static void getEmail(UserServiceGrpc.UserServiceBlockingStub serviceBlockingStub, UsernameRequest studentRequest) {
//        StopWatch totalTime = new StopWatch();
//        totalTime.start();
//        serviceBlockingStub.getUserEmail(studentRequest);
//
//        totalTime.stop();
//        System.out.println("total time = " + totalTime.getTotalTimeMillis());
//    }
////It uses a non-blocking stub (StudentServiceStub), allowing for asynchronous calls.
//
//
//}
//
//
