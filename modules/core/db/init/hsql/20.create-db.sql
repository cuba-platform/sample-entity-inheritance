-- begin DEMO_COMPANY
alter table DEMO_COMPANY add constraint FK_DEMO_COMPANY_ID foreign key (ID) references DEMO_CUSTOMER(ID)^
-- end DEMO_COMPANY
-- begin DEMO_PERSON
alter table DEMO_PERSON add constraint FK_DEMO_PERSON_ID foreign key (ID) references DEMO_CUSTOMER(ID)^
-- end DEMO_PERSON
-- begin DEMO_ORDER
alter table DEMO_ORDER add constraint FK_DEMO_ORDER_CUSTOMER_ID foreign key (CUSTOMER_ID) references DEMO_CUSTOMER(ID)^
create index IDX_DEMO_ORDER_CUSTOMER on DEMO_ORDER (CUSTOMER_ID)^
-- end DEMO_ORDER
