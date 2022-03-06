package ui;

public class Main {

	  public static void main(String[] args) {

	    Conjunto<Integer> c1 = new ConjuntoImpl<>(1, 2, 3, 4);
	    Conjunto<Integer> c2 = new ConjuntoImpl<>(2, 3, 4, 5);
	    Conjunto<String> c3 = new ConjuntoImpl<>("A", "B", "C");
	    Conjunto<String> c4 = new ConjuntoImpl<>("A", "B", "C");

	    
	    System.out.println("c1 union c2:" + c1.union(c2));
	    System.out.println("c1 interseccion c2:" + c1.interseccion(c2));
	    System.out.println("c3 : " + c3);
	    System.out.println("c4 : " + c4);
	    System.out.println("c3 equal c4:" + c3.equals(c4));


	    c2 = (Conjunto<Integer>) ((ConjuntoImpl<Integer>) c1).clone();

	    System.out.println("\n----------------------------------------------------");

	    System.out.println("clonacion:" + c2.toString());

	    c1 = c1.union(c2);
	    System.out.println("union" + c1);

	    Conjunto<String> c1Name = new ConjuntoImpl<>("Juan", "David", "Sara");
	    ConjuntoImpl<String> c2Name = new ConjuntoImpl<>("Juan", "Jose", "Sara", "Laura");

	    Conjunto<String> interseccion = c1Name.interseccion(c2Name);
	    System.out.println("interseccion:" + interseccion);

	    System.out.println("diferencia:" + c1Name.diferencia(c2Name).toString());
	    System.out.println("complemento:" + c1Name.complemento(c2Name).toString());

	    Conjunto<Integer> cDiff = new ConjuntoImpl<>(1, 2, 3, 4);
	    Conjunto<Integer> cDiffDos = new ConjuntoImpl<>(1, 2, 3, 4, 5);

	    System.out.println(
	        "Subconjunto" + cDiff.toString() + " de " + cDiffDos + ": " + cDiffDos.subConjunto(cDiff));

	    System.out.println(
	        "Subconjunto Propio"
	            + cDiff.toString()
	            + " de "
	            + cDiffDos
	            + ": "
	            + cDiffDos.subConjuntoPropio(cDiff));


	    /*Conjunto<Par<Integer, String>> deepClone =
	        ((ConjuntoImpl<Par<Integer, String>>) pc).deepClone();
	    System.out.println("\n" + deepClone.toString());
	    System.out.println(c1.equals(c2));*/

	  }
	}