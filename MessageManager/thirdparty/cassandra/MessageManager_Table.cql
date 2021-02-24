CREATE TABLE IF NOT EXISTS message (
            message_id   text primary key,
            auis         list<text>,
            eo_id        text,
            message_type text,
            status       text,
            ui_type      int
 );