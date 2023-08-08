package com.snjdigitalsolutions.elastic.action;

import com.snjdigitalsolutions.elastic.AbstractTest;
import com.snjdigitalsolutions.elastic.document.EmailDocument;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DocumentIndexActionTest extends AbstractTest {

    @Test
    void testIndexing()
    {
        //Arrange
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

}