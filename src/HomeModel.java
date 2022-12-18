
import java.awt.Color;

public class HomeModel {

    //เปลี่ยนสีปุ่ม Cashier ตอนเม้าส์ไปโดน
    public void MouseEnteredCashier(HomeView view) {
        view.getJbcashier().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getJbcashier().setBackground(new Color(155, 0, 0));
            }
        });
    }

    //เปลี่ยนสีปุ่ม Cashier ตอนลากเม้าท์ออก
    public void MouseExitedCashier(HomeView view) {
        view.getJbcashier().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getJbcashier().setBackground(new Color(255, 204, 0));
            }
        });
    }
    
        //เปลี่ยนสีปุ่ม Menu ตอนเม้าส์ไปโดน
    public void MouseEnteredMenu(HomeView view) {
        view.getJbmenu().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getJbmenu().setBackground(new Color(155, 0, 0));
            }
        });
    }

    //เปลี่ยนสีปุ่ม Menu ตอนลากเม้าท์ออก
    public void MouseExitedMenu(HomeView view) {
        view.getJbmenu().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getJbmenu().setBackground(new Color(255, 204, 0));
            }
        });
    }
}
