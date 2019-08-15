package banco;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A classe Banco Ã© responsÃ¡vel por gerenciar um nÃºmero indeterminado de
 * contas bancÃ¡rias. O banco permite abrir e encerrar uma conta bancÃ¡ria;
 * consultar o saldo, depositar e sacar de uma determinada conta, alÃ©m de
 * listar todas as contas.
 *
 * @author Aline
 */
public class Banco {

    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    /**
     * Abrir uma nova conta no banco.
     *
     * @param novaConta
     */
    public void abrirConta(Conta novaConta) {
        contas.add(novaConta);
    }

    /**
     * Captura a conta com o nÃºmero informado por parÃ¢metro.
     *
     * @param numero NÃºmero da conta a ser capturada.
     * @return A conta capturada ou null caso o nÃºmero informado nÃ£o exista
     */
    private Conta getConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    /**
     * Captura a conta com o nÃºmero e senha informados por parÃ¢metro.
     *
     * @param numero NÃºmero da conta a ser capturada.
     * @param senha Senha da conta a ser capturada.
     * @return A conta capturada ou null caso o nÃºmero ou senha informados
     * estejam incorretos.
     */
    private Conta getConta(int numero, String senha) {
        Conta c = getConta(numero);
        if (c != null) {
            if (c.isSenhaCorreta(senha)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Sacar o valor informado da conta com o nÃºmero informado caso a senha
     * esteja correta.
     *
     * @param numero NÃºmero da conta a ser realizado o saque.
     * @param senha Senha da conta a ser realizado o saque.
     * @param valor Valor a ser sacado.
     * @return True caso o saque tenha sido realizado e False caso os dados
     * (nÃºmero e/ou senha) da conta estejam incorretos ou nÃ£o Ã© permitido
     * realizar o saque do valor solicitado.
     */
    public boolean sacar(int numero, String senha, double valor) {
        Conta c = getConta(numero,senha);
        if(c!=null){
            return c.saca(valor);
        }
        return false;
    }

    /**
     * Deposita o valor informado na conta com o nÃºmero informado caso a senha
     * esteja correta.
     *
     * @param numero NÃºmero da conta a ser realizado o depÃ³sito.
     * @param senha Senha da conta a ser realizado o depÃ³sito.
     * @param valor Valor a ser depositado.
     * @return True caso o depÃ³sito tenha sido realizado e False caso os dados
     * (nÃºmero e/ou senha) da conta estejam incorretos.
     */
    public boolean depositar(int numero, String senha, double valor) {
        Conta c = getConta(numero,senha);
        if(c!=null){
            c.deposita(valor);
            return true;
        }
        return false;
    }

    /**
     * Consulta o saldo da conta cujo nÃºmero foi informado por parÃ¢metro e
     * caso a senha esteja correta.
     *
     * @param numero NÃºmero da conta.
     * @param senha Senha da conta.
     * @return Valor do saldo caso os dados (nÃºmero e senha) informados estejam
     * corretos ou -1 caso contrÃ¡rio.
     */
    public double consultarSaldo(int numero, String senha) {
        Conta c = getConta(numero,senha);
        if(c!=null){
            return c.getSaldo();
        }
        return -1;
    }

    /**
     * Transfere um valor da conta origem para a conta destino caso as
     * informaÃ§Ãµes das contas estejam corretas e a conta origem tenha saldo
     * suficente.
     *
     * @param numeroOrigem NÃºmero da conta de origem, onde o valor serÃ¡
     * sacado.
     * @param senhaOrigem Senha da conta de origem.
     * @param numeroDestino NÃºmero da conta de destino, onde o valor serÃ¡
     * depositado.
     * @param valor Valor a ser transferido.
     * @return True caso a transferÃªncia tenha sido realizada ou False caso os
     * dados das contas estejam incorretos ou a conta origem nÃ£o tenha saldo
     * suficiente.
     */
    public boolean transferir(int numeroOrigem, String senhaOrigem, int numeroDestino, double valor) {
        if(sacar(numeroOrigem, senhaOrigem, valor)){
            getConta(numeroDestino).deposita(valor);
            return true;
        }
        return false;
    }

    /**
     * Retorna uma String com os dados de todas as contas existentes.
     *
     * @return String com as informaÃ§Ãµes das contas.
     */
    public String listarContas() {
        String str;
        str = "";
        for(Conta c:contas){
            str = str.concat(c.toString());
        }
        return str;
    }

    /**
     * Encerra a conta com o nÃºmero informado, removendo do conjunto, desde que
     * a senha informada esteja correta.
     *
     * @param numero NÃºmero da conta a ser encerrada.
     * @param senha Senha da conta a ser encerrada.
     * @return True caso a conta tenha sido encerrada e False cao contrÃ¡rio.
     */
    public boolean encerrar(int numero, String senha) {
        return contas.remove(getConta(numero,senha));
    }
}
