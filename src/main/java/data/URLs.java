package data;

public enum URLs {

    HOME_PAGE(""),
    PRODUCTS("/products"),
    PRODUCTS_ERP("/products/erp-accounting-software"),
    PRODUCTS_FINANCIAL_PLANNING("/products/budget-and-forecasting-software"),
    PRODUCTS_HUMAN_CAPITAL("/products/talent-and-hr-management-software"),
    PRODUCTS_STUDENT_MANAGEMENT("/products/student-information-system"),
    PRODUCTS_PEOPLE_EXPERIENCE("/products/the-people-experience-suite"),

    INDUSTRIES("/industries"),
    INDUSTRIES_HIGHER_EDUCATION("/industries/higher-education-erp-software"),
    INDUSTRIES_NONPROFIT("/industries/nonprofit-erp-accounting-software"),
    INDUSTRIES_PROFESSIONAL_SERVICES("/industries/professional-services-software"),
    INDUSTRIES_PUBLIC_SECTOR("/industries/public-sector-software"),

    CUSTOMERS("/customers"),
    CUSTOMERS_CITY_OF_PORT("/our-customers/city-port-coquitlam"),
    CUSTOMERS_FH_ST_POLTEN("/our-customers/fh-st-polten"),
    CUSTOMERS_MANCHESTER("/our-customers/manchester-metropolitan-university"),
    CUSTOMERS_SCREWFIX("/our-customers/screwfix"),
    CUSTOMERS_STANLEY("/our-customers/stanley-security"),
    CUSTOMERS_WAR_CHILD("/our-customers/war-child"),

    BLOG("/blog"),
    EVENTS("/events"),
    SITEMAP("/sitemap"),
    LIBRARY("/library"),
    WRONG_URL("/wrong"),
    CONTACT_US("/contact-us"),
    LOCATIONS("/our-locations"),
    WHY_UNIT4("/why-choose-unit4"),
    PRIVACY_POLICY("/terms-and-conditions"),
    DISCLAIMER("/terms-and-conditions/disclaimer"),
    COOKIES("/terms-and-conditions/cookies-policy"),
    TRADEMARKS("/terms-and-conditions/trademarks");

    private String stage;

    URLs(String stage) {
        this.stage = stage;
    }

    public String URL() {
        String baseURL = "stg.unit4.com";
       // todo pass and user are hidden due to NDA
        String fullUrl = "https://" + username + ":" + password + "@" + baseURL + stage;
        return fullUrl;
    }

    public String STAGE() {
        return stage;
    }

}
