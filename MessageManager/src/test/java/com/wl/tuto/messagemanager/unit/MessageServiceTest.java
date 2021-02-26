package com.wl.tuto.messagemanager.unit;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.repository.MessageRepository;
import com.wl.tuto.messagemanager.service.MessageService;
import com.wl.tuto.messagemanager.utils.EmbeddedCassandraAbstract;
import com.wl.tuto.messagemanager.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest
public class MessageServiceTest extends EmbeddedCassandraAbstract {

    @Autowired
    public MessageRepository msgRepo;

    @Autowired
    public MessageService msgServ;

    @Test
    public void Test_getMessageById_OK() {
        String messageId = "messageId";
        msgRepo.save(TestUtils.buildMessage(messageId));
        try {
            assertEquals(TestUtils.buildResponseDTO(messageId), msgServ.getMessageById(messageId));
        } catch (MessageNotFoundException e){
            fail();
        }
    }

    @Test
    public void Test_getMessageById_KO() {
        String messageId = "messageId";
        assertFalse(msgRepo.findByMessageId(messageId).isPresent());
        assertThrows(MessageNotFoundException.class, () -> msgServ.getMessageById(messageId));
    }

    @Test
    public void Test_save()  {
        String messageId = "messageId";
        MessageDTO msgDTO = TestUtils.buildMessageDTO(messageId);
        assertFalse(msgRepo.findByMessageId(messageId).isPresent());
        msgServ.save(msgDTO);
        assertTrue(msgRepo.findByMessageId(messageId).isPresent());
        assertEquals(TestUtils.buildMessage(messageId), msgRepo.findByMessageId(messageId).get());
    }
}
