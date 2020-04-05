--CREATE ADDRESS TABLE
DROP SEQUENCE IF EXISTS ADDRESS_ID_SEQ;
DROP TABLE IF EXISTS ADDRESS;

CREATE SEQUENCE ADDRESS_ID_SEQ;
CREATE TABLE ADDRESS
(
    ID           INTEGER     DEFAULT NEXTVAL('ADDRESS_ID_SEQ'),
    STREET       VARCHAR(50) NOT NULL,
    HOUSE_NUMBER VARCHAR(8)  NOT NULL,
    HOUSE_INDEX  VARCHAR(8)  DEFAULT '',
    HOUSE_BOX    VARCHAR(8)  DEFAULT '',
    POSTAL_CODE  VARCHAR(6)  NOT NULL,
    LOCALITY     VARCHAR(50) NOT NULL,
    ADDRESS_TYPE VARCHAR(10) DEFAULT 'LCM',
    CONSTRAINT ADDRESS_PK PRIMARY KEY (ID)
);

INSERT INTO ADDRESS (STREET, HOUSE_NUMBER, POSTAL_CODE, LOCALITY)
VALUES ('Hollywood Boulevard', '88', '1580', 'Hollywood'),
       ('Sorcerer Street', '66', '4040', 'Zweinstein'),
       ('Unknown Lane', '10', '9999', 'Neverland');

--CREATE SUBSCRIBER TABLE
DROP SEQUENCE IF EXISTS SUBSCRIBER_ID_SEQ;
DROP TABLE IF EXISTS SUBSCRIBER;

CREATE SEQUENCE SUBSCRIBER_ID_SEQ;
CREATE TABLE SUBSCRIBER
(
    ID                       INTEGER     DEFAULT NEXTVAL('SUBSCRIBER_ID_SEQ'),
    ADDRESS_ID               INTEGER     NOT NULL,
    FIRSTNAME                VARCHAR(20) NOT NULL,
    LASTNAME                 VARCHAR(30) NOT NULL,
    BIRTHDATE                DATE        NOT NULL,
    DEATHDATE                DATE        DEFAULT NULL,
    GENDER                   VARCHAR(6)  NOT NULL,
    NATIONAL_REGISTER_NUMBER VARCHAR(25) NOT NULL,
    CM_MEMBER_IND            BOOLEAN     DEFAULT FALSE,
    M_NUMBER                 VARCHAR(25) DEFAULT NULL,
    ACV_MEMBER_IND           BOOLEAN     DEFAULT FALSE,
    ACV_UUID                 VARCHAR(36) DEFAULT NULL,
    CONSTRAINT SUBSCRIBER_PK PRIMARY KEY (ID),
    FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID)
);

INSERT INTO SUBSCRIBER (ADDRESS_ID, FIRSTNAME, LASTNAME, BIRTHDATE, DEATHDATE, GENDER,
                        NATIONAL_REGISTER_NUMBER)
VALUES (1, 'Tom', 'Cruise', '1962-07-03', null, 'MALE', 67070322361),
       (2, 'Harry', 'Potter', '1988-11-06', null, 'MALE', 67089332361),
       (3, 'Jane', 'Doe', '1944-01-15', null, 'FEMALE', 53550322361);

--CREATE SUBSCRIPTION TABLE
DROP SEQUENCE IF EXISTS SUBSCRIPTION_ID_SEQ;
DROP TABLE IF EXISTS SUBSCRIPTION;

CREATE SEQUENCE SUBSCRIPTION_ID_SEQ;
CREATE TABLE SUBSCRIPTION
(
    ID                  INTEGER  DEFAULT NEXTVAL('SUBSCRIPTION_ID_SEQ'),
    SUBSCRIPTION_NUMBER VARCHAR(20) NOT NULL,
    START_DATE          DATE     DEFAULT NULL,
    END_DATE            DATE     DEFAULT NULL,
    SEND_PHYSICAL_IND   BOOLEAN  DEFAULT FALSE,
    SEND_DIGITAL_IND    BOOLEAN  DEFAULT FALSE,
    VALIDATION_ERROR_ID INTEGER  DEFAULT NULL,
    MAGAZINE            VARCHAR(12) NOT NULL,
    NUMBER_OF_COPIES    SMALLINT DEFAULT 1,
    EDITION_ID          INTEGER     NOT NULL,
    PUBLISHED_IND       BOOLEAN  DEFAULT FALSE,
    SUBSCRIBER_ID       INTEGER     NOT NULL,
    CONSTRAINT SUBSCRIPTION_PK PRIMARY KEY (ID),
    FOREIGN KEY (SUBSCRIBER_ID) REFERENCES SUBSCRIBER (ID)
);

INSERT INTO SUBSCRIPTION (SUBSCRIPTION_NUMBER, SUBSCRIBER_ID, MAGAZINE, EDITION_ID)
VALUES ('xxxxxxxxx454545', 1, 'EN_MARCHE', 10),
       ('xxxxxxxxx448521', 2, 'VISIE', 15),
       ('xxxxxxxxx448521', 1, 'VISIE', 15),
       ('xxxxxxxxx691175', 3, 'LEEF', 20);

