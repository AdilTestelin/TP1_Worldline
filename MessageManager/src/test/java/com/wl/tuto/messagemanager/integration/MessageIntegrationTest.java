package com.wl.tuto.messagemanager.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.tuto.messagemanager.controller.MessageControler;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.repository.MessageRepository;
import com.wl.tuto.messagemanager.service.MessageService;
import com.wl.tuto.messagemanager.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static com.wl.tuto.messagemanager.controller.advice.MessageControllerAdvice.MESSAGE_NOT_FOUND;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageControler.class)
public class MessageIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @SpyBean
    public MessageService msgService;

    @MockBean
    public MessageRepository msgRepo;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ParameterizedTest(name = "{0}")
    @MethodSource("com.wl.tuto.messagemanager.utils.TestUtils#providesGood")
    public void Test_sendDTOMessage_OK(String name, Path path) {
        try {
            mockMvc.perform((MockMvcRequestBuilders.post("/v1/message"))
                    .characterEncoding(StandardCharsets.UTF_8.toString())
                    .contentType("application/json")
                    .content(new String(Files.readAllBytes(path), StandardCharsets.UTF_8)))
                    .andDo(print())
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            fail();
        }

    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("com.wl.tuto.messagemanager.utils.TestUtils#providesBad")
    public void Test_sendDTOMessage_KO(String name, Path path) {
        try {
            mockMvc.perform((MockMvcRequestBuilders.post("/v1/message"))
                    .characterEncoding(StandardCharsets.UTF_8.toString())
                    .contentType("application/json")
                    .content(new String(Files.readAllBytes(path), StandardCharsets.UTF_8)))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void Test_getMessage_OK() {
        String messageId = "messageId";
        Mockito.when(msgRepo.findByMessageId(messageId)).thenReturn(Optional.of(TestUtils.buildMessage(messageId)));
        try {
            mockMvc.perform((MockMvcRequestBuilders.get("/v1/message?id=" + messageId))
                    .characterEncoding(StandardCharsets.UTF_8.toString())
                    .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(TestUtils.buildResponseDTO(messageId))));
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void Test_getMessage_KO() {
        String messageId = "messageId";
        Optional<Message> msgMockRepo = Optional.empty();
        Mockito.when(msgRepo.findByMessageId(messageId)).thenReturn(msgMockRepo);
        try {
            mockMvc.perform((MockMvcRequestBuilders.get("/v1/message?id=" + messageId))
                    .characterEncoding(StandardCharsets.UTF_8.toString())
                    .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().string(containsString(MESSAGE_NOT_FOUND)))
                    .andExpect(content().string(containsString(messageId)));
        } catch (Exception e) {
            fail();
        }
    }
}
