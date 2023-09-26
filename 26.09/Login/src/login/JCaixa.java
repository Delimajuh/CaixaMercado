package login;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JCaixa extends JFrame {

    private JuLabel lblTotal;
    private JButton btnSair;
    private JTextField txtValorProduto;
    private JTextField txtQuantidade;
    private DefaultTableModel tabela;
    private double valorTotal;
    private double resultadoFinal;
   
    public JCaixa(){

        this.setTitle("Caixa de Mercado");
        this.setSize(500, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        JuLabel lblValorProduto = new JuLabel();
        lblValorProduto.setText("Valor do Produto:");
        lblValorProduto.setLocation(40, 60);

        this.txtValorProduto = new JTextField();
        this.txtValorProduto.setSize(150, 50);
        this.txtValorProduto.setLocation(40, 100);

        JuLabel lblQuantidade = new JuLabel();
        lblQuantidade.setText("Quantidade:");
        lblQuantidade.setLocation(40, 150);

        this.txtQuantidade = new JTextField();
        this.txtQuantidade.setSize(100, 50);
        this.txtQuantidade.setLocation(40, 200);

        JuLabel lblTotal = new JuLabel();
        lblTotal.setText("TOTAL:");
        lblTotal.setSize(133, 21);
        lblTotal.setLocation(40, 300);
        this.lblTotal = new JuLabel();
        this.lblTotal.setSize(200, 50);
        this.lblTotal.setLocation(50, 300);

        this.btnSair = new JButton();
        this.btnSair.setText("Sair");
        this.btnSair.setSize(120, 50);
        this.btnSair.setLocation(30, 500);
        this.btnSair.addActionListener(new ActionSair());

        JButton btAdicionar = new JButton();
        btAdicionar.setText("Adicionar");
        btAdicionar.setSize(120, 30);
        btAdicionar.setLocation(20, 400);
        BtnAdicionarListener btnAdicionarListener1 = new BtnAdicionarListener();
        btAdicionar.addMouseListener(btnAdicionarListener1);
        
        JButton btCalcTotal = new JButton();
        btCalcTotal.setText("Calcular Total");
        btCalcTotal.setSize(130, 30);
        btCalcTotal.setLocation(150, 400);
        BtnCalcularListener btCalcularListener = new BtnCalcularListener();
        btCalcTotal.addMouseListener(btCalcularListener);
        
        JButton btFinalizar = new JButton();
        btFinalizar.setText("Finalizar Compra");
        btFinalizar.setSize(130, 30);
        btFinalizar.setLocation(290, 400);
        BtnFinalizarListener btnFinalizarListener = new BtnFinalizarListener();
		btFinalizar.addMouseListener(btnFinalizarListener);

        this.tabela = new DefaultTableModel();
		tabela.addColumn("Valor Unitário");
		tabela.addColumn("Qtde");
		
		JTable table = new JTable(this.tabela);
		
		JScrollPane scrollpane = new JScrollPane(table);		
		scrollpane.setSize(180, 140);
		scrollpane.setLocation(250, 60);
	    table.setFillsViewportHeight(true); 
       
        this.add(this.lblTotal); 
        this.add(btnSair);
        this.add(btAdicionar);
        this.add(btCalcTotal);
        this.add(btFinalizar);
        this.add(txtValorProduto);
        this.add(lblValorProduto);
        this.add(txtQuantidade);
        this.add(lblQuantidade);
        this.add(lblTotal);
        this.add(scrollpane);
    }
    class ActionSair implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Tchau!");
            System.exit(0);
        }  
    }
    class BtnFinalizarListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        String valorTotal = String.valueOf(resultadoFinal);
        JFinalizar JFinalizar = new JFinalizar(valorTotal);

        JFinalizar.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
    class BtnAdicionarListener implements MouseListener{
        
        @Override
            public void mouseClicked(MouseEvent e) {
            double valor = Double.parseDouble(txtValorProduto.getText());
            int qtd = Integer.parseInt(txtQuantidade.getText());
			
			if (valor <= 0 || qtd <=0 )
				JOptionPane.showMessageDialog(null, "Valor não informado");
			else {
                valorTotal = ( valor * qtd) + valorTotal;
				tabela.insertRow(tabela.getRowCount(), new Object[] {valor, qtd });
                resultadoFinal = valorTotal;
                
			}					
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
   class BtnCalcularListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        lblTotal.setText("R$" + resultadoFinal);
        }
        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
   }
}  


