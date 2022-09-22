package webElements.single;

public interface ISelect {
    void selectByValue(String value);

    void selectByVisibleText(String text);

    void selectByIndex(int index);

    void deSelectByValue(String value);

    void deSelectByVisibleText(String text);

    void deSelectByIndex(int index);
}
