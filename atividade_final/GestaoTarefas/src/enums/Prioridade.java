package enums;

/*
 * ENUM = lista fixa de valores possíveis.
 *
 * Em vez de guardar a prioridade como texto ("media", "MEDIA", "Média"...),
 * usamos um enum. Assim o compilador só aceita um destes três valores
 * e ninguém consegue digitar errado.
 *
 * Na tela, o JComboBox é preenchido automaticamente com Prioridade.values(),
 * que devolve um array com todos os valores declarados aqui embaixo.
 */
public enum Prioridade {
    BAIXA, MEDIA, ALTA
}
