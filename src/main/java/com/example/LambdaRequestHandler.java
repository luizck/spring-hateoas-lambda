package com.example;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LambdaRequestHandler implements RequestStreamHandler {

    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler =
            createSpringBootLambdaContainerHandler();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> createSpringBootLambdaContainerHandler() {
        try {
            return SpringBootLambdaContainerHandler.getAwsProxyHandler(SpringBootLambdaApplication.class);
        } catch (ContainerInitializationException e) {
            throw new RuntimeException(e);
        }
    }
}
