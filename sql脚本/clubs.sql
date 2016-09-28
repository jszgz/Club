-- Table: public.clubs

-- DROP TABLE public.clubs;

CREATE TABLE public.clubs
(
  clno character varying(10) NOT NULL,
  clname character varying(20),
  clabout character varying,
  CONSTRAINT "Clubs_pkey" PRIMARY KEY (clno)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.clubs
  OWNER TO postgres;
