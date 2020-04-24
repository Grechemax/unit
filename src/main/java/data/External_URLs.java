package data;

public enum External_URLs {
    COMMUNITY_PORTAL_URL("https://unit4.force.com/"),
    CAREERS_URL("https://www.careers.unit4.com/"),
    PRIVACY_AND_TRUST_URL("https://info.unit4.com/rs"),
    INFO_PERSONAL_DATA("https://info.unit4.com/Information-regarding-your-personal-data"),
    MORE_INFO("https://info.unit4.com/Unit4-Subscription-Cente"),
    DOWNLOAD_REPORT("https://info.unit4.com/Global-Unit4-2020-Analyst-Report"), // report can have different URLs

    FACEBOOK("facebook.com"),
    LINKEDIN("linkedin.com"),
    TWITTER("twitter.com"),
    INSTAGRAM("instagram.com"),

    ONE_TRUST("onetrust.com/");




    private String EXT_URL;

    External_URLs(String EXT_URL) {
        this.EXT_URL = EXT_URL;
    }

    public String URL() {
        return EXT_URL;
    }


}
