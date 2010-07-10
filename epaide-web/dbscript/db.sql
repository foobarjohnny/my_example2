create table t_site_info
(
   id                   int auto_increment,
   name             varchar(10),
   title             varchar(20),
   logo                 varchar(20),
   url                  varchar(20),
   allowed_register     int,
   allowed_mailnotified int,
   allowed_phone_auth   int,
   send_epaibe          int,
   unactiveduration     int,
   copyright            varchar(100),
   meta_key             varchar(100),
   meta_desc            varchar(200),
   site_desc            text,
   com_co_desc          text,
   register_agreement   text
);

create table t_admin_info
(
   id                   int,
   name                 varchar(20),
   realname             varchar(20),
   password             varchar(20),
   phone                varchar(13),
   role_id                 int
);

create table t_help_center
(
   id                   int,
   title                varchar(100),
   content              text,
   publish_date         date
);

create table t_site_declare
(
   id                   int,
   title                varchar(50),
   content              text,
   publish_date         date
);

create table t_question
(
   id                   int,
   title                varchar(50),
   userid               int,
   content              varchar(200),
   publish_date         date
);

create table t_answer
(
   id                   int,
   title                varchar(50),
   content              text,
   question_id          int
);

create table t_category
(
   id                   int,
   name                 varchar(20)
);

create table t_product
(
   id                   int,
   name                 varchar(20),
   category_id          int,
   price                double,
   current_price        double,
   float_price          double,
   num_per_time         int,
   e_category           int,
   start_time           datetime,
   end_time             datetime,
   add_time             int,
   image_path           varchar(20),
   brief_info           varchar(200)
);

create table t_robot
(
   id                   int,
   name                 varchar(20),
   email                varchar(30),
   phone                varchar(13),
   product_ids          varchar(1000),
   start_price          double,
   end_price            double,
   duration             int
);

create table t_user
(
   id                   int,
   username             varchar(20),
   password             varchar(20),
   realname             varchar(20),
   email                varchar(50),
   phone                varchar(13),
   address              varchar(50),
   register_time        datetime,
   last_login           datetime,
   login_num            int,
   activation_code      varchar(20)
);

alter table t_answer add constraint FK_Reference_1 foreign key (question_id)
      references t_question (id) on delete restrict on update restrict;
alter table t_product add constraint FK_Reference_2 foreign key (category_id)
      references t_category (id) on delete restrict on update restrict;
