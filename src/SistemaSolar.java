import java.util.ArrayList;
import java.util.List;

/**Classe de objetos que representa o Sistema Solar
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
*/

public class SistemaSolar {
	
	/**Nome do Sistema Solar
	*/
	
	private String nome;
	
	/**Lista bi-dimensional dos planetas
	*/
	
	private Planeta[][] planetas;

	/**Dá os valores iniciais dos atributos do novo objeto
	 * @param nome - Nome do Sistema Solar
	 * @param planetas - Lista bi-dimensional dos planetas do Sistema Solar
	 * @requires universoValido(planetas) = true 
	 */
	
	public SistemaSolar(String nome, Planeta[][] planetas) {
		this.nome=nome;
		this.planetas=planetas;	
	}
	
	/**Verifica se a lista bi-dimensional arrayBi é uma matriz
	 * @param arrayBi - Lista bi-dimensional dos planetas do Sistema Solar
	 * @return Boolean - Valor do resultado conforme se verifique se a lista bi-dimensional é uma matriz
	 */
	
	private static boolean isMatrix(Planeta[][] arrayBi) {
		for(Planeta[] conjunto:arrayBi) {
			if(conjunto.length!=arrayBi[0].length) {
				return false;
			}
		}
		return true;
	}
	
	/**Verifica se a lista bi-dimensional arrayBi é uma matriz
	 * @param arrayBi - Lista bi-dimensional dos planetas do Sistema Solar
	 * @return Boolean - Valor do resultado conforme se verifique se a lista bi-dimensional é uma matriz
	 */
	
    public static boolean universoValido(Planeta[][] arrayBi){
    	if(!isMatrix(arrayBi)) {
    		return false;
    	}
    	for(Planeta[] conjunto:arrayBi) {
    		for(Planeta planeta:conjunto) {
    			if(planeta.equals(null)) {
    				return false;
    			}
    		}
    	}
    	return true;	
    }

    /**Nome desse Sistema Solar
	 * @return String - Nome desse Sistema Solar
	 */
    
    public String nome() {
    	return this.nome;
    }
    
    /**
     * Procura no Sistema Solar se existe um planeta com o nome dado
     * @param nome - Nome do planeta que se pretende verificar 
     * @return Boolean - Valor do resultado conforme se verifique se o planeta existe no Sistema Solar
     */
    
    public boolean temPlaneta(String nome) {
    	for(Planeta[] conjunto:this.planetas) {
    		for(Planeta planeta:conjunto) {
    			if(planeta.nome().equals(nome)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    /**
     * Verifica se todas as propriedades da lista props se encontram na lista de propriedades de cada planeta do Sistema Solar
     * @param props - Lista de propriedades que se pretende verificar
     * @return String[] - Lista com o nome dos planetas que têm todas as propriedades
     */
    
    public List<String> comPropriedades(List<Propriedade>props){
    	List<String> nomesPlanetas = new ArrayList<String>();
    	for(Planeta[] conjunto:this.planetas) {
    		for(Planeta planeta:conjunto) {
    			if(planeta.props.containsAll(props)) {
    				nomesPlanetas.add(planeta.nome());
    			}
    		}
		}
    	return nomesPlanetas;
    }
    
    /**
     * Conta quantas vezes é que as propriedades de Propriedade são encontradas em todos os planetas
     * @return int[] - Devolve um vetor	em que o i-ésimo elemento representa o	número de planetas deste sistema solar	
     * que tem a i-ésima propriedade do vetor
     */
    
    public int[] quantosPorPropriedade() {
    	Propriedade[] listaPropriedades= Propriedade.values();
    	int[] ocorrenciasPorPropriedade=new int[listaPropriedades.length];
    	int indice = 0;
    	for(Propriedade propriedade:listaPropriedades) {
    		for(Planeta[] conjunto:this.planetas) {
        		for(Planeta planeta:conjunto) {
        			if(planeta.props.contains(propriedade)) {
        				ocorrenciasPorPropriedade[indice]+=1;
        			}
        		}
    		}
    		indice++;
    	}
    	return ocorrenciasPorPropriedade;
    }
    
    /**
     * Verifica se o n-ésimo planeta contém todas as propriedades da lista props 
     * @param props - Lista de propriedades que se pretende verificar
     * @param n - Posição do planeta na lista bi-dimensional de planetas que queremos verificar 
     * @return Boolean - Valor do resultado conforme se o n-ésimo planeta deste	sistema	solar tem todas as propriedades referidas na lista props;
     */
    
    public boolean nEsimoTem(int n, List<Propriedade> props) {
        int numeroPlaneta=0;
        int linha = 0;
        while (numeroPlaneta <= n) {
                 if(linha%2==0) { 
                     for(int coluna=0;coluna<this.planetas[linha].length;coluna++) {
                         if(numeroPlaneta==n) {
                             return this.planetas[linha][coluna].props.containsAll(props);
                         }
                         numeroPlaneta++;
                     }
                 }
                 else {
                    for(int coluna=this.planetas[linha].length-1;coluna>=0;coluna--) {                     
                        if(numeroPlaneta==n) {
                            return this.planetas[linha][coluna].props.containsAll(props);
                        }
                        numeroPlaneta++;
                    }
                 }              
                 if (numeroPlaneta%(this.planetas.length*this.planetas[linha].length)==0) {
                     linha = 0;
                 } else {
                     linha++; 
                 }
            }
        return false;
    }
    
    /**
     * Verifica qual a propriedade que aparece mais vezes
     * @return Propriedade - devolve a propriedade	que	aparece	mais vezes nos planetas	deste sistema solar;
     */
    
    public Propriedade maisFrequente() {
    	int[] ocorrencias= quantosPorPropriedade();
    	int indiceMaisFrequente=0;
    	int maiorValor=0;
    	Propriedade[] p = Propriedade.values();
    	for(int indice=0;indice<ocorrencias.length;indice++) {
    		if(ocorrencias[indice]>maiorValor) {
    			maiorValor=ocorrencias[indice];
    			indiceMaisFrequente=indice;
    		}
    	}
    	return p[indiceMaisFrequente];
    }
    
	/**Representação textual deste Sistema Solar 
	 * @return String - Representação textual deste Sistema Solar
	 */
    
    public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(this.nome+"\n");
		for(Planeta[] conjunto:this.planetas) {
    		for(Planeta planeta:conjunto) {
    			sb.append(planeta);
    			
    		}
    		sb.append("\n");
		}
		return sb.toString();
	}
    

    
    
}
