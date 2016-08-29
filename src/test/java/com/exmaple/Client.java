package com.exmaple;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class Client {

    private HttpClient client;

    @Before
    public void before() throws Exception {
        client = new DefaultHttpClient();
    }

    @Test
    public void client() throws Exception {
        //HttpGet get = new HttpGet("http://localhost:8080/");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        //String back = client.execute(get, responseHandler);
        //System.out.print(back);
        HttpPost post = new HttpPost("http://localhost:8080/");
        //HttpEntity file = new FileEntity(new File("C:\\worksapces\\jetty-example\\jetty\\src\\test\\resources\\WP_20150527_003.jpg"), "multipart/form-data");
        HttpEntity file = MultipartEntityBuilder.create()
                .addBinaryBody("businesscard", new File("C:\\worksapces\\jetty-example\\jetty\\src\\test\\resources\\WP_20150527_003.jpg"),
                        ContentType.create("multipart/form-data"), "WP_20150527_003.jpg").build();
        post.setEntity(file);
        String back = client.execute(post, responseHandler);
        System.out.print(back);
    }

    @After
    public void after() throws Exception {
        client.getConnectionManager().shutdown();
    }
}
