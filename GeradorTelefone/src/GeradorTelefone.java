import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GeradorTelefone extends JFrame
{

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    GeradorTelefone frame = new GeradorTelefone();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GeradorTelefone()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblGeradorDeNumeros = new JLabel("Gerador de numeros de Telefones Moveis");
        lblGeradorDeNumeros.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
        lblGeradorDeNumeros.setBounds(99, 0, 264, 28);
        contentPane.add(lblGeradorDeNumeros);
        
        JLabel lblPrefixo = new JLabel("Prefixo:");
        lblPrefixo.setBounds(29, 43, 46, 14);
        contentPane.add(lblPrefixo);
        
        JLabel lblDdd = new JLabel("DDD:");
        lblDdd.setBounds(127, 43, 46, 14);
        contentPane.add(lblDdd);
        
        JLabel lblQuant = new JLabel("Quant:");
        lblQuant.setBounds(211, 43, 46, 14);
        contentPane.add(lblQuant);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(29, 68, 46, 28);
        contentPane.add(spinner);
        spinner.setValue(55);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setBounds(113, 68, 46, 28);
        contentPane.add(spinner_1);
        spinner_1.setValue(61);
        
        JSpinner spinner_2 = new JSpinner();
        spinner_2.setBounds(201, 68, 46, 28);
        contentPane.add(spinner_2);
        spinner_2.setValue(2);
        
        JButton btnGerar = new JButton("Gerar");
        btnGerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String pref =  spinner.getModel().getValue().toString();
                String ddd =   spinner_1.getModel().getValue().toString();
                int quant =  (int) spinner_2.getModel().getValue() / 2; 
                Random gera = new Random();
                
                FileWriter arq = null;
                try
                {
                    arq = new FileWriter("C:\\Users\\igortomio\\Desktop\\listaTelefones.txt");
                } catch (IOException e2)
                {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                PrintWriter gravarArq = new PrintWriter(arq);
               
                gravarArq.printf("+--Lista de Telefones--+%n");
                int cont = 0;
                for (int i = 0; i < quant; i++) {    
                    cont = cont ++;
                    gravarArq.println('+' + pref + '(' + ddd + ')'+ 9 + 9 + gera.nextInt(9999999));
                    gravarArq.println('+' + pref + '(' + ddd + ')'+ 9 + 8 + gera.nextInt(9999999));
                    
                }
                gravarArq.printf("+-------------+%n");  
                try
                {
                    arq.close();
                    JOptionPane.showMessageDialog(null, "O resultado foi salvo com sucesso em listaTelefones.txt: ");
                } catch (IOException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                 
            }
            
        });
        btnGerar.setBounds(147, 119, 89, 23);
        contentPane.add(btnGerar);
        
        JLabel label = new JLabel("");
        label.setEnabled(false);
        Image imagem = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
        label.setIcon(new ImageIcon(imagem));
        label.setBounds(110, 23, 208, 211);
        contentPane.add(label);
    }

}
