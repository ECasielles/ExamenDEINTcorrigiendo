package com.mercacortex.offerings;

import java.util.ArrayList;

import static com.mercacortex.offerings.OfferModel.CATEGORY_ELECTRONICS;
import static com.mercacortex.offerings.OfferModel.CATEGORY_HOME;
import static com.mercacortex.offerings.OfferModel.CATEGORY_SPORT;
import static com.mercacortex.offerings.OfferModel.Importancia.NOT_RELEVANT;
import static com.mercacortex.offerings.OfferModel.Importancia.RELEVANT;
import static com.mercacortex.offerings.OfferModel.Importancia.VERY_RELEVANT;

public class OfferRepository {

    private ArrayList<OfferModel> offerList;
    private static OfferRepository repository;

    private OfferRepository() {
        initializeOfferList();
    }

    private void initializeOfferList() {
        offerList = new ArrayList<>();
        offerList.add(new OfferModel("28/2/2014", "Decathlon", R.mipmap.ic_sports, "Balón de fútbol", VERY_RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("23/2/2015", "Decathlon", R.mipmap.ic_sports, "Bicicleta", RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("21/12/2014", "Tienda del Málaga FC", R.mipmap.ic_sports, "Camiseta de Movilla", NOT_RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("3/2/2014", "Tienda del Málaga FC", R.mipmap.ic_sports, "Las botas de Roteta", RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("3/12/2014", "Tienda del Málaga FC", R.mipmap.ic_sports, "El flequillo de Sandro", RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("23/12/2014", "Décimas", R.mipmap.ic_sports, "Pantalones mu malos", NOT_RELEVANT, CATEGORY_SPORT));
        offerList.add(new OfferModel("21/12/2014", "Ikea", R.mipmap.ic_home, "Silla de montar", RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("2/12/2014", "Ikea", R.mipmap.ic_home, "Silla fácil de montar", NOT_RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("23/12/2014", "Ikea", R.mipmap.ic_home, "Silla difícil de montar", VERY_RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("2/12/2013", "El Corte Inglés", R.mipmap.ic_home, "Sofá rojo", RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("21/6/2013", "El Corte Inglés", R.mipmap.ic_home, "Sofá negro", RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("23/6/2013", "El Corte Inglés", R.mipmap.ic_home, "Sofá rojo y negro", RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("23/12/2013", "Sumobel", R.mipmap.ic_home, "Mesa cocina mu chula", VERY_RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("23/2/2014", "Sumobel", R.mipmap.ic_home, "Mesa cocina", RELEVANT, CATEGORY_HOME));
        offerList.add(new OfferModel("13/11/2015", "Media Markt", R.mipmap.ic_mobile, "Sega Saturn", RELEVANT, CATEGORY_ELECTRONICS));
        offerList.add(new OfferModel("3/11/2015", "Media Markt", R.mipmap.ic_mobile, "Play Station 5", RELEVANT, CATEGORY_ELECTRONICS));
        offerList.add(new OfferModel("23/11/2012", "Media Markt", R.mipmap.ic_mobile, "Portátil HP", VERY_RELEVANT, CATEGORY_ELECTRONICS));
        offerList.add(new OfferModel("27/11/2015", "Media Markt", R.mipmap.ic_mobile, "Portátil HP no tan bueno", NOT_RELEVANT, CATEGORY_ELECTRONICS));
        offerList.add(new OfferModel("6/11/2015", "Media Markt", R.mipmap.ic_mobile, "Otro Portátil HP", NOT_RELEVANT, CATEGORY_ELECTRONICS));
    }

    public static OfferRepository getInstance() {
        if(repository == null)
            repository = new OfferRepository();
        return repository;
    }

    public ArrayList<OfferModel> getOfferList() {
        return offerList;
    }

    public void addOffer(OfferModel offerModel) {
        offerList.add(offerModel);
    }

}
