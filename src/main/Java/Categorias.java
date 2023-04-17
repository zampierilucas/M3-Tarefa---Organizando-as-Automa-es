package src.main.Java;
import java.util.*;

public class Categorias
{
	private List <String> tipos;

	public Categorias()
	{
		tipos=new ArrayList<>();
		tipos.add("Mercado");
		tipos.add("Restaurante");
		tipos.add("Contas");
		tipos.add("Lazer");
		tipos.add("Salário");
	}

	public boolean adicionarCategoria(String novoTipo)
	{
		if(tipos.contains(novoTipo))
			return false;
		else
			tipos.add(novoTipo);
		return true;
	}
	//precisamos de gets?
	public ArrayList mostrarCategorias()
	{
		return tipos;
	}

	@Override
	public String toString()
	{
		String mensagem="";

		for(String item:tipos)
			mensagem+=item+";";


		return mensagem;
	}
}
