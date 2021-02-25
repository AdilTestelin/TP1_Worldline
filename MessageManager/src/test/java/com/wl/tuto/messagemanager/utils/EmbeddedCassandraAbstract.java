package com.wl.tuto.messagemanager.utils;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class EmbeddedCassandraAbstract {

    public static Session session;

    @BeforeAll
    public static void createEmbeddedServer() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();

        Cluster clust = Cluster.builder().addContactPoint("localhost").withPort(9142).build();
        session = clust.connect();

        session.execute("CREATE KEYSPACE IF NOT EXISTS message_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};");

        session.execute("USE message_keyspace");
        session.execute("DROP TABLE IF EXISTS message");
        session.execute("CREATE TABLE message_keyspace.message(message_id text, auis list<text>, eo_id text, message_type text, status text, ui_type int, PRIMARY KEY (message_id))");
        session.execute("INSERT INTO message_keyspace.message(message_id, auis, eo_id, message_type, status, ui_type)  VALUES ('unmessageidTest', ['aui1', 'aui2'], 'eoidTest', 'messagetypeTest', 'in_progress', 2)");
    }

    @AfterAll
    public static void stopEmbeddedServer() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();    }
}
