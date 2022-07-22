# imersao-java

Fim da Aula 2 - Criando stickers para o whatsapp
Projeto do fim da aula funcionando para criar stickers da lista de todos os 250 filmes mais populares do IMDB. Não inclui mais que 3 stickers porque estão com o tamanho bem grande.

Os stickers são criados com a imagem a partir da API do imdb e corrigindo a URL para obter a imagem no tamanho original.
A classe RequestHandler foi criada e devolve o retorno da API com o método getJsonFromEndpoint

A classe GerenciadorDeLista é responsavel por criar a lista a partir da URL, restaurar o tamanho original das imagens e também salvar a lista em um arquivo de texto para consulta mais fácil do retorno durante o desenvolvimento.


 O texto é escolhido com um método simples que atribui um texto para cada intervalo de notas. Como as imagens vem em tamanhos variados, foi preciso atrelar o tamanho da fonte ao tamanho da imagem, e ajustar o parametro do eixo y a partir da fonte para que o texto esteja centralizado.
