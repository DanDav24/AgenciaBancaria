/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author danie
 */
public class AgenciaSwing extends JFrame{
   private Banco banco;

    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField montoField;

    public AgenciaSwing() {
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del banco:"));
        banco = new Banco(capacidad);
        

        setTitle("Cuentas Bancarias");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        codigoField = new JTextField(10);
    nombreField = new JTextField(10);
    montoField = new JTextField(10);

        JButton agregarButton = new JButton("Agregar Cuenta");
        JButton transferirButton = new JButton("Transferir");
        JButton interesesButton = new JButton("Calcular Intereses");
        JButton listaButton = new JButton("Lista de Cuentas");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = JOptionPane.showInputDialog("Ingrese el código:");
    if (codigoStr == null) {
        return; // El usuario presionó "Cancelar" o cerró la ventana
    }

    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
    if (nombre == null) {
        return; // El usuario presionó "Cancelar" o cerró la ventana
    }

    int codigo;
    try {
        codigo = Integer.parseInt(codigoStr);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "El código debe ser un número entero válido.");
        return;
    }
    boolean agregado = banco.agregar(codigo, nombre);
    if (agregado) {
        JOptionPane.showMessageDialog(null, "Cuenta agregada con éxito.");
    } else {
        JOptionPane.showMessageDialog(null, "La cuenta no pudo ser agregada. El código ya existe.");
    }
            }
                
                 
                
        });

        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
              String codigoOrigenStr = codigoField.getText();
        String codigoDestinoStr = nombreField.getText();
        String montoStr = montoField.getText();

        if (codigoOrigenStr.isEmpty() || codigoDestinoStr.isEmpty() || montoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        } else {
            boolean transferido = banco.transferir(codigoOrigenStr, codigoDestinoStr, montoStr);
            if (transferido) {
                JOptionPane.showMessageDialog(null, "Transferencia exitosa.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la transferencia.");
            }
        }
    }
                
            
        });

        interesesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco.Intereses();
                JOptionPane.showMessageDialog(null, "Intereses calculados y aplicados.");
            }
        });

        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(montoField.getText());
                banco.lista(monto);
            }
        });

        

        panel.add(agregarButton);
        panel.add(transferirButton);
        panel.add(interesesButton);
        panel.add(listaButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgenciaSwing gui = new AgenciaSwing();
            gui.setVisible(true);
        });
    }
}