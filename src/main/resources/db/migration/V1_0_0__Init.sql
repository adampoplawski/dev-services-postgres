CREATE SEQUENCE public.parent_seq INCREMENT 50 START WITH 1 MINVALUE 1;

CREATE TYPE language AS ENUM (
    'PL',
    'EN'
    );

CREATE TABLE parent
(
    id       BIGINT,
    property VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE child
(
    parent_id BIGINT,
    language language,
    property VARCHAR NOT NULL,
    PRIMARY KEY (parent_id, language),
    FOREIGN KEY (parent_id) REFERENCES parent (id)
);
