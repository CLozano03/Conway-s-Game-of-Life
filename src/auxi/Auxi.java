package auxi;
/** 
 * Funciones auxiliares. 
 *
 * @author Javier Galve
 */
public class Auxi
{ 
  /**
   FUNCION enIntervalo (Real x, a, b) ---> Boolean 
   POST: Devuelve cierto si y solo si x está en el intervalo [a, b] 
   POST: resultado = a <= x <= b
   */
  public static boolean enIntervalo (double x, double a, double b)
  {
    return a <= x && x <= b;
  } 
  /**
   FUNCION esIgual (Real x, y) ---> Boolean 
   POST: Comparador de igualdad entre reales por aproximación
   de un EPSILON fijado localmente.
   Devuelve cierto si y solo si x = y +- EPSILON
   DONDE: EPSILON = <<error de precisión>>
   POST: Devuelve cierto si y solo si x está en el 
   intervalo [y + EPSILON, y - EPSILON] 
   */
  public static boolean esIgual (double x, double y)
  {
    final double EPSILON = 0.001;
    return enIntervalo(x, y - EPSILON, y + EPSILON);
  } 
  /**
   FUNCION cuadratica (Entero a, b, c, x) --> Entero
   POST: Calcula a*x^2+b*x+c.
   */
  public static int cuadratica (int a, int b, int c, int x)
  {
    return a * (int)Math.pow(x, 2) + b * x + c;
  }
  /**
   FUNCION posicionMayor (Entero posA, valorA, posB, valorB) 
   --> Entero
   POST: Dados dos valores enteros valorA y valorB y sus 
   posicioines respectivas, posA y posB, devolver 
   la posición del que sea mayor de los dos valores.
   valorA >= valorB  --> posA
   eoc               --> posB
   */ 
  public static int posicionMayor (int posA, int valorA, int posB, int valorB)
  {
    if (valorA >= valorB)
      return posA;
    else
      return posB;
  }
  /**
   FUNCION delta (Booleano p) --> Entero
   POST: p   --> resultado = 1
   eoc --> resultado = 0
   */ 
  public static int delta (boolean p) 
  {
    if (p) 
      return 1;
    else
      return 0;
    //return p? 1 : 0;
  }
  /*
   * aleatorio (n : int) : int
   * POST: Genera un número aleatorio en el rango [0, |n-1|] 
   */       
  public static int aleatorio (int n) { 
    return (int)(Math.random() * Math.abs(n));
  }
  /*
   * aleatorio (a, b : int) : int
   * POST: Genera un número aleatorio en el rango [a, b] 
   */       
  public static int aleatorio (int a, int b) { 
    return (int)(Math.random() * Math.abs(b-a+1)) + a;
  }
  /*
   FUNCION parteDecimal (Real y) ---> Real 
   PRE: cierto
   POST: resultado es la parte decimal del número real "y"
   */
  public static double parteDecimal (double y)
  {
    return y - (int) y;
  }
  /*
   FUNCION aMayuscula (Caracter letra) ---> Caracter 
   PRE: letra IN ['a','z']
   POST: resultado es la mayuscula correspondiente a "letra"
   */
  public static char aMayuscula (char letra)
  {
    return (char)(letra - 'a' + 'A');
  }
  /* 
   FUNCIÓN aMinuscula (Caracter letra) ---> Caracter 
   PRE: letra IN ['A','Z']
   POST: resultado es la minuscula correspondiente a "letra"
   */
  public static char aMinuscula (char letra)
  {
    return (char)(letra - 'A' + 'a');
  }
  /* 
   ACCIÓN esperar1segundo ()
   EFECTO: Pausa la ejecución durante un segundo.
   */
  private static void espera1segundo ()
  {
    double ahora = System.currentTimeMillis();
    double dentroDe1Seg = ahora + 1000; 
    while (System.currentTimeMillis() < dentroDe1Seg);
  }
  /* 
   ACCIÓN espera (Natural segundos)
   EFECTO: Pausa la ejecución durante <segundos>.
   */
  public static void espera (int segundos)
  {
    for (int i = 1; i <= segundos; i++)
      espera1segundo();
  }

}