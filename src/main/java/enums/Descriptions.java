package enums;

public enum Descriptions {
    ERROR_NAME (10,"Ім\'я не співпадаз з очікуваним "),
    ERROR_EMAIL (20,"Email не співпадаз з очікуваним "),
    ERROR_BALANCE (30,"Баланс не співпадаз з очікуваним "),
    ERROR_200 (200,"Код статусу відрізняється від 200  ");

    private int testId;
    private String testDescription;

    Descriptions(int testId, String testDescription) {
        this.testId = testId;
        this.testDescription = testDescription;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public int getTestId() {
        return testId;
    }

    @Override
    public String toString() {
        return "ID_" + testId + ": " + testDescription;
    }
}
