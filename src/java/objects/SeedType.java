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
public class SeedType {
    final static String TABLE_SEEDTYPE = "SeedType";
    final static String COLUMN_SEEDTYPEID = "SeedTypeID";
    final static String COLUMN_TYPENAME = "TypeName";
    
    private int seedTypeID;
    private String typeName;
    
    public SeedType() {
        
    }

    /**
     * @return the seedTypeID
     */
    public int getSeedTypeID() {
        return seedTypeID;
    }

    /**
     * @param seedTypeID the seedTypeID to set
     */
    public void setSeedTypeID(int seedTypeID) {
        this.seedTypeID = seedTypeID;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
