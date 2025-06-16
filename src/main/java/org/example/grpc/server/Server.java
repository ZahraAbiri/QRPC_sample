//package org.example.grpc.server;
//
//import org.example.grpc.UsernameRequest;
//import org.example.grpc.UsernameResponse;
//import org.example.grpc.UserServiceGrpc;
//import io.grpc.stub.StreamObserver;
//import org.lognet.springboot.grpc.GRpcService;
//
//@GRpcService
////The Server class extends the generated base class StudentServiceImplBase, which provides default implementations for the RPC methods defined in the protobuf file.
//public class Server extends UserServiceGrpc.UserServiceImplBase{
//
//    UsernameResponse response = UsernameResponse.newBuilder()
//            .setUserEmail("sara@gmial.com")
//            .build();
////    @Override
//    public void GetUserEmail(UsernameRequest request, StreamObserver<UsernameResponse> responseObserver) {
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//}
