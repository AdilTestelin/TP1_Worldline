CREATE KEYSPACE IF NOT EXISTS message_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};
USE message_keyspace;
