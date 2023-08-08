package com.snjdigitalsolutions.elastic;

import com.snjdigitalsolutions.elastic.action.DocumentIndexAction;
import com.snjdigitalsolutions.elastic.action.IndexAction;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class AbstractTest {

    protected String apikey = "UktzcXpZa0ItM3NNLXQxVWRsZmE6eFpNdlJxeVBRS0M1aWpZbEM2Qk54UQ==";
    protected String url = "192.168.74.228";
    protected String port = "9200";
    protected String certfile = "certs/http_ca.crt";



}
