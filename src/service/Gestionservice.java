/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Services;
import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Safsaf
 */
public class Gestionservice {

    public Gestionservice() {
    }
   public ArrayList<Services> getAllservice()
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/affichetoutt");
        con.setPost(false);
        
        ArrayList<Services> annonces = new ArrayList<>();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                
                try {
                    
                    Map<String, Object> an = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) an.get("root");
                    // Map<String,Object> dateDes=(Map<String,Object>)(an.get("date"));
//                      int temp=(int)Float.parseFloat(dateDes.get("timestamp").toString());
//                Date mydate=new Date(temp*1000L);
//                System.out.println(mydate);
                    for(Map<String, Object> ann : list )
                    {
                        Services a = new  Services();
                        // System.out.println(ann);
                        a.setId((int) Float.parseFloat(ann.get("id").toString()));
                        a.setTitre(ann.get("titre").toString());
                        a.setDescription(ann.get("description").toString());
                        a.setTelephone(ann.get("telephone").toString());
                        a.setDate(new Date((((Double) ((Map<String, Object>) ann.get("date")).get("timestamp")).longValue() * 1000)));
                        a.setImage(ann.get("image").toString());
                        
                        annonces.add(a);
                        System.out.println(a);
                    }
                    
                } catch (IOException ex) {ex.printStackTrace();}
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return annonces;
    }
   public ArrayList<Services> getMyservice(int id)
    { 
        ArrayList<Services> annonces = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/afficheme?user="+id);
        con.setPost(false);
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                
                try {
                    
                    Map<String, Object> an = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    
                    if(an.get("root") != null)
                    {
                        List<Map<String, Object>> list = (List<Map<String, Object>>) an.get("root");
                        for(Map<String, Object> ann : list )
                        {
                        Services a = new  Services();
                        // System.out.println(ann);
                        a.setId((int) Float.parseFloat(ann.get("id").toString()));
                        a.setTitre(ann.get("titre").toString());
                        a.setDescription(ann.get("description").toString());
                        a.setTelephone(ann.get("telephone").toString());
                        a.setDate(new Date((((Double) ((Map<String, Object>) ann.get("date")).get("timestamp")).longValue() * 1000)));
                        a.setImage(ann.get("image").toString());
                        a.setId_user(id);
                           // System.out.println(a.setId_user(id));
                        annonces.add(a);
                        System.out.println(a);
                    }
                    
                }} catch (IOException ex) {ex.printStackTrace();}
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return annonces;
  
    
    
    
    
    }
   public void AddAnnonce(String titre,String Description, String telephone, String image, int id_categorie, int id_user)
    {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/ajout");
        con.addArgument("titre", titre);
        con.addArgument("description", Description);
        con.addArgument("telephone", telephone);
        con.addArgument("image", image);
       
        con.addArgument("user", Integer.toString(id_user));
        con.addArgument("Categories", Integer.toString(id_categorie));
       
        //con.setPost(false);
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                //System.out.println("json :" + json);
                JSONParser j = new JSONParser();

            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
    public void updateAnnonce(int id,String titre,String Description, String telephone/*, String image*/, int id_categorie, int id_user)
    {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/updateS");
        con.addArgument("id", Integer.toString(id));
        con.addArgument("titre", titre);
        con.addArgument("description", Description);
        con.addArgument("telephone", telephone);
        //con.addArgument("image", image);
       
        con.addArgument("user", Integer.toString(id_user));
        con.addArgument("Categories", Integer.toString(id_categorie));
        //con.setPost(false);
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                //System.out.println("json :" + json);
                JSONParser j = new JSONParser();

            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
   
   
   public void deleteAnnonce(int id)
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/deleteS?id="+id);
        con.setPost(false);
        System.out.println("before entring try "+ id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                
                JSONParser j = new JSONParser();
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
   
   public ArrayList<User> topview()
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/topview");
        con.setPost(false);
        
        ArrayList<User> annonces = new ArrayList<>();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                
                try {
                    
                    Map<String, Object> an = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) an.get("root");
                    // Map<String,Object> dateDes=(Map<String,Object>)(an.get("date"));
//                      int temp=(int)Float.parseFloat(dateDes.get("timestamp").toString());
//                Date mydate=new Date(temp*1000L);
//                System.out.println(mydate);
                    for(Map<String, Object> ann : list )
                    {
                        User a = new  User();
                        
                        // System.out.println(ann);
                        a.setId((int) Float.parseFloat(ann.get("id").toString()));
                        a.setUsername(ann.get("username").toString());
                        a.setView((int) Float.parseFloat(ann.get("view").toString()));
                        
//                        a.setTitre(ann.get("titre").toString());
//                        a.setDescription(ann.get("description").toString());
//                        a.setTelephone(ann.get("telephone").toString());
//                        a.setDate(new Date((((Double) ((Map<String, Object>) ann.get("date")).get("timestamp")).longValue() * 1000)));
//                        a.setImage(ann.get("image").toString());
                        
                        annonces.add(a);
                        
                        System.out.println(a);
                    }
                    
                } catch (IOException ex) {ex.printStackTrace();
                    System.out.println(ex);}
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return annonces;
    }
   
   
   
   
}
