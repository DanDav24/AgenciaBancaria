/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author danie
 */
public class CuentaBancaria {
    private int codigo;
    private String nombreCliente;
    private double saldoCuenta;
    
    public CuentaBancaria(int codigo, String nombreCliente){
        this.codigo=codigo;
        this.nombreCliente=nombreCliente;
        this.saldoCuenta=500;
    }
    public int getCodigo(){
        return codigo;
    }
    public double getSaldo(){
        return saldoCuenta;
    }
    
    public void depositar(double monto){
        if(monto>0){
            monto+=saldoCuenta;
        }
    }
    
    public boolean retirar(double monto){
        if(monto>0 && monto<saldoCuenta){
            monto-=saldoCuenta;
            return true;
        }
        return false;
    }
    public void print(){
        System.out.println("Codigo: "+codigo);
        System.out.println("Nombre del Cliente: "+nombreCliente);
        System.out.println("saldoCuenta: "+saldoCuenta);
    }
}
