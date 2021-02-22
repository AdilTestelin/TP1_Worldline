CREATE table message (
        id VARCHAR PRIMARY KEY,
        status VARCHAR,
        EO_ID VARCHAR,
        message_type VARCHAR,
        UI_Type int,
        aUis list<VARCHAR>
);