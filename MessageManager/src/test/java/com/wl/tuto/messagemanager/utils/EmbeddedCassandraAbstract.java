package com.wl.tuto.messagemanager.utils;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.FileCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public abstract class EmbeddedCassandraAbstract {

    public static Session session;
    public final static String DROP_TABLE = "DROP TABLE IF EXISTS message";
    public final static String CREATE_TABLE = "CREATE TABLE message_keyspace.message(message_id text," +
            " auis list<text>," +
            " eo_id text," +
            " message_type text," +
            " status text," +
            " ui_type int," +
            " PRIMARY KEY (message_id))";

    @BeforeAll
    public static void createEmbeddedServer() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();

        Cluster cluster = Cluster.builder()
                .addContactPoint("localhost")
                .withPort(9142)
                .build();

        session = cluster.connect();

        CQLDataLoader dataLoader = new CQLDataLoader(session);
        dataLoader.load(new FileCQLDataSet("src/test/resources/schema.cql", true, true));
    }

    @BeforeEach
    public void createTable(){
        session.execute(CREATE_TABLE);
    }

    @AfterEach
    public void dropTable(){
        session.execute(DROP_TABLE);
    }

    @AfterAll
    public static void stopEmbeddedServer() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();    }
}
