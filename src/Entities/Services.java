/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Safsaf
 */
public class Services {
   private int id;
private String titre;
private String Description;
private Date date;
private String telephone;
private String image;
private int autorise;
 int id_categorie;
private int id_user;
private String c;

    
    public Services() {
    }
    
   public Services(int id, String titre, String Description, Date date, String telephone, String image, int autorise, int id_user, String c) {
        this.id = id;
        this.titre = titre;
        this.Description = Description;
        this.date = date;
        this.telephone = telephone;
        this.image = image;
        this.autorise = autorise;
        this.id_user = id_user;
        this.c = c;
    }
     /**
     * @param titre
     * @param Description
     * @param date
     * @param telephone
     * @param id_user
     * @param image
     * @param id_categorie
     * @param autorise
     */
    public Services( String titre, String Description, Date date, String telephone,int id_categorie, String image, int id_user,  int autorise) {
        
        this.titre = titre;
        this.Description = Description;
        this.date = date;
        this.telephone = telephone;
        this.image = image;
        this.autorise = autorise;
        this.id_categorie = id_categorie;
        this.id_user = id_user;
    }

    

    public Services(String titre, String Description, Date date, String telephone) {
        this.titre = titre;
        this.Description = Description;
        this.date = date;
        this.telephone = telephone;
    }
    
 public Services(String titre, String Description, Date date,String telephone,int id_categorie,int id_user,int autorise) {
        this.titre = titre;
        this.Description = Description;
        this.telephone = telephone;
        this.date= date;
        this.id_categorie= id_categorie;
        this.id_user=id_user;
        this.autorise=autorise;
        
    }

    @Override
    public String toString() {
        return "services{" + "id=" + id + ", titre=" + titre + ", Description=" + Description + ", date=" + date + ", telephone=" + telephone + ", image=" + image + ", autorise=" + autorise + ", id_categorie=" + id_categorie + ", id_user=" + id_user + ", c=" + c + '}';
    }
 
   

    
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAutorise() {
        return autorise;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setAutorise(int autorise) {
        this.autorise = autorise;
    }  

    
}
