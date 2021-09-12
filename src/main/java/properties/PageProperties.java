package properties;

public enum PageProperties {
    BUDGET_ACTIVITY("BudgetActivity"),
    GOOGLE_PAGE("https://google.com"),
    EPAM_SEARCH("EPAM");


    private String str;

    public String getText() {
        return this.str;
    }

    PageProperties(String str) {
        this.str = str;
    }
}
