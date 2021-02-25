package com.wl.tuto.messagemanager.unit;

import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMapperTest {

    @Test
    public final void testMessageDTOtoMessage(){
        ArrayList<String> aUIsTest = new ArrayList<>();
        aUIsTest.add("aUI_1");
        aUIsTest.add("aUI_2");
        MessageDTO msgDto = MessageDTO.builder()
                .messageID("unmessageid")
                .messageType("testMsgType")
                .eoID("testEoId")
                .uiType(2)
                .aUIs(aUIsTest)
                .build();
        Message msg = Message.builder()
                .messageId("unmessageid")
                .messageType("testMsgType")
                .eoId("testEoId")
                .uiType(2)
                .aUis(aUIsTest)
                .status("IN_PROGRESS")
                .build();
        Message msgDtoConvertedToMsg = MessageMapper.messageDTOToMessage(msgDto);
        assertEquals(msg, msgDtoConvertedToMsg);
    }

    @Test
    public final void testMessageToResponseDTO(){
        ArrayList<String> aUIsTest = new ArrayList<>();
        aUIsTest.add("aUI_1");
        aUIsTest.add("aUI_2");
        Message msg = Message.builder()
                .messageId("unmessageid")
                .messageType("testMsgType")
                .eoId("testEoId")
                .uiType(2)
                .aUis(aUIsTest)
                .status("IN_PROGRESS")
                .build();
        ResponseDTO respDTO = ResponseDTO.builder()
                .messageID("unmessageid")
                .status("IN_PROGRESS")
                .aUis(aUIsTest)
                .build();
        ResponseDTO msgConvertedToRespDTO = MessageMapper.messageToResponseDTO(msg);
        assertEquals(respDTO, msgConvertedToRespDTO);
    }
}
