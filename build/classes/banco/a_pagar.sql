
create table a_pagar (
cod_a_pagar int not null primary key auto_increment,
descricao varchar (100),
data_vencimento date,
valor decimal (10,2),
observacao varchar(300);
cod_categoria int,
cod_fornecedor int
);


alter table a_pagar
add constraint fk_pagar_categoria foreign key (cod_categoria) references categoria (cod_categoria);
 
alter table a_pagar
add constraint fk_fornecedor foreign key (cod_fornecedor) references fornecedores (cod_fornecedor);