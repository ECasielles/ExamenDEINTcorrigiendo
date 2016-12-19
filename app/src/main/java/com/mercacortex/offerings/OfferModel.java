package com.mercacortex.offerings;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;

public class OfferModel implements Comparable{

    //Retention indica cuándo se quita la anotación
    //Indicamos que sólo exista cuando se programa y no cuando se ejecute
    @Retention(RetentionPolicy.SOURCE)
    //@IntDef({NOT_RELEVANT, RELEVANT, VERY_RELEVANT})  <- si lo tenemos declarado fuera
    @IntDef()
    public @interface Importancia{
        //Weight
        int VERY_RELEVANT = 2;
        int RELEVANT = 1;
        int NOT_RELEVANT = 0;
    }

    //La arroba indica que se sólo
    //se le pueden asignar los tres valores de arriba
    //Equivaldría a una enumeración, aunque es más débil
    //Con esto se puede indicar en la firma de cualquier método
    //y el entorno nos llama la atención si no cumple con los valores permitidos
    private @Importancia int importancia;

    //Category
    public static final int CATEGORY_HOME = 0;
    public static final int CATEGORY_ELECTRONICS = 1;
    public static final int CATEGORY_SPORT = 2;

    int imgId;
    String name, date, seller;
    int relevancy;

    public static Comparator NAME_ASC = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((OfferModel) o1).getName().compareTo(((OfferModel) o1).getName());
        }
    };
    public static Comparator NAME_DESC = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return -1 * ((OfferModel) o1).getName().compareTo(((OfferModel) o1).getName());
        }
    };
    public static Comparator TYPE_ASC = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((OfferModel) o1).getImgId() > (((OfferModel) o1).getImgId()) ? 1 :
                    ((OfferModel) o1).getImgId() < (((OfferModel) o1).getImgId()) ? - 1 : 0;
        }
    };

    public OfferModel(String date, String seller, int imgId, String name, @Importancia int relevancy, int category) {
        this.date = date;
        this.seller = seller;
        this.imgId = imgId;
        this.name = name;
        this.relevancy = relevancy;

        //importancia = RELEVANT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelevancy() {
        return relevancy;
    }

    public void setRelevancy(int relevancy) {
        this.relevancy = relevancy;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
