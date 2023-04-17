package src.main.Java;
//import algo para data
//https://www.devmedia.com.br/manipulando-datas-em-java/21765 verificar com carinho
import java.util.Date;
public class Registro
{
	private Date data;
	private String tipo;
	private boolean entrada;
	private String nome;
	private double valor;

	public Registro(Date data, String tipo, boolean entrada, String nome, double valor)
	{
		this.data=data;
		this.tipo=tipo;
		this.entrada=entrada;
		this.nome=nome;
		this.valor=valor;
	}

	public Date getData()
	{
		return this.data;
	}
	public String getTipo()
	{
		return this.tipo;
	}
	public boolean getEntrada()
	{
		return this.entrada;
	}
	public String getNome()
	{
		return this.nome;
	}
	public double getValor()
	{
		return this.valor;
	}

	//sem sets? errou, apaga e faz de novo?

	@Override
	//não tenho certeza sobre a necessidade do toString.
	//está escrito, de qualquer formaa
	public String toString()
	{
		String mensagem="";
		mensagem+=getNome()+";";
		mensagem+=getValor()+";";
		mensagem+=getData()+";";
		mensagem+=getTipo()+";";
		mensagem+=getEntrada()+";";


		return mensagem;
	}
}
