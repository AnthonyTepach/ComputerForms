DROP DATABASE DB_CFProjets;
CREATE DATABASE  DB_CFProjets;
USE DB_CFProjets;

--CREATE TABLE tb_()engine=innodb;

--
CREATE TABLE tb_cliente(
 cl_rfc CHAR(13) PRIMARY KEY,
 cl_nom VARCHAR(30),
 cl_calle VARCHAR(30),
 cl_numc VARCHAR(20),
 cl_col VARCHAR(30),
 cl_cp int(6),
 cl_mun VARCHAR(30),
 cl_estado VARCHAR(30),
 cl_pais VARCHAR(30),
 cl_numtel CHAR(10) NOT NULL,
 cl_email VARCHAR(40) NOT NULL
)engine=innodb;

INSERT INTO tb_cliente VALUES("TERB960831RI6","BRYAN ANTHONY TEPACH REYES","FIRMAMAMENTO","777","JARDINES DEL BOSQUE",44520,"GUADALAJARA","JALISCO","MÉXICO","5540665453","anthony.tepach@gmail.com");
INSERT INTO `tb_cliente` VALUES ('UAE5702287S5','UNIVERSIDAD AUTÓNOMA DE BAJA CALIFORNIA','AV. PUNTO ÁLVARO OBREGÓN Y JULIÁN CARRILLO','0','NUEVA MEXICALI',21100,'MEXICALI','Baja California','MÉXICO','6865528800','6865528800@GMAIL.COM');
--tabla proyectos
CREATE TABLE tb_proyecto(
	pry_clave CHAR(15) PRIMARY KEY,
	pry_lider varchar(40),
	pry_nombre VARCHAR(45),
	pry_descripcion text,
	pry_fecha_inicio DATE,
	pry_fecha_fin DATE,
	pry_alta DATE,
	pry_tipo ENUM('Propios','Acuerdo','Contrato'),
	cl_rfc CHAR(13),
	FOREIGN KEY (cl_rfc) REFERENCES tb_cliente (cl_rfc)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	pry_entregas_parciales ENUM('Si','No'),
	pry_costo_total int(10),
	pry_volumen_total int (20)
)engine=innodb;

INSERT INTO `tb_proyecto` VALUES ('CG-3AA-18','BERNARDO PÉREZ','BOLETOS SORTEO 84 UABC','BOLETOS SORTEO 84 UABC','2018-10-30','2018-11-27','2018-11-23','Contrato','UAE5702287S5',"No",100000,10000);
--tabla producto terminado
CREATE TABLE tb_producto_terminado(
	pt_codigo CHAR(14) PRIMARY KEY,
	pt_nombre VARCHAR(50),
	pt_fam_iniciales CHAR(3),
	pt_familia CHAR(25)
)engine=innodb;
--VALCADO DE DATOS PRODUCTO TERMINADO
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-001","Billete Tómbola","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-002","Billete de Lotería Instantánea","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-003","Billete Trivia","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-004","Billete 3 en 1","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-005","Billete 2 en 1","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-006","Abre la ventana","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-007","Suajadito","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-008","Win Decoder","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-009","Diamond Coupon","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-010","Planilla Plus","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-IML-011","Planilla Bingo","IML","ImpreLotto");
INSERT INTO tb_producto_terminado VALUES("A002-F-LET-001","Eme","LET","Letterme");
INSERT INTO tb_producto_terminado VALUES("A002-F-LET-002","Sobre NG","LET","Letterme");
INSERT INTO tb_producto_terminado VALUES("A002-F-LET-003","Sobre alto impacto","LET","Letterme");
INSERT INTO tb_producto_terminado VALUES("A002-F-LET-004","Sobre Convencional","LET","Letterme");
INSERT INTO tb_producto_terminado VALUES("A002-F-LET-005","Autosobre","LET","Letterme");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-001","Hologramas de línea Tamper Evidet","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-002","Holograma Personalizado  aleatorio Tamper Evidet","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-003","Hologramas Personalizado  a registro Tamper Evidet","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-004","Mica holográfica de línea transparente","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-005","Mica holográfica de línea Tamper Evidet","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-006","Mica holográfica personalizada aleatoria  Tamper Evident","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-HOL-007","Mica holográfica personalizada a registro  Tamper Evident","HOL"," Hologramas");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-001","Sello de seguridad termoformable","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-002","Sello de seguridad termoformable con holograma","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-003","Etiquetas colgantes","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-004","Etiquetas autoadheribles","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-005","Marbetes","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-PNL-006","Etiquetas de seguridad","PNL","Paching & Label");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-001","Safety Seal evidencia de línea","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-002","Safety Sea evidencia Personalizada","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-003","Safety Tag evidencia de línea","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-004","Safety Tag evidencia Personalizada","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-005","Safety Nip evidencia de línea","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-006","Safety Nip evidencia Personalizada","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-007","Safety Tape evidencia de línea","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-EVS-008","Safety Tape evidencia Personalizada","EVS","Eviden Seal");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-001","Certificados","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-002","Títulos","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-003","Formato de Seguridad","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-004","Licencias","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-005","Recibos","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-006","Vale de transporte","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-007","Vale de gasolina","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-008","Vale de despensa","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-009","Constancia de no Antecedentes Penales","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-010","Boleto de acceso","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-011","Tarjetas de Prepago","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-012","Hojas de Servicio Social","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-013","Actas de Nacimiento con intaglio","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-014","Actas de Nacimiento Interestatales (Verdes)","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-DOC-015","Brazalete","DOC","DOCU");
INSERT INTO tb_producto_terminado VALUES("A002-F-BCD-001","Credencial ","BCD","Beclearid");
INSERT INTO tb_producto_terminado VALUES("A002-F-BCD-002","Gafetes","BCD","Beclearid");
INSERT INTO tb_producto_terminado VALUES("A002-F-BCD-003","Credencial de PVC","BCD","Beclearid");
INSERT INTO tb_producto_terminado VALUES("A002-F-L3D-001","Security Label 3D","L3D","LabeLen 3D");
INSERT INTO tb_producto_terminado VALUES("A002-F-L3D-002","Etiqueta para vaso 3D","L3D","LabeLen 3D");
INSERT INTO tb_producto_terminado VALUES("A002-F-L3D-003","Etiquetas 3D","L3D","LabeLen 3D");
INSERT INTO tb_producto_terminado VALUES("A002-F-L3D-004","Boleto de Acceso 3D","L3D","LabeLen 3D");
INSERT INTO tb_producto_terminado VALUES("A002-F-L3D-005","Vaso Promocional 3D","L3D","LabeLen 3D");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-001","Formato","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-002","Papel Stock","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-003","Vale","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-004","Boleto","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-005","Folleto","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-006","Diptico","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-007","Triptico","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-008","Poster","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-009","Cuadernillo","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-010","Tarjetas de Presentación ","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-011","Volantes","FCO","Formas Comerciales");
INSERT INTO tb_producto_terminado VALUES("A002-F-FCO-012","Carpetas","FCO","Formas Comerciales");


