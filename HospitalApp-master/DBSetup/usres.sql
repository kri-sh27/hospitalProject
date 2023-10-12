-- Table: public.usres

-- DROP TABLE IF EXISTS public.usres;

CREATE TABLE IF NOT EXISTS public.usres
(
    id bigint NOT NULL DEFAULT nextval('usres_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    enabled boolean NOT NULL,
    full_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    dob date,
    gender character varying(255) COLLATE pg_catalog."default",
    maritalstatus character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usres_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usres
    OWNER to postgres;