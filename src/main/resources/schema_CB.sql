CREATE TABLE PESSOA(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	DATA_NASCIMENTO DATE NOT NULL,
	CPF VARCHAR(11) NOT NULL,
	SEXO CHAR(1) NOT NULL
);

CREATE TABLE IGREJA(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL
);

CREATE TABLE CONCURSO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	IGREJA_ID INTEGER NOT NULL,
	FOREIGN KEY (IGREJA_ID) REFERENCES IGREJA (ID),
	DATA DATE NOT NULL
);

CREATE TABLE COMPETIDOR(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	PESSOA_ID INTEGER NOT NULL,
	IGREJA_ID INTEGER NOT NULL,
	CONCURSO_ID INTEGER NOT NULL,
	FOREIGN KEY (PESSOA_ID) REFERENCES PESSOA (ID),
	FOREIGN KEY (IGREJA_ID) REFERENCES IGREJA (ID),
	FOREIGN KEY (CONCURSO_ID) REFERENCES CONCURSO (ID),
	MANUAL_ID INTEGER
);

CREATE TABLE PONTUACAO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	COMPETIDOR_ID INTEGER NOT NULL
	FOREIGN KEY (COMPETIDOR_ID) REFERENCES COMPETIDOR (ID),
	PONTOS INTEGER NOT NULL
);