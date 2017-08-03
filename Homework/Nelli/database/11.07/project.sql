--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: roles; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE roles AS ENUM (
    'user',
    'administrator'
);


ALTER TYPE roles OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;
--
-- Name: cameras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cameras (
    id integer NOT NULL,
    location character varying(50) NOT NULL,
    is_online boolean NOT NULL,
    about character varying(255)
);


ALTER TABLE cameras OWNER TO postgres;

--
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE images (
    id integer NOT NULL,
    path character varying(100) NOT NULL,
    trafic_id integer NOT NULL,
    "time" time without time zone NOT NULL
);


ALTER TABLE images OWNER TO postgres;

--
-- Name: trafic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE trafic (
    id integer NOT NULL,
    camera_id integer NOT NULL,
    date date NOT NULL,
    dir_path character varying(200) NOT NULL
);


ALTER TABLE trafic OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    email character varying(200) NOT NULL,
    name character varying(25) NOT NULL,
    password character varying(100) NOT NULL,
    role roles NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Data for Name: cameras; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cameras (id, location, is_online, about) FROM stdin;
\.


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY images (id, path, trafic_id, "time") FROM stdin;
\.


--
-- Data for Name: trafic; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY trafic (id, camera_id, date, dir_path) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (email, name, password, role) FROM stdin;
\.


--
-- Name: cameras cameras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--


ALTER TABLE ONLY cameras
ADD CONSTRAINT cameras_pkey PRIMARY KEY (id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
ADD CONSTRAINT images_pkey PRIMARY KEY (id);


--
-- Name: trafic trafic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trafic
ADD CONSTRAINT trafic_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
ADD CONSTRAINT users_pkey PRIMARY KEY (email);


--
-- Name: images images_trafic_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
ADD CONSTRAINT images_trafic_id_fkey FOREIGN KEY (trafic_id) REFERENCES trafic(id);


--
-- Name: trafic trafic_camera_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trafic
ADD CONSTRAINT trafic_camera_id_fkey FOREIGN KEY (camera_id) REFERENCES cameras(id);


--
-- PostgreSQL database dump complete
--


