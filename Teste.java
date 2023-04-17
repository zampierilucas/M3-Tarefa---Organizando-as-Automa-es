import java.util.*;

public class Teste
{
	public static void main(String [] args)
	{
		static int ANOATUAL=2023;//adquirir isto através do SO
		Categorias categorias = new Categorias();
		
		Date dataInicio, dataFim, dataRegistro;
		int dia, mes, ano;
		FolhaDeConta folhaTeste;
		Registro umRegistro;
		Scanner entrada = new Scanner(System.in);
		int controleRegistrar=-1;
		
		System.out.println("Criando uma nova folha de registros:");
		System.out.println("Data de inicio dos registros");
		dia=adquireDia();
		mes=adquireMes();
		ano=adquireAno();
		dataInicio=new Date(dia, mes, ano);
		
		System.out.println("Data de fim dos registros");
		dia=adquireDia();
		mes=adquireMes();
		ano=adquireAno();
		dataFim=new Date(dia, mes, ano);
		
		folhaTeste=new FolhaDeConta(Date dataInicio, Date dataFim);
		
		while(controleRegistrar<0||controleRegistrar>2)
		{
			System.out.println("Menu:");
			System.out.println("1-Criar registro\n2-Ver registros\n0-Sair\n>: ");
			controleRegistrar=entrada.nextInt();
			switch(controleRegistrar)
			{
				case 1:
				{
					System.out.println("Data do registro:"):
					dia=adquireDia();
					mes=adquireMes();
					ano=adquireAno();
					dataRegistro=new Date(dia, mes, ano);
					//List<String> categoriasSalvas=
					System.out.println("Nome do registro: ");
					String nomeRegistro=entrada.next();
					System.out.println("Valor do registro: ");
					double valorRegistro=entrada.nextDouble();		
					boolean isReceita=receitaOuDespesa();
					//int i=1;
					//esse bloco do nome pode ser melhorado!
					System.out.println("Categorias de registro: ");
					for(String nome: categorias.mostrarCategorias())
						System.out.println(nome);
					System.out.println("Digite o tipo do registro ou uma nova categoria: ");
					String tipoRegistro=entrada.next();
					if(!categorias.containsIgnoreCase(tipoRegistro))
						categorias.adicionarCategoria(tipoRegistro);
		
					umRegistro=new Registro(dataRegistro,tipoRegistro,isReceita,nomeRegistro,valorRegistro);
					
					if(insereRegistro(umRegistro))
						System.out.println("Registro salvo!");
					else
						System.out.println("Falha em salvar o registro!");
					controleRegistrar=-1;

				}
				case 2:
				{
					System.out.println("Registros efetuados:");
					System.out.println("ENTRADAS");
					if(folhaTeste.getEntrada()==NULL)
						System.out.println("Nenhuma entrada inserida");
					else
						System.out.println(folhaTeste.getEntrada());
					
					System.out.println("SAÍDAS");
					if(folhaTeste.getSaida()==NULL)
						System.out.println("Nenhuma saída inserida");
					else
						System.out.println(folhaTeste.getSaida());
					controleRegistrar=-1;
				}
				
				default:
					System.out.println("Valor inválido");
			}
		}
		entrada.close();
	}
	
	public static int adquireDia()
	{
		Scanner entrada = new Scanner(System.in);
		int novoDia=0;
		while(novoDia<=0 || novoDia>30)
		{
		System.out.println("entre com um dia válido: ");
			novoDia=entrada.nextInt();
		}
		entrada.close();
		return novoDia;
	}
	public static int adquireMes()
	{
		Scanner entrada = new Scanner(System.in);
		int novoMes=0;
		while(novoMes<1||novoMes>12)
		{
			System.out.println("entre com um mês válido: ");
			novoMes=entrada.nextInt();
		}
		entrada.close();
		return novoMes;
	}
	public static int adquireAno()
	{
		Scanner entrada = new Scanner(System.in);
		int novoAno=0;
		while(novoAno<ANOATUAL)
		{
			System.out.println("entre com um ano válido: ");
			novoAno=entrada.nextInt();
		}
		entrada.close();
		return novoAno;
		
	}
	public static boolean receitaOuDespesa()
	{
		Scanner entrada = new Scanner(System.in);
		char resposta='';
		while(resposta!='R'||resposta!='r'||resposta!='D'||resposta!='d')
		{
			System.out.println("O registro é uma (R)eceita ou (D)espesa?: ");
			resposta=entrada.nextChar();
		}
		entrada.close();
		if(resposta=='R'||resposta=='r')
			return true;
		return false;
	}
}