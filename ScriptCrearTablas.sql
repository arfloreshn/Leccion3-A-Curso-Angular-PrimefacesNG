CREATE TYPE public.sexo AS ENUM (
    'MASCULINO',
    'FEMENINO'
);

--
-- Name: actores; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.actores (
    idactor smallint NOT NULL,
    nombre character varying(60),
    fecha_nacimiento date,
    salario numeric(18,2),
    sexo public.sexo,
    sn_activo bit(1),
    sn_gano_oscar "char",
    fec_muerte date
);


--
-- Name: actores_idactor_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.actores_idactor_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: actores_idactor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.actores_idactor_seq OWNED BY public.actores.idactor;


--
-- Name: actores_interpretacion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.actores_interpretacion (
    idinterpretacion smallint NOT NULL,
    idactor smallint,
    idpelicula smallint,
    sn_reparto bit(1),
    sn_protagonista bit(1)
);


--
-- Name: actores_interpretacion_idinterpretacion_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.actores_interpretacion_idinterpretacion_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: actores_interpretacion_idinterpretacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.actores_interpretacion_idinterpretacion_seq OWNED BY public.actores_interpretacion.idinterpretacion;


--
-- Name: cafeteria; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.cafeteria (
    idcafeteria smallint NOT NULL,
    descripcion character varying,
    idsucusal smallint
);


--
-- Name: cafeteria_idcafeteria_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.cafeteria_idcafeteria_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: cafeteria_idcafeteria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.cafeteria_idcafeteria_seq OWNED BY public.cafeteria.idcafeteria;


--
-- Name: canal_venta; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.canal_venta (
    idcanal smallint NOT NULL,
    descripcion character varying(50)
);


--
-- Name: departamentos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.departamentos (
    departamentoid smallint NOT NULL,
    descripcion character varying(50),
    nro_habitantes smallint,
    paisid smallint
);


--
-- Name: departamento_departamentoid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.departamento_departamentoid_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: departamento_departamentoid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.departamento_departamentoid_seq OWNED BY public.departamentos.departamentoid;


--
-- Name: empleados; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.empleados (
    idresponsable smallint NOT NULL,
    idsucursal smallint,
    idsociedad smallint,
    idempleado smallint NOT NULL,
    nombre character varying(50),
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    fecha_nacimiento date,
    fecha_alta date,
    fecha_baja date,
    sexo "char",
    estado_civil "char",
    salario numeric(18,2)
);


--
-- Name: empleados_idempleado_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.empleados_idempleado_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: empleados_idempleado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.empleados_idempleado_seq OWNED BY public.empleados.idempleado;


--
-- Name: empleados_idresponsable_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.empleados_idresponsable_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: empleados_idresponsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.empleados_idresponsable_seq OWNED BY public.empleados.idresponsable;


--
-- Name: factura_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.factura_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;


--
-- Name: facturas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.facturas (
    idfactura smallint DEFAULT nextval('public.factura_seq'::regclass) NOT NULL,
    nro_fila smallint,
    nro_butaca smallint,
    idsala smallint,
    idpelicula smallint,
    idfuncion smallint,
    idprecio smallint,
    importe_boleto numeric(18,2),
    importe_descuento numeric(18,2),
    importe_pagado numeric(18,2),
    idcanal_vta smallint,
    sn_preciooferta bit(1),
    idoferta smallint,
    fecha_venta date,
    fecha_anulacion date NOT NULL,
    idmotivoanulacion smallint,
    idusuario smallint
);


--
-- Name: facturas_pagos_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.facturas_pagos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999
    CACHE 1;


--
-- Name: facturas_pagos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.facturas_pagos (
    idpago smallint DEFAULT nextval('public.facturas_pagos_seq'::regclass) NOT NULL,
    idfactura smallint,
    idformapago smallint,
    importe_venta numeric(18,2),
    importe_pagado numeric(18,2),
    importe_cambio numeric(18,2),
    idmonedapago smallint,
    importe_divisa numeric(18,2)
);


--
-- Name: formas_pago; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.formas_pago (
    idformapago smallint NOT NULL,
    descripcion character varying(50)
);


--
-- Name: funciones; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.funciones (
    idfuncion smallint NOT NULL,
    horario character varying(80)
);


--
-- Name: inventario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.inventario (
    idproducto smallint NOT NULL,
    codbarra character varying(20),
    descripcion character varying(80),
    existencia numeric(18,2),
    costo_unitario numeric(18,2),
    precio_venta numeric(18,4)
);


--
-- Name: inventario_doc; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.inventario_doc (
    idmotivo smallint NOT NULL,
    descripcion character varying(50)
);


--
-- Name: inventario_idproducto_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.inventario_idproducto_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: inventario_idproducto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.inventario_idproducto_seq OWNED BY public.inventario.idproducto;


--
-- Name: medio_proyeccion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.medio_proyeccion (
    idmedio smallint NOT NULL,
    descripcion character varying(50)
);


