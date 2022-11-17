/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAXB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author joange
 */
public class CreateXML {
    
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        String fileName="Libros.xml";
        Book b= new Book(1L, "El problema de los tres cuerpos", "Xicin Liu", new Date(System.currentTimeMillis()));
        System.out.println("Original-> " + b);
        JAXBContext context= JAXBContext.newInstance(Book.class);
        
        Marshaller mar=context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(b, new File(fileName));
        
        Unmarshaller um=context.createUnmarshaller();
        Book b2=(Book)um.unmarshal(new FileReader(fileName));
        
        System.out.println("Guardado-> "+b2);
        
    }
}
