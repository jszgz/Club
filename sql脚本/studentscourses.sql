-- Table: public.studentscourses

-- DROP TABLE public.studentscourses;

CREATE TABLE public.studentscourses
(
  sno character varying(20) NOT NULL,
  cno character varying(10) NOT NULL,
  scgrade double precision,
  CONSTRAINT "StudentsCourses_pkey" PRIMARY KEY (sno, cno),
  CONSTRAINT studentscourses_cno_fkey FOREIGN KEY (cno)
      REFERENCES public.courses (cno) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT studentscourses_sno_fkey FOREIGN KEY (sno)
      REFERENCES public.students (sno) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.studentscourses
  OWNER TO postgres;
