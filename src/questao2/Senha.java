package questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Senha {
	
	private String senha;
	private int tamanho;

	public Senha(String senha) {
		this.senha = senha;
		this.tamanho = this.getSenha().length();
	}
	
	private String getSenha() {
		return senha;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	private boolean verificaRegex(String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(this.getSenha());
		return m.find();
	}
	
	private boolean temNoMinimo6Caracteres() {
		return this.getTamanho() >= 6;
	}
	
	private boolean temMaiuscula() {
		return this.verificaRegex("[A-Z]");
	}
	
	private boolean temMinuscula() {
		String regex = "[a-z]";
		return this.verificaRegex(regex);
	}
	
	private boolean temDigito() {
		return this.verificaRegex("\\d");
	}
	
	private boolean temCaracterEspecial() {
		return this.verificaRegex("[!@#$%^&*()-+]");
	}
	
	public boolean aSenhaEhSegura() {
		return	this.temNoMinimo6Caracteres() && this.temDigito() &&
		 		this.temMaiuscula() && this.temMinuscula() &&
		 		this.temCaracterEspecial();
    }
	
	public List<String> caracteresFaltando() {
		List<String> caracteres = new ArrayList<String>();
		if (!this.temDigito()) {caracteres.add("digito");};
		if (!this.temMaiuscula()) {caracteres.add("maiuscula");};
		if (!this.temMinuscula()) {caracteres.add("minuscula");};
		if (!this.temCaracterEspecial()) {caracteres.add("especial");};
		
		return caracteres;
	}
	
	private int qtdCaracteresParaChegarEm6() {
		if (!this.temNoMinimo6Caracteres()) {
			return 6 - this.getTamanho();
		}
		return 0;
	}
	

	public int qtdMinimaCaracteres() {
		if (this.aSenhaEhSegura()) {
			return 0;
		}
		
		List <String> caracteres = this.caracteresFaltando();
		int qtdCaracteres = caracteres.size();
		int qtdCaracteresRestante = this.qtdCaracteresParaChegarEm6() - caracteres.size();
		
		if ((qtdCaracteres + this.tamanho) < 6) {
			return qtdCaracteres + qtdCaracteresRestante;
		}
		
		return qtdCaracteres;
	}
	
	
}
