package com.wl.tuto.messagemanager.utils;

import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class TestUtils {
    public static Stream<Arguments> providesGood() throws URISyntaxException, IOException {
        Path p = Paths.get(ClassLoader.getSystemResource("good").toURI());
        List<Path> arr = Files.list(p).collect(Collectors.toList());
        Stream<Arguments> res = arr.stream().map(
                json ->
                {
                    return Arguments.of(json.toFile().getName().split(".json")[0], json);
                });
        return res;
    }

    public static Stream<Arguments> providesBad() throws URISyntaxException, IOException {
        Path p = Paths.get(ClassLoader.getSystemResource("bad").toURI());
        List<Path> arr = Files.list(p).collect(Collectors.toList());
        Stream<Arguments> res = arr.stream().map(
                json ->
                {
                    return Arguments.of(json.toFile().getName().split(".json")[0], json);
                });
        return res;
    }

    public Message buildMessage(String messageId) {
        return Message.builder()
                .messageId(messageId)
                .messageType("test")
                .eoId("test")
                .status("IN_PROGRESS")
                .aUis(Arrays.asList("aUis1", "aUis2"))
                .uiType(2)
                .build();
    }


    public MessageDTO buildMessageDTO(String messageId){
        return MessageDTO.builder()
                .messageID(messageId)
                .messageType("test")
                .eoID("test")
                .uiType(2)
                .aUIs(Arrays.asList("aUis1", "aUis2"))
                .build();
    }

    public ResponseDTO buildResponseDTO(String messageId){
        return ResponseDTO.builder()
                .messageID(messageId)
                .aUis(Arrays.asList("aUis1", "aUis2"))
                .status("IN_PROGRESS")
                .build();
    }


}
