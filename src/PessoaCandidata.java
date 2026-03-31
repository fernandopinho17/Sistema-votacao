public class PessoaCandidata extends Pessoa {

    int numero;
    int votos;

    public int getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }

    public void receberVoto() {
         votos+=1;
    }

    PessoaCandidata(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;

        votos = 0;
    }
}
