package com.snjdigitalsolutions.elastic.client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.snjdigitalsolutions.elastic.AbstractTest;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ElasticClientTest extends AbstractTest {

    @Test
    public void verifyNoFailuresCreatingClient()
    {
        //Arrange
        ElasticsearchClient client = elasticClient.getClient();

        //Act
        boolean closed = elasticClient.closeClient();

        //Assert
        assertNotNull(client);
        assertTrue(closed);
    }

}