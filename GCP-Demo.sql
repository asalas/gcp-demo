/*
Navicat PGSQL Data Transfer

Source Server         : GCP-Demo
Source Server Version : 90601
Source Host           : 35.184.96.98:5432
Source Database       : gcp
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90601
File Encoding         : 65001

Date: 2017-10-28 15:16:03
*/


-- ----------------------------
-- Sequence structure for saludo_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."saludo_id_seq";
CREATE SEQUENCE "public"."saludo_id_seq"
 INCREMENT 1
 MINVALUE 11
 MAXVALUE 9223372036854775807
 START 17
 CACHE 1;
SELECT setval('"public"."saludo_id_seq"', 17, true);

-- ----------------------------
-- Table structure for saludo
-- ----------------------------
DROP TABLE IF EXISTS "public"."saludo";
CREATE TABLE "public"."saludo" (
"id_saludo" int4 DEFAULT nextval('saludo_id_seq'::regclass) NOT NULL,
"mensaje" varchar(255) COLLATE "default" NOT NULL,
"fecha_creacion" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of saludo
-- ----------------------------
INSERT INTO "public"."saludo" VALUES ('11', 'Hola Antonino, un gusto saludarte!', '2017-10-25 20:55:05.829');
INSERT INTO "public"."saludo" VALUES ('12', 'Hola Antonino, un gusto saludarte!', '2017-10-25 20:56:29.674');
INSERT INTO "public"."saludo" VALUES ('13', 'Hola Antonino, un gusto saludarte!', '2017-10-25 21:09:31.361');
INSERT INTO "public"."saludo" VALUES ('14', 'Hola Pamela, un gusto saludarte!', '2017-10-25 21:13:33.344');
INSERT INTO "public"."saludo" VALUES ('15', 'Hola Pamela, un gusto saludarte!', '2017-10-25 22:03:21.092');
INSERT INTO "public"."saludo" VALUES ('16', 'Hola Antonella, un gusto saludarte!', '2017-10-26 12:45:26.823');
INSERT INTO "public"."saludo" VALUES ('17', 'Hola Luisa, un gusto saludarte!', '2017-10-28 19:10:17.918');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."saludo_id_seq" OWNED BY "saludo"."id_saludo";

-- ----------------------------
-- Primary Key structure for table saludo
-- ----------------------------
ALTER TABLE "public"."saludo" ADD PRIMARY KEY ("id_saludo");
