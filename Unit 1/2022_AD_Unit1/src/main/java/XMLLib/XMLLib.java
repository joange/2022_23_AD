/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLLib;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import Sample6.Modul;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author joange
 */
public class XMLLib {

    public Document OpenXML(String name) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException {
        // Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // Using the DocumentBuilderFactory instance we create a DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        //And we use DocumentBuilder's "parse" method to get the document
        Document doc = dBuilder.parse(new File(name));

        return doc;
    }

    public void ShowXML(Document doc) throws IOException {

        Element root = doc.getDocumentElement();

        // We will get a list of nodes (Step 1)
        NodeList modules = root.getElementsByTagName("modul");

        // For each node (Step 2)
        for (int i = 0; i < modules.getLength(); i++) {
            Element el = (Element) modules.item(i);

            // Display the node name (Step 3)
            System.out.println(el.getNodeName() + " " + (i + 1));

            // And we show the value of the different tags (Steps 4, 5 and 6)
            System.out.println("Nom: " + el.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue());
            System.out.println("Hores: " + el.getElementsByTagName("hores").item(0).getTextContent());
            System.out.println("Qualificació: " + el.getElementsByTagName("qualificacio").item(0).getFirstChild().getNodeValue());
            System.out.println();

        }

    }

    public void WriteXML(String nameObj, String nameXML) throws FileNotFoundException, IOException, ClassNotFoundException, TransformerConfigurationException, TransformerException, ParserConfigurationException {

        ObjectInputStream f = new ObjectInputStream(new FileInputStream(nameObj));

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Element root = doc.createElement("NuevoCurso");
        doc.appendChild(root);

        try {
            while (true) {
                Modul m = (Modul) f.readObject();
                Element modul = doc.createElement("Modulnou");

                Element name = doc.createElement("Nomnou");
                name.appendChild(doc.createTextNode(m.getModul()));
                modul.appendChild(name);

                Element hours = doc.createElement("Horesnou");
                hours.appendChild(doc.createTextNode(Integer.toString(m.getHores())));
                modul.appendChild(hours);

                Element qualification = doc.createElement("Qualificacionou");
                qualification.appendChild(doc.createTextNode(Double.toString(m.getNota())));
                modul.appendChild(qualification);

                root.appendChild(modul);

            }
        } catch (EOFException ex) {
            f.close();

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(nameXML));
            trans.transform(source, result);
        }

    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException, ClassNotFoundException, TransformerException {

        XMLLib libreria = new XMLLib();
        
        Document doc = libreria.OpenXML("Moduls.xml");
        
        Element root=doc.getDocumentElement();
        
       // System.out.println(root.getTextContent());
        

        
        libreria.ShowXML(doc);
        
        libreria.WriteXML("modulsObject.dat", "modulsNew.xml");


    }

}
