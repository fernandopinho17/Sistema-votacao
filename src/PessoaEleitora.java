public class PessoaEleitora extends Pessoa{

    private String cpf;

    public PessoaEleitora(String nome, String cpf) {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
