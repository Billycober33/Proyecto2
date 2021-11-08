/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
/**
 *
 * @author Elian Cordova
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner Leer = new Scanner(System.in);
        int LeerOpcion;
        char answer;
        char answerCourseA = 's';
        char answerCourseR = 's'; 
        int leeranswer;
        ObjectOutputStream WriteEstudiante = null;
        ObjectInputStream ReadingEstudiantes = null;
        Estudiantes estudiante;
        
        
        
        
        System.out.println(""" 
                           -----------------------------
                           Analisis de Datos Estudiantes
                           -----------------------------
                           """);
        
        System.out.println("1. Ingreso de datos");
        System.out.println("2. Análisis de Datos ");
        System.out.println("3. Salir");
        
        System.out.println("Ingrese una Opcion: ");
        LeerOpcion = Integer.valueOf(Leer.nextLine());
        
        
        
        if(LeerOpcion == 1){
        try{
            if(Files.exists(Paths.get("Estudiantes.txt"))){
                WriteEstudiante = new AddingObjectOutputStream(Files.newOutputStream(Paths.get("Estudiantes.txt"), StandardOpenOption.APPEND));
            }else{
                WriteEstudiante = new ObjectOutputStream(Files.newOutputStream(Paths.get("Estudiantes.txt")));
            }   
            do {
                
            estudiante = new Estudiantes();
            
            System.out.println("""
                               ---------------------------------
                               INGRESE LOS DATOS DEL ESTUDIANTE
                               ---------------------------------
                               """);
            
            System.out.println("NOMBRE: ");
            estudiante.setNombres(Leer.nextLine());
            System.out.println("APELLIDOS: ");
            estudiante.setApellidos(Leer.nextLine());
            System.out.println("CARNE: ");
            estudiante.setCarne(Leer.nextLine());
            System.out.println("EDAD: ");
            estudiante.setEdad(Integer.valueOf(Leer.nextLine()));
            System.out.println("SEXO: ");
            estudiante.setSexo(Leer.nextLine());
             System.out.println("CARRERA: ");
            estudiante.setCarrera(Leer.nextLine());
            System.out.println("TOTAL CREDITOS OBTENIDOS: ");
            estudiante.setTotalCreditos(Integer.valueOf(Leer.nextLine()));
            System.out.println("CANTIDAD CURSOS APROBADOS: ");
            estudiante.setCantCursosAprobados(Integer.valueOf(Leer.nextLine()));
            // need to create bucle to make new question of add other course
            System.out.println("<<<<<<< CURSO APROBADOS >>>>>>>>");
            do{
                
            System.out.println("SEMESTRE: ");
            estudiante.setSemestreCA(Integer.valueOf(Leer.nextLine()));
            System.out.println("NOMBRE: ");
            estudiante.setCursoNombreCA(Leer.nextLine());
            System.out.println("CODIGO DEL CURSO: ");
            estudiante.setCursoCodigoCA(Leer.nextLine());
            System.out.println("ZONA OBTENIDA DEL CURSO: ");
            estudiante.setZonaCA(Integer.valueOf(Leer.nextLine()));
            System.out.println("NOTA FINAL: ");
            estudiante.setNotaCA(Integer.valueOf(Leer.nextLine()));
            System.out.println("FECHA DE APROBACION: ");
            estudiante.setFechaCA(Leer.nextLine());
            
            System.out.println("\n Desea Agregar otro Curso Aprobado? (s/n)");
            answerCourseA = Leer.nextLine().toLowerCase().charAt(0);
            } while (answerCourseA == 's');
            
            // need to create bucle to make new question of add other course
            System.out.println("<<<<<<<<<<< CURSOS REPROBADOS >>>>>>>>>>>");
            do{
            System.out.println("SEMESTRE: ");
            estudiante.setSemestreCR(Integer.valueOf(Leer.nextLine()));
            System.out.println("NOMBRE: ");
            estudiante.setCursoNombreCR(Leer.nextLine());
            System.out.println("CODIGO DEL CURSO: ");
            estudiante.setCursoCodigoCR(Leer.nextLine());
            System.out.println("ZONA OBTENIDA DEL CURSO: ");
            estudiante.setZonaCR(Integer.valueOf(Leer.nextLine()));
            System.out.println("NOTA FINAL: ");
            estudiante.setNotaCR(Integer.valueOf(Leer.nextLine()));
            System.out.println("FECHA DE APROBACION");
            estudiante.setFechaCR(Leer.nextLine());
            System.out.println("\n Desea Agregar otro Curso Reprobado? (s/n)");
            answerCourseR = Leer.nextLine().toLowerCase().charAt(0);
            } while (answerCourseR == 's');
            
            WriteEstudiante.writeObject(estudiante);
            System.out.println("\nDatos Ingresados Con Exito!!! \nDesea ingresar Otro Estudiante? (s/n)");
            answer = Leer.nextLine().toLowerCase().charAt(0);
        } while (answer == 's');
            
            WriteEstudiante.close();
            
        } catch(Exception e){
        }
        
        
            
            
            
        } else if(LeerOpcion == 2){
            System.out.println("Vamos a Analisar Datos");
         
        try{
            
            System.out.println("1. Datos personales de Estudiantes");
            System.out.println("2. Cantidad de Estudiantes masculinos y femeninos");
            System.out.println("3. Mejor promedio de Cada Carrera");
            System.out.println("4. Datos Academicos de Estudiantes");
            System.out.println("5. Constancia de Cursos Aprobados");
            System.out.println("6. Salir");
            
            System.out.println("Seleccione el reporte que desea Generar");
            leeranswer = Integer.valueOf(Leer.nextLine());
            
            if(leeranswer == 1){
            
           
            System.out.println("""
                                   ----------------------------------------------------------
                                                 ANALISIS DE DATOS DE ESTUDIANTES
                                                        Analisis de Datos
                                                  Datos personales de Estudiantes
                                   ----------------------------------------------------------
                                   """);
            System.out.println("Nombres\t\t\t" + "Apellidos\t\t" + "Edad \t" + "Sexo \t\t");
                ReadingEstudiantes = new ObjectInputStream(Files.newInputStream(Paths.get("Estudiantes.txt")));
            
            while(true){
            estudiante = (Estudiantes) ReadingEstudiantes.readObject();    
                System.out.println(estudiante.getNombres() +"\t\t "  +  estudiante.getApellidos() +" \t" +  estudiante.getEdad() +"\t " +  estudiante.getSexo());  
            } 
            }
            //opcion 2
            else if(leeranswer == 4){
                System.out.println("""
                                   ----------------------------------------------------------
                                                 ANALISIS DE DATOS DE ESTUDIANTES
                                                        Analisis de Datos
                                                  Datos Academicos de Estudiantes
                                   ----------------------------------------------------------
                                   """);
                System.out.println("Nombre\t\t\t Apellidos \t\t Carne \t Carrera \t Total Creditos \t Cursos Aprobados \t Cursos Reprobados" );
                    ReadingEstudiantes = new ObjectInputStream(Files.newInputStream(Paths.get("Estudiantes.txt")));
            
                while(true){
                    estudiante = (Estudiantes) ReadingEstudiantes.readObject();    
                    //System.out.printf("%10s %40st %20s %20s \n",estudiante.getNombres(), estudiante.getApellidos(), estudiante.getEdad(), estudiante.getSexo());  
                    System.out.println(estudiante.getNombres() +"\t\t "  +  estudiante.getApellidos() +" \t" + estudiante.getCarne() +" \t" + estudiante.getCarrera() +" \t" + estudiante.getTotalCreditos() +" \t" + estudiante.getCursosAprobados() +" \t" + estudiante.getCursosReprobados());  
                
                }
            
            }
             
        }
        catch(EOFException endOfFileException){
            System.out.printf("%s%n", "No hay mas registros");
        }
        catch(Exception e){
        }
        finally {
           ReadingEstudiantes.close();   
        }
                    
        } else if (LeerOpcion == 3){
            System.out.println("Esperamos Verte Pronto!!");
        }
    }
    
}
