[![Build Status](https://travis-ci.org/gscharlau/cooperados-api.svg?branch=master)](https://travis-ci.org/gscharlau/cooperados-api)

# COOPERADOS-API
Serviço externo desenvolvido com o objetivo de verificar se o Cooperado possuí permissão de votar em determinada Assembléia. Este serviço foi hospedado no Heroku, afim de realizar a integração com a Tarefa principal, conforme o exemplo (GET): `https://cooperados-api.herokuapp.com/users/07262076167`

CPFs habilitados para a votação (CPF verificado no serviço hospedado na nuvem):
```
  07262076167 : Cooperado 001
  51066194165 : Cooperado 002
  95746638501 : Cooperado 003
  23302747772 : Cooperado 004
  24481361573 : Cooperado 005
  99131576257 : Cooperado 006
  11775765890 : Cooperado 007
  35573415778 : Cooperado 008
  51343483409 : Cooperado 009
  41449059422 : Cooperado 010
  ```
  
  Assim como o projeto principal, este também se encontra integrado com o TravisCI afim de verificar o build após cada commit no repositório.