--tabla OrdenProduccion
CREATE TABLE tb_orden_produccion(
	op_num char(9) PRIMARY KEY,
	op_tipo ENUM('Normal','Rush','Reproceso'),
    op_nom_forma text,
	op_fecha_inicio DATE,
	op_fecha_fin DATE,
    op_status ENUM('Finalizado','Produccion','Diseño'),
    op_cotizacion char(10),
    op_descripcion text,
	pt_codigo CHAR(14),
		FOREIGN KEY (pt_codigo) REFERENCES tb_producto_terminado (pt_codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	pry_clave CHAR(15),
		FOREIGN KEY (pry_clave) REFERENCES tb_proyecto (pry_clave) ON DELETE CASCADE ON UPDATE CASCADE
)engine=innodb;

INSERT INTO `tb_orden_produccion` VALUES ('1810-0378','Normal','BOLETO SORTEO MAGNO No. 84','2018-11-01','2018-11-04','Produccion','49394','8 3/16” X 3 ¾”,\n1 TANTO,\nSELECCIÓN COLOR AL FRENTE MÁS 6 TINTAS\nY UNA TINTA AL REVERSO,\nINFORMACIÓN VARIABLE AL FRENTE\n(FOLIOS Y CÓDIGOS DE BARRAS),\nPAPEL CARTULINA SULFATADA 10 PTOS,\n3 PERFORACIONES VERTICALES,\nÁREA DE SCRATCH OFF DE 1” X 1”,\nSOBRE IMPRESIÓN DE SCRATCH A  UNA TINTA,\nBARNIZ UV REGISTRO, ACABADO EN CARTERA ENGRAPADA,\nSE APLICAN BOLETOS (10,5,4 0 3)  POR CARTERA. ','A002-F-IML-004','CG-3AA-18'),('1810-0401','Normal','BOLETO COLABORADORES','2018-11-01','2018-11-04','Produccion','49394','8 ½” X 3 ¾”,\n1 TANTO,\n1 TINTA AL FRENTE Y UNA AL REVERSO,\n2 FOLIOS ARÁBIGOS,\nPAPEL BOND 90 GRS,\nACABADO EN BLOCKS ENGOMADOS','A002-F-IML-004','CG-3AA-18'),('1810-0402','Normal','TAPA','2018-11-01','2018-11-04','Produccion','49394','8 3/16” X 3 ¾”,\n1 TANTO,\nSELECCIÓN COLOR AL FRENTE,\nUNA TINTA AL REVERSO,\n1 FOLIO ARÁBIGO,\nPAPEL CARTULINA SULFATADA DE 10 PTOS,\nACABADO EN CARTERA ENGRAPADA,\nSE APLICA 1 POR CADA CARTERA','A002-F-IML-004','CG-3AA-18');
drop table  tb_usuario;
CREATE TABLE tb_usuario(
	us_uidd char(36) PRIMARY KEY,
	us_nombre varchar(20),
	us_passw varchar(20),
	us_rol varchar(20)
)engine=innodb;

INSERT INTO tb_usuario VALUES("669dd6ab-3b27-40a2-9dcb-49ddf281fbf3","GuadalupeSepulveda","123","Proyectos");
INSERT INTO tb_usuario VALUES("379bf06a-91c5-4bd0-8cf1-734e9a3f39a8","Adrian","123","Diseño");
INSERT INTO tb_usuario VALUES("acfbdcbc-7dea-46b1-8bb3-898bba0f5077","CesarCarrillo","123","Produccion");
INSERT INTO tb_usuario VALUES("2d0dbfc1-b84d-4272-8793-551fc87ba1ed","Cecilia","123","Almacen");
INSERT INTO tb_usuario VALUES("TERB960831HMCPYR02","TEPACH","123","Admin");

