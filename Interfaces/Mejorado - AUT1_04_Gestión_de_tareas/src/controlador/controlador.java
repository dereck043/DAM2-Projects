/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import vista.modelo.tarea;

/**
 *
 * @author dama
 */
public class controlador {
    String fileName;

    public controlador(String fileName) {
        this.fileName = fileName;
    }
    
    
    public ArrayList<tarea> tareas = new ArrayList<tarea>();

    public ArrayList<tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<tarea> tareas) {
        this.tareas = tareas;
    }
    
    public void iniciador() throws ParseException{
        try {
            File tareaFile = new File(fileName);
            if (!tareaFile.createNewFile()) {
                leerTareas(tareaFile);
            }
        }catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
    
    public void leerTareas(File file) throws IOException, ParseException{
        String cadena;
        DateFormat format = new SimpleDateFormat("EEEE MMMM d HH:mm:ss z yyyy", Locale.ENGLISH);
        Date date;
        FileReader f = new FileReader(file.getName());
        try (BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                tareas.add(new tarea(cadena.split(";")[0], format.parse(cadena.split(";")[1]),cadena.split(";")[2]));
            }
        }
    }
    
    public void escribirTareas(String nombreTarea, Date fecha, String realizado){
        
        try {
            FileWriter tarea = new FileWriter(fileName, true);
            tarea.write(nombreTarea+";"+fecha+";"+realizado+"\n");
            tarea.close();
            tareas.add(new tarea(nombreTarea,fecha,realizado));
         } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
         }
    }

    public String todasLasTareas() {
        String todasLasTareas = "";
        for (tarea tarea : tareas) {
            todasLasTareas += tarea.getNombre() + " ["+tarea.getFecha() + "] Realizada: "+tarea.getRealizado()+"\n";
        }
        return todasLasTareas;
    }

    public void removerTarea(int i) throws IOException {
        tareas.remove(i); 
    }
    
    public void rescribeTarea() throws IOException{	
        FileWriter writer = new FileWriter(fileName, false);
        for (tarea tarea1 : tareas) {
            writer.write(tarea1.getNombre()+";"+tarea1.getFecha()+";"+tarea1.getRealizado()+"\n");
        }
        
        writer.close();
    }
    
    
    
}
