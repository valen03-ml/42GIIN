import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
			//Declaramos las variables u objetos necesarios
				
			int option = 0;
			Scanner entradaDatos = new Scanner(System.in);
			String nombreFichero ="";
			String decision = "";
			String addDatos = "";
			File f = null;
			FileWriter fw = null;
			PrintWriter pw = null;
				
			//Realizamos el menú
			do {
				System.out.println("");
				System.out.println("*********************");
				System.out.println("EDITOR DE TEXTO");
				System.out.println("*********************");
				System.out.println("");
				System.out.println("Seleccione una opción:");
				System.out.println("1) Crear un fichero");
				System.out.println("2) Editar un fichero");
				System.out.println("3) Borrar un fichero");
				System.out.println("4) Crear una carpeta");
				System.out.println("5) Borrar una carpeta");
				System.out.println("0) Salir");
				System.out.print("Opción: ");
				option = entradaDatos.nextInt();
							
				//En caso de que el usuario quiera crear un fichero (opción 1)
							
				if(option == 1)
				{
					System.out.println("");
					System.out.print("Introduzca el nombre del nuevo fichero: ");
					nombreFichero = entradaDatos.next();
						
					f = new File(nombreFichero);
						
					if(f.exists())
					{
						//Si el fichero introducido por el usuario existe preguntaremos si quiere sobreescribirlo o no
							
						System.out.println("");
						System.out.print("Fichero existente ¿Desea sobreescribirlo? SI/NO: ");
						decision = entradaDatos.next();
							
						if(decision.toUpperCase().equals("SI"))
						{
							//Si el usuario decide que SI, lo sobreescribimos machacando lo que había por el string vacío ""
							try 
							{
								fw = new FileWriter(f);
								pw = new PrintWriter(fw);
									
								pw.println("");
									
								pw.close();
								fw.close();
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
						}
					}
					else
					{
						//Si el fichero introducido por el usuario NO existe lo creamos vacío	
						try 
						{
							fw = new FileWriter(f);
							pw = new PrintWriter(fw);
							
							pw.close();
							fw.close();
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}	
				//En caso de que el usuario quiera editar un fichero (opción 2)
							
				if(option == 2)
				{
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a editar: ");
					nombreFichero = entradaDatos.next();
						
					f = new File(nombreFichero);
						
					if(f.exists())
					{
						//Si el fichero introducido por el usuario existe le pediremos que introduzca lo que quiere añadir	
						System.out.println("");
						System.out.print("Introduzca el texto que desea añadir al fichero: ");
						entradaDatos.nextLine();
						addDatos = entradaDatos.nextLine();
							
						//Abrimos el fichero y añadimos el texto introducido por el usuario
						try 
						{
							fw = new FileWriter(f, true);
							pw = new PrintWriter(fw);
								
							pw.println(addDatos);
								
							pw.close();
							fw.close();
						} 
						catch (IOException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
						//Confirmamos al usuario que se ha editado correctamente
						System.out.println("");
						System.out.println("Documento editado correctamente");	
					}
					else
					{
						//Si el fichero introducido por el usuario NO existe le diremos al usuario que ese fichero es inexistente	
						System.out.println("");
						System.out.println("Fichero inexistente");
					}	
				}
							
				//En caso de que el usuario quiera borrar un fichero (opción 3)		
				if(option == 3)
				{
					System.out.println("");
					System.out.print("Introduzca el nombre del fichero a borrar: ");
					nombreFichero = entradaDatos.next();
						
					f = new File (nombreFichero);
						
					if(f.exists())
					{
						System.out.println("");
						System.out.print("¿Está seguro de que quiere borrarlo? (Afirmación S): ");
						decision = entradaDatos.next();
							
						if(decision.equals("S"))
						{
							if(f.delete())
							{
								System.out.println("");
								System.out.println("Fichero eliminado correctamente");
							}
						}
						else
						{
							System.out.println("");
							System.out.println("El fichero no se borró del sistema");
						}
					}
				}			
				//En caso de que el usuario quiera crear una carpeta (opción 4)			
				if(option == 4)
				{
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a crear: ");
					nombreFichero = entradaDatos.next();
						
					f = new File(nombreFichero);
						
					if(f.exists())
					{
						//Si la carpeta ya existe se lo indicaremos al usuario y nos salimos al menú
							
						System.out.println("");
						System.out.println("Carpeta ya existente");
					}
					else
					{
						if(f.mkdir())
						{
							System.out.println("");
							System.out.println("Carpeta creada correctamente");
						}
					}	
				}	
				//En caso de que el usuario quiera borrar una carpeta (opción 5)		
				if(option == 5)
				{
					System.out.println("");
					System.out.print("Introduzca el nombre de la carpeta a borrar: ");
					nombreFichero = entradaDatos.next();
						
					f = new File(nombreFichero);
						
					if(f.exists())
					{
						//Si la carpeta existe preguntaremos al usuario confirmación de borrado	
						System.out.println("");
						System.out.print("¿Está seguro de que desea borrar la carpeta? (Afirmación S): ");
						decision = entradaDatos.next();
							
						if(decision.equals("S"))
						{
							//Si el usuario confirma el borrado lo realizamos y mostramos por pantalla el éxito de la tarea
								
							if(f.delete())
							{
								System.out.println("");
								System.out.println("Carpeta borrada correctamente");
							}
						}
						else
						{
							//Si el usuario no confirma el borrado se le dirá que no se ha borrado y volvemos al menú
								
							System.out.println("");
							System.out.println("La carpeta no se borró del sistema");
						}	
					}
					else
					{
						System.out.println("");
						System.out.println("La carpeta no existe");
					}
				}					
				//Establecemos un mensaje en el caso de que el usuario introduzca una opción distinta a las mostradas en el menú		
				if(option < 0 || option > 5)
				{
					System.out.println("");
					System.out.println("Opción errónea");
					System.out.println("");
				}			
				//Establecemos un mensaje de finalización de programa en caso de que el usuario introduzca la opción 0. Salir		
				if(option == 0)
				{
				System.out.println("");
				System.out.println("Programa finalizado");
				}
			}
			while(option != 0 );
		}
	}
