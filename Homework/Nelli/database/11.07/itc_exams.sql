--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;






--
-- Database creation
--

CREATE DATABASE itc WITH TEMPLATE = template0 OWNER = postgres;
REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect itc

SET default_transaction_read_only = off;

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

--
-- Name: learn; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE learn AS ENUM (
    'itc_1',
    'itc_7',
    'itc_8'
);


ALTER TYPE learn OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: exams; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE exams (
    id integer NOT NULL,
    student_id integer NOT NULL,
    subject_id integer NOT NULL,
    score integer NOT NULL,
    itc learn NOT NULL
);
ALTER TABLE exams OWNER TO postgres;

--

-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE students (
        id integer NOT NULL,
            name character varying(50) NOT NULL
        );


        ALTER TABLE students OWNER TO postgres;

        --
        -- Name: subjects; Type: TABLE; Schema: public; Owner: postgres
        --

        CREATE TABLE subjects (
                id integer NOT NULL,
                    title character varying(20) NOT NULL
                );


                ALTER TABLE subjects OWNER TO postgres;

                --
                -- Data for Name: exams; Type: TABLE DATA; Schema: public; Owner: postgres
                --

COPY exams (id, student_id, subject_id, score, itc) FROM stdin;
3       1       1       7       itc_8
4       1       2       6       itc_8
5       1       3       8       itc_8
6       1       4       9       itc_8
7       2       1       9       itc_8
8       2       2       9       itc_8
9       2       3       9       itc_8
10      3       1       9       itc_8
11      3       1       7       itc_7
12      4       4       9       itc_7
13      5       3       9       itc_7
20      7       4       10      itc_1
21      8       1       10      itc_1
22      8       2       10      itc_1
23      6       1       5       itc_8
24      6       2       8       itc_8
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (id, name, itc) FROM stdin;
\.


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY students (id, name) FROM stdin;
1       Nelli
2       Liana
3       Mary
4       Jiro
5       Hasmik
6       Albert
7       Nane
8       Mane
9       Smbat
\.


--
-- Data for Name: subjects; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY subjects (id, title) FROM stdin;
1       c++
2       python
3       bash
4       javascript
\.


--
-- Name: exams exams_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exams
    ADD CONSTRAINT exams_pkey PRIMARY KEY (id);


    --
    -- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
    --

    ALTER TABLE ONLY student
        ADD CONSTRAINT student_pkey PRIMARY KEY (id);


        --
        -- Name: students students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
        --

        ALTER TABLE ONLY students
            ADD CONSTRAINT students_pkey PRIMARY KEY (id);


            --
            -- Name: subjects subjects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
            --

            ALTER TABLE ONLY subjects
                ADD CONSTRAINT subjects_pkey PRIMARY KEY (id);


                --
                -- Name: exams exams_student_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
                --

ALTER TABLE ONLY exams
    ADD CONSTRAINT exams_student_id_fkey FOREIGN KEY (student_id) REFERENCES students(id);


    --
    -- Name: exams exams_subject_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
    --

    ALTER TABLE ONLY exams
        ADD CONSTRAINT exams_subject_id_fkey FOREIGN KEY (subject_id) REFERENCES subjects(id);


        --
        -- PostgreSQL database dump complete
        --

        \connect postgres

        SET default_transaction_read_only = off;

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
        -- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
        --

        COMMENT ON DATABASE postgres IS 'default administrative connection database';


        --
        -- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
        -

        CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

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
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

