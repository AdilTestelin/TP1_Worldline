package com.wl.tuto.messagemanager.repository;

import com.wl.tuto.messagemanager.model.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<Message, String> {
}
