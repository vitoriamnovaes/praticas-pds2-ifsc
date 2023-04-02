package questao8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.table.DefaultTableModel;

public class tela extends JFrame {
	public static String DATABASE = "hr";
	public static String USER = "aluno";
	public static String PSW = "aluno";
	public static Pessoa pessoa = new Pessoa();
	public static ArrayList<Pessoa> listapessoa = new ArrayList<Pessoa>();
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txtTelefone;
	private JTable table_1;

	public tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 27, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(23, 11, 70, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String tele = txtTelefone.getText();
				controller controllerPessoa = new controller();
				
				Boolean resultado = controllerPessoa.insertPessoa(nome,tele);
				if (resultado != false) {
					JOptionPane.showMessageDialog(null, "cadastrado");
				}
		}});
		btnNewButton.setBounds(23, 82, 129, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 11, 230, 94);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Telefone"
				}
			);
		table_1.setModel(modelo);
		scrollPane.setViewportView(table_1);
		
		controller c = new controller();
		ArrayList<Pessoa> p = c.consultaUsuarios();
		
		for (Pessoa pessoa : p) {
			modelo.addRow(new Object[] { pessoa.getNome(), pessoa.getTelefone() });
			table_1.setModel(modelo);
		}
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(23, 57, 129, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	
}
