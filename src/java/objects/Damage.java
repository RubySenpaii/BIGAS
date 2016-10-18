/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author RubySenpaii
 */
public class Damage {
    final static String TABLE_DAMAGE = "Damage";
    final static String COLUMN_DAMAGE = "DamageID";
    final static String COLUMN_NAME = "Name";
    final static String COLUMN_IMAGE = "SampleImage";
    
    private int damageID;
    private String name;
    private String sampleImage;
    
    public Damage() {
        
    }

    /**
     * @return the damageID
     */
    public int getDamageID() {
        return damageID;
    }

    /**
     * @param damageID the damageID to set
     */
    public void setDamageID(int damageID) {
        this.damageID = damageID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sampleImage
     */
    public String getSampleImage() {
        return sampleImage;
    }

    /**
     * @param sampleImage the sampleImage to set
     */
    public void setSampleImage(String sampleImage) {
        this.sampleImage = sampleImage;
    }
}
