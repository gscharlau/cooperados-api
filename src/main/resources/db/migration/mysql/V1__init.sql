-- Criação de Tabela de Cooperados --
CREATE TABLE public.cooperado (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
	cpf varchar(15) NOT NULL,
	nome varchar(100) NOT NULL
);


-- Carga Inicial --
INSERT INTO public.cooperado (cpf, nome) VALUES ('07262076167', 'Cooperado 001');
INSERT INTO public.cooperado (cpf, nome) VALUES ('51066194165', 'Cooperado 002');
INSERT INTO public.cooperado (cpf, nome) VALUES ('95746638501', 'Cooperado 003');
INSERT INTO public.cooperado (cpf, nome) VALUES ('23302747772', 'Cooperado 004');
INSERT INTO public.cooperado (cpf, nome) VALUES ('24481361573', 'Cooperado 005');
INSERT INTO public.cooperado (cpf, nome) VALUES ('99131576257', 'Cooperado 006');
INSERT INTO public.cooperado (cpf, nome) VALUES ('11775765890', 'Cooperado 007');
INSERT INTO public.cooperado (cpf, nome) VALUES ('35573415778', 'Cooperado 008');
INSERT INTO public.cooperado (cpf, nome) VALUES ('51343483409', 'Cooperado 009');
INSERT INTO public.cooperado (cpf, nome) VALUES ('41449059422', 'Cooperado 010');