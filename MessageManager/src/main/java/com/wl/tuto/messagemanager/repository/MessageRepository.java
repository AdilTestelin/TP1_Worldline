package com.wl.tuto.messagemanager.repository;

import com.wl.tuto.messagemanager.model.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CassandraRepository<Message, String> {
    Optional<Message> findByMessageId(String messageId);
}
