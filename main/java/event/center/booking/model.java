package event.center.booking;

public class model{
    private int image;
    private String menu_title;
    private String desc;

    public model(int image, String menu_title, String desc) {
        this.image = image;
        this.menu_title = menu_title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
