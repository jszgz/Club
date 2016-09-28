-- Table: public.courses

-- DROP TABLE public.courses;

CREATE TABLE public.courses
(
  cno character varying(10) NOT NULL,
  cname character varying(20),
  cyear character varying(10),
  cteacher character varying(20),
  CONSTRAINT "Courses_pkey" PRIMARY KEY (cno)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.courses
  OWNER TO postgres;
