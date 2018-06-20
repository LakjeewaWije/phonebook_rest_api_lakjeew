# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  c_id                          bigint auto_increment not null,
  c_name                        varchar(255) not null,
  c_mobile                      varchar(255) not null,
  c_office                      varchar(255),
  c_home                        varchar(255),
  c_email                       varchar(255),
  user_u_id                     bigint,
  constraint pk_contact primary key (c_id)
);

create table user (
  u_id                          bigint auto_increment not null,
  u_firstname                   varchar(255) not null,
  u_lasttname                   varchar(255) not null,
  u_email                       varchar(255) not null,
  u_phoneno                     varchar(255) not null,
  u_password                    varchar(255) not null,
  constraint pk_user primary key (u_id)
);

alter table contact add constraint fk_contact_user_u_id foreign key (user_u_id) references user (u_id) on delete restrict on update restrict;
create index ix_contact_user_u_id on contact (user_u_id);


# --- !Downs

alter table contact drop foreign key fk_contact_user_u_id;
drop index ix_contact_user_u_id on contact;

drop table if exists contact;

drop table if exists user;

