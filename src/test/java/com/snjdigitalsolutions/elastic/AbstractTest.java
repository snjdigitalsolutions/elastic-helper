package com.snjdigitalsolutions.elastic;

import com.snjdigitalsolutions.elastic.action.DocumentIndexAction;
import com.snjdigitalsolutions.elastic.action.IndexAction;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractTest {

    @Value("${test.apikey}")
    protected String apikey;
    @Value("${test.url}")
    protected String url;
    @Value("${test.port}")
    protected String port;
    @Value("${test.certfile}")
    protected String certfile;

    @SpringBootConfiguration
    public static class TestConfig {
    }


}
