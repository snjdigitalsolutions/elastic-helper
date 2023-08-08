package com.snjdigitalsolutions.elastic.action;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class DocumentIndexAction implements Action {

    private final ElasticClient elasticClient;
    private ElasticsearchClient client;

    public boolean indexDocument(Object indexableDocument, String indexName)
    {
        boolean success = false;
        try
        {
            if (client == null)
            {
                throw new ClientNotOpenException("Client not opened");
            }
            IndexResponse response = client.index(document -> document
                    .index(indexName)
                    .document(indexableDocument)
            );

            success = true;
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public boolean open()
    {
        boolean success = false;
        if (client == null)
        {
            client = elasticClient.getClient();
        }
        if (client != null)
        {
            success = true;
        }
        return success;
    }

    @Override
    public boolean close()
    {
        client = null;
        return elasticClient.closeClient();
    }

}
