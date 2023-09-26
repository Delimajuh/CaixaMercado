package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JLogin extends JFrame{

    private JButton btnEntrar;
    private JTextField txtUsuario;
    private JTextField txtSenha;

    public JLogin(){

        this.setTitle("Login");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.btnEntrar = new JButton();
        this.btnEntrar.setText("Entrar");
        this.btnEntrar.setSize(100, 50);
        this.btnEntrar.setLocation(40, 300);
        this.btnEntrar.addMouseListener(new EntrarMouseListener());

        JuLabel lblUsuario = new JuLabel();
        lblUsuario.setText("Usuário");
        lblUsuario.setLocation(40, 60);

        this.txtSenha = new JTextField();
        this.txtSenha.setSize(150, 50);
        this.txtSenha.setLocation(40, 200);

        JuLabel lblSenha = new JuLabel();
        lblSenha.setText("Senha");
        lblSenha.setLocation(40, 160);

        this.txtUsuario = new JTextField();
        this.txtUsuario.setSize(150, 50);
        this.txtUsuario.setLocation(40, 90);

        this.add(this.btnEntrar);
        this.add(this.txtSenha);
        this.add(txtUsuario);
        this.add(lblSenha);
        this.add(lblUsuario);
    }
    class EntrarMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {

            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();
            
            if(usuario.equals("Juliana")&& senha.equals("123")){
                JCaixa secundaria = new JCaixa();
                secundaria.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha Inválido");
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
}