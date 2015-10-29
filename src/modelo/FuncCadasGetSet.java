package modelo;

public class FuncCadasGetSet {
	private String Nome;
	private String RG;
	private String CPF;
	private String DataNascimento;
	private String Sexo;
	private String Telefone;
	private String Celular;
	private String Email;
	private String CEP;
	private String Endereco;
	private int Numero;
	private String Complemento;
	private String Cidade;
	private String Bairro;
	private String UF;
	private String ACAO;

	public FuncCadasGetSet(String Nome, String RG, String CPF,
			String DataNascimento, String Sexo, String Telefone,
			String Celular, String Email, String CEP, String Endereco,
			int Numero, String Complemento, String Cidade, String Bairro,
			String UF, String ACAO) {
		this.Nome = Nome;
		this.RG = RG;
		this.CPF = CPF;
		this.DataNascimento = DataNascimento;
		this.Sexo = Sexo;
		this.Telefone = Telefone;
		this.Celular = Celular;
		this.Email = Email;
		this.CEP = CEP;
		this.Endereco = Endereco;
		this.Numero = Numero;
		this.Complemento = Complemento;
		this.Cidade = Cidade;
		this.Bairro = Bairro;
		this.UF = UF;
		this.ACAO = ACAO;
	}
	
	public FuncCadasGetSet(){
		
	}

	/**
	 * @return the Nome
	 */
	public String getNome() {
		return Nome;
	}

	/**
	 * @param Nome
	 *            the Nome to set
	 */
	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	/**
	 * @return the RG
	 */
	public String getRG() {
		return RG;
	}

	/**
	 * @param RG
	 *            the RG to set
	 */
	public void setRG(String RG) {
		this.RG = RG;
	}

	/**
	 * @return the CPF
	 */
	public String getCPF() {
		return CPF;
	}

	/**
	 * @param CPF
	 *            the CPF to set
	 */
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	/**
	 * @return the DataNascimento
	 */
	public String getDataNascimento() {
		return DataNascimento;
	}

	/**
	 * @param DataNascimento
	 *            the DataNascimento to set
	 */
	public void setDataNascimento(String DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	/**
	 * @return the Sexo
	 */
	public String getSexo() {
		return Sexo;
	}

	/**
	 * @param string
	 *            the Sexo to set
	 */
	public void setSexo(String string) {
		this.Sexo = string;
	}

	/**
	 * @return the Telefone
	 */
	public String getTelefone() {
		return Telefone;
	}

	/**
	 * @param Telefone
	 *            the Telefone to set
	 */
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}

	/**
	 * @return the Celular
	 */
	public String getCelular() {
		return Celular;
	}

	/**
	 * @param Celular
	 *            the Celular to set
	 */
	public void setCelular(String Celular) {
		this.Celular = Celular;
	}

	/**
	 * @return the Email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param Email
	 *            the Email to set
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

	/**
	 * @return the CEP
	 */
	public String getCEP() {
		return CEP;
	}

	/**
	 * @param CEP
	 *            the CEP to set
	 */
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	/**
	 * @return the Endereco
	 */
	public String getEndereco() {
		return Endereco;
	}

	/**
	 * @param Endereco
	 *            the Endereco to set
	 */
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}

	/**
	 * @return the Numero
	 */
	public int getNumero() {
		return Numero;
	}

	/**
	 * @param i
	 *            the Numero to set
	 */
	public void setNumero(int i) {
		this.Numero = i;
	}

	/**
	 * @return the Complemento
	 */
	public String getComplemento() {
		return Complemento;
	}

	/**
	 * @param Complemento
	 *            the Complemento to set
	 */
	public void setComplemento(String Complemento) {
		this.Complemento = Complemento;
	}

	/**
	 * @return the Cidade
	 */
	public String getCidade() {
		return Cidade;
	}

	/**
	 * @param Cidade
	 *            the Cidade to set
	 */
	public void setCidade(String Cidade) {
		this.Cidade = Cidade;
	}

	/**
	 * @return the Bairro
	 */
	public String getBairro() {
		return Bairro;
	}

	/**
	 * @param Bairro
	 *            the Bairro to set
	 */
	public void setBairro(String Bairro) {
		this.Bairro = Bairro;
	}

	/**
	 * @return the UF
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * @param UF
	 *            the UF to set
	 */
	public void setUF(String UF) {
		this.UF = UF;
	}
	
	public String getACAO() {
		return UF;
	}


	public void setACAO(String ACAO) {
		this.ACAO = ACAO;
	}
}
