package com.snjdigitalsolutions.elastic.action;

import com.snjdigitalsolutions.elastic.AbstractTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IndexActionTest extends AbstractTest {


    @Test
    @Order(1)
    public void indexExistsFalse() throws Exception
    {
        //Arrange
        indexAction.open();

        //Act
        boolean exists = indexAction.doesIndexExist("test_index");

        //Assert
        assertFalse(exists);
    }

    @Test
    @Order(2)
    public void createIndex() throws Exception
    {
        //Arrange
        indexAction.open();

        //Act
        boolean success = indexAction.createIndex("test_index");

        //Assert
        assertTrue(success);
    }

    @Test
    @Order(3)
    public void indexExistsTrue() throws Exception
    {
        //Arrange
        indexAction.open();

        //Act
        boolean exists = indexAction.doesIndexExist("test_index");

        //Assert
        assertTrue(exists);
    }

    @Test
    @Order(4)
    public void deleteIndex() throws Exception
    {
        //Arrange
        indexAction.open();
        String indexName = "test_index";

        //Act
        boolean success = indexAction.deleteIndex(indexName);
        boolean exists = indexAction.doesIndexExist(indexName);

        //Assert
        assertTrue(success);
        assertFalse(exists);
    }


}