
create table a_receber (
cod_a_pagar int not null primary key auto_increment,
descricao varchar (100),
data_recebimento date,
valor decimal (10,2),
observacao varchar(300);
cod_categoria int,
cod_cliente int
);


alter table a_pagar
add constraint fk_receber_categoria foreign key (cod_categoria) references categoria (cod_categoria);
 
alter table a_pagar
add constraint fk_cliente foreign key (cod_cliente) references fornecedores (cod_cliente);