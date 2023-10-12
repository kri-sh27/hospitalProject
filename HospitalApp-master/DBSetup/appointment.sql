-- Table: public.appointment

-- DROP TABLE IF EXISTS public.appointment;

CREATE TABLE IF NOT EXISTS public.appointment
(
    id bigint NOT NULL,
    appointment_date date,
    appointment_end_time time without time zone,
    appointment_start_time time without time zone,
    charges double precision NOT NULL,
    created_at timestamp without time zone,
    name_of_doctor character varying(255) COLLATE pg_catalog."default",
    patientname character varying(255) COLLATE pg_catalog."default",
    prescription character varying(255) COLLATE pg_catalog."default",
    price numeric(19,2),
    status boolean NOT NULL,
    health_issue character varying(255) COLLATE pg_catalog."default",
    speciality character varying(255) COLLATE pg_catalog."default",
    note character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT appointment_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.appointment
    OWNER to postgres;