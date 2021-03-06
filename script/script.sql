CREATE TABLE PUBLICACAO (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	Tipo_publicacao varchar(50) NOT NULL,
	NumFolder int NOT NULL,
	Digital boolean NOT NULL,
	Armario varchar(15),
	Local varchar(50),
	CONSTRAINT Pk_publi 
		PRIMARY KEY(Titulo)
);

CREATE TABLE FORMADO_POR (
	TituloCompilacao varchar(250) NOT NULL,
	TituloArtigo varchar(250) NOT NULL,
	CONSTRAINT Pk_formado_por 
		PRIMARY KEY(TituloCompilacao, TituloArtigo)
);	

CREATE TABLE LIVRO (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	Tipo_livro varchar(50) CHECK (Tipo_livro in ('LIVROCAP', 'LIVROART')),
	Autor varchar(250) NOT NULL,
	NumPaginas int,
	NumEdicao int NOT NULL,
	Editora varchar(50) NOT NULL,
	Ano_publicacao int NOT NULL CHECK (Ano_publicacao  BETWEEN 1800 AND 2019),
	CONSTRAINT Pk_livro 
		PRIMARY KEY (Titulo)
);

CREATE TABLE AUTOR (
	Nome_autor varchar(50) NOT NULL,
	CONSTRAINT Pk_autor 
		PRIMARY KEY(Nome_autor)
);

CREATE TABLE AUTOR_LIVROS (
	Nome_autor varchar(50) NOT NULL,
	Titulo_livro varchar(250) NOT NULL,
	CONSTRAINT Pk_autor_livros 
		PRIMARY KEY(Nome_autor, Titulo_livro),
	CONSTRAINT Fk_autor_livro 
		FOREIGN KEY(Nome_autor) REFERENCES AUTOR(Nome_autor)
			ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT Fk_livro_autor 
		FOREIGN KEY(Titulo_livro) REFERENCES LIVRO(Titulo)
			ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_LIVRO (
	Titulo_artigo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	Titulo_do_livro varchar(250) NOT NULL,
	Titulo_original varchar(250),
	Edicao int NOT NULL,
	NumCapitulo int NOT NULL,
	Ano_publicacao int NOT NULL,
	CONSTRAINT Pk_art_livro 
		PRIMARY KEY(Titulo_artigo),
	CONSTRAINT Pk_art_livro_publi
		FOREIGN KEY(Titulo_artigo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT Fk_art_livro
		FOREIGN KEY(Titulo_do_livro) REFERENCES LIVRO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE PERIODICO (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	PrimeiroVolume varchar(10) NOT NULL,
	UltimoVolume varchar(10),
	Editora varchar(50),
	CONSTRAINT Pk_periodico 
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_periodico_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MONOGRAFIA (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1800 AND 2019),
	Mes varchar(10) NOT NULL,
	Local varchar(50) NOT NULL,
	Autor varchar(250) NOT NULL, 
	Instituicao varchar(20) NOT NULL,
	Codigo varchar(5) NOT NULL,
	CONSTRAINT Pk_mono
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_mono_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
);
	
CREATE TABLE LIVRO_DE_ANAIS (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	Editora varchar(50),
	Cidade varchar(50) NOT NULL,
	Estado varchar(50) NOT NULL,
	Pais varchar(50),
	Volume int NOT NULL,
	CONSTRAINT Pk_livro_de_anais
		PRIMARY KEY(Titulo),	
	CONSTRAINT Fk_livro_anais_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_ANAIS (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	TituloCongresso varchar(50) NOT NULL,
	Numero int NOT NULL,
	Volume int NOT NULL,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1800 AND 2019),
	Mes varchar(10) NOT NULL,
	CONSTRAINT Pk_art_anais
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_art_anais_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ARTIGO_DE_PERIODICOS (
	Titulo varchar(250) NOT NULL,
	Publi_id int GENERATED BY DEFAULT AS IDENTITY,
	TituloPeriodico varchar(50) NOT NULL,
	NumVolume int NOT NULL,
	Ano int  NOT NULL CHECK (Ano BETWEEN 1800 AND 2019),
	Mes varchar(10) NOT NULL,
	CONSTRAINT Pk_art_periodico
		PRIMARY KEY(Titulo),
	CONSTRAINT Fk_art_perio_publi
		FOREIGN KEY(Titulo) REFERENCES PUBLICACAO(Titulo)
			ON DELETE CASCADE ON UPDATE CASCADE
);
	
ALTER TABLE LIVRO
ADD CONSTRAINT Fk_livro_autor 
	FOREIGN KEY(Autor) REFERENCES Autor(Nome_autor)
		ON DELETE SET NULL ON UPDATE CASCADE;

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

ALTER TABLE PUBLICACAO
ADD CONSTRAINT publi_id UNIQUE(PUBLI_ID);

ALTER TABLE LIVRO_DE_ANAIS
ADD CONSTRAINT Fk_livro_anais_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);

ALTER TABLE MONOGRAFIA
ADD CONSTRAINT Fk_monografia_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);

ALTER TABLE PERIODICO
ADD CONSTRAINT FK_periodico_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);

ALTER TABLE ARTIGO_DE_ANAIS
ADD CONSTRAINT Fk_art_anais_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);

ALTER TABLE ARTIGO_DE_LIVRO
ADD CONSTRAINT Fk_art_livro_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);

ALTER TABLE ARTIGO_DE_PERIODICOS
ADD CONSTRAINT Fk_art_per_id 
	FOREIGN KEY(publi_id) REFERENCES PUBLICACAO(PUBLI_ID);
