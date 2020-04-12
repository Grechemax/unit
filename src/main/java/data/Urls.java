package data;

public enum Urls {

    HOME_PAGE(""),
    PRODUCTS("/products"),
    INDUSTRIES("/industries"),
    CUSTOMERS("/customers"),
    RESOURCES("/resources"),
    WHY_UNIT4("");


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
