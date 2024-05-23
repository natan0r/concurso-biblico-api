CREATE TABLE PESSOA(
	ID_PESSOA INTEGER PRIMARY KEY AUTO_INCREMENT,
	DATA_NASCIMENTO DATE,
	CPF VARCHAR(11),
	SEXO CHAR(1)
);

CREATE TABLE IGREJA(
	ID_IGREJA INTEGER PRIMARY KEY AUTO_INVREMENT,
	NOME_IGREJA VARCHAR(100)
);

CREATE TABLE CONCURSO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	CONSTRAINT ID_IGREJA FOREIGN KEY (ID_IGREJA) REFERENCES IGREJA (ID_IGREJA),
);

CREATE TABLE COMPETIDOR(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	CONSTRAINT ID_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES PESSOA (ID_PESSOA),
	CONSTRAINT ID_IGREJA FOREIGN KEY (ID_IGREJA) REFERENCES IGREJA (ID_IGREJA),
	CONSTRAINT ID_CONCURSO FOREIGN KEY (ID_CONCURSO) REFERENCES CONCURSO (ID),
	ID_MANUAL INTEGER AUTO_INCREMENT
);

CREATE TABLE PONTUACAO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	CONSTRAINT ID_COMPETIDOR FOREIGN KEY (ID_COMPETIDOR) REFERENCES COMPETIDOR (ID),
	PONTOS INTEGER
);