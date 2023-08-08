package com.snjdigitalsolutions.elastic.action;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class IndexAction implements Action {

    private final ElasticClient elasticClient;
    private ElasticsearchClient client;

    public boolean createIndex(String indexName) throws IOException
    {
        if (client == null)
        {
            throw new ClientNotOpenException("Client has not been opened");
        }
        return client.indices().create(createIndexBuilder -> createIndexBuilder.index(indexName)).acknowledged();
    }

    public boolean doesIndexExist(String indexName) throws IOException
    {
        if (client == null)
        {
            throw new ClientNotOpenException("Client has not been opened");
        }
        return client.indices().exists(existsRequestBuilder -> existsRequestBuilder.index(indexName)).value();
    }

    public boolean deleteIndex(String indexName) throws IOException
    {
        if (client == null)
        {
            throw new ClientNotOpenException("Client has not been opened");
        }
        return client.indices().delete(createIndexBuilder -> createIndexBuilder.index(indexName)).acknowledged();
    }

    @Override
    public boolean open()
    {
        boolean opened = false;
        if (client == null)
        {
            client = elasticClient.getClient();
        }
        if (client != null)
        {
            opened = true;
        }
        return opened;
    }

    @Override
    public boolean close()
    {
        return elasticClient.closeClient();
    }

}
