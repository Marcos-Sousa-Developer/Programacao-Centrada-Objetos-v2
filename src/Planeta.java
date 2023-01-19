
import java.util.List;

/**Classe de objetos que representa o planeta 
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
*/

public class Planeta {
	
	/**Nome do planeta
	*/
	
	private String nome;
	
	/**Lista de propriedades do planeta
	*/
	
	public List<Propriedade> props;
	
	/**Dá os valores iniciais dos atributos do novo objeto
	 * @param nome - Nome do planeta
	 * @param props - Lista de propriedades do planeta
	 * @requires os elementos da lista props tem de ser do tipo Propriedade
	 */
	
	public Planeta(String nome, List<Propriedade> props) {
		this.nome=nome;
		this.props=props;			
	}
	
	/**Nome desse planeta
	 * @return String - Nome desse planeta
	 */
	
	public String nome() {
		return this.nome;
	}
	
	/**Verifica se a propriedade p, se encontra na lista de propriedades do planeta  
	 * @param p - A propriedade que se pretende verificar
	 * @return Boolean - Valor do resultado conforme a propriedade se encontra na lista de propriedades do planeta
	 */
	
	public boolean temPropriedade(Propriedade p) {
		if(this.props.contains(p)) {
			return true;
		}
		return false;
	}
	
	/**Verifica se todas as propriedades da lista props, se encontram na lista de propriedades do planeta  
	 * @param props - Lista de propriedades do planeta
	 * @return Boolean - Valor do resultado conforme todas as propriedades se encontrem na lista de propriedades do planeta
	 */
	
	public boolean temTodas(List<Propriedade> props) {
		for(Propriedade p: props) {
			if(!temPropriedade(p)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**Representaçãon textual deste planeta  
	 * @return String - Representação textual deste planeta
	 */
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(Propriedade p: this.props) {
			sb.append(p+" ");
		}
		return this.nome+": "+sb.toString();
	}
}






