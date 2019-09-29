package utils;

public abstract class WebElementConstant {
    //region HOME PAGE
    public static final String DSL_BUTTON_ID = "mps-tab-5";
    public static final String AREA_CODE_TEXTBOX_XPATH = "/html[1]/body[1]/div[3]/main[1]/div[2]/section[1]/div[1]/div[1]/div[6]/form[1]/div[2]/div[1]/input[1]";
    public static final String MPS_BUTTON_XPATH = "/html[1]/body[1]/div[3]/main[1]/div[2]/section[1]/div[1]/div[1]/div[6]/form[1]/div[2]/div[2]/input[1]";
    public static final String COMPARE_NOW_BUTTON_XPATH = "//div[@id='mps-tab-box-5']//button[@class='page-button'][contains(text(),'Jetzt vergleichen')]";
    //endregion

    //region OFFER PAGE
    public static final String TARIFF_DETAILS_BUTTON_CSS = ".tariff-detail";
    public static final String IN_5_MIN_BUTTON_XPATH = "//div[@class='summary-tariff-content flex']//a[@class='responsive-label-txt offer-page-cta']";
    //endregion
}
