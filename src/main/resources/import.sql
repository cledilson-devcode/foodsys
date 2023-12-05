INSERT INTO cozinha (id,nome) values (1, 'Tailandesa')
INSERT INTO cozinha (id,nome) values (2, 'Indiana')
INSERT INTO cozinha (id,nome) values (3, 'Japonesa')

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Thai Gourmet', 10, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Thai Delivey', 9.5, 3);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('TukTuk Comida Indiana', 15, 2);

INSERT INTO forma_pagamento (id,descricao) values (1, 'Pix')
INSERT INTO forma_pagamento (id,descricao) values (2, 'Dinheiro')
INSERT INTO forma_pagamento (id,descricao) values (3, 'Cartão')

INSERT INTO permissao (id,nome, descricao) values (1, 'Estagiario', 'Tem acesso a somente inserir e listar')
INSERT INTO permissao (id,nome, descricao) values (2, 'Operador', 'Tem acesso a inserir, atualizar e listar')
INSERT INTO permissao (id,nome, descricao) values (3, 'Supervisor', 'Tem acesso a todas as funções')

INSERT INTO estado (id,nome) values (1, 'Maranhão')
INSERT INTO estado (id,nome) values (2, 'São Paulo')
INSERT INTO estado (id,nome) values (3, 'Rio de Janeiro')

INSERT INTO cidade (nome, estado_id) VALUES ('São Luis', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('São Paulo', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Rio de Janeiro', 3);