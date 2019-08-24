/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.locacoes;
/**
 * Interface que permite manipular um conjunto de locações.
 * @author Aline
 */
public interface ILocacoes {
    /**
     * Adiciona uma locação na relação de locações.
     * @param l Locação a ser inserido.
     */
    public void add(Locacao l);
    
    /**
     * Captura a locação com o codigo informado por parâmetro.
     * @param codigo Codigo do locação a ser capturado.
     * @return Locação com o codigo informado ou null caso o codigo não for encontrado.
     */
    public Locacao get(int codigo);
    
    /**
     * Captura uma String com as informaçoes da locação com o codigo informado por parâmetro.
     * @param codigo Codigo da locação a ser capturada.
     * @return String com as informaçoes da locação com o codigo informado por parâmetro 
     * ou null caso o codigo não for encontrado.
     */
    public String getInfo(int codigo);
    
    /**
     * Captura uma String com as informaçoes de todas as locações.
     * @return String com as informaçoes de todas as locações
     * ou null caso não exista nenhuma locação.
     */
    public String getInfo();
    
    /**
     * Modifica as informações da locação com o codigo informado por parâmetro.
     * @param codigo Codigo da locação a ser modificada.
     * @param l Locação com as modificações.
     * @return True se a locação com o codigo informado por parâmetro foi modificada ou
     * false caso não exista nenhuma locação com o codigo informado.
     */
    public boolean set(int codigo, Locacao l);
    
    /**
     * Remove a locação com o codigo igual ao informado por parâmetro.
     * @param codigo Codigo da locação a ser capturada.
     * @return True se a locação com o codigo informado por parâmetro foi removida ou
     * false caso não exista nenhuma locação com o codigo informado. 
     */
    public boolean remove(int codigo);
    
    /**
     * Verifica se existe uma locação com o codigo informado por parâmetro.
     * @param codigo Codigo da locação a ser verificada.
     * @return True se uma locação com o codigo informado for encontrada ou 
     * false caso não exista nenhuma locação com o codigo informado.
     */
    public boolean existe(int codigo);    
}