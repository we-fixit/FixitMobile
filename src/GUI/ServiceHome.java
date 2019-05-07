/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Services;
import Entities.User;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import service.Gestionservice;

/**
 *
 * @author Safsaf
 */
public class ServiceHome extends Form{
    public ServiceHome(Resources theme){
       setTitle("Espace service"); 
   
       getToolbar().addCommandToSideMenu("List d'offre", null , ev ->{  
            
                GUIService LE = new GUIService(theme);
                LE.show();
            
            });
       
       getToolbar().addCommandToSideMenu("Ajouter un offre", null , ev ->{  
            
                Addservice LE = new Addservice(theme);
                LE.show();
            
            });
       getToolbar().addCommandToSideMenu("Ma Liste service", null , ev ->{  
            
                Serviceprestataire LE = new Serviceprestataire(theme);
                LE.show();
            
            });
        Container e = new Container(new FlowLayout(CENTER));
        SpanLabel x = new SpanLabel("Un probleme un numéro");
        Image image = theme.getImage("fixit.png");
        Image image1 = theme.getImage("téléchargé.jpg");
        SpanLabel z = new SpanLabel("Qui ne s’est pas retrouvé un jour ou l’autre avec un robinet qui fuit,"
                + " une serrure qui coince, un climatiseur qui nous fait faux bond en pleine canicule,"
                + " une chaudière qui ne veut rien entendre en plein hiver ou même une machine à laver qui refuse d’essorer le linge?");
        Gestionservice ser = new Gestionservice();
        ArrayList<User> annonces = ser.topview();
        Container c1 = new Container(new FlowLayout(CENTER));
        
        for(int i=0 ;i<annonces.size()-12;i++){
         
            c1.add(new Label("Prestataire: \n"+annonces.get(i).getUsername()));
            
            Image image2 = theme.getImage("téléchargement.png");
            c1.add(image2).add(new Label("View \n"+annonces.get(i).getView()));
         
        }
//        for (User annonce : annonces) 
//        {
//        Container c1 = new Container(new FlowLayout(CENTER));
//            c1.add(new Label("Titre: \n"+annonce.getUsername()));
//            
//                   
//        e.add(c1);
//        }
        SpanLabel p = new SpanLabel("Top prestataire");
        e.add(x);
        e.add(image);
        e.add(z);
        e.add(image1);
        e.add(p);
        e.add(c1);  
        add(e);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       show(); }
    
    
    
}
