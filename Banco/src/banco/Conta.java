package banco;
/**
 * Classe Conta modela uma conta bancária permitindo consultar saldo,
 * limite, número da conta e titular, efetuar operações de saque e  
 * depósito, além de modificar o limite e o titular.
 * A classe Conta possui seguintes atributos:
 * * numero corresponde ao número da conta e é gerado automaticamente
 * pela classe a fim de que seja um valor único;
 * * titular corresponde ao nome do(a) proprietário(a) da conta.
 * * senha corresponde a um código secreto composto por letras ou 
 * que serve para autenticar o titular e dar poder de manipular a conta.
 * * saldo corresponde ao valor que o titular já depositou na conta. 
 * * limite corresponde ao valor que o titular pode sacar além de seu saldo.
 * @author Aline
 */
public class Conta {
    private static int nConta = 1;
    
    private final int numero;
    private String senha;
    private Cliente titular;
    private double saldo;
    private double limite;
    
    /**
     * Construtor da Conta que recebe o titular por parâmetro, 
     * inicializa saldo e limite com zero e o número da conta
     * de forma a garantir que toda conta possui um número único.
     * @param titular Nome completo do titular da conta.
     */
    public Conta(Cliente titular){
        this.titular=titular;
        this.saldo=0;
        this.limite=0;
        this.numero=nConta++;
        this.senha="1234";
    }
       
    /**
     * Captura o titular da Conta.
     * @return Titular.
     */
    public Cliente getTitular(){
        return titular;
    }
    /**
     * Captura número da conta.
     * @return Número da conta.
     */
    public int getNumero(){
        return numero;
    }
    
    /**
     * Captura o saldo da conta.
     * @return Saldo.
     */
    public double getSaldo(){
        return saldo;
    }
    
    /**
     * Captura o limite da conta.
     * @return Limite.
     */
    public double getLimite(){
        return limite;
    }
    
    /**
     * Captura a senha da conta.
     * @return Senha.
     */
    public String getSenha(){
        return senha;
    }
    
    /**
     * Verifica se a senha informada por parâmetro é igual a 
     * senha da conta.
     * @param senhaInformada Senha a ser verificada.
     * @return True caso a senha informada esteja correta e 
     * False caso contrário.
     */
    public boolean isSenhaCorreta(String senhaInformada){
        return senhaInformada.equals(senha);
    }
    
    /**
     * Modifica o titular da conta.
     * @param t Novo titular.
     */
    public void setTitular(Cliente t){
        titular=t;
    }
    
    /**
     * Modifica a senha caso a senha antiga esteja correta.
     * @param senhaAntiga Senha antiga.
     * @param senhaNova Senha nova.
     * @return True se a senha for modificada e False caso
     * contrário.
     */
    public boolean setSenha(String senhaAntiga,String senhaNova){
        if(isSenhaCorreta(senhaAntiga)){
            senha=senhaNova;
            return true;
        }
        return false;
    }
    
    /**
     * Modifica o limite da conta. 
     * @param l Novo limite.
     */
    public void setLimite(double l){
        limite=l;
    }
	
    /**
     * Acrescenta o valor informado por parâmetro ao saldo da conta.
     * @param valor 
     */
    public void deposita(double valor){
        saldo+=valor;
    }
    
    /**
     * Subtrai o valor informado por parâmetro do saldo da conta 
     * caso esse valor seja inferior ou igual a soma do saldo e do limite.
     * @param valor Valor a ser sacado.
     * @return True se o saque foi realizado com sucesso e 
     * False caso contrário. 
     */
    public boolean saca(double valor){
        if(valor <= (saldo+limite)){
            saldo-=valor;
            return true;
        }
        return false;
    }
    
    /**
     * Retorna as informações da conta
     * @return Uma String com as informações.
     */
    @Override
    public String toString(){
        return  "Numero: "+this.numero+" | Titular: "+this.titular.getNome()+" | Saldo: "+this.saldo+" | Limite: "+this.limite+"\n";
    }
    
}