--
-- Name: medio_proyeccion_idmedio_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.medio_proyeccion_idmedio_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: medio_proyeccion_idmedio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.medio_proyeccion_idmedio_seq OWNED BY public.medio_proyeccion.idmedio;


--
-- Name: motivos_cortesia; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.motivos_cortesia (
    idmotivo smallint NOT NULL,
    descripcion character varying(50)
);


--
-- Name: motivos_cortesia_idmotivo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.motivos_cortesia_idmotivo_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: motivos_cortesia_idmotivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.motivos_cortesia_idmotivo_seq OWNED BY public.motivos_cortesia.idmotivo;


--
-- Name: motivos_inventario_idmotivo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.motivos_inventario_idmotivo_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: motivos_inventario_idmotivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.motivos_inventario_idmotivo_seq OWNED BY public.inventario_doc.idmotivo;


--
-- Name: paises; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.paises (
    paisid smallint NOT NULL,
    nom_pais character varying(150),
    idcontinente smallint,
    fec_creacion date,
    sn_monarquia "char"
);


--
-- Name: paises_paisID_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public."paises_paisID_seq"
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: paises_paisID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public."paises_paisID_seq" OWNED BY public.paises.paisid;


--
-- Name: pase_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.pase_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999999
    CACHE 1;


--
-- Name: pases; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.pases (
    idpases smallint DEFAULT nextval('public.pase_seq'::regclass) NOT NULL,
    nro_fila smallint,
    nro_butaca smallint,
    idsala smallint,
    idpelicula smallint,
    idfuncion smallint,
    fec_vig_desde date,
    fec_vig_hasta date,
    idmotivo smallint
);


--
-- Name: peliculas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.peliculas (
    idpelicula smallint NOT NULL,
    idcategoria smallint,
    nombre_pelicula character varying,
    duracion numeric(6,2),
    fec_caduciadad date,
    fec_estreno date,
    idmedio smallint
);


--
-- Name: peliculas_actores_idpelicula_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.peliculas_actores_idpelicula_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: peliculas_actores_idpelicula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.peliculas_actores_idpelicula_seq OWNED BY public.peliculas.idpelicula;


--
-- Name: peliculas_categorias; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.peliculas_categorias (
    idcategoria smallint NOT NULL,
    descripcion character varying
);


--
-- Name: precios_vta; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.precios_vta (
    idprecio smallint NOT NULL,
    descripcion character varying,
    precio_venta numeric(18,2)
);


--
-- Name: promociones; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.promociones (
    idpromocion smallint NOT NULL,
    descripcion character varying(80),
    importe_venta numeric(18,2),
    dia smallint,
    sn_activa bit(1)
);


--
-- Name: promociones_idpromocion_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.promociones_idpromocion_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: promociones_idpromocion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.promociones_idpromocion_seq OWNED BY public.promociones.idpromocion;


--
-- Name: proyectores; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.proyectores (
    idproyector smallint NOT NULL,
    descripcion character varying,
    limite_horas numeric(8,2),
    horas_consumidas numeric(8,2),
    punto_retorno numeric(8,2),
    fec_alta date,
    fec_baja date,
    idmotivo smallint
);


--
-- Name: proyectores_idproyector_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.proyectores_idproyector_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: proyectores_idproyector_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.proyectores_idproyector_seq OWNED BY public.proyectores.idproyector;


--
-- Name: residentes_pago_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.residentes_pago_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999
    CACHE 1;


--
-- Name: salas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.salas (
    idsala smallint NOT NULL,
    nombre_sala character varying(50),
    nro_butacas smallint,
    idreposable smallint,
    fecultmantenimiento date,
    sn_disponible bit(1),
    idsucursal smallint
);


--
-- Name: salas_idsala_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.salas_idsala_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: salas_idsala_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.salas_idsala_seq OWNED BY public.salas.idsala;


--
-- Name: salas_inventario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.salas_inventario (
    idproducto smallint NOT NULL,
    idsala smallint,
    descripcion character varying,
    cantidad smallint,
    costo_neto numeric(18,2),
    sn_activo smallint,
    sn_depreciado smallint,
    codbarra character varying(20)
);


--
-- Name: salas_inventario_idproducto_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.salas_inventario_idproducto_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: salas_inventario_idproducto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.salas_inventario_idproducto_seq OWNED BY public.salas_inventario.idproducto;


--
-- Name: salas_peliculas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.salas_peliculas (
    idrow smallint NOT NULL,
    idsala smallint,
    idpelicula smallint,
    idfuncion smallint
);


--
-- Name: salas_peliculas_idrow_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.salas_peliculas_idrow_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: salas_peliculas_idrow_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.salas_peliculas_idrow_seq OWNED BY public.salas_peliculas.idrow;


--
-- Name: salas_precio_idprecio_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.salas_precio_idprecio_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: salas_precio_idprecio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.salas_precio_idprecio_seq OWNED BY public.precios_vta.idprecio;


--
-- Name: salas_proyector; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.salas_proyector (
    idsalaproyector smallint NOT NULL,
    idproyector smallint,
    idpelicula smallint,
    idanuncios smallint,
    idsala smallint
);


