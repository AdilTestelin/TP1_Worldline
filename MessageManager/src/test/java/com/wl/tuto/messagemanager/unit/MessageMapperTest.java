package com.wl.tuto.messagemanager.unit;

import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMapperTest {

    @Test
    public final void testMessageDTOtoMessage(){
        String messageId = "messageId";
        Message msgDtoConvertedToMsg = MessageMapper.messageDTOToMessage(TestUtils.buildMessageDTO(messageId));
        assertEquals(TestUtils.buildMessage(messageId), msgDtoConvertedToMsg);
    }

    @Test
    public final void testMessageToResponseDTO(){
        String messageId = "messageId";
        ResponseDTO msgConvertedToRespDTO = MessageMapper.messageToResponseDTO(TestUtils.buildMessage(messageId));
        assertEquals(TestUtils.buildResponseDTO(messageId), msgConvertedToRespDTO);
    }
}
