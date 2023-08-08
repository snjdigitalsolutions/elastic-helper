package com.snjdigitalsolutions.elastic.client;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Component
public class ElasticClient {

    @Value("${elastic.apikey}")
    private String apiKey;
    @Value("${elastic.url}")
    private String url;
    @Value("${elastic.port}")
    private String port;
    @Value("${elastic.certfile}")
    private String httpCertFile;

    private RestClient restClient;
    private ElasticsearchTransport transport;
    private ElasticsearchClient client;

    public ElasticsearchClient getClient()
    {
        if (client == null)
        {
            StringBuilder urlBuilder = new StringBuilder("https://");
            urlBuilder.append(url).append(":").append(port);
            try
            {
                File certFile = new File(httpCertFile);
                SSLContext sslContext = TransportUtils
                        .sslContextFromHttpCaCrt(certFile);

                //Create the low-level client
                restClient = RestClient
                        .builder(HttpHost.create(urlBuilder.toString()))
                        .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "ApiKey " + apiKey)})
                        .setHttpClientConfigCallback(hc -> hc.setSSLContext(sslContext))
                        .build();

                //Create the transport with a Jackson mapper
                JacksonJsonpMapper mapper = new JacksonJsonpMapper();
                mapper.objectMapper().registerModule(new JavaTimeModule());
                mapper.objectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                transport = new RestClientTransport(restClient, mapper);

                //Create the API client
                client = new ElasticsearchClient(transport);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return client;
    }

    public boolean closeClient()
    {
        boolean success = false;
        try
        {
            transport.close();
            restClient.close();
            client = null;
            success = true;
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return success;
    }

}
