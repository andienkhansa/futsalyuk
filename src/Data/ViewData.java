/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Andien
 */
public class ViewData {
    private String idFutsal,namaFutsal,hpFutsal,kodeFutsal,mulaiFutsal,selesaiFutsal,tglFutsal;

    public ViewData(String idFutsal, String namaFutsal, String hpFutsal, String kodeFutsal, String mulaiFutsal, String selesaiFutsal, String tglFutsal) {
        this.idFutsal = idFutsal;
        this.namaFutsal = namaFutsal;
        this.hpFutsal = hpFutsal;
        this.kodeFutsal = kodeFutsal;
        this.mulaiFutsal = mulaiFutsal;
        this.selesaiFutsal = selesaiFutsal;
        this.tglFutsal = tglFutsal;
    }

    /**
     * @return the idFutsal
     */
    public String getIdFutsal() {
        return idFutsal;
    }

    /**
     * @param idFutsal the idFutsal to set
     */
    public void setIdFutsal(String idFutsal) {
        this.idFutsal = idFutsal;
    }

    /**
     * @return the namaFutsal
     */
    public String getNamaFutsal() {
        return namaFutsal;
    }

    /**
     * @param namaFutsal the namaFutsal to set
     */
    public void setNamaFutsal(String namaFutsal) {
        this.namaFutsal = namaFutsal;
    }

    /**
     * @return the hpFutsal
     */
    public String getHpFutsal() {
        return hpFutsal;
    }

    /**
     * @param hpFutsal the hpFutsal to set
     */
    public void setHpFutsal(String hpFutsal) {
        this.hpFutsal = hpFutsal;
    }

    /**
     * @return the kodeFutsal
     */
    public String getKodeFutsal() {
        return kodeFutsal;
    }

    /**
     * @param kodeFutsal the kodeFutsal to set
     */
    public void setKodeFutsal(String kodeFutsal) {
        this.kodeFutsal = kodeFutsal;
    }

    /**
     * @return the mulaiFutsal
     */
    public String getMulaiFutsal() {
        return mulaiFutsal;
    }

    /**
     * @param mulaiFutsal the mulaiFutsal to set
     */
    public void setMulaiFutsal(String mulaiFutsal) {
        this.mulaiFutsal = mulaiFutsal;
    }

    /**
     * @return the selesaiFutsal
     */
    public String getSelesaiFutsal() {
        return selesaiFutsal;
    }

    /**
     * @param selesaiFutsal the selesaiFutsal to set
     */
    public void setSelesaiFutsal(String selesaiFutsal) {
        this.selesaiFutsal = selesaiFutsal;
    }

    /**
     * @return the tglFutsal
     */
    public String getTglFutsal() {
        return tglFutsal;
    }

    /**
     * @param tglFutsal the tglFutsal to set
     */
    public void setTglFutsal(String tglFutsal) {
        this.tglFutsal = tglFutsal;
    }
    
}
