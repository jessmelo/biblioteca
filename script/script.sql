Criação do banco:

CREATE DATABASE biblioteca
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default

Criação de tabelas:

CREATE TABLE PUBLICACAO (
	Titulo varchar(50) NOT NULL,
	Tipo_publicacao(50) NOT NULL;
	NumFolder int NOT NULL,
	Digital boolean NOT NULL,
	Armario varchar(15),
	CONSTRAINT Pk_publi 
PRIMARY KEY(Titulo)
);

CREATE TABLE LIVRO (
	Titulo varchar(50) NOT NULL,
	Titulo_original varchar(50),
	Tipo_livro varchar(18) NOT NULL CHECK (Tipo_livro in (‘CAP’, ‘ART’)),
	NumPaginas int,
	NumEdicao int NOT NULL,
	Editora varchar(20) NOT NULL,
	Ano_publicacao int NOT NULL CHECK (Ano_publicacao  BETWEEN 1900 AND 2019),
	CONSTRAINT Pk_livro 
PRIMARY KEY (Titulo, Tipo_livro),
	CONSTRAINT Fk_publi_livro 
FOREIGN KEY (Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE FORMADO_POR (
	TituloCompilacao varchar(50) NOT NULL,
	TituloArtigo varchar(50) NOT NULL,
	CONSTRAINT Pk_formado_por 
		PRIMARY KEY(TituloCompilacao, TituloArtigo)
);	

CREATE TABLE LIVRO_DE_CAPITULO (
	Titulo varchar(50) NOT NULL,
	Tipo_livro varchar(18) NOT NULL CHECK (Tipo_livro in (‘CAP’, ‘ART’)),
	Autor varchar(20) NOT NULL,
	CONSTRAINT Pk_livro_cap 
PRIMARY KEY (Titulo),
	CONSTRAINT Fk_livro_cap 
FOREIGN KEY (Titulo, Tipo_livro) REFERENCES LIVRO(Titulo, Tipo_livro)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE LIVRO_DE_ARTIGO (
	Titulo varchar(50) NOT NULL,
	Tipo_livro varchar(18) NOT NULL CHECK (Tipo_livro in (‘CAP’, ‘ART’)),
	Editor varchar(20) NOT NULL,
	CONSTRAINT Pk_livro_art 
PRIMARY KEY (Titulo),
	CONSTRAINT Fk_livro_art 
FOREIGN KEY (Titulo, Tipo_livro) REFERENCES LIVRO(Titulo, Tipo_livro)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE EDITOR (
	Nome_editor varchar(20) NOT NULL,
	Titulo_livro varchar(50) NOT NULL,
	CONSTRAINT Pk_editor 
PRIMARY KEY(Nome_editor),
	CONSTRAINT Fk_livro_art_editor 
FOREIGN KEY(Titulo_livro) REFERENCES LIVRO_DE_ARTIGO(Titulo)
			ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE AUTOR (
	Nome_autor varchar(20) NOT NULL,
	Titulo_livro varchar(50) NOT NULL,
	CONSTRAINT Pk_autor 
PRIMARY KEY(Nome_autor)
);

CREATE TABLE ARTIGO (
	Titulo_artigo varchar(50) NOT NULL,
	CONSTRAINT Pk_artigo 
PRIMARY KEY(Titulo_artigo),
	CONSTRAINT Fk_art_publi 
FOREIGN KEY(Titulo_artigo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_LIVRO (
	Titulo_artigo varchar(50) NOT NULL,
	Titulo_de_livro varchar(50) NOT NULL,
	Titulo_original varchar(50),
	Edicao int NOT NULL,
	NumCapitulo int NOT NULL,
	Ano_publicacao int NOT NULL,
	CONSTRAINT Pk_art_livro 
PRIMARY KEY(Titulo_artigo),
CONSTRAINT Pk_art_livro_publi
	FOREIGN KEY(Titulo_artigo) REFERENCES PUBLICACAO(Titulo)
		ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT Fk_art_livro
	FOREIGN KEY(Titulo_de_livro) REFERENCES LIVRO_DE_ARTIGO(Titulo)
		ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE PERIODICO (
	Titulo varchar(50) NOT NULL,
PrimeiroVolume varchar(10) NOT NULL,
	UltimoVolume varchar(10),
	Editora varchar(20),
	CONSTRAINT Pk_periodico 
PRIMARY KEY(Titulo),
CONSTRAINT Fk_periodico_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MONOGRAFIA (
	Titulo varchar(50) NOT NULL,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1900 AND 2019),
	Mes varchar(3) NOT NULL CHECK (Mes in (‘Jan’, ‘Fev’, ‘Mar’, ‘Abr’, ‘Mai’, ‘Jun’, ‘Jul’, ‘Ago’, ‘Set’, ‘Out’, ‘Nov’, ‘Dez’)),
	Local varchar(30) NOT NULL,
	Autor varchar(20) NOT NULL, 
	Instituicao varchar(20) NOT NULL,
	Codigo varchar(5) NOT NULL,
	CONSTRAINT Pk_mono
		PRIMARY KEY(Titulo),
CONSTRAINT Fk_mono_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
)
	
CREATE TABLE LIVRO_DE_ANAIS (
	Titulo varchar(50) NOT NULL,
	Editora varchar(20),
	Cidade varchar(30) NOT NULL,
	Estado varchar(2) NOT NULL,
	Pais varchar(30),
	Volume int NOT NULL,
	CONSTRAINT Pk_livro_de_anais
		PRIMARY KEY(Titulo),	
CONSTRAINT Fk_livro_anais_publi
FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_ANAIS (
	Titulo varchar(50) NOT NULL,
	TituloCongresso varchar(50) NOT NULL,
	Numero int NOT NULL,
	Volume int NOT NULL,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1900 AND 2019),
	Mes varchar(3) NOT NULL CHECK (Mes in (‘Jan’, ‘Fev’, ‘Mar’, ‘Abr’, ‘Mai’, ‘Jun’, ‘Jul’, ‘Ago’, ‘Set’, ‘Out’, ‘Nov’, ‘Dez’)),
	CONSTRAINT Pk_art_anais
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_art_anais_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_PERIODICOS (
	Titulo varchar(50) NOT NULL,
	TituloPeriodico varchar(50) NOT NULL,
	NumVolume int NOT NULL,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1900 AND 2019),
	Mes varchar(3) NOT NULL CHECK (Mes in (‘Jan’, ‘Fev’, ‘Mar’, ‘Abr’, ‘Mai’, ‘Jun’, ‘Jul’, ‘Ago’, ‘Set’, ‘Out’, ‘Nov’, ‘Dez’)),
	CONSTRAINT Pk_art_periodico
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_art_perio_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);
	
ALTER TABLE LIVRO_DE_CAPITULO
ADD CONSTRAINT Fk_livro_autor
	FOREIGN KEY(Autor) REFERENCES AUTOR(Nome_autor)
		ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE LIVRO_DE_ARTIGO
ADD CONSTRAINT Fk_livro_editor 
	FOREIGN KEY(Editor) REFERENCES EDITOR(Nome_editor)
		ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE FORMADO_POR
ADD CONSTRAINT Fk_livro_de_artigos
	FOREIGN KEY(TituloCompilacao) REFERENCES LIVRO_DE_ARTIGO(Titulo);

ALTER TABLE FORMADO_POR
ADD CONSTRAINT Fk_anais
	FOREIGN KEY(TituloCompilacao) REFERENCES LIVRO_DE_ANAIS(Titulo)
		ON DELETE SET NULL ON UPDATE CASCADE;
		
ALTER TABLE FORMADO_POR
ADD CONSTRAINT Fk_congresso_art
	FOREIGN KEY(TituloArtigo) REFERENCES ARTIGO_DE_ANAIS(Titulo)
		ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE FORMADO_POR
ADD CONSTRAINT Fk_periodico
	FOREIGN KEY(TituloCompilacao) REFERENCES PERIODICO(Titulo)
		ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE FORMADO_POR
ADD CONSTRAINT Fk_art_periodico
	FOREIGN KEY(TituloArtigo) REFERENCES ARTIGO_DE_PERIODICOS(Titulo)
		ON DELETE SET NULL ON UPDATE CASCADE;

