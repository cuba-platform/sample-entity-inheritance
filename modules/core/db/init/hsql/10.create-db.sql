-- begin DEMO_CUSTOMER
create table DEMO_CUSTOMER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(3),
    --
    NAME varchar(255) not null,
    EMAIL varchar(100),
    --
    primary key (ID)
)^
-- end DEMO_CUSTOMER
-- begin DEMO_COMPANY
create table DEMO_COMPANY (
    ID varchar(36) not null,
    --
    INDUSTRY varchar(255),
    --
    primary key (ID)
)^
-- end DEMO_COMPANY
-- begin DEMO_PERSON
create table DEMO_PERSON (
    ID varchar(36) not null,
    --
    FIRST_NAME varchar(100),
    LAST_NAME varchar(100),
    --
    primary key (ID)
)^
-- end DEMO_PERSON
-- begin DEMO_ORDER
create table DEMO_ORDER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUM varchar(20) not null,
    DATE_ date not null,
    AMOUNT decimal(19, 2),
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end DEMO_ORDER
