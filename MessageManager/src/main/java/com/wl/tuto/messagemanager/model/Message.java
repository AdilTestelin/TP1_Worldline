package com.wl.tuto.messagemanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

import static com.wl.tuto.messagemanager.model.Message.TABLE_NAME;


@Table(TABLE_NAME)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Message {

    public static final String TABLE_NAME = "message";

    @PrimaryKeyColumn(value = "message_id", type = PrimaryKeyType.PARTITIONED)
    private String messageId;

    @Column(value = "message_type")
    private String messageType;

    @Column(value = "eo_id")
    private String eoId;

    @Column(value = "ui_type")
    private Integer uiType;

    @Column(value = "auis")
    private List<String> aUis;

    @Column(value = "status")
    private String status;

}

