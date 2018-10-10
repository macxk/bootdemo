package com.kon.restclientdemo;

import okio.Utf8;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class RestClientDemo {

    public static void restClientWithBasicAuthDemo(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","basic "+ Base64.encodeBase64String("1501186000000:123456".getBytes()));
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
        String obj = new RestTemplate().exchange("http://10.1.4.89:9090/web/CYShinowNetWorking.asmx/hrd/getShieldedHitLog?since={since}", HttpMethod.GET,requestEntity,String.class,"2010-01-01 00:00:00").getBody();
        System.out.println(obj);

    }

    public static void main(String[] a){

        restClientWithBasicAuthDemo();
    }
}
