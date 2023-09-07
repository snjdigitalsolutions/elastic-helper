package com.snjdigitalsolutions.elastic;

import com.snjdigitalsolutions.elastic.action.DocumentIndexAction;
import com.snjdigitalsolutions.elastic.action.IndexAction;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTest {

    @Value("${test.apikey}")
    protected String apikey;// = "UktzcXpZa0ItM3NNLXQxVWRsZmE6eFpNdlJxeVBRS0M1aWpZbEM2Qk54UQ==";
    @Value("${test.url}")
    protected String url;// = "192.168.74.228";
    @Value("${test.port}")
    protected String port;// = "9200";
    @Value("${test.certfile}")
    protected String certfile;// = "certs/http_ca.crt";

    @SpringBootConfiguration
    public static class TestConfig {
    }



}
