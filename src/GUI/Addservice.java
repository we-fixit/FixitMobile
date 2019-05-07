/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categories;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import service.Gestioncategorie;
import service.Gestionservice;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
/**
 *
 * @author Safsaf
 */
public class Addservice extends Form {
    String jobPic = "";
    private EncodedImage encImage;
    private int idcat;
    public static int current_user=11;
    public Addservice(Resources theme)  {
         setTitle("ajout service");
         getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png") , e->{
             ServiceHome s = new ServiceHome(theme);
             s.show();
          
        });
        
         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        Label Name = new Label("Titre:");
        TextArea nameTxt = new TextArea();
        nameTxt.setHint("Reparation tel et tel");
        container.add(Name);
        container.add(nameTxt);
        Label desc = new Label("Description:");
        TextArea descTxt = new TextArea();
        descTxt.setHint("Description");
        container.add(desc);
        container.add(descTxt);
        Label tel = new Label("Telephone:");
        TextArea tel1 = new TextArea();
        
        tel1.setHint("+216XXXXXXXX");
        container.add(tel);
        container.add(tel1);
        try {
        encImage=EncodedImage.create("/load.png");
            }
        catch (IOException ex) {System.out.println("xxxxxxxxx");
        }
         Random randomNum = new Random();
        Image ia = URLImage.createToStorage(encImage, randomNum+".jpg","C:/Users/safsaf/"+randomNum+".jpg" , URLImage.RESIZE_SCALE); 
        ImageViewer imgv=new ImageViewer(ia);                        
         //comps.add(imgv);   
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        Image camera = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
        Button jobIcon = new Button("Ajouter photo",camera);
        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + randomNum+".jpg";
        jobIcon.addActionListener((ActionEvent en) -> {
            jobPic = Capture.capturePhoto();
            if (jobPic != null) {
                Display.getInstance().openGallery(ee -> {
                    if (ee.getSource() != null) {
                        try {
                            jobPic = (String) ee.getSource();
                            Image img = Image.createImage((String) ee.getSource());

                            ImageIO imgIO = ImageIO.getImageIO();

                            OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile);
                            imgIO.save(img, os, ImageIO.FORMAT_JPEG, 1);

                           jobIcon.setIcon(img);
                           imgv.setImage(img);
                            //System.out.println(ee.getSource());
                            //System.out.println(imgIO);
                        } catch (IOException err) {
                            ToastBar.showErrorMessage("An error occured while loading the image: " + err);
                            Log.e(err);
                        }
                    }
                }, Display.GALLERY_IMAGE);
            }
        });
        
        
        container.add(jobIcon);
        
        
        
        
        
        
        
        
        
        
        
         ComboBox<String> categ = new ComboBox<>();
         Gestioncategorie ser = new Gestioncategorie();
         ArrayList<Categories> categories = ser.getAllservice();
         for(int i=0; i<categories.size(); i++)
        {
            
             categ.addItem(categories.get(i).getLibelle());
             
                
        }
         
         
         categ.addSelectionListener( new SelectionListener() {
            @Override
            public void selectionChanged(int oldSelected, int newSelected) {
                //String categorieSelected = categ.getSelectedItem();
                //System.out.println(categorieSelected);
                for(int i=0 ; i<categories.size(); i++)
                {
                 idcat=categ.getSelectedIndex()+1;
                 //idcat= categories.get(i).getId();
                System.out.println(idcat);
                }}});
         container.add(categ);
        Button btn = new Button("Valider");
        container.add(btn);
        
        
        add(container);
        
       btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            
                Gestionservice a = new Gestionservice();
            
            a.AddAnnonce(nameTxt.getText(), descTxt.getText(), tel1.getText(), jobPic, idcat, current_user);
            
             if(Dialog.show("Success", "You have added successfully a new service", "OK", null))
                {
                    
                }
            nameTxt.setEditable(false);
            tel1.setEditable(false);
            descTxt.setEditable(false);
            
            
            
            }});
    
    
    
    
    
    
    
    
    show();  
    
    }
    
    
    
    
    
    
    
    
}
