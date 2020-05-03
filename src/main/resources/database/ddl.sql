-- Table: public.grocery_item

-- DROP TABLE public.grocery_item;

CREATE TABLE public.grocery_item
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    quantity numeric NOT NULL DEFAULT 0,
    CONSTRAINT grocery_item_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.grocery_item
    OWNER to cresloga;