CREATE TABLE api_contact_schema.player (
  id                  SERIAL PRIMARY KEY,
  name                VARCHAR
);

CREATE SEQUENCE contact_register_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
