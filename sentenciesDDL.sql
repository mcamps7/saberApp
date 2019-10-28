/* 
 * Setciències
 * Sentències DDL per a la creació de la base de dades del Server de SaberApp
 */

-- Table: instituts

-- DROP TABLE instituts;

CREATE TABLE instituts
(
  id SERIAL,
  nom character varying(20),
  ciutat character varying(20),
  CONSTRAINT "institutsPK" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE instituts
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: professors

-- DROP TABLE professors;

CREATE TABLE professors
(
  id SERIAL,
  nick character varying(10) NOT NULL,
  password character varying(20) NOT NULL,
  nom character varying(15),
  cognoms character varying(30),
  mail character varying(30),
  image character varying(200),
  id_institut integer,
  materia character varying(20),
  CONSTRAINT "professorsPK" PRIMARY KEY (id),
  CONSTRAINT "institutsFK" FOREIGN KEY (id_institut)
      REFERENCES instituts (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE professors
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: alumnes

-- DROP TABLE alumnes;

CREATE TABLE alumnes
(
  id SERIAL,
  nick character varying(10) NOT NULL,
  password character varying(20) NOT NULL,
  nom character varying(15),
  cognoms character varying(30),
  mail character varying(30),
  image character varying(200),
  id_institut integer,
  curs character varying(20),
  CONSTRAINT "alumnesPK" PRIMARY KEY (id),
  CONSTRAINT "institutsFK" FOREIGN KEY (id_institut)
      REFERENCES instituts (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE alumnes
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: jocs

-- DROP TABLE jocs;

CREATE TABLE jocs
(
  id SERIAL,
  id_professor integer,
  nom character varying(20),
  imatge character varying(200),
  CONSTRAINT "jocsPK" PRIMARY KEY (id),
  CONSTRAINT "professorsFK" FOREIGN KEY (id_professor)
      REFERENCES professors (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE jocs
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: partides

-- DROP TABLE partides;

CREATE TABLE partides
(
  id SERIAL,
  id_joc integer,
  num_jornada integer,
  data_inici date,
  data_fi date,
  CONSTRAINT "partidesPK" PRIMARY KEY (id),
  CONSTRAINT "jocsFK" FOREIGN KEY (id_joc)
      REFERENCES jocs (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE partides
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: preguntes

-- DROP TABLE preguntes;

CREATE TABLE preguntes
(
  id SERIAL,
  id_partida integer,
  ordre integer,
  pregunta character varying(200),
  imatge character varying(200),
  explicacio character varying(400),
  CONSTRAINT "preguntesPK" PRIMARY KEY (id),
  CONSTRAINT "partidesFK" FOREIGN KEY (id_partida)
      REFERENCES partides (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE preguntes
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: respostes

-- DROP TABLE respostes;

CREATE TABLE respostes
(
  id SERIAL,
  id_pregunta integer,
  resposta character varying(200),
  correcta boolean,
  CONSTRAINT "respostesPK" PRIMARY KEY (id),
  CONSTRAINT "preguntesPK" FOREIGN KEY (id_pregunta)
      REFERENCES preguntes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE respostes
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: alumne_partida

-- DROP TABLE alumne_partida;

CREATE TABLE alumne_partida
(
  id SERIAL,
  id_alumne integer,
  id_partida integer,
  puntuacio integer,
  CONSTRAINT "alumne_partidaPK" PRIMARY KEY (id),
  CONSTRAINT "alumnesFK" FOREIGN KEY (id_alumne)
      REFERENCES alumnes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "partidesFK" FOREIGN KEY (id_partida)
      REFERENCES partides (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE alumne_partida
  OWNER TO prodelpe;

--------------------------------------------------------------------------------

-- Table: alumne_joc

-- DROP TABLE alumne_joc;

CREATE TABLE alumne_joc
(
  id SERIAL,
  id_alumne integer NOT NULL,
  id_joc integer,
  puntuacio integer,
  CONSTRAINT "alumne_jocPK" PRIMARY KEY (id_alumne),
  CONSTRAINT "alumnesFK" FOREIGN KEY (id_alumne)
      REFERENCES alumnes (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "jocsFK" FOREIGN KEY (id_joc)
      REFERENCES jocs (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE alumne_joc
  OWNER TO prodelpe;
