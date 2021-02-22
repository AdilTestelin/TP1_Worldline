CREATE table message (
        Message_ID VARCHAR PRIMARY KEY,
        Status VARCHAR,
        EO_ID VARCHAR,
        message_type VARCHAR,
        UI_Type int,
        aUis list<VARCHAR>
);