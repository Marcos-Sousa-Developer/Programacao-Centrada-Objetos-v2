import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class teste {
	
	public static void main(String[] args) {
		
		List<Propriedade> props = new ArrayList<Propriedade>(Arrays.asList(Propriedade.values()));
		
		//List<Propriedade> props1 = Arrays.asList(new Propriedade[] {Propriedade.HAS_WATER,Propriedade.FRIENDLY});
		
		//Planeta planeta = new Planeta("Pasiphae", props1);
		
		//System.out.println(planeta.temPropriedade(Propriedade.HAS_LIGHT));
		
		//System.out.println("O planeta Pasiphae tem as propriedades " + props.toString() + "? " + planeta.temTodas(props)); 
		
		List<Propriedade> props1 = Arrays.asList(new Propriedade[] 
				{Propriedade.HAS_WATER,Propriedade.FRIENDLY});
		List<Propriedade> props2 = Arrays.asList(new Propriedade[] 
				{Propriedade.BREATHABLE,Propriedade.HAS_WATER,Propriedade.HAS_LIGHT});
		List<Propriedade> props3 = Arrays.asList(new Propriedade[] 
				{Propriedade.FRIENDLY,Propriedade.BREATHABLE});
		
		Planeta[][] result = { 
				{ new Planeta("Pasiphae", props1),   // HAS_WATER,FRIENDLY
					new Planeta("Paaliaq", props2),  // BREATHABLE,HAS_WATER,HAS_LIGHT
					new Planeta("Kalliope", props1)  // HAS_WATER,FRIENDLY
				} ,
				{ new Planeta("Linus", props3),      // FRIENDLY,BREATHABLE
					new Planeta("Amalthea", props2), // BREATHABLE,HAS_WATER,HAS_LIGHT
					new Planeta("Ganymede", props3)  // FRIENDLY,BREATHABLE
				} ,
				{ new Planeta("Ananke", props2),     // BREATHABLE,HAS_WATER,HAS_LIGHT
					new Planeta("Eurydome", props3), // FRIENDLY,BREATHABLE
					new Planeta("Orthosie", props1)  // HAS_WATER,FRIENDLY
				} ,
				{ new Planeta("Kallichore", props2), // BREATHABLE,HAS_WATER,HAS_LIGHT
					new Planeta("Cyllene", props3),  // FRIENDLY,BREATHABLE
					new Planeta("Eukelade", props2)  // BREATHABLE,HAS_WATER,HAS_LIGHT
				}
		};
		
		SistemaSolar sistema = new SistemaSolar("Tarvos",result);
		
		//System.out.println(Arrays.toString(result[0]));
		
		System.out.println(sistema.temPlaneta("Cyllene"));
		
		
	}

}
