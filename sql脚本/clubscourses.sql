-- Table: public.clubscourses

-- DROP TABLE public.clubscourses;

CREATE TABLE public.clubscourses
(
  clno character varying(10) NOT NULL,
  cno character varying(10) NOT NULL,
  CONSTRAINT "ClubsCourses_pkey" PRIMARY KEY (clno, cno),
  CONSTRAINT clubscourses_clno_fkey FOREIGN KEY (clno)
      REFERENCES public.clubs (clno) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT clubscourses_cno_fkey FOREIGN KEY (cno)
      REFERENCES public.courses (cno) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.clubscourses
  OWNER TO postgres;
