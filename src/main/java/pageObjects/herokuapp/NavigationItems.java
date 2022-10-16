package pageObjects.herokuapp;

public enum NavigationItems {
    DYNAMIC_LOADING("Dynamic Loading"),
    DROPDOWN("Dropdown"),
    INFINITE_SCROLL("Infinite Scroll"),
    CONTEXT_MENU("Context Menu"),
    FILE_UPLOAD("File Upload"),
    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    SORTABLE_DATA_TABLES("Sortable Data Tables");

    private String item;

    NavigationItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }}