CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE character
(
   id UUID NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
   name VARCHAR NOT NULL,
   description VARCHAR,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP
);

CREATE INDEX character_name ON character (name);
