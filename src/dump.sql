--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: telegram; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA telegram;


ALTER SCHEMA telegram OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: town; Type: TABLE; Schema: telegram; Owner: postgres
--

CREATE TABLE telegram.town (
    description character varying(256) NOT NULL,
    country character varying(16) NOT NULL,
    foundation_year character varying(16),
    id bigint NOT NULL,
    town_name character varying(16)
);


ALTER TABLE telegram.town OWNER TO postgres;

--
-- Name: town_id_seq; Type: SEQUENCE; Schema: telegram; Owner: postgres
--

CREATE SEQUENCE telegram.town_id_seq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE telegram.town_id_seq OWNER TO postgres;

--
-- Name: town_id_seq; Type: SEQUENCE OWNED BY; Schema: telegram; Owner: postgres
--

ALTER SEQUENCE telegram.town_id_seq OWNED BY telegram.town.id;


--
-- Name: town id; Type: DEFAULT; Schema: telegram; Owner: postgres
--

ALTER TABLE ONLY telegram.town ALTER COLUMN id SET DEFAULT nextval('telegram.town_id_seq'::regclass);


--
-- Data for Name: town; Type: TABLE DATA; Schema: telegram; Owner: postgres
--

COPY telegram.town (description, country, foundation_year, id, town_name) FROM stdin;
Good town	Russia	1500	1	Moscow
Clean Town	Belarus	1067	2	Minsk
Football town	England	1200	3	London
Football town	England	1200	6	Liverpool
The Capital of Norway	Norway	1100	4	Oslo
\.


--
-- Name: town_id_seq; Type: SEQUENCE SET; Schema: telegram; Owner: postgres
--

SELECT pg_catalog.setval('telegram.town_id_seq', 7, true);


--
-- Name: town town_pk; Type: CONSTRAINT; Schema: telegram; Owner: postgres
--

ALTER TABLE ONLY telegram.town
    ADD CONSTRAINT town_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

