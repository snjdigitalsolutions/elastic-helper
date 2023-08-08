package com.snjdigitalsolutions.elastic;

import com.snjdigitalsolutions.elastic.action.DocumentIndexAction;
import com.snjdigitalsolutions.elastic.action.IndexAction;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractTest {

    @Autowired
    protected ElasticClient elasticClient;
    @Autowired
    protected IndexAction indexAction;
    @Autowired
    protected DocumentIndexAction documentIndexAction;

}
