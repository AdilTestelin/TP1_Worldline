package com.wl.tuto.messagemanager.unit;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.repository.MessageRepository;
import com.wl.tuto.messagemanager.service.MessageService;
import com.wl.tuto.messagemanager.utils.EmbeddedCassandraAbstract;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
public class MessageServiceTest extends EmbeddedCassandraAbstract {

    @Autowired
    public MessageRepository msgRepo;

    @Autowired
    public MessageService msgServ;

    @Test
    public void testGetMessageById() throws MessageNotFoundException {
        // MessageService msgServ = new MessageService(msgRepo);
        ResponseDTO resp = msgServ.getMessageById("unmessageidTest");
        ArrayList<String> aUIsTest = new ArrayList<>();
        aUIsTest.add("aui1");
        aUIsTest.add("aui2");
        ResponseDTO respDTO = ResponseDTO.builder()
                .messageID("unmessageidTest")
                .aUis(aUIsTest)
                .status("in_progress")
                .build();

        assertEquals(resp, respDTO);
    }

    @Test
    public void testSave() throws MessageNotFoundException {
        ArrayList<String> aUIsTest = new ArrayList<>();
        aUIsTest.add("aUI_1");
        aUIsTest.add("aUI_2");
        MessageDTO msgDTO = MessageDTO.builder()
                .messageID("unmessageidTest1")
                .messageType("messagetypeTest")
                .eoID("eoidTest")
                .uiType(2)
                .aUIs(aUIsTest)
                .build();
        msgServ.save(msgDTO);
        ResponseDTO respDTO = msgServ.getMessageById("unmessageidTest1");
        assertEquals(msgDTO.getMessageID(), respDTO.getMessageID());
    }
}
