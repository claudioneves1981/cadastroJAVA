package cadastroJAVA;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class CadastroJAVA {
	
	
	static JLabel[] Label = new JLabel[11];
	static JFrame frmCadClientes;
	static JTextField IDCliente, NomeCliente, Apelido, CPF, Endereco, CEP, Pesquisa, Estado, Cidade;
	static JComboBox FilmeEscolhido; 
	static JInternalFrame frListagem;
	static JList lstRegistros;
	static JButton cmdNovo, cmdSalvar, cmdExcluir, cmdCancelar, cmdPesquisa;
	static String arquivoCadClientes = "C:/Users/cfneg/eclipse-workspace/cadastroJAVA/CadClientes.csv";
	static String arquivoTemp = "C:/Users/cfneg/eclipse-workspace/cadastroJAVA/temp.txt";  
	static ActionListener salvar, novo, cancelar, excluir, pesquisa;
	static String[] items = new String[] {"Filme1","Filme2","Filme3"};

	
	public static void main(String[] args) throws IOException {
		
		frmCadClientes = new JFrame("Locadora");
		frmCadClientes.setSize(554, 417);
		frmCadClientes.setVisible(true);
		frmCadClientes.setResizable(false);
		frmCadClientes.setLayout(null);
		frmCadClientes.setLocationRelativeTo(null);
		frmCadClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int x = 0; x < Label.length ; x++) {
			
		Label[x] = new JLabel();
		frmCadClientes.add(Label[x]);
		
		}
		
		Label[0].setVisible(true);
		Label[0].setBounds(12, 6, 66, 12);
		Label[0].setText("IDCliente:");
		 
		Label[1].setVisible(true);
		Label[1].setBounds(84, 6, 90, 12);
		Label[1].setText("Nome:");
		
		Label[2].setVisible(true);
		Label[2].setBounds(12, 42, 114, 12);
		Label[2].setText("Apelido:");
		
		Label[3].setVisible(true);
		Label[3].setBounds(420, 42, 72, 12);
		Label[3].setText("CPF:");
		
		Label[4].setVisible(true);
		Label[4].setBounds(12, 78, 72, 18);
		Label[4].setText("Endereço:");
		
		Label[5].setVisible(true);
		Label[5].setBounds(12, 114, 72, 12);
		Label[5].setText("Estado:");
		
		Label[6].setVisible(true);
		Label[6].setBounds(138, 114, 72, 12);
		Label[6].setText("Cidade");
		
		Label[7].setVisible(true);
		Label[7].setBounds(312, 114, 88, 12);
		Label[7].setText("Filme Escolhido");
	
		IDCliente = new JTextField();
		frmCadClientes.add(IDCliente);
		IDCliente.setVisible(true);
		IDCliente.setBounds(12, 18, 66, 18);
		
		NomeCliente= new JTextField();
		frmCadClientes.add(NomeCliente);
		NomeCliente.setVisible(true);
		NomeCliente.setBounds(84, 18, 450, 18);
		
		Apelido= new JTextField();
		frmCadClientes.add(Apelido);
		Apelido.setVisible(true);
		Apelido.setBounds(12, 54, 402, 18);
		
		CPF= new JTextField();
		frmCadClientes.add(CPF);
		CPF.setVisible(true);
		CPF.setBounds(420, 54, 114, 18);
		
		Endereco= new JTextField();
		frmCadClientes.add(Endereco);
		Endereco.setVisible(true);
		Endereco.setBounds(12, 93, 522, 18);
		
		Estado = new JTextField();
		frmCadClientes.add(Estado);
		Estado.setVisible(true);
		Estado.setBounds(12, 126, 120, 18);
		
		Cidade = new JTextField();
		frmCadClientes.add(Cidade);
		Cidade.setVisible(true);
		Cidade.setBounds(138, 126, 168, 18);
		
		FilmeEscolhido = new JComboBox();
		frmCadClientes.add(FilmeEscolhido);
		FilmeEscolhido.setVisible(true);
		FilmeEscolhido.setBounds(312, 126, 222, 18);
		
		frListagem = new JInternalFrame();
		frmCadClientes.add(frListagem);
		frListagem.setTitle("Registros");
		frListagem.setVisible(true);
		frListagem.setResizable(false);
		frListagem.setLayout(null);
		frListagem.setBounds(12,180,522,174);
		
		Pesquisa = new JTextField();
		frListagem.add(Pesquisa);
		Pesquisa.setVisible(true);
		Pesquisa.setBounds(6,12,400,18);
		
		cmdPesquisa = new JButton();
		frListagem.add(cmdPesquisa);
		cmdPesquisa.setVisible(true);
		cmdPesquisa.setBounds(410,11,100,18);
		cmdPesquisa.setText("Pesquisar");
		
		frListagem.add(Label[9]);
		Label[9].setVisible(true);
		Label[9].setBounds(6, 36, 66, 12);
		Label[9].setText("Cliente ID:");
		
		frListagem.add(Label[10]);
		Label[10].setVisible(true);
		Label[10].setBounds(84, 36, 90, 12);
		Label[10].setText("Nome:");
		
		lstRegistros = new JList();
		frListagem.add(lstRegistros);
		lstRegistros.setVisible(true);
		lstRegistros.setBounds(6,48,500,111);
		lstRegistros.setVisibleRowCount(3);
		
		cmdNovo = new JButton();
		frmCadClientes.add(cmdNovo);
		cmdNovo.setVisible(true);
		cmdNovo.setBounds(12,360,62,22);
		cmdNovo.setText("Novo");
		
		cmdSalvar = new JButton();
		frmCadClientes.add(cmdSalvar);
		cmdSalvar.setVisible(true);
		cmdSalvar.setEnabled(true);
		cmdSalvar.setBounds(74,360,70,22);
		cmdSalvar.setText("Salvar");
		
		cmdExcluir= new JButton();
		frmCadClientes.add(cmdExcluir);
		cmdExcluir.setVisible(true);
		cmdExcluir.setBounds(144,360,73,22);
		cmdExcluir.setText("Excluir");
		
		cmdCancelar = new JButton();
		frmCadClientes.add(cmdCancelar);
		cmdCancelar.setVisible(true);
		cmdCancelar.setBounds(217,360,85,22);
		cmdCancelar.setText("Cancelar");
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(items);
		FilmeEscolhido.setModel(model);
		
		lstRegistros_Change();
		cmdSalvar_Click();
		cmdNovo_Click();
		cmdCancelar_Click();
		cmdExcluir_Click();
		cmdPesquisa_Click();
		
	}

	private static void lstRegistros_Change () throws IOException {
		
	    Configuracoes.selecionaRegistro(arquivoCadClientes);
	    
	}
	
	private static void cmdSalvar_Click() {
		
		cmdSalvar.addActionListener(new Salvar(salvar));
		            
   }
	
	private static void cmdNovo_Click() {
		
		cmdNovo.addActionListener(new Novo(novo));	
		
	}
	
	private static void cmdCancelar_Click() {
		
		cmdCancelar.addActionListener(new Cancelar(cancelar));
		
	}
	
	private static void cmdExcluir_Click() {
		
		cmdExcluir.addActionListener(new Excluir(excluir));
		
	}
	
	private static void cmdPesquisa_Click() {
		
		cmdPesquisa.addActionListener(new Pesquisa(pesquisa));
		
	}
	
	
}