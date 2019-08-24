package br.com.locadora.veiculos;
/**
 * Interface que permite a manipulação de um conjunto de veículos.
 * @author Aline
 */
public interface IVeiculos {

    /**
     * Adiciona um veiculo na relação de veiculos.
     * @param v Veiculo a ser inserido.
     */
    public void add(Veiculo v);
    
    /**
     * Captura o veiculo com a placa informada por parâmetro.
     * @param placa Placa do veiculo a ser capturado.
     * @return Veiculo com a placa informada ou null em caso da placa não ser encontrada.
     */
    public Veiculo get(String placa);
    
    /**
     * Captura uma String com as informaçoes do veiculo com a placa informada por parâmetro.
     * @param placa Placa do veiculo a ser capturado.
     * @return String com as informaçoes do veiculo com a placa informada por parâmetro 
     * ou null em caso da placa não ser encontrada.
     */
    public String getInfo(String placa);
    
    /**
     * Captura uma String com as informaçoes de todos os veiculos.
     * @return String com as informaçoes de todos os veiculos 
     * ou null caso não exista nenhum veiculo.
     */
    public String getInfo();
    
    /**
     * Captura uma String com a placa, o ano e o valor da diaria de todos os veiculos.
     * @return String com a placa, o ano e o valor da diaria de todos os veiculos 
     * ou null caso não exista nenhum veiculo.
     */
    public String getResumoInfo();
    
    /**
     * Modifica as informações do veiculo com a placa informada por parâmetro.
     * @param placa Placa do veiculo a ser modificado.
     * @param v Veiculo com as modificações.
     * @return True se o veiculo com a placa informada por parâmetro for modificado ou
     * false caso não exista nenhum veiculo com a placa informada.
     */
    public boolean set(String placa, Veiculo v);
    
    /**
     * Remove o veiculo com placa igual a informada por parâmetro.
     * @param placa Placa do veiculo a ser capturado.
     * @return True se o veiculo com a placa informada por parâmetro for removido ou
     * false caso não exista nenhum veiculo com a placa informada. 
     */
    public boolean remove(String placa);
    
    /**
     * Verifica se existe um veiculo com a placa informada por parâmetro.
     * @param placa Placa do veiculo a ser verificada.
     * @return True se um veiculo com a placa informada for encontrado ou 
     * false caso não exista nenhum veiculo com a placa informada.
     */
    public boolean existe(String placa);
}