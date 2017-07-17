--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

SET statement_timeout = 0;
SET lock_timeout = 0;
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
-- Name: fixedobjecttype; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE fixedobjecttype AS ENUM (
    'people',
    'animal',
    'car',
    'undefined'
);


ALTER TYPE fixedobjecttype OWNER TO postgres;

--
-- Name: usersrole; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE usersrole AS ENUM (
    'admin',
    'guest'
);


ALTER TYPE usersrole OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cameras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cameras (
    id integer NOT NULL,
    cameraname character varying(255) NOT NULL,
    latitude double precision,
    longitude double precision,
    status boolean,
    about character varying(255)
);


ALTER TABLE cameras OWNER TO postgres;

--
-- Name: cameras_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cameras_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cameras_id_seq OWNER TO postgres;

--
-- Name: cameras_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cameras_id_seq OWNED BY cameras.id;


--
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE images (
    id integer NOT NULL,
    detecteddate date NOT NULL,
    imagespath character varying(255) NOT NULL,
    camerasid integer NOT NULL,
    trafficid integer NOT NULL,
    detectedtime time without time zone NOT NULL
);


ALTER TABLE images OWNER TO postgres;

--
-- Name: images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE images_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE images_id_seq OWNER TO postgres;

--
-- Name: images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE images_id_seq OWNED BY images.id;


--
-- Name: traffic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE traffic (
    id integer NOT NULL,
    type fixedobjecttype NOT NULL,
    firstrundate date NOT NULL,
    firstruntime time without time zone DEFAULT '00:00:00'::time without time zone NOT NULL
);


ALTER TABLE traffic OWNER TO postgres;

--
-- Name: traffic_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE traffic_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE traffic_id_seq OWNER TO postgres;

--
-- Name: traffic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE traffic_id_seq OWNED BY traffic.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    email character varying(255) NOT NULL,
    password character varying(20) NOT NULL,
    role usersrole NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cameras ALTER COLUMN id SET DEFAULT nextval('cameras_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images ALTER COLUMN id SET DEFAULT nextval('images_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY traffic ALTER COLUMN id SET DEFAULT nextval('traffic_id_seq'::regclass);


--
-- Data for Name: cameras; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cameras (id, cameraname, latitude, longitude, status, about) FROM stdin;
1	Camera-1	50.1254757000000026	51.1582482000000027	t	about for camera-1
2	Camera-2	70.1254756999999955	71.1582482000000027	f	about for camera-2
\.


--
-- Name: cameras_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cameras_id_seq', 2, true);


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY images (id, detecteddate, imagespath, camerasid, trafficid, detectedtime) FROM stdin;
1	2017-07-07	images folder path-1	1	1	03:33:00
2	2017-05-05	images folder path-2	2	2	05:55:00
\.


--
-- Name: images_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('images_id_seq', 2, true);


--
-- Data for Name: traffic; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY traffic (id, type, firstrundate, firstruntime) FROM stdin;
1	people	2017-07-07	00:00:00
2	car	2017-05-05	00:00:00
3	car	2017-07-08	02:30:00
\.


--
-- Name: traffic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('traffic_id_seq', 3, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (email, password, role, name) FROM stdin;
user1@mail.ru	password-1	admin	User-1
user2@mail.ru	password-2	guest	User-2
\.


--
-- Name: cameras_cameraname_latitude_longitude_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cameras
    ADD CONSTRAINT cameras_cameraname_latitude_longitude_key UNIQUE (cameraname, latitude, longitude);


--
-- Name: cameras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cameras
    ADD CONSTRAINT cameras_pkey PRIMARY KEY (id);


--
-- Name: images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_pkey PRIMARY KEY (id);


--
-- Name: traffic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY traffic
    ADD CONSTRAINT traffic_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (email);


--
-- Name: images_camerasid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_camerasid_fkey FOREIGN KEY (camerasid) REFERENCES cameras(id);


--
-- Name: images_trafficid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_trafficid_fkey FOREIGN KEY (trafficid) REFERENCES traffic(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

