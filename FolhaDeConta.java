import java.util.*;
//dentro do util, já tem date
public class FolhaDeConta
{
	private Date dataInicio, dataFim;
	private List<Registro> entrada;
	private List<Registro> saida;
	
	public FolhaDeConta(Date dataInicio, Date dataFim)
	{
		this.dataInicio=dataInicio;
		this.dataFim=dataFim;
		entrada=new ArrayList<>();
		saida=new ArrayList<>();
	}
	
	public Date getDataInicio()
	{
		return this.dataInicio;
	}
	public Date getDataFim()
	{
		return this.dataFim;
	}
	public List<Registro> getEntrada()
	{
		return this.entrada;
	}
	public List<Registro> getSaida()
	{
		return this.saida;
	}
	//vão ser necessários sets?
	
	public boolean insereRegistro(Registro novoRegistro)
	{
		if(novoRegistro.getEntrada() && this.testData(novoRegistro.getData()))
		{
			entrada.add(novoRegistro);
			return true;
		}
		if(!novoRegistro.getEntrada() && this.testData(novoRegistro.getData()))
		{
			saida.add(novoRegistro);
			return true;
		}
		return false;
		//melhorar o retorno do problema de não inserção?
		//faço ordenação?
	}
	
	private boolean testData(Date umaData)
	{
		if(umaData.compareTo(this.getDataFim())>0 || umaData.compareTo(this.getDataInicio())<0)//melhorar os sinais
			return false;
		return true;
	}
}