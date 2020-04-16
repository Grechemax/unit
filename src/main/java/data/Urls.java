package data;

public enum Urls {

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
    RESOURCES("/our-customers/war-child"),
    WHY_UNIT4("/why-choose-unit4");


    private String stage;

    Urls(String stage) {
        this.stage = stage;
    }

    public String URL() {
        String baseURL = "stg.unit4.com";
        String username = "sql";
        String password = "www2020=";
        String fullUrl = "https://" + username + ":" + password + "@" + baseURL + stage;
        System.out.println(fullUrl);
        return fullUrl;
    }

}
