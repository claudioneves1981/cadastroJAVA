package cadastroJAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Configuracoes {
	
	public static DefaultListModel <String> lista = new DefaultListModel<String>();
	public static DefaultListModel <String> pesquisados = new DefaultListModel<String>();

	
	private static String exibelista;
	
	public static void selecionaRegistro(String arquivoCadClientes) throws IOException{
				
		FileReader fr = new FileReader(arquivoCadClientes);
	    BufferedReader br = new BufferedReader(fr);

	    String rsRegistro = null;
	    String[] selecionados;
	  
	    	while ((rsRegistro = br.readLine()) != null) {

	    		selecionados = rsRegistro.split("\n");

	    		for (int i = 0; i < selecionados.length; i++) {

	    			String listaRegistros = selecionados[i].replaceAll(";", " ");
	    			lista.addElement(listaRegistros);  
            
	    		}
	    		
	    		CadastroJAVA.lstRegistros.setListData(lista.toArray());	
            
	    	}
	    	
	    br.close();
	 	fr.close();
	}
	
	public static void exibeLista() {
	
		setExibelista(String.valueOf(CadastroJAVA.IDCliente.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.NomeCliente.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.Apelido.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.CPF.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.Endereco.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.Estado.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.Cidade.getText())+" ");
		setExibelista(getExibelista()+String.valueOf(CadastroJAVA.FilmeEscolhido.getSelectedItem()+" "));
		setExibelista(getExibelista().replace('[', ' '));
	
		if(lista.contains(getExibelista())) {
			
		JOptionPane.showMessageDialog(null, "Filme ja escolhido pelo cliente, selecione outro");
		
		} else {
		
		lista.addElement(getExibelista());
		setExibelista(" ");
		
		}
	}
		
	public static void registraDados(String arquivoCadClientes) throws IOException {
		
        FileWriter fw = null;   
        BufferedWriter bw = null;
        
        File arquivo = new File(arquivoCadClientes);

        arquivo.createNewFile();
        
        fw = new FileWriter(arquivo, true);  
        bw = new BufferedWriter(fw);
        
		String registro;
	
			exibeLista();
			
			registro = String.valueOf(CadastroJAVA.IDCliente.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.NomeCliente.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.Apelido.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.CPF.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.Endereco.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.Estado.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.Cidade.getText())+";";
			registro = registro+String.valueOf(CadastroJAVA.FilmeEscolhido.getSelectedItem());
			
			if(registro.contains(";;") || registro.contains("; ") || registro.contains("  ")) {
				
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			
			}else {
				
			CadastroJAVA.lstRegistros.setListData(lista.toArray());
			
			registro = registro.replaceAll(",","\n");
			registro = registro.replace("[", "");
			registro = registro.replace("]", "");
			registro = registro.replace(" ", ";");
			registro = registro.replaceAll(";\n;", " \n");
			
			bw.write("\n"+registro);
			
			}
			
			bw.close();
			fw.close();
	}
	
	public static void limpaCampos() {
		
			CadastroJAVA.IDCliente.setText("");
			CadastroJAVA.NomeCliente.setText("");
			CadastroJAVA.Apelido.setText("");
			CadastroJAVA.CPF.setText("");
			CadastroJAVA.Endereco.setText("");
			CadastroJAVA.Estado.setText("");
			CadastroJAVA.Cidade.setText("");
			
	}
	
	public static void deletaRegistros(String arquivoCadClientes, String arquivoTemp, DefaultListModel lista) throws IOException {
		
		FileReader fr = null;  
        FileWriter fw = null;   
        BufferedReader br = null;  
        BufferedWriter bw = null;
        
        File arquivotemp = new File(arquivoTemp);
        File arquivonovo = new File(arquivoCadClientes);
        
        fr = new FileReader(new File(arquivoCadClientes));  
        fw = new FileWriter(new File(arquivoTemp)); 
        br = new BufferedReader(fr);
        bw = new BufferedWriter(fw);
        
        arquivotemp.createNewFile();
      
        String linha;
    	String selecionados[];
        String conteudo = CadastroJAVA.lstRegistros.getSelectedValue().toString();
       
        String registro = "";
        
             while ((linha = br.readLine()) != null) {  
            	 
            	 selecionados = linha.split(",");
            	 conteudo  = conteudo.replaceAll(" ",";");
            	 
            	  try {     
            		  
            		  
                 	if(!selecionados[0].contains(conteudo)){ 
                 		        
                 		lista.removeElementAt(CadastroJAVA.lstRegistros.getSelectedIndex());
          		
                 		CadastroJAVA.lstRegistros.setListData(lista.toArray()); 
                 		
                 		registro = lista.toString();
                 		
                 		registro = registro.replaceAll(",","\n");
            			registro = registro.replace("[", "");
            			registro = registro.replace("]", "");
            			registro = registro.replace(" ", ";");
            			registro = registro.replaceAll(";\n;", " \n");
            			registro = registro.replaceAll("\n;","\n");
            			
            			bw.write(registro);
                 	} 
                 	
            	  }catch(ArrayIndexOutOfBoundsException e){
            		  
            		
            	  }
            	  
            }
           br.close();
           bw.close();
           fr.close();
           fw.close();
           
         if(arquivonovo.exists()) {
           arquivonovo.delete();
           arquivotemp.renameTo(arquivonovo);
         }
	}

	public static String getExibelista() {
		return exibelista;
	}

	public static void setExibelista(String exibelista) {
		Configuracoes.exibelista = exibelista;
	}

	public static void pesquisa() {
		
		 pesquisados.removeAllElements();
				
		 for (int i = 0; i < lista.size(); i++) {   

            if (lista.get(i).contains(CadastroJAVA.Pesquisa.getText())) {
            	
            	pesquisados.addElement(lista.get(i));
            	
            }
 
		 }	
		 
	CadastroJAVA.lstRegistros.setListData(pesquisados.toArray());
	
	}
		
}


