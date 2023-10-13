/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author danie
 */
public class Banco {
    private CuentaBancaria[] cuentas;
    private static final double tasaInteres=0.1;
    
    public Banco(int capacidad){
        cuentas = new CuentaBancaria[capacidad];
    }
    
    public CuentaBancaria Buscar(int codigo){
     for (int i=0;i<cuentas.length;i++){
     if (cuentas[i]!=null && cuentas[i].getCodigo()==codigo){
          return cuentas[i];
      }
     }
     return null;
    }
  
    
    public boolean agregar(int codigo, String nombre){
        if(Buscar(codigo)!=null){
            return false;
        }
        for(int i=0;i<cuentas.length;i++){
            if (cuentas[i] == null) {
                cuentas[i] = new CuentaBancaria(codigo, nombre);
                return true;
            }
        }
        return false; 
    }
    public boolean transferir(int codigoOrigen, int codigoDestino, double monto){
        CuentaBancaria origen=Buscar(codigoOrigen);
        CuentaBancaria destino=Buscar(codigoDestino);      
    
    if (origen!=null && destino!=null && origen.retirar(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }
    
    public void Intereses(){
        for(CuentaBancaria cuenta:cuentas){
            if(cuenta!=null){
                double intereses=cuenta.getSaldo()*tasaInteres;
                
            }
        }
        
    }
     public void lista(double monto){
      for (int i=0; i<cuentas.length;i++){
          if (cuentas[i]!=null && cuentas[i].getSaldo()>=monto){
              System.out.println("codigo: "+cuentas[i].getCodigo());
              System.out.println("Saldo: "+cuentas[i].getSaldo());
          }
      }
     }

    boolean transferir(String codigoOrigenStr, String codigoDestinoStr, String montoStr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}
 
    
    

