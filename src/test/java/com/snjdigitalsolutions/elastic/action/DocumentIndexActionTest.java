package com.snjdigitalsolutions.elastic.action;

import com.snjdigitalsolutions.elastic.AbstractTest;
import com.snjdigitalsolutions.elastic.client.ElasticClient;
import com.snjdigitalsolutions.elastic.document.EmailDocument;
import com.snjdigitalsolutions.elastic.document.PipelineDocument;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DocumentIndexActionTest extends AbstractTest {

    @Test
    void testIndexDocument()
    {
        //Arrange
        DocumentIndexAction documentIndexAction = new DocumentIndexAction(new ElasticClient(apikey, url, port, certfile));
        EmailDocument document = new EmailDocument();
        document.setTo("john@testing.com");
        document.setFrom("jamey@theparhams.net");
        document.setSubject("Test Subject");
        document.setDate_received(LocalDateTime.now());
        document.setDomain(".com");

        //Act
        assertTrue(documentIndexAction.open());
        boolean success = documentIndexAction.indexDocument(document, "email_filter");

        //Assert
        assertTrue(success);
        documentIndexAction.close();
    }

    @Test
    void testIndexDocumentWithgPipeline()
    {
        //Arrange
        DocumentIndexAction documentIndexAction = new DocumentIndexAction(new ElasticClient(apikey, url, port, certfile));
        PipelineDocument pipelineDocument = new PipelineDocument();
        pipelineDocument.setName("SusieQ");
        pipelineDocument.setSocial("987-65-4321");

        //Act
        assertTrue(documentIndexAction.open());
        boolean success = documentIndexAction.indexDocumentWithPipeline(pipelineDocument, "pipeline-test", "example-pipeline");

        //Assert
        assertTrue(success);
        documentIndexAction.close();
    }

}