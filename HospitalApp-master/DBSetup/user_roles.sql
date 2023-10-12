-- Table: public.user_role

-- DROP TABLE IF EXISTS public.user_role;

CREATE TABLE IF NOT EXISTS public.user_role
(
    user_role_id bigint NOT NULL,
    role_role_id bigint,
    user_id bigint,
    CONSTRAINT user_role_pkey PRIMARY KEY (user_role_id),
    CONSTRAINT fk4cvlo8ar1utq0vpo23q8bsi3s FOREIGN KEY (user_id)
        REFERENCES public.usres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk7u21823ktfhu9bmx2350x6n8s FOREIGN KEY (role_role_id)
        REFERENCES public.roles (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_role
    OWNER to postgres;