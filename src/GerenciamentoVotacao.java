import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
    private ArrayList<PessoaCandidata> pessoasCandidatas;
    private ArrayList<PessoaEleitora> pessoasEleitoras;
    private ArrayList<String> cpfsComputados;

   public GerenciamentoVotacao() {
       pessoasCandidatas = new ArrayList<>();
       pessoasEleitoras = new ArrayList<>();
       cpfsComputados = new ArrayList<>();
   }

    void cadastrarPessoaCandidata(String nome, int numero) {
        for (PessoaCandidata p : pessoasCandidatas) {
            if (p.getNumero() == numero) {
                System.out.println("Número da pessoa candidata já utilizado!");
                return;
            }
        }

        PessoaCandidata nova = new PessoaCandidata(nome, numero);

        pessoasCandidatas.add(nova);
    }

    void cadastrarPessoaEleitora(String nome, String cpf) {
       for (PessoaEleitora e : pessoasEleitoras) {
           if (e.getCpf() == cpf) {
               System.out.println("Pessoa eleitora já cadastrada!");
               return;
           }
       }
       PessoaEleitora nova = new PessoaEleitora(nome, cpf);
    }

    public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

        if (cpfsComputados.contains(cpfPessoaEleitora)) {
            System.out.println("Pessoa eleitora já votou!");
            return;
        }

        for (PessoaCandidata p : pessoasCandidatas) {
            if (p.getNumero() == numeroPessoaCandidata) {

                p.receberVoto();

                cpfsComputados.add(cpfPessoaEleitora);

                return; // encerra após votar
            }
        }
    }

    public void mostrarResultado() {

        // verificar se há votos
        if (cpfsComputados.isEmpty()) {
            System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
            return;
        }

        int totalVotos = cpfsComputados.size();

        for (PessoaCandidata p : pessoasCandidatas) {

            int votos = p.getVotos();

            double percentual = (votos * 100.0) / totalVotos;
            long percentualArredondado = Math.round(percentual);

            System.out.println(
                    "Nome: " + p.getNome() +
                            " - " + votos + " votos ( " +
                            percentualArredondado + "% )"
            );
        }

        System.out.println("Total de votos: " + totalVotos);
    }
}
