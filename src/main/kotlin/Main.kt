import java.util.Scanner

fun main() {
    val entrada = Scanner(System.`in`)
    val limitePontos = 27
    var pontosRestantes = limitePontos

    println("Digite o nome do seu personagem:")
    val nomePersonagem = entrada.next()

    println("Selecione a raça do seu personagem:")
    val opcoesRacas = listOf(
        "Anão", "Elfo", "Humano", "Orc", "Anão da Montanha",
        "Dracono", "Halfling", "Halfling Robusto", "Halfling Pés-Leves",
        "Anão da Colina", "Tiefling", "Meio-Elfo", "Gnomo da Floresta",
        "Alto Elfo", "Gnomo das Rochas", "Elfo da Floresta", "Gnomo", "Drow"
    )

    for (i in opcoesRacas.indices) {
        println("${i + 1}. ${opcoesRacas[i]}")
    }

    val racaEscolhida = when (readLine()?.toIntOrNull()) {
        1 -> Anao(nomePersonagem)
        2 -> Elfo(nomePersonagem)
        3 -> Humano(nomePersonagem)
        4 -> Orc(nomePersonagem)
        5 -> AnaoDaMontanha(nomePersonagem)
        6 -> Dracono(nomePersonagem)
        7 -> Halfling(nomePersonagem)
        8 -> HalflingRobusto(nomePersonagem)
        9 -> HalflingPesLeves(nomePersonagem)
        10 -> AnaoDaColina(nomePersonagem)
        11 -> Tiefling(nomePersonagem)
        12 -> MeioElfo(nomePersonagem)
        13 -> GnomoDaFloresta(nomePersonagem)
        14 -> AltoElfo(nomePersonagem)
        15 -> GnomoDasRochas(nomePersonagem)
        16 -> ElfoDaFloresta(nomePersonagem)
        17 -> Gnomo(nomePersonagem)
        18 -> Drow(nomePersonagem)
        else -> {
            println("Raça inválida, definindo como Anão por padrão.")
            Anao(nomePersonagem)
        }
    }

    while (pontosRestantes > 0) {
        println("Você tem $pontosRestantes pontos restantes.")
        println("Tabela de Custo de Pontos:")
        val tabelaCusto = mapOf(8 to 0, 9 to 1, 10 to 2, 11 to 3, 12 to 4, 13 to 5, 14 to 7, 15 to 9)

        println("Selecione o atributo para alocar pontos:")
        val atributos = listOf("Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma")

        for (i in atributos.indices) {
            println("${i + 1}. ${atributos[i]}")
        }

        val escolhaAtributo = readLine()?.toIntOrNull()
        if (escolhaAtributo == null || escolhaAtributo !in 1..atributos.size) {
            println("Opção inválida. Tente novamente.")
            continue
        }

        println("Quantos pontos deseja atribuir ao atributo ${atributos[escolhaAtributo - 1]} (8-15)?")
        val pontosEscolhidos = readLine()?.toIntOrNull()

        if (pontosEscolhidos == null || pontosEscolhidos !in 8..15) {
            println("Valor inválido, insira um número entre 8 e 15.")
            continue
        }

        val custoNovo = tabelaCusto[pontosEscolhidos] ?: 0
        val atributoAtual = when (escolhaAtributo) {
            1 -> racaEscolhida.forca
            2 -> racaEscolhida.destreza
            3 -> racaEscolhida.constituicao
            4 -> racaEscolhida.inteligencia
            5 -> racaEscolhida.sabedoria
            6 -> racaEscolhida.carisma
            else -> 8
        }
        val custoAtual = tabelaCusto[atributoAtual] ?: 0

        if (pontosRestantes + custoAtual >= custoNovo) {
            pontosRestantes = pontosRestantes + custoAtual - custoNovo
            when (escolhaAtributo) {
                1 -> racaEscolhida.forca = pontosEscolhidos
                2 -> racaEscolhida.destreza = pontosEscolhidos
                3 -> racaEscolhida.constituicao = pontosEscolhidos
                4 -> racaEscolhida.inteligencia = pontosEscolhidos
                5 -> racaEscolhida.sabedoria = pontosEscolhidos
                6 -> racaEscolhida.carisma = pontosEscolhidos
            }
        } else {
            println("Pontos insuficientes para essa alocação.")
        }
    }

    println("Distribuição de pontos concluída!")
    racaEscolhida.ModFinal = racaEscolhida.calcularMod(racaEscolhida.constituicao) + 10
    racaEscolhida.aplicarBonusRacial()
    racaEscolhida.mostrar()
}
