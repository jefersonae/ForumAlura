CREATE TABLE users(
    id TEXT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    perfis TEXT NOT NULL
);
CREATE TABLE topics(
    id TEXT PRIMARY KEY NOT NULL,
    titulo TEXT NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao TEXT NOT NULL,
    status TEXT NOT NULL,
    autor TEXT NOT NULL,
    curso TEXT NOT NULL,
    respostas TEXT NOT NULL
);
CREATE TABLE responses(
    id TEXT PRIMARY KEY NOT NULL,
    mensagem TEXT NOT NULL,
    topico TEXT NOT NULL,
    dataCriacao TEXT NOT NULL,
    autor TEXT NOT NULL,
    solucao TEXT NOT NULL
);
CREATE TABLE courses(
    id TEXT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    categoria TEXT NOT NULL
);
CREATE TABLE perfils(
    id TEXT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL
);