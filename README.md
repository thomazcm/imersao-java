# Projeto Imersão Java
__Projeto desenvolvido durante a semana de imersão Java da Alura, focado em consumir APIs e gerar imagens dinamicamente__

## Fim da Aula 2 - Criando stickers para o whatsapp
_Para os primeiros dias da imersão foi enfatizado o uso das bibliotecas básicas do Java, e sem uso de Maven ou Spring_

Projeto do fim da aula funcionando para criar stickers da lista de todos os 250 filmes mais populares do IMDB. Não inclui mais que 3 stickers porque estão com o tamanho bem grande.

Os stickers são criados com a imagem a partir da API do imdb e corrigindo a URL para obter a imagem no tamanho original.
A classe RequestHandler foi criada e devolve o retorno da API com o método getJsonFromEndpoint

A classe GerenciadorDeLista é responsavel por criar a lista a partir da URL, restaurar o tamanho original das imagens e também salvar a lista em um arquivo de texto para consulta mais fácil do retorno durante o desenvolvimento.

O texto é escolhido com um método simples que atribui um texto para cada intervalo de notas. Como as imagens vem em tamanhos variados, foi preciso atrelar o tamanho da fonte ao tamanho da imagem, e ajustar o parametro do eixo y a partir da fonte para que o texto esteja centralizado.

## Desenvolvimento Aula 3 - Ligando as pontas, refatoração e orientação a objetos
O objetivo principal era desaclopar o código, reorganizar para melhor leitura, e refatorar com o uso de conceitos de orientação a objetos.

As Classes Conteudo e ConteudoImdb foram criadas para representar os conteúdos das listas que serão usadas para gerar as imagens. A classe ConteudoImdb é filha da classe conteudo e sua única diferença é por ter um atributo com o rating do filme, que será usado para gerar o texto das figurinhas.

A classe GeradorDeLista fica responsável por gerar as listas de conteúdo a partir de String json. Ela possui um método para cada API usada. O método da NASA verifica se as entradas não são do tipo vídeo e cria a lista apenas com as imagens, enquanto o método do Imdb também salva o ImdbRating no objeto. A correção da url do Imdb para ajustar o tamanho das imagens foi delegada para o construtor da classe ConteudoImdb.

Tanto o AppImdb como o AppNasa funcionam para gerar um conjunto de imagens a partir do retorno de suas APIs usando as mesmas classes GeradorDeLista e GeradorDeFigurinhas.
