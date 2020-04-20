package data;

public enum External_URLs {
    COMMUNITY_PORTAL_URL("https://unit4.force.com/"),
    CAREERS_URL("https://www.careers.unit4.com/"),
    PRIVACY_AND_TRUST_URL("https://info.unit4.com/rs"),
    INFO_PERSONAL_DATA("https://info.unit4.com/Information-regarding-your-personal-data"),
    MORE_INFO("https://info.unit4.com/Unit4-Subscription-Cente"),

    FACEBOOK_URL("facebook.com"),
    LINKEDIN_URL("linkedin.com"),
    TWITTER_URL("twitter.com"),
    INSTAGRAM_URL("instagram.com");

    private String EXT_URL;

    External_URLs(String EXT_URL) {
        this.EXT_URL = EXT_URL;
    }

    public String URL() {
        return EXT_URL;
    }


}
