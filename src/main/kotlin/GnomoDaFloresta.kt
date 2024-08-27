class GnomoDaFloresta  (nome: String) : Personagem(
    nome = nome,
    raca = "Gnomo da Floresta",
    forca = 0,
    destreza = 0,
    constituicao = 0,
    inteligencia = 0,
    sabedoria = 0,
    carisma = 0,
    ModFinal = 0
) {
    override fun mostrar() {
        super.mostrar()
    }
    override fun calcularMod(valor: Int): Int {
        return super.calcularMod(valor)
    }
    override fun aplicarBonusRacial() {
        this.forca += 0
        this.destreza += 2
        this.constituicao += 0
        this.inteligencia += 0
        this.sabedoria += 0
        this.carisma += 0
    }
}