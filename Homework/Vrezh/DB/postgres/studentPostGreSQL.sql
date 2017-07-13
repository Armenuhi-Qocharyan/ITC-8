--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: exames; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exames (
    id integer NOT NULL,
    subject_id integer NOT NULL,
    student_id integer NOT NULL,
    score integer NOT NULL,
    itc_number integer
);


ALTER TABLE public.exames OWNER TO postgres;

--
-- Name: exames_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE exames_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exames_id_seq OWNER TO postgres;

--
-- Name: exames_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE exames_id_seq OWNED BY exames.id;


--
-- Name: itc; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE itc (
    number integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.itc OWNER TO postgres;

--
-- Name: itc_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE itc_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.itc_number_seq OWNER TO postgres;

--
-- Name: itc_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE itc_number_seq OWNED BY itc.number;


--
-- Name: subjects; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE subjects (
    id integer NOT NULL,
    title character varying(20) NOT NULL
);


ALTER TABLE public.subjects OWNER TO postgres;

--
-- Name: maxscoreofitc; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW maxscoreofitc AS
 SELECT itc.number AS itc,
    subjects.title,
    max(exames.score) AS maxscore,
    count(exames.student_id) AS studentcount
   FROM ((exames
     JOIN itc ON ((itc.number = exames.itc_number)))
     JOIN subjects ON ((subjects.id = exames.subject_id)))
  GROUP BY subjects.title, itc.number
  ORDER BY itc.number;


ALTER TABLE public.maxscoreofitc OWNER TO postgres;

--
-- Name: students; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE students (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    surname character varying(20) NOT NULL
);


ALTER TABLE public.students OWNER TO postgres;

--
-- Name: students_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.students_id_seq OWNER TO postgres;

--
-- Name: students_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE students_id_seq OWNED BY students.id;


--
-- Name: subjectavgfromcurrentitc; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW subjectavgfromcurrentitc AS
 SELECT students.name,
    subjects.title,
    avg(exames.score) AS scoreavg,
    count(exames.itc_number) AS itcnumber
   FROM ((exames
     JOIN students ON ((students.id = exames.student_id)))
     JOIN subjects ON ((subjects.id = exames.subject_id)))
  GROUP BY subjects.title, students.name
  ORDER BY students.name;


ALTER TABLE public.subjectavgfromcurrentitc OWNER TO postgres;

--
-- Name: subjects_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE subjects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.subjects_id_seq OWNER TO postgres;

--
-- Name: subjects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE subjects_id_seq OWNED BY subjects.id;


--
-- Name: userscoreavg; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW userscoreavg AS
 SELECT students.name,
    avg(exames.score) AS avg
   FROM (students
     JOIN exames ON ((students.id = exames.student_id)))
  GROUP BY students.name;


ALTER TABLE public.userscoreavg OWNER TO postgres;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exames ALTER COLUMN id SET DEFAULT nextval('exames_id_seq'::regclass);


--
-- Name: number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY itc ALTER COLUMN number SET DEFAULT nextval('itc_number_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY students ALTER COLUMN id SET DEFAULT nextval('students_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY subjects ALTER COLUMN id SET DEFAULT nextval('subjects_id_seq'::regclass);


--
-- Data for Name: exames; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY exames (id, subject_id, student_id, score, itc_number) FROM stdin;
1	1	1	100	1
2	2	1	99	1
3	3	1	99	1
4	3	1	90	2
5	3	2	100	2
6	3	2	99	1
7	2	2	99	1
8	2	3	80	1
9	3	3	90	2
10	2	3	90	2
11	2	3	85	1
12	1	3	85	1
13	3	3	87	1
\.


--
-- Name: exames_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('exames_id_seq', 13, true);


--
-- Data for Name: itc; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY itc (number, date) FROM stdin;
1	2009-01-01
2	2010-01-01
3	2011-01-01
4	2012-01-01
5	2013-01-01
6	2014-01-01
7	2015-01-01
8	2017-01-01
\.


--
-- Name: itc_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('itc_number_seq', 1, false);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY students (id, name, surname) FROM stdin;
1	Vazgel	Abelyan
2	Sahak	Sahakyan
3	Minas	Minasyan
\.


--
-- Name: students_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('students_id_seq', 3, true);


--
-- Data for Name: subjects; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY subjects (id, title) FROM stdin;
1	C++
2	Python
3	Bash
\.


--
-- Name: subjects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('subjects_id_seq', 3, true);


--
-- Name: exames_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exames
    ADD CONSTRAINT exames_pkey PRIMARY KEY (id);


--
-- Name: itc_date_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY itc
    ADD CONSTRAINT itc_date_key UNIQUE (date);


--
-- Name: itc_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY itc
    ADD CONSTRAINT itc_pkey PRIMARY KEY (number);


--
-- Name: students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);


--
-- Name: subjects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY subjects
    ADD CONSTRAINT subjects_pkey PRIMARY KEY (id);


--
-- Name: exames_itc_number_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exames
    ADD CONSTRAINT exames_itc_number_fkey FOREIGN KEY (itc_number) REFERENCES itc(number);


--
-- Name: exames_student_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exames
    ADD CONSTRAINT exames_student_id_fkey FOREIGN KEY (student_id) REFERENCES students(id);


--
-- Name: exames_subject_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exames
    ADD CONSTRAINT exames_subject_id_fkey FOREIGN KEY (subject_id) REFERENCES subjects(id);


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

