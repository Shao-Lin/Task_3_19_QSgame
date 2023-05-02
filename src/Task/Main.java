package Task;
public class Main {
    static FrameMain frame;

    static {
        try {
            frame = new FrameMain();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        frame.setVisible(true);
    }
}
