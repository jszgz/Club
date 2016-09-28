-- Table: public.students

-- DROP TABLE public.students;

CREATE TABLE public.students
(
  sno character varying(20) NOT NULL,
  sname character varying(20),
  ssex character varying(6),
  spassword character varying(20),
  CONSTRAINT "Students_pkey" PRIMARY KEY (sno)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.students
  OWNER TO postgres;
