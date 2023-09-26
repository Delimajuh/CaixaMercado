package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JFinalizar extends JFrame{
    
    private JTextField txtValorPago;
    private JuLabel lblVlTotal;
    private JuLabel lblTroco;
    private double valorResultado;
    private JuLabel lblTotal;
    private JuLabel lblValorPago;

    public JFinalizar(String valorTotal){

        this.setTitle("Caixa de Mercado");
        this.setSize(500, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.txtValorPago = new JTextField();
        this.txtValorPago.setSize(150, 50);
        this.txtValorPago.setLocation(40, 100);

        this.lblValorPago = new JuLabel();
        this.lblValorPago.setText("Valor Pago Pelo Cliente:");
        this.lblValorPago.setLocation(40, 60);

        JButton btCalcularTroco = new JButton();
        btCalcularTroco.setText("Calcular Troco");
        btCalcularTroco.setSize(130, 30);
        btCalcularTroco.setLocation(40, 270);
        BtnCalcularTrocoListener btnCalcularTrocoListener = new BtnCalcularTrocoListener();
		btCalcularTroco.addMouseListener(btnCalcularTrocoListener);
        
        JButton btSair = new JButton();
        btSair.setText("Sair");
        btSair.setSize(130, 30);
        btSair.setLocation(40, 310);
        btSair.addActionListener(new ActionSair());

        this.lblTotal = new JuLabel();
        this.lblTotal.setText("TOTAL: R$ ");
        this.lblTotal.setLocation(40, 180);

        this.lblVlTotal = new JuLabel();
        this.lblVlTotal.setText(valorTotal);
        this.lblVlTotal.setSize(200, 30);
        this.lblVlTotal.setLocation(120, 180);

        this.lblTroco = new JuLabel();
        this.lblTroco.setText("TROCO: R$ ");
        this.lblTroco.setLocation(40, 220);

        this.add(btCalcularTroco);
        this.add(btSair);
        this.add(lblValorPago);
        this.add(txtValorPago);
        this.add(lblTotal);
        this.add(lblTroco);
        this.add(lblVlTotal);
        
    }
    class BtnCalcularTrocoListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            double valorPago = Double.parseDouble(txtValorPago.getText());
            double valorTotal = Double.parseDouble(lblVlTotal.getText());

            if (valorPago < valorTotal ) 
            JOptionPane.showMessageDialog(null, "O valor pago é insuficiente");
            else {
            valorResultado = valorPago - valorTotal;
            lblTroco.setText("TROCO: R$ " + valorResultado);
            }					

		}

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
    class ActionSair implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Tchau!");
            System.exit(0);
        }
    }
}
