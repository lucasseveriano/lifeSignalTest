Funcionalidade: Acesso ao Sistema

Narrativa:
Para obter a tela inicial apareceça para mim
Como um usuário
Desejo acessar o sistema

Cenário: Iniciar Aplicação
Dado que vou para a tela "tela principal"
Então será exibido "BPM"
Quando clico em "Iniciar"

Cenário: Iniciar tela Menu
Dado que estou na tela "tela principal"
Então será exibido "BPM"
Quando clico em "abrirJanelaMenu"

Cenário: Configuração de Bradicardia Sinusal
Dado que vou para a tela "tela Menu"
Então será exibido "Ritmo Cardíaco"
Quando seleciono a opção de valor "Bradicardia Sinusal" no campo "comboBox"
Quando seleciono a opção "Bradicardia Sinusal"
Quando clico em "abrirJanelaMenu"
Então será exibido "Ritmo Cardíaco"

Cenário: Abrir tela aluno
Dado que estou na tela "tela principal"
Então será exibido "BPM"
Quando clico em "abrirJanelaAluno"
Então será exibido "BPM"