--
-- Name: sociedad; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.sociedad (
    idsociedad smallint NOT NULL,
    descripcion character varying(50),
    idpais smallint
);


--
-- Name: sociedad_idsociedad_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.sociedad_idsociedad_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: sociedad_idsociedad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.sociedad_idsociedad_seq OWNED BY public.sociedad.idsociedad;


--
-- Name: sucursal; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.sucursal (
    idsucursal smallint NOT NULL,
    descripcion character varying(50),
    idpais smallint,
    idsociedad smallint
);


--
-- Name: sucursal_idsucursal_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.sucursal_idsucursal_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: sucursal_idsucursal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.sucursal_idsucursal_seq OWNED BY public.sucursal.idsucursal;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuario (
    usuarioid smallint NOT NULL,
    nombre character varying(50),
    clave character varying(20),
    correo character varying(50),
    apodo character varying(20),
    sn_activo bit(1),
    fec_alta date,
    idresponsable smallint
);


--
-- Name: usuario_usuarioID_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public."usuario_usuarioID_seq"
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: usuario_usuarioID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public."usuario_usuarioID_seq" OWNED BY public.usuario.usuarioid;


--
-- Name: actores idactor; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.actores ALTER COLUMN idactor SET DEFAULT nextval('public.actores_idactor_seq'::regclass);


--
-- Name: actores_interpretacion idinterpretacion; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.actores_interpretacion ALTER COLUMN idinterpretacion SET DEFAULT nextval('public.actores_interpretacion_idinterpretacion_seq'::regclass);


--
-- Name: cafeteria idcafeteria; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cafeteria ALTER COLUMN idcafeteria SET DEFAULT nextval('public.cafeteria_idcafeteria_seq'::regclass);


--
-- Name: departamentos departamentoid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.departamentos ALTER COLUMN departamentoid SET DEFAULT nextval('public.departamento_departamentoid_seq'::regclass);


--
-- Name: empleados idresponsable; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.empleados ALTER COLUMN idresponsable SET DEFAULT nextval('public.empleados_idresponsable_seq'::regclass);


--
-- Name: empleados idempleado; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.empleados ALTER COLUMN idempleado SET DEFAULT nextval('public.empleados_idempleado_seq'::regclass);


--
-- Name: inventario idproducto; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.inventario ALTER COLUMN idproducto SET DEFAULT nextval('public.inventario_idproducto_seq'::regclass);


--
-- Name: inventario_doc idmotivo; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.inventario_doc ALTER COLUMN idmotivo SET DEFAULT nextval('public.motivos_inventario_idmotivo_seq'::regclass);


--
-- Name: medio_proyeccion idmedio; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medio_proyeccion ALTER COLUMN idmedio SET DEFAULT nextval('public.medio_proyeccion_idmedio_seq'::regclass);


--
-- Name: motivos_cortesia idmotivo; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.motivos_cortesia ALTER COLUMN idmotivo SET DEFAULT nextval('public.motivos_cortesia_idmotivo_seq'::regclass);


--
-- Name: paises paisid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.paises ALTER COLUMN paisid SET DEFAULT nextval('public."paises_paisID_seq"'::regclass);


--
-- Name: peliculas idpelicula; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.peliculas ALTER COLUMN idpelicula SET DEFAULT nextval('public.peliculas_actores_idpelicula_seq'::regclass);


--
-- Name: precios_vta idprecio; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.precios_vta ALTER COLUMN idprecio SET DEFAULT nextval('public.salas_precio_idprecio_seq'::regclass);


--
-- Name: promociones idpromocion; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.promociones ALTER COLUMN idpromocion SET DEFAULT nextval('public.promociones_idpromocion_seq'::regclass);


--
-- Name: proyectores idproyector; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.proyectores ALTER COLUMN idproyector SET DEFAULT nextval('public.proyectores_idproyector_seq'::regclass);


--
-- Name: salas idsala; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.salas ALTER COLUMN idsala SET DEFAULT nextval('public.salas_idsala_seq'::regclass);


--
-- Name: salas_inventario idproducto; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.salas_inventario ALTER COLUMN idproducto SET DEFAULT nextval('public.salas_inventario_idproducto_seq'::regclass);


--
-- Name: salas_peliculas idrow; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.salas_peliculas ALTER COLUMN idrow SET DEFAULT nextval('public.salas_peliculas_idrow_seq'::regclass);


--
-- Name: sociedad idsociedad; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sociedad ALTER COLUMN idsociedad SET DEFAULT nextval('public.sociedad_idsociedad_seq'::regclass);


--
-- Name: sucursal idsucursal; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sucursal ALTER COLUMN idsucursal SET DEFAULT nextval('public.sucursal_idsucursal_seq'::regclass);

--
-- Name: usuario usuarioid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario ALTER COLUMN usuarioid SET DEFAULT nextval('public."usuario_usuarioID_seq"'::regclass);

