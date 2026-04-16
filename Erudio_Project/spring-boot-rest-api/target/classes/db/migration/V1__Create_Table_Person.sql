CREATE TABLE public.clientes (
    id integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    idade integer
);


--
-- TOC entry 219 (class 1259 OID 16397)
-- Name: clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3446 (class 0 OID 0)
-- Dependencies: 219
-- Name: clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;


--
-- TOC entry 3289 (class 2604 OID 16401)
-- Name: clientes id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);


--
-- TOC entry 3440 (class 0 OID 16398)
-- Dependencies: 220
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.clientes (id, nome, email, idade) FROM stdin;
\.


--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 219
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.clientes_id_seq', 1, false);


--
-- TOC entry 3291 (class 2606 OID 16404)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


-- Completed on 2026-04-16 00:20:46 UTC

--
-- PostgreSQL database dump complete
--

\unrestrict IBWnzQPuF8qouC97h1ahQOFoCd3XcI6mjyJ4u5WtoIn8kcDC1tabh0UXtYbC8Vf